package ru.s1uad_dw.dictionary_spring.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordIsNotValidException extends Exception{
    private String value1;
    private String value2;
    private String message;

    public WordIsNotValidException(String value1, String value2, String message) {
        this.value1 = value1;
        this.value2 = value2;
        this.message = message;
    }
}
