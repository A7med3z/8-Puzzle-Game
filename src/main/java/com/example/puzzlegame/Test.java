package com.example.puzzlegame;

public class Test {
    public static void main(String[] args) {
        Asearch obj = new Asearch();
        ResultState resultState = new ResultState();
        long G = System.currentTimeMillis();
        obj.AStarSearch(new StateNode("142658730", -1, 0, "manhattan"), "012345678");
        long G2 = System.currentTimeMillis();
        System.out.println(obj.get_goal().getState());
        resultState.FinalStates(obj.get_goal());
        System.out.println("first :" + (G2 - G) + "secs");

    }
}
