package com.mvs.algo.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

class TestHighestValuePalindrome {

    @ParameterizedTest()
    @NullAndEmptySource
    @DisplayName("Empty String, n=0, k=0 should return 0")
    void highestValuePalindrome_EmptyStringWithN0K0_ShouldReturnSame(String s) {
        final int n = 0, k = 0;
        final String expected = s;

        final String actual = HighestValuePalindrome.highestValuePalindrome(s, n, k);

        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource(value = {
            "1:1:0:1",
            "1:1:1:9",
            "12:2:1:22",
            "3943:4:1:3993",
            "12321:5:3:92929",
            "474:3:3:999",
    }, delimiter = ':')
    @DisplayName("Valid Inputs, should return non-zero or positive")
    void highestValuePalindrome_ValidInput_ShouldReturnZeroOrPositive(String s, int n, int k, String expected) {

        final String actual = HighestValuePalindrome.highestValuePalindrome(s, n, k);

        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource(value = {
            "12:2:0",
            "31943:4:1",
            "123456:6:2",
            "1234567:7:2",
    }, delimiter = ':')
    @DisplayName("Valid Inputs, should return non-zero or positive")
    void highestValuePalindrome_InvalidInput_ShouldReturnMinusOne(String s, int n, int k) {
        final String expected = "-1";

        final String actual = HighestValuePalindrome.highestValuePalindrome(s, n, k);

        assertEquals(expected, actual);
    }

}
