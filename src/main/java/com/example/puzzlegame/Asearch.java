package com.example.puzzlegame;

import java.util.*;

//this class override comparator implementation of queue

class StateComparator implements Comparator<StateNode> {
    public int compare(StateNode s1, StateNode s2) {
        if (s1.getCost() > s2.getCost()) return 1;
        else if (s1.getCost() < s2.getCost()) return -1;
        return 0;
    }
}

public class Asearch {
    HashSet<String> Explored;
    private StateNode Goal;

    public HashSet<String> get_expanded() {
        return Explored;
    }

    public StateNode get_goal() {
        return this.Goal;
    }

    public boolean AStarSearch(StateNode initState, String goal) {
        PriorityQueue<StateNode> stateHeap = new PriorityQueue<StateNode>(new StateComparator());
        HashSet<String> stateValue = new HashSet<>();
        Explored = new HashSet<>();
        stateHeap.add(initState);
        stateValue.add(initState.getState());
        while (!stateHeap.isEmpty()) {
            StateNode state = stateHeap.poll();
            stateValue.remove(state.getState());
            Explored.add(state.getState());
            if (state.getState().equals(goal)) {
                this.Goal = state;
                return true;
            }
            List<StateNode> neighbors = state.getNeighbors();
            for (StateNode neighbor : neighbors) {
                if (!(Explored.contains(neighbor.getState()) && stateValue.contains(neighbor.getState()))) {
                    stateHeap.add(neighbor);
                    stateValue.add(neighbor.getState());
                } else if (stateValue.contains(neighbor.getState())) {
                    Iterator<StateNode> value = stateHeap.iterator();
                    while (value.hasNext()) {
                        StateNode st = value.next();
                        if (st.getState().equals(neighbor.getState()) && (st.getCost() > neighbor.getCost())) {
                            st.setCost(neighbor.getCost());
                        }
                    }
                }
            }
        }
        return false;
    }
}