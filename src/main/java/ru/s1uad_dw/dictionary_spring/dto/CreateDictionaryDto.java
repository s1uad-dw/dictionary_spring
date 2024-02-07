package ru.s1uad_dw.dictionary_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateDictionaryDto {
    private String title;
    private String language1;
    private String language2;
    private String pattern;
}
