package com.fpineda.katas;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * https://www.codewars.com/kata/54b724efac3d5402db00065e/
 * Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.
 * 
 * For example:
 * 
 * MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
 * should return "HEY JUDE"
 * 
 */
public class MorseCodeDecoder {

    private static final Pattern WORD_PATTERN = Pattern.compile("\\s{3}");
    private static final Pattern LETTER_PATTERN = Pattern.compile("\\s");

    public static String decode(String morseCode) {
        var words = WORD_PATTERN.split(morseCode.trim());
        return Stream.of(words).map(MorseCodeDecoder::decodeWord).collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        var letters = LETTER_PATTERN.split(word);
        return Stream.of(letters).map(MorseCode::get).collect(Collectors.joining());
    }

    static class MorseCode {
        public static String get(String code) {
            return morseMap.get(code);
        }

        static Map<String, String> morseMap = new HashMap<>() {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            {
                put("a", "b");
                put("c", "d");
                put("-.-.-.", ";");
                put("-...-", "=");
                put("---", "O");
                put("----.", "9");
                put("-..-.", "/");
                put(".-...", "&");
                put("...--", "3");
                put(".--", "W");
                put("--", "M");
                put("--..", "Z");
                put(".----.", "'");
                put("-.-.--", "!");
                put("-...", "B");
                put("..-", "U");
                put(".----", "1");
                put("-.--.-", ")");
                put(".-", "A");
                put("-....-", "-");
                put("...-", "V");
                put("...---...", "SOS");
                put("-.--", "Y");
                put("..", "I");
                put("--.-", "Q");
                put("-.", "N");
                put("..---", "2");
                put("-....", "6");
                put("---...", ";");
                put(".-.-.", "+");
                put(".--.-.", "@");
                put("....-", "4");
                put("-----", "0");
                put(".-.-.-", ".");
                put("-.-.", "C");
                put(".", "E");
                put("..-.", "F");
                put(".---", "J");
                put("-.-", "K");
                put(".-..", "L");
                put(".-.", "R");
                put("...", "S");
                put("--.", "G");
                put("---..", "8");
                put("..--..", "?");
                put("-.--.", "(");
                put(".--.", "P");
                put(".....", "5");
                put("..--.-", "_");
                put("-..", "D");
                put(".-..-.", "\"");
                put("-", "T");
                put("....", "H");
                put("--..--", ",");
                put("...-..-", "$");
                put("--...", "7");
                put("-..-", "X");
            }
        };
    }
}
