package com.fpineda.katas;

import java.util.HashMap;
import java.util.Map;


public class LongestPyramidPath {
      
    private static int pathValue(int[][] pyramid, int floor, int position,
            Map<String, Integer> cache) {
        var currentValue = pyramid[floor][position];
        if (floor == pyramid.length - 1) {           
            return currentValue;
        }
        var currentPosition = String.join(",", String.valueOf(floor), String.valueOf(position));
        if (cache.containsKey(currentPosition)) {
            return cache.get(currentPosition);
        }        
        var firstPath = currentValue + pathValue(pyramid, floor + 1, position, cache);
        var secondPath = currentValue + pathValue(pyramid, floor + 1, position + 1, cache);

        cache.put(currentPosition, Math.max(firstPath, secondPath));
        return Math.max(firstPath, secondPath);
    }

    public static int longestSlideDown(int[][] pyramid) {
        if (pyramid.length == 1) {
            return pyramid[0][0];
        }        
        var cache = new HashMap<String, Integer>();
        var rootElement = pyramid[0][0];        

        var firstPath = rootElement + pathValue(pyramid, 1, 0, cache);
        var secondPath = rootElement + pathValue(pyramid, 1, 1, cache);

        return Math.max(firstPath, secondPath);        
    }
    

}
