package com.lucasmro.graphs.algorithm;

import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import com.lucasmro.graphs.entity.Node;

public class PathCostSearch {

    public int calculateCostBetweenNodes(Node... args) {
        int sum = 0;

        if (args.length < 2) {
            throw new IllegalArgumentException("At least two arguments are mandatory to calculate the cost.");
        }

        Node prev = args[0];
        for (int i = 1; i < args.length; i++) {
            Node curr = args[i];
            LinkedHashMap<Node, Integer> neighbours = prev.getOutNeighbors();

            if (!neighbours.containsKey(curr)) {
                throw new NoSuchElementException();
            }

            sum += neighbours.get(curr);
            prev = curr;
        }

        return sum;
    }
}
