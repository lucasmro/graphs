package com.lucasmro.graphs.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import com.lucasmro.graphs.entity.Node;

public class Dijkstra {
    private PriorityQueue<Node> pq;
    private HashSet<Node> visited;
    private HashMap<Node, Node> parent;
    private ArrayList<Node> path;

    public Dijkstra() {
        this.pq = new PriorityQueue<Node>();
        this.visited = new HashSet<Node>();
        this.parent = new HashMap<Node, Node>();
        this.path = new ArrayList<Node>();
    }

    public int searchPath(Node start, Node goal) {
        start.setDistance(0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited.contains(curr)) {
                continue;
            }

            visited.add(start);

            if (curr.equals(goal)) {
                buildPath(goal);
                return curr.getDistance();
            }

            ArrayList<Node> neighbours = curr.getOutNodeNeighbors();
            for (Node n : neighbours) {
                Integer cost = curr.getOutNeighbors().get(n);
                Integer totalCost = cost + curr.getDistance();

                if (totalCost < n.getDistance()) {
                    n.setDistance(totalCost);
                    parent.put(n, curr);
                    pq.add(n);
                }
            }
        }

        return 0;
    }

    public List<Node> getPath() {
        return Collections.unmodifiableList(path);
    }

    private void buildPath(Node goal) {
        Node curr = goal;

        while (curr != null) {
            path.add(curr);
            curr = parent.get(curr);
        }

        Collections.reverse(path);
    }
}
