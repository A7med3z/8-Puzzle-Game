package com.example.puzzlegame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class ResultState {

    private ArrayList<String> path_to_goal;
    private int cost_of_path;
    private HashSet nodes_expanded;
    private int search_depth;
    private double running_time;

    public int getCost_of_path() {
        return cost_of_path;
    }

    public void setCost_of_path(int cost_of_path) {
        this.cost_of_path = cost_of_path;
    }

    public double getRunning_time() {
        return running_time;
    }

    public void setRunning_time(double running_time) {
        this.running_time = running_time;
    }

    public HashSet getNodes_expanded() {
        return this.nodes_expanded;
    }

    public void setNodes_expanded(HashSet nodes_expanded) {
        this.nodes_expanded = nodes_expanded;
    }

    public int getSearch_depth() {
        return search_depth;
    }

    public ArrayList<String> getPath_to_goal() {
        return path_to_goal;
    }

    public void FinalStates(StateNode state) {
        path_to_goal = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        while (state != null) {
            stack.push(state.getState());
            state = state.getParent();
        }
        while (!stack.empty()) {
            String st = stack.pop();
            path_to_goal.add(st);
        }
        cost_of_path = path_to_goal.size() - 1;
        search_depth = path_to_goal.size() - 1;
    }
}