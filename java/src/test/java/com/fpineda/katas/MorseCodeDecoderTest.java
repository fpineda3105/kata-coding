package com.fpineda.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseCodeDecoderTest {

    @Test
    void decode_MorseCode_ShouldBe_Successful() {
        var morseCode = ".... . -.--   .--- ..- -.. .";
        var expected = "HEY JUDE";

        Assertions.assertEquals(expected, MorseCodeDecoder.decode(morseCode));
    }

    @Test
    void decode_MorseBitsCode_ShouldBe_Successful() {
        var message = "00001100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011000";
        var expected = "HEY JUDE";

        Assertions.assertEquals(expected, MorseCodeDecoder.decodeMessageFromBits(message));
    }
    
}
