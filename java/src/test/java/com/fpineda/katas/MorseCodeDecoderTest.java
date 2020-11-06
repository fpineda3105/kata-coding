package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseCodeDecoderTest {

    @Test
    void decodeShouldBe_Successful() {
        var morseCode = ".... . -.--   .--- ..- -.. .";
        var expected = "HEY JUDE";

        Assertions.assertEquals(expected, MorseCodeDecoder.decode(morseCode));
    }
    
}
