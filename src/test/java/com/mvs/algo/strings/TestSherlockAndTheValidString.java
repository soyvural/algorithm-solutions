package com.mvs.algo.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class TestSherlockAndTheValidString {
    @ParameterizedTest
    @CsvSource(value = {
        "a:YES",
        "ab:YES", 
        "abc:YES", 
        "aabbccd:YES", 
        "abcdefghhgfedecba:YES",
        "aabbcd:NO",
        "abcdefghhgfedecb:NO",
        "aabbccddeefghi:NO",
        "abcdefghhgfedec:NO",
        "aabbccddeeffgghhhi:NO",
    }, delimiter = ':')
    @DisplayName("testIsValidReturnsExpectedResultForGivenInput")
    void testIsValidReturnsExpectedResultForGivenInput(String input, String expected) {
        var actual = SherlockAndTheValidString.isValid(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("isBlank_ShouldReturnYESForNullInputs")
    void isBlank_ShouldReturnYESForNullInputs(String input) {
        var actual = SherlockAndTheValidString.isValid(input);
        assertEquals("YES", actual);
    }
}