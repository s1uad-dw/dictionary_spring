package ru.s1uad_dw.dictionary_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.s1uad_dw.dictionary_spring.dao.Dictionary;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateWordDto {
    String value1;
    String value2;
}
