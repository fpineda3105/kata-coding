package com.fpineda.katas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Triplets {       

    public static long count(final List<Long> arr, long r) {
        
        Map<Long, Long> pairsMap = new HashMap<>();
        Map<Long, Long> ocurrences = new HashMap<>();
        long count = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            long element = arr.get(i);
            long intermediate = element * r;
            if (pairsMap.containsKey(intermediate)){
                count += pairsMap.get(intermediate);
            }

            if (ocurrences.containsKey(intermediate)) {
                long value = 0;
                if (pairsMap.containsKey(element)){
                    value = pairsMap.get(element);
                }
                
                pairsMap.put(element, value + ocurrences.get(intermediate));
            }
            if (ocurrences.containsKey(element)) {
                ocurrences.put(element, ocurrences.get(element) + 1);
            }else {
                ocurrences.put(element, 1L);
            }
            
        }

        return count;

    }

}
