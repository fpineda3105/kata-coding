package com.fpineda.katas;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/51fda2d95d6efda45e00004e
 * 
 * Write a class called User that is used to calculate the amount that a user will progress through
 * a ranking system similar to the one Codewars uses.
 * 
 * A user has a Rank There is no ZERO (0) Rank -> -8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8 A user has
 * a progress from 0 to 100 when a user reaches 100, the rank will increase + 1
 */
public class UserRanking {

        public static int MIN_RANK = -8;
        public static int MAX_RANK = 8;

        public int rank;
        public int progress;
        private Map<Integer, Integer> rankValues = new HashMap<Integer, Integer>();

        public UserRanking() {
            this.rank = MIN_RANK;
            this.progress = 0;
            initRankValues();

        }

        private void initRankValues() {
            var counter = 16;
            var validValues =
                    IntStream.rangeClosed(MIN_RANK, MAX_RANK).filter(number -> number != 0).toArray();
            
            for (int element : validValues) {
                rankValues.put(element, counter);
                counter--;
            }            
        }

        public void incProgress(int activityRank) {
            if (!isValidRank(activityRank)) {
                throw new IllegalArgumentException();
            }
            performProgressWith(activityRank);
            calculateNewRank();
        }

        private boolean isValidRank(int rank) {
            return rankValues.containsKey(rank);
        }

        private void performProgressWith(int activityRank) {
            if (rank == 8) {
                return;
            }
            int rankDifference = calculateRankDifferenceWith(activityRank);            
            if (rankDifference <= -1) {
                progress += 1;
                return;
            }
            switch (rankDifference) {                
                case 0:
                    progress += 3; break;
                default:
                    progress += 10 * rankDifference * rankDifference;
            }
        }

        private int calculateRankDifferenceWith(int activityRank) {
            return rankValues.get(rank) - rankValues.get(activityRank);

        }        

        private void calculateNewRank() {
            if (progress >= 100) {
                var rankUpgrades = progress / 100;
                rank += rankUpgrades;
                if (rank == 0) {
                    rank++;
                }
                progress = progress % 100;
                if (rank >= MAX_RANK) {
                    rank = MAX_RANK;
                    progress = 0;                    
                }                
            }
        }

        public int getRank() {
            return rank;
        }

        public int getProgress() {
            return progress;
        }



}
