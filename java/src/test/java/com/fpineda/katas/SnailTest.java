package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SnailTest {

    @Test
    void shoudlReturn_CorrectArray_3X3() {
        var array = new int[][] {{1, 2, 3}, 
                                {4, 5, 6}, 
                                {7, 8, 9}};
        var result = Snail.snail(array);

        Assertions.assertArrayEquals(new int[] {1, 2, 3, 6, 9, 8, 7, 4, 5}, result);
    }

    @Test
    void shoudlReturn_CorrectArray_4X4() {
        int[][] array
                = {{1, 2, 3, 9},
                {4, 5, 6, 4},
                {7, 8, 9, 1},
                {1, 2, 3, 4}};

        var result = Snail.snail(array);

        Assertions.assertArrayEquals(new int[] {1, 2, 3, 9, 4, 1, 4, 3, 2, 1, 7, 4, 5, 6, 9, 8}, result);
    }

}
