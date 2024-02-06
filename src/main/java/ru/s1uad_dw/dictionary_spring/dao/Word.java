package ru.s1uad_dw.dictionary_spring.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Data
@Entity(name = "words")
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String value1;
    private String value2;
    @ManyToOne
    private Dictionary dictionary;

    public Word(String value1, String value2, Dictionary dictionary){
        this.value1 = value1;
        this.value2 = value2;
        this.dictionary = dictionary;
    }
}
