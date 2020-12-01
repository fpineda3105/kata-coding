package com.fpineda.katas;

public class TheArray {

  public static Integer minimalSwapsToOrder(int[] array) {
    int swapsCount = 0;
    int index = 0;
    while (index < array.length) {
      if (array[index] == index + 1) {
        index++;
        continue;
      }
      int secondIndex = index + 1;
      while (secondIndex < array.length) {
        if (array[secondIndex] == index + 1) {
          swapsCount++;
          int temp = array[index];
          array[index] = array[secondIndex];
          array[secondIndex] = temp;
          index++;
          break;
        }
        secondIndex++;
      }
    }
    return swapsCount;
  }

  public static int maxSumSubSet(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    array[0] = Math.max(0, array[0]);
    if (array.length == 1) {
      return array[0];
    }
    array[1] = Math.max(array[0], array[1]);
    for (int i = 2; i < array.length; i++) {
      array[i] = Math.max(array[i - 1], array[i] + array[i - 2]);
    }
    return array[array.length - 1];
  }

}
