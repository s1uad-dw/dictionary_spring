package ru.s1uad_dw.dictionary_spring.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.s1uad_dw.dictionary_spring.dao.Word;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UpdateDictionaryDto {
    private UUID id;
    private String title;
    private String language1;
    private String language2;
    private String pattern;
    private List<Word> words;
}
