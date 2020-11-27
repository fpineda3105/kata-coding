package com.fpineda.katas;

public class JumpingClouds {

  public static int count(int[] clouds) {
    int index = 0;
    int minimalJumps = 0;
    
    while (index < clouds.length -1) {
        if (index + 2 < clouds.length && clouds[index + 2] == 0){
            minimalJumps++;
            index += 2;
            continue;
        }
        if (clouds[index + 1] == 0){
            minimalJumps++;
            index += 1;            
        }              
    }
    return minimalJumps;
  }

}
