package ru.s1uad_dw.dictionary_spring.services;

import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ru.s1uad_dw.dictionary_spring.dao.Word;
import ru.s1uad_dw.dictionary_spring.dto.*;
import ru.s1uad_dw.dictionary_spring.exceptions.WordIsNotValidException;
import ru.s1uad_dw.dictionary_spring.exceptions.WordNotFountException;
import ru.s1uad_dw.dictionary_spring.mappers.DictionaryMappers;
import ru.s1uad_dw.dictionary_spring.mappers.WordMappers;
import ru.s1uad_dw.dictionary_spring.repositories.DictionaryRepository;
import ru.s1uad_dw.dictionary_spring.validators.DictionaryValidator;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DictionaryService {
    private final DictionaryRepository repository;

    public UUID saveDictionary(CreateDictionaryDto dictionary) {
        return repository.save(DictionaryMappers.createDtoToDao(dictionary)).getId();
    }

    public List<ViewDictionaryListDto> getAllDictionaries() {
        return repository.findAll().stream().map(DictionaryMappers::daoToViewListDto).toList();
    }

    public ViewDictionaryDto getDictionaryById(UUID id) throws ChangeSetPersister.NotFoundException {
        var dictionaryDao = repository.findById(id);
        if (dictionaryDao.isPresent()) return DictionaryMappers.daoToViewDto(dictionaryDao.get());
        throw new ChangeSetPersister.NotFoundException();
    }

    public ViewWordDto findWordByOneValue(UUID id, String value) throws WordNotFountException, ChangeSetPersister.NotFoundException {
        var dictionaryDao = repository.findById(id);
        if (dictionaryDao.isPresent()) {
            return WordMappers.DaoToViewWordDto(dictionaryDao.get().findWordByOneValue(value));
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    public ViewWordDto findWordByTwoValues(UUID id, String value1, String value2) throws WordNotFountException, ChangeSetPersister.NotFoundException {
        var dictionaryDao = repository.findById(id);
        if (dictionaryDao.isPresent()) {
            return WordMappers.DaoToViewWordDto(dictionaryDao.get().findWordByTwoValues(value1, value2));
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    public UUID updateDictionary(UpdateDictionaryDto dictionary) {
        return repository.save(DictionaryMappers.updateDtoToDao(dictionary)).getId();
    }

    public UUID addWord(UUID id, CreateWordDto word) throws ChangeSetPersister.NotFoundException, WordIsNotValidException {
        var dictionaryDao = repository.findById(id);
        if (dictionaryDao.isPresent()) {
            if (DictionaryValidator.isValid(word.getValue1(), dictionaryDao.get().getPattern()) &&
                    DictionaryValidator.isValid(word.getValue2(), dictionaryDao.get().getPattern())) {
                Word wordDao = WordMappers.createDtoToDao(word, dictionaryDao.get());
                dictionaryDao.get().addWord(wordDao);
                repository.save(dictionaryDao.get());
                return wordDao.getId();
            }
            throw new WordIsNotValidException(word.getValue1(), word.getValue2(),
                    "Слово не соответствует ограничениям словаря");
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    public void removeWord(UUID id, String value) throws ChangeSetPersister.NotFoundException, WordNotFountException {
        var dictionaryDao = repository.findById(id);
        if (dictionaryDao.isPresent()) {
            dictionaryDao.get().removeWord(dictionaryDao.get().findWordByOneValue(value));
            repository.save(dictionaryDao.get());
            return;
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }


}
