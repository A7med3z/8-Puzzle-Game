package com.example.puzzlegame;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS {
    HashSet<String> visited = new HashSet<>();
    //this is a help hash to store states in forntier as strings only
    HashSet<String> list = new HashSet<>();

    Stack<StateNode> frontier = new Stack<>();
    private StateNode Goal;

    public HashSet<String> get_expanded() {
        return visited;
    }

    public StateNode get_goal() {
        return Goal;
    }

    public boolean DepthFirstSearch(StateNode initState, String goal) {
        frontier.push(initState);
        list.add(initState.getState());
        while (!frontier.empty()) {
            StateNode state = frontier.pop();
            list.remove(state.getState());
            visited.add(state.getState());
            if (state.getState().equals(goal)) {
                Goal = state;
                return true;
            }
            //this list of neighbors of current state
            List<StateNode> neighbors = state.getNeighbors();
            for (StateNode neighbor : neighbors) {

                if (!list.contains(neighbor.getState()) && !visited.contains(neighbor.getState())) {
                    frontier.push(neighbor);
                    list.add(state.getState());
                }
            }
        }
        return false;
    }
}

