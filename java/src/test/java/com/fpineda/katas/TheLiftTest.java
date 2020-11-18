package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheLiftTest {

    @Test
    void otherTest() {
        final int[][] queues = {new int[] {8, 8, 6}, //
                new int[] {8, 3, 4, 7}, //
                new int[0], //
                new int[] {2, 6, 8, 5}, //
                new int[0], //
                new int[] {0, 8, 8, 4, 1}, //
                new int[0], //
                new int[] {3, 2, 2, 3}, //
                new int[0]};

        var result = TheLift.theLift(queues, 9);
        Assertions.assertArrayEquals(new int[] {0, 1, 3, 4, 5, 6, 7, 8, 7, 5, 4, 3, 2, 1, 0},
                result);
    }

    @Test
    void testUpAndUp() {
        final int[][] queues = {new int[0], // G
                new int[] {3}, // 1
                new int[] {4}, // 2
                new int[0], // 3
                new int[] {5}, // 4
                new int[0], // 5
                new int[0], // 6
        };

        var result = TheLift.theLift(queues, 9);
        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 0}, result);
    }

    @Test
    void testDown() {
        final int[][] queues = {new int[0], // G
                new int[0], // 1
                new int[] {1, 1}, // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[0], // 6
        };

        var result = TheLift.theLift(queues, 9);
        Assertions.assertArrayEquals(new int[] {0, 2, 1, 0}, result);
    }

    @Test
    void testUP() {
        final int[][] queues = {new int[0], // G
                new int[0], // 1
                new int[] {5, 5, 5}, // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[0], // 6
        };

        var result = TheLift.theLift(queues, 9);
        Assertions.assertArrayEquals(new int[] {0, 2, 5, 0}, result);
    }

    @Test
    void testDownAndDown() {
        final int[][] queues = {new int[0], // G
                new int[] {0}, // 1
                new int[0], // 2
                new int[0], // 3
                new int[] {2}, // 4
                new int[] {3}, // 5
                new int[0], // 6
        };
        final int[] result = TheLift.theLift(queues, 5);
        Assertions.assertArrayEquals(new int[] {0, 5, 4, 3, 2, 1, 0}, result);
    }

    @Test    
    void testTrickyQueues() {
        final int[][] queues = {
                new int[0], // G
                new int[] {0, 0, 0, 6}, // 1
                new int[0], // 2
                new int[0], // 3
                new int[0], // 4
                new int[] {6, 6, 0, 0, 0, 6}, // 5                
                new int[0], // 6
        };
        final int[] result = TheLift.theLift(queues, 5);
        Assertions.assertArrayEquals(new int[] {0, 1, 5, 6, 5, 1, 0, 1, 0}, result);
    }

    @Test    
    void testLiftFullUp() {
        final int[][] queues = {
                new int[]{3, 3, 3, 3, 3, 3}, // G
                new int[0], // 1
                new int[0], // 2
                new int[0], // 3
                new int[0], // 4
                new int[0], // 5
                new int[0], // 6
        };
        final int[] result = TheLift.theLift(queues, 5);
        Assertions.assertArrayEquals(new int[] {0, 3, 0, 3, 0}, result);
    }

    @Test    
    void testUpAndDown() {
        final int[][] queues = {
                new int[]{3}, // G
                new int[]{2}, // 1
                new int[]{0}, // 2
                new int[]{2}, // 3
                new int[0], // 4
                new int[0], // 5
                new int[]{5}, // 6
        };
        final int[] result = TheLift.theLift(queues, 5);
        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3, 6, 5, 3, 2, 0}, result);
    }

    @Test    
    void testLiftFullUpAndDown() {
        final int[][] queues = {
                new int[]{3, 3, 3, 3, 3, 3}, // G
                new int[0], // 1
                new int[0], // 2
                new int[0], // 3
                new int[0], // 4
                new int[]{4, 4, 4, 4, 4, 4}, // 5
                new int[0] // 4
        };
        final int[] result = TheLift.theLift(queues, 5);
        Assertions.assertArrayEquals(new int[] {0, 3, 5, 4, 0, 3, 5, 4, 0}, result);
    }

    @Test    
    void testYoYo() {
        final int[][] queues = {                
                new int[0], // G
                new int[0], // 1
                new int[]{4, 4, 4, 4}, // 2
                new int[0], // 3
                new int[]{2, 2, 2, 2}, // 4
                new int[0], // 5
                new int[0] // 6
        };
        final int[] result = TheLift.theLift(queues, 2);
        Assertions.assertArrayEquals(new int[] {0, 2, 4, 2, 4, 2, 0}, result);
    }

    @Test    
    void testHighlander() {
        final int[][] queues = {                
                new int[0], // G
                new int[]{2}, // 1
                new int[]{3, 3, 3}, // 2
                new int[]{1}, // 3
                new int[0], // 4
                new int[0], // 5
                new int[0] // 6
        };
        final int[] result = TheLift.theLift(queues, 1);
        Assertions.assertArrayEquals(new int[] {0, 1, 2, 3, 1, 2, 3, 2, 3, 0}, result);
    }

}
