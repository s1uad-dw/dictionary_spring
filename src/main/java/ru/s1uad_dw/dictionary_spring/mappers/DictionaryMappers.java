package ru.s1uad_dw.dictionary_spring.mappers;

import ru.s1uad_dw.dictionary_spring.dao.Dictionary;
import ru.s1uad_dw.dictionary_spring.dto.CreateDictionaryDto;
import ru.s1uad_dw.dictionary_spring.dto.UpdateDictionaryDto;
import ru.s1uad_dw.dictionary_spring.dto.ViewDictionaryDto;
import ru.s1uad_dw.dictionary_spring.dto.ViewDictionaryListDto;

public class DictionaryMappers {
    public static Dictionary createDtoToDao(CreateDictionaryDto dto) {
        return new Dictionary(
                dto.getTitle(),
                dto.getLanguage1(),
                dto.getLanguage2()
        );
    }

    public static ViewDictionaryListDto daoToViewListDto(Dictionary dao) {
        return new ViewDictionaryListDto(
                dao.getId(),
                dao.getTitle(),
                dao.getLanguage1(),
                dao.getLanguage2(),
                dao.getWords().stream().map(WordMappers::DaoToViewWordDto).toList()
        );
    }

    public static ViewDictionaryDto daoToViewDto(Dictionary dao) {
        return new ViewDictionaryDto(
                dao.getTitle(),
                dao.getLanguage1(),
                dao.getLanguage2(),
                dao.getWords().stream().map(WordMappers::DaoToViewWordDto).toList()
        );
    }

    public static Dictionary updateDtoToDao(UpdateDictionaryDto dto){
        return new Dictionary(
                dto.getId(),
                dto.getTitle(),
                dto.getLanguage1(),
                dto.getLanguage2(),
                dto.getWords()
        );
    }
}
