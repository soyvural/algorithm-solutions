package com.mvs.algo.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class TestSherlockAndTheValidString {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("empty input should return YES")
    void isValid_emptyInput_shouldReturnYES(String input) {

        final String actual = SherlockAndTheValidString.isValid(input);

        assertEquals("YES", actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a",
            "aa",
            "aaa",
            "aabbccdd",
            "afbcdefcbea",
    }, delimiter = ':')
    @DisplayName("string with all characters count same should return YES")
    void isValid_StringWithAllCharactersCountSame_shouldReturnYES(String input) {
        final String expected = "YES";

        final String actual = SherlockAndTheValidString.isValid(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "ab",
            "abbac",
            "aabbccd",
            "abcdefghhgfedecba",
    }, delimiter = ':')
    @DisplayName("string with one character count different should return YES")
    void isValid_StringWithOneCharacterCountDifferent_shouldReturnYES(String input) {
        final String expected = "YES";

        final String actual = SherlockAndTheValidString.isValid(input);

        assertEquals(expected, actual);
    }
}