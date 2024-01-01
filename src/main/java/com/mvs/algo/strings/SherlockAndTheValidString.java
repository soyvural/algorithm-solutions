package com.mvs.algo.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.OptionalLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAndTheValidString {

    /**
     * Sherlock and the Valid String
     * 
     * Sherlock considers a string to be valid if all characters of the string
     * appear the same number of times. It is also valid if he can remove just
     * character at index in the string, and the remaining characters will occur the
     * same number of times. Given a string , determine if it is valid. If so,
     * return YES, otherwise return NO.
     */
    public static String isValid(String s) {
        // s chars -> map {"a":2, "b":3,....}
        // {"a": 2, "b": 3,....} -> freq map: {2:1, 3:1, 4:3}
        // if all ocurrencefrequencies are same means it has one item, YES
        // if there are more than 2 frequencies then no-way to make it valid, NO
        // find max and min keys among two of frequencies
        //   if max - min == 1 and max=1 (one remove from max occurrence) then, YES
        //   if min=1 and minOccurrenceFrequency == 1 (one remove from min) then, YES
        //   otherwise NO

        final String YES = "YES";
        final String NO = "NO";

        if (s == null || s.length() == 0) {
            return YES;
        }

        var freq = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // occurrenceFrequencyMap (key: occurrenceOfChar, value: frequency), ex:
        // a:3,b:3,c:2 -> {3:2,2:1}
        var occurrenceFrequencyMap = freq.values().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Let's find out the shortcuts at first:
        // all of the chars have the same frequency, YES
        if (occurrenceFrequencyMap.size() == 1) {
            return YES;
        }

        // if there are more than 2 frequencies then no-way to make it valid since we
        // only have 1 char to remove
        if (occurrenceFrequencyMap.size() > 2) {
            return NO;
        }

        OptionalLong maxKey = occurrenceFrequencyMap.keySet().stream().mapToLong(Long::longValue).max();
        OptionalLong minKey = occurrenceFrequencyMap.keySet().stream().mapToLong(Long::longValue).min();
        if (!maxKey.isPresent() || !minKey.isPresent()) {
            return NO;
        }

        long maxKeyVal = maxKey.getAsLong();
        long minKeyVal = minKey.getAsLong();
        if ((maxKeyVal - minKeyVal == 1) && occurrenceFrequencyMap.get(maxKeyVal) == 1) {
            return YES;
        }

        if (minKeyVal == 1 && occurrenceFrequencyMap.get(minKeyVal) == 1) {
            return YES;
        }

        return NO;
    }

    public static void main(String[] args) {
        var inputs = Arrays.asList("", "a", "ab", "abc", "aabbccd", "abcdefghhgfedecba");
        inputs.stream().map(s -> Map.entry(s, isValid(s)))
                .forEach(e -> System.out.println("input:  " + e.getKey() + " - isValid: " + e.getValue()));
    }
}
