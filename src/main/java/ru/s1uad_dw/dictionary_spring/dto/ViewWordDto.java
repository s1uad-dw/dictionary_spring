package ru.s1uad_dw.dictionary_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ViewWordDto {
    UUID id;
    String value1;
    String value2;
}
