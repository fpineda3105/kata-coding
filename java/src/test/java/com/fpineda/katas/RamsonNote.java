package com.fpineda.katas;

import java.util.HashMap;
import java.util.Map;


public class RamsonNote {

    private static Map<String, Integer> createDictionary(String[] words) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (String word : words) {
            if (dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.get(word) + 1);
                continue;
            }
            dictionary.put(word, 1);
        }
        return dictionary;
    }

    public static boolean canWrite(String[] magazine, String[] note) {

        Map<String, Integer> dictionary = createDictionary(magazine);

        for (String word : note) {
            if (!dictionary.containsKey(word)) {
                return false;
            } else {
                int value = dictionary.get(word);
                if (value > 0) {
                    dictionary.put(word, dictionary.get(word) - 1);
                    continue;
                }
                return false;

            }
        }
        return true;
    }

}
