package ru.s1uad_dw.dictionary_spring.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.s1uad_dw.dictionary_spring.exceptions.WordNotFountException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "dictionaries")
@AllArgsConstructor
@NoArgsConstructor
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String language1;
    private String language2;
    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Word> words = new ArrayList<>();

    public Dictionary(String title, String language1, String language2) {
        this.title = title;
        this.language1 = language1;
        this.language2 = language2;
    }

    public void addWord(Word word) {
        words.add(word);
        word.setDictionary(this);
    }

    public Word findWordByOneValue(String value) throws WordNotFountException {
        for (Word word : words) {
            if (word.getValue1().equalsIgnoreCase(value) || word.getValue2().equalsIgnoreCase(value))
                return word;
        }
        throw new WordNotFountException(value, "Слово со значением " + value + " не найдено");
    }

    public Word findWordByTwoValues(String value1, String value2) throws WordNotFountException {
        for (Word word : words) {
            if (word.getValue1().equalsIgnoreCase(value1) && word.getValue2().equalsIgnoreCase(value2))
                return word;
        }
        throw new WordNotFountException(value1, value2, "Слово со значениями [" + value1 + ", " + value2 + "] не найдено");
    }

    public void removeWord(Word word) {
        words.remove(word);
        word.setDictionary(null);
    }
}

