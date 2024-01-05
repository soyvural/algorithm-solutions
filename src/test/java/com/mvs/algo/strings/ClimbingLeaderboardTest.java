package com.mvs.algo.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ClimbingLeaderboardTest {

        // use @ArgumentSource (your solution) when the same generated test cases can be
        // used by more than one Test Class

        // use @MethodSource (Sormuras' solution) when the same generated test cases can
        // be used by more than one Test Method (in the same class)

        // otherwise try to keep the source for test cases as local as possible to the
        // method that uses them

        @ParameterizedTest
        @MethodSource("provideTestCasesForUniqueRankedValues")
        void climbingLeaderboard_uniqeRankedValues(List<Integer> ranked, List<Integer> player, List<Integer> expected) {
                final List<Integer> actual = ClimbingLeaderboard.climbingLeaderboardBruteForce(ranked, player);
                assertEquals(expected, actual);
        }

        @ParameterizedTest
        @MethodSource("provideTestCases")
        void climbingLeaderboard_shouldReturnOrders(List<Integer> ranked, List<Integer> player,
                        List<Integer> expected) {
                final List<Integer> actual = ClimbingLeaderboard.climbingLeaderboardBruteForce(ranked, player);
                assertEquals(expected, actual);
        }

        // providedTestCases is a method that returns a Stream of Arguments
        // 1st arg rankedList, 2nd arg playerList, 3rd arg expectedList
        static Stream<Arguments> provideTestCases() {
                return Stream.of(
                                Arguments.of(Arrays.asList(100, 90, 90, 80, 75, 60), Arrays.asList(50, 65, 77, 90, 102),
                                                Arrays.asList(6, 5, 4, 2, 1)),
                                Arguments.of(Arrays.asList(100, 90, 80, 70, 60), Arrays.asList(50, 65, 77, 90, 102),
                                                Arrays.asList(6, 5, 4, 2, 1)),
                                Arguments.of(Arrays.asList(100, 90, 90, 80, 75, 60), Arrays.asList(60, 75, 80, 90, 100),
                                                Arrays.asList(5, 4, 3, 2, 1)));
        }

        static Stream<Arguments> provideTestCasesForUniqueRankedValues() {
                return Stream.of(
                                Arguments.of(Arrays.asList(100, 100, 100, 100), Arrays.asList(50, 65, 77),
                                                Arrays.asList(2, 2, 2),
                                                Arguments.of(Arrays.asList(90, 90, 90, 90, 90),
                                                                Arrays.asList(100, 100, 100, 100, 100),
                                                                Arrays.asList(1, 1, 1, 1, 1, 1))));
        }

}