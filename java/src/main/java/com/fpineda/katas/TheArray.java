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

}
