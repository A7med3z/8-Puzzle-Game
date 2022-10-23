package com.example.puzzlegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hdistance {

    private static final HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public int EuclideanDist(String state) {
        map.put(0, new ArrayList<>(Arrays.asList(0, 0)));
        map.put(1, new ArrayList<>(Arrays.asList(0, 1)));
        map.put(2, new ArrayList<>(Arrays.asList(0, 2)));
        map.put(3, new ArrayList<>(Arrays.asList(1, 0)));
        map.put(4, new ArrayList<>(Arrays.asList(1, 1)));
        map.put(5, new ArrayList<>(Arrays.asList(1, 2)));
        map.put(6, new ArrayList<>(Arrays.asList(2, 0)));
        map.put(7, new ArrayList<>(Arrays.asList(2, 1)));
        map.put(8, new ArrayList<>(Arrays.asList(2, 2)));
        int distance = 0;
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) != '0') {
                distance += Math.sqrt(Math.pow(map.get(state.charAt(i) - '0').get(0) - map.get(i).get(0), 2) + Math.pow((map.get(state.charAt(i) - '0').get(1) - map.get(i).get(1)), 2));
            }
        }
        return distance;
    }

    public int ManhattanDist(String state) {
        map.put(0, new ArrayList<>(Arrays.asList(0, 0)));
        map.put(1, new ArrayList<>(Arrays.asList(0, 1)));
        map.put(2, new ArrayList<>(Arrays.asList(0, 2)));
        map.put(3, new ArrayList<>(Arrays.asList(1, 0)));
        map.put(4, new ArrayList<>(Arrays.asList(1, 1)));
        map.put(5, new ArrayList<>(Arrays.asList(1, 2)));
        map.put(6, new ArrayList<>(Arrays.asList(2, 0)));
        map.put(7, new ArrayList<>(Arrays.asList(2, 1)));
        map.put(8, new ArrayList<>(Arrays.asList(2, 2)));
        int distance = 0;
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) != '0') {
                distance += Math.round(Math.abs(map.get(state.charAt(i) - '0').get(0) - map.get(i).get(0)) + Math.abs(map.get(state.charAt(i) - '0').get(1) - map.get(i).get(1)));
            }
        }
        return distance;
    }
}