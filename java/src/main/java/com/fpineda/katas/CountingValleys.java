package com.fpineda.katas;

public class CountingValleys {

  public static int count(String path, int length) {
    int valleysCount = 0;
    int position = 0;
    for (int i = 0; i <path.length(); i++) {
        char ch = path.charAt(i);        
        if (ch == 'U') {
            if (position + 1 == 0){               
                valleysCount++;
            }
            position++;
        }
        else {
            position--;
        }           
    }
   
    return valleysCount; 
  }

}
