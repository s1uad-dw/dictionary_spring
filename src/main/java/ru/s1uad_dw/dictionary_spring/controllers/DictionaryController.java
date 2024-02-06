package ru.s1uad_dw.dictionary_spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.s1uad_dw.dictionary_spring.dto.*;
import ru.s1uad_dw.dictionary_spring.exceptions.WordNotFountException;
import ru.s1uad_dw.dictionary_spring.services.DictionaryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/dictionaries")
@AllArgsConstructor
public class DictionaryController {
    @Autowired
    private final DictionaryService service;

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID saveDictionary(@RequestBody CreateDictionaryDto dictionary) {
        return service.saveDictionary(dictionary);
    }

    //READ
    @GetMapping
    public List<ViewDictionaryListDto> getAllDictionaries() {
        return service.getAllDictionaries();
    }

    @GetMapping("{id}")
    public ViewDictionaryDto getDictionaryById(@PathVariable UUID id) throws ChangeSetPersister.NotFoundException {
        return service.getDictionaryById(id);
    }

    @GetMapping("/{id}/find_word")
    public ViewWordDto findWordByOneValue(@PathVariable UUID id, @RequestParam String value) throws WordNotFountException, ChangeSetPersister.NotFoundException {
        return service.findWordByOneValue(id, value);
    }
    @GetMapping("/{id}/find_word_by_two_values")
    public ViewWordDto findWordByTwoValues(@PathVariable UUID id, @RequestParam String value1, @RequestParam String value2) throws WordNotFountException, ChangeSetPersister.NotFoundException {
        return service.findWordByTwoValues(id, value1, value2);
    }

    //UPDATE
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID updateDictionary(@RequestBody UpdateDictionaryDto dictionary) {
        return service.updateDictionary(dictionary);
    }

    @PutMapping("/{id}/add_word")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID addWord(@PathVariable UUID id,  @RequestBody CreateWordDto word) throws ChangeSetPersister.NotFoundException {
        return service.addWord(id, word);
    }

    @PutMapping("/{id}/remove_word")
    @ResponseStatus(HttpStatus.CREATED)
    public void removeWord(@PathVariable UUID id, @RequestParam String value) throws ChangeSetPersister.NotFoundException, WordNotFountException {
        service.removeWord(id, value);
    }

    //DELETE
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id){
        service.deleteById(id);
    }
}
