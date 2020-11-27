package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpingCloudsTest {

    @Test
    void shouldReturn_4Jumps() {        
        int[] clouds = new int[] {0, 0, 1, 0, 0, 1,0};

        Assertions.assertEquals(4, JumpingClouds.count(clouds));
    }
    
}
