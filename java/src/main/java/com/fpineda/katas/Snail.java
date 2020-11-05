package com.fpineda.katas;

import java.util.stream.Stream;
/**
 * https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1
 * 
 * Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
 * array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
         
         snail(array) #=> [1,2,3,6,9,8,7,4,5]
 */
public class Snail {

    public static int[] snail(final int[][] array) {
        if (array[0].length == 0) {
            return new int[] {};
        } 
        var result = "";
        var index = 0;
        while (index < array.length) {
            result += horizontalLineForward(array, index, array.length - index);
            result += verticalLineForward(array, index + 1, array.length - index - 1);
            result += horizontalLineBackward(array, array.length - index - 1, index);
            result += verticalLineBackward(array, array.length - index - 1, index);
            index++;
        }        
        return Stream.of(result.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private static String horizontalLineForward(final int[][] array, int begin, int end) {
        var line = "";
        for (int i = begin; i < end; i++) {
            line += array[begin][i] + ",";
        }
        return line;
    }

    private static String verticalLineForward(final int[][] array, int begin, int end) {
        var line = "";
        for (int i = begin; i < end; i++) {
            line += array[i][end] + ",";
        }
        return line;
    }

    private static String horizontalLineBackward(final int[][] array, int end, int begin) {
        var line = "";
        for (int i = end; i > begin; i--) {
            line += array[end][i] + ",";
        }
        return line;
    }

    private static String verticalLineBackward(final int[][] array, int end, int begin) {
        var line = "";
        for (int i = end; i > begin; i--) {
            line += array[i][begin] + ",";
        }
        return line;
    }

}
