package com.fpineda.katas;

public class Hourglass {

  private static int hourglassSumFor(int[][] array, int row, int col) {
    var hourGlasSum =
        array[row][col] + array[row][col + 1] + array[row][col + 2] + array[row + 1][col + 1]
            + array[row + 2][col] + array[row + 2][col + 1] + array[row + 2][col + 2];
            return hourGlasSum;
  }

  public static int max(int[][] array) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
          max = Math.max(max,hourglassSumFor(array, i, j));
      }
    }
    return max;
  }

}
