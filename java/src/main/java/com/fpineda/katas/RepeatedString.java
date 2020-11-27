package com.fpineda.katas;

public class RepeatedString {


  private static long countALetterOcurrencesIn(String str, long length) {
    int ocurrences = 0;

    for (int i = 0; i < length; i++) {
      if (str.charAt(i) == 'a') {
        ocurrences++;
      }
    }

    return ocurrences;
  }

  public static long count(String str, long n) {
    if (str.length() == 1) {
      if (str.charAt(0) == 'a') {
        return n;
      }
    }

    long ocurrencesALetter = 0;

    if (n > str.length()) {
      ocurrencesALetter = countALetterOcurrencesIn(str, str.length());
      long repetitions = n / str.length();
      return ocurrencesALetter * repetitions + countALetterOcurrencesIn(str, n % str.length());

    }
    else {
      return countALetterOcurrencesIn(str, n);
    }
    
  }

}
