package com.mvs.algo.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingLeaderboard {

    /*
     * An arcade game player wants to climb to the top of the leaderboard and track
     * their ranking. The game uses Dense Ranking, so its leaderboard works like
     * this:
     * 
     * The player with the highest score is ranked number on the leaderboard.
     * Players who have equal scores receive the same ranking number, and the next
     * player(s) receive the immediately following ranking number.
     * Example
     * ranked = [100, 90, 90, 80] -> [1, 2, 2, 3]
     * player = [70, 80, 105]
     * Output: [4, 3, 1]
     * 
     * The ranked players will have ranks 4th, 3rd, 1st and , respectively. If the
     * player's scores are , and , their rankings after each game are and return[4,
     * 3, 1].
     * 
     * 
     * Input Format
     * 'ranked' the leaderboard scores in decreasing order.
     * 'player' the game scores of the player.
     */
    public static List<Integer> climbingLeaderboardBruteForce(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();

        var distinctRanked = ranked.stream().distinct().collect(Collectors.toList());
        // go over the player scores and find the order of player
        for (int i = 0; i < player.size(); i++) {
            int playerScore = player.get(i);
            // initially put at last then iterate player in asc order in ranked list
            int order = distinctRanked.size() + 1;
            for (int j = distinctRanked.size() - 1; j >= 0; j--) {
                var rank = distinctRanked.get(j);
                if (playerScore < rank) {
                    result.add(order);
                    break;
                } else {
                    order--;
                }
            }

            if (order == 1) {
                result.add(1);
            }

        }

        return result;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Get distict ranked ranked [100, 90, 80]
        // order = size(distinct randked) - 1
        // calculate from desc order of distinctRanked
        // if (score >= lastIteratedItem) then
        // orderIndex--
        // else add to result
        // check the minimum edge case when the score is less than all of the renked
        // items

        List<Integer> result = new ArrayList<>();
        List<Integer> distinctRanked = ranked.stream().distinct().collect(Collectors.toList());
        int orderIndex = distinctRanked.size() - 1;
        int prevOrderIndex = orderIndex;
        for (int score : player) {
            while (orderIndex >= 0) {
                if (score >= distinctRanked.get(orderIndex)) {
                    orderIndex--;
                } else {
                    result.add(orderIndex + 2);
                    break;
                }
            }
            if (orderIndex < 0) {
                result.add(1);
                orderIndex = prevOrderIndex;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var ranked = List.of(100, 90, 90, 80);
        var player = List.of(70, 80, 105);
        var result = climbingLeaderboard(ranked, player);
        System.out.println(result);
    }
}
