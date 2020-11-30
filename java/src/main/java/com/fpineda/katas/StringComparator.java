package com.fpineda.katas;

import java.util.HashSet;
import java.util.Set;

public class StringComparator {

  private static Set<Character> createDictionary(String word){
    Set<Character> letters = new HashSet<>(word.length());
    for (int i = 0; i < word.length(); i++) {
        letters.add(word.charAt(i));
    }

    return letters;
  }

  public static boolean containsSubStr(String firstString, String secondString) {
    Set<Character> letters = createDictionary(firstString);

    for (int i = 0; i < secondString.length(); i++) {
        if (letters.contains(secondString.charAt(i))){
          return true;
        }
    }

    return false;
  }

}
