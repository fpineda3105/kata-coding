package com.fpineda.katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public class Triplets {

    private static long populateMaps(final List<Long> arr, long r) {
        Map<Long, SortedSet<Long>> ocurrences = new HashMap<>(arr.size()/2);
        long count = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            long element = arr.get(i);
            if (element == 1 || element % r == 0) {
                if (!ocurrences.containsKey(element)) {
                    ocurrences.put(element, new TreeSet<Long>());
                }
                ocurrences.get(element).add((long) i);
                long value = arr.get(i);
                long j = value * r;
                long k = value * r * r;
                if (ocurrences.containsKey(j) && ocurrences.containsKey(k)) {
                    for (Long indexJ : ocurrences.get(j).tailSet((long) i + 1)) {
                        count = count + ocurrences.get(k).tailSet((long) indexJ + 1).size();                        

                    }
                }
            }
        }

        return count;

    }

    private static long countTriplets(final List<Long> arr, long r) {
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

    public static long count(final List<Long> arr, long r) {
        // Map<Long, List<Long>> ocurrences = new HashMap<>(arr.size());


        return countTriplets(arr, r);


    }


    public static void main(String[] args) {
        // var array = new Long[100];
        // Arrays.fill(array, 1L);
        // var elements = Arrays.asList(array);
        // var ratio = 1L;

        var elements = Arrays.asList(new Long[] {1L, 2L, 2L, 4L});
        var ratio = 2;

        System.out.println(count(elements, ratio));
    }

}
