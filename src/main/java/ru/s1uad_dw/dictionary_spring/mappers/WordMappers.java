package ru.s1uad_dw.dictionary_spring.mappers;

import ru.s1uad_dw.dictionary_spring.dao.Dictionary;
import ru.s1uad_dw.dictionary_spring.dao.Word;
import ru.s1uad_dw.dictionary_spring.dto.CreateWordDto;
import ru.s1uad_dw.dictionary_spring.dto.RemoveWordDto;
import ru.s1uad_dw.dictionary_spring.dto.ViewWordDto;

public class WordMappers {
    public static Word createDtoToDao(CreateWordDto dto, Dictionary dictionary){
        return new Word(
                dto.getValue1(),
                dto.getValue2(),
                dictionary
        );
    }

    public static ViewWordDto DaoToViewWordDto(Word dao){
        return new ViewWordDto(
                dao.getId(),
                dao.getValue1(),
                dao.getValue2()
        );
    }
}
