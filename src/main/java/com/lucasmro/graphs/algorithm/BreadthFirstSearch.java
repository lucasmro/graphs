package com.lucasmro.graphs.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lucasmro.graphs.entity.Node;

public class BreadthFirstSearch {
    private Queue<Node> queue;
    private HashSet<Node> visited;
    private HashMap<Node, Node> parent;
    private ArrayList<Node> path;
    private LinkedHashSet<Node> visitedSequence;

    public BreadthFirstSearch() {
        this.queue = new LinkedList<Node>();
        this.visited = new HashSet<Node>();
        this.parent = new HashMap<Node, Node>();
        this.path = new ArrayList<Node>();
        this.visitedSequence = new LinkedHashSet<Node>();
    }

    public List<Node> searchPath(Node start, Node goal) {
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            visitedSequence.add(curr);

            if (curr.equals(goal)) {
                return getPath(goal);
            }

            ArrayList<Node> neighbours = curr.getOutNodeNeighbors();
            for (Node n : neighbours) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    parent.put(n, curr);
                    queue.add(n);
                }
            }
        }

        return path;
    }

    public LinkedHashSet<Node> getSequenceOfVisitedNodes() {
        return visitedSequence;
    }

    private List<Node> getPath(Node goal) {
        Node curr = goal;

        while (curr != null) {
            path.add(curr);
            curr = parent.get(curr);
        }

        Collections.reverse(path);

        return Collections.unmodifiableList(path);
    }
}
