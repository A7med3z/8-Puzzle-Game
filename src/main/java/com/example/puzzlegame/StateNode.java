package com.example.puzzlegame;

import java.util.ArrayList;
import java.util.List;

public class StateNode {

    private final String state;
    private final int position;
    private final int height;
    private StateNode right;
    private StateNode left;
    private StateNode up;
    private StateNode down;
    private StateNode parent;
    private int cost;
    private final List<StateNode> neighbors;
    private String HType = "";

    public StateNode(String state, int position, int height) {
        this.state = state;
        this.position = position;
        this.height = height;
        this.right = null;
        this.left = null;
        this.up = null;
        this.down = null;
        this.neighbors = new ArrayList<StateNode>();
    }

    public StateNode(String state, int position, int height, String AstarH) {
        Hdistance obj = new Hdistance();
        this.state = state;
        this.position = position;
        this.height = height;
        if (AstarH.equals("manhattan")) {
            this.cost = this.height + obj.ManhattanDist(this.state);
        } else {
            this.cost = this.height + obj.EuclideanDist(this.state);

        }
        this.HType = AstarH;
        this.right = null;
        this.left = null;
        this.up = null;
        this.down = null;
        this.neighbors = new ArrayList<StateNode>();
    }

    public String getState() {
        return state;
    }

    public int getHeight() {
        return height;
    }

    public StateNode getRight() {
        updateNextLevel();
        return right;
    }

    public StateNode getLeft() {
        updateNextLevel();
        return left;
    }

    public StateNode getUp() {
        updateNextLevel();
        return up;
    }

    public StateNode getDown() {
        updateNextLevel();
        return down;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public StateNode getParent() {
        return parent;
    }

    public List<StateNode> getNeighbors() {
        updateNextLevel();
        return neighbors;
    }

    private String swap(String s, int position1, int position2) {
        int max = position1 > position2 ? position1 : position2;
        int min = position1 + position2 - max;
        return s.substring(0, min) + s.charAt(max) + s.substring(min + 1, max) + s.charAt(min) + s.substring(max + 1);
    }

    private void updateNextLevel() {
        boolean[] availablePositions = {true, true, true, true};
        if (state.indexOf('0') % 3 == 2) availablePositions[0] = false;
        if (state.indexOf('0') % 3 == 0) availablePositions[1] = false;
        if (state.indexOf('0') < 3) availablePositions[2] = false;
        if (state.indexOf('0') > 5) availablePositions[3] = false;
        switch (position) {
            case 0:
                availablePositions[1] = false;
                break;
            case 1:
                availablePositions[0] = false;
                break;
            case 2:
                availablePositions[3] = false;
                break;
            case 3:
                availablePositions[2] = false;
                break;
            default:
                break;
        }
        int pos = state.indexOf('0');
        if (availablePositions[0]) {
            String newState = swap(state, pos, pos + 1);
            if (HType.isEmpty()) {
                this.right = new StateNode(newState, 0, height + 1);
            } else {
                this.right = new StateNode(newState, 0, height + 1, this.HType);
            }
            this.right.parent = this;
            neighbors.add(this.right);
        }
        if (availablePositions[1]) {
            String newState = swap(state, pos, pos - 1);
            if (HType.isEmpty()) {
                this.left = new StateNode(newState, 1, height + 1);
            } else {
                this.left = new StateNode(newState, 1, height + 1, this.HType);
            }
            this.left.parent = this;
            neighbors.add(this.left);
        }
        if (availablePositions[2]) {
            String newState = swap(state, pos, pos - 3);
            if (HType.isEmpty()) {
                this.up = new StateNode(newState, 2, height + 1);
            } else {
                this.up = new StateNode(newState, 2, height + 1, this.HType);
            }
            this.up.parent = this;
            neighbors.add(this.up);
        }
        if (availablePositions[3]) {
            String newState = swap(state, pos, pos + 3);
            if (HType.isEmpty()) {
                this.down = new StateNode(newState, 3, height + 1);
            } else {
                this.down = new StateNode(newState, 3, height + 1, this.HType);
            }
            this.down.parent = this;
            neighbors.add(this.down);
        }
    }
}