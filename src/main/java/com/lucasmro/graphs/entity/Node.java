package com.lucasmro.graphs.entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Node {
    private char label;
    private LinkedHashMap<Node, Integer> outNeighbors;
    private LinkedHashMap<Node, Integer> inNeighbors;

    public Node(char label) {
        this.label = label;
        this.outNeighbors = new LinkedHashMap<Node, Integer>();
        this.inNeighbors = new LinkedHashMap<Node, Integer>();
    }

    public char getLabel() {
        return label;
    }

    public ArrayList<Node> getOutNodeNeighbors() {
        return new ArrayList<Node>(outNeighbors.keySet());
    }

    public ArrayList<Node> getInNodeNeighbors() {
        return new ArrayList<Node>(inNeighbors.keySet());
    }

    public LinkedHashMap<Node, Integer> getOutNeighbors() {
        return outNeighbors;
    }

    public LinkedHashMap<Node, Integer> getInNeighbors() {
        return inNeighbors;
    }

    public void connect(Node node, Direction direction) {
        this.connect(node, direction, 0);
    }

    public void connect(Node node, Direction direction, Integer cost) {
        if (direction.equals(Direction.BOTH)) {
            this.addBidirectionalNeighbour(node, cost);
        } else if (direction.equals(Direction.OUT)) {
            this.addOutNeighbor(node, cost);
            node.addInNeighbor(this, cost);
        } else if (direction.equals(Direction.IN)) {
            this.addInNeighbor(node, cost);
            node.addOutNeighbor(this, cost);
        }
    }

    private void addBidirectionalNeighbour(Node node, Integer cost) {
        this.addOutNeighbor(node, cost);
        node.addInNeighbor(this, cost);

        this.addInNeighbor(node, cost);
        node.addOutNeighbor(this, cost);
    }

    private void addOutNeighbor(Node target, Integer cost) {
        if (null == outNeighbors.get(target)) {
            outNeighbors.put(target, cost);
        }
    }

    private void addInNeighbor(Node source, Integer cost) {
        if (null == inNeighbors.get(source)) {
            inNeighbors.put(source, cost);
        }
    }
}
