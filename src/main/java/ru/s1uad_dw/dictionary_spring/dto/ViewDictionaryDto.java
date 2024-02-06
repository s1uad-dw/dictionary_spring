package ru.s1uad_dw.dictionary_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ViewDictionaryDto {
    private String title;
    private String language1;
    private String language2;
    private List<ViewWordDto> words;
}
