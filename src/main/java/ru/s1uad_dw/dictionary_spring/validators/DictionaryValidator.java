package ru.s1uad_dw.dictionary_spring.validators;

import java.util.regex.Pattern;

public class DictionaryValidator {
    public static boolean isValid(String value, String pattern){
        return Pattern.compile(pattern).matcher(value).matches();
    }
}
