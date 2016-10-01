package com.lucasmro.graphs;

import com.lucasmro.graphs.algorithm.Dijkstra;
import com.lucasmro.graphs.algorithm.PathCostSearch;
import com.lucasmro.graphs.entity.Direction;
import com.lucasmro.graphs.entity.Node;
import com.lucasmro.graphs.exception.NoSuchRouteException;

public class Solution {
    private static final String NOT_IMPLEMENTED = "NOT IMPLEMENTED";

    public static void main(String[] args) {
        // Nodes (Vertex)
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');

        // Edges
        A.connect(D, Direction.OUT, 4);
        D.connect(E, Direction.OUT, 1);
        E.connect(C, Direction.OUT, 8);
        C.connect(B, Direction.OUT, 2);
        B.connect(A, Direction.OUT, 6);
        A.connect(C, Direction.OUT, 9);
        D.connect(F, Direction.OUT, 7);
        F.connect(C, Direction.OUT, 5);
        F.connect(E, Direction.OUT, 9);
        B.connect(D, Direction.OUT, 3);
        F.connect(A, Direction.OUT, 3);

        int id = 1;
        // 1. The cost of the route A-D-E.
        printPathCostSearchResult(id++, A, D, E);

        // 2. The cost of the route A-F-E.
        printPathCostSearchResult(id++, A, F, E);

        // 3. The cost of the route E-C-B.
        printPathCostSearchResult(id++, E, C, B);

        // 4. The cost of the route B-D-F-E.
        printPathCostSearchResult(id++, B, D, F, E);

        // 5. The cost of the route F-C.
        printPathCostSearchResult(id++, F, C);

        // 6. How many routes are arriving the client `C`
        printOutput(id++, String.valueOf(C.getInNeighbors().size()));

        // 7. How many routes start at the client `B` and end at the client `A`
        // with a maximum of 5 stops.
        printOutput(id++, NOT_IMPLEMENTED);

        // 8. How many routes start at the client `A` and end at the client `A`
        // with exactly 3 stops.
        printOutput(id++, NOT_IMPLEMENTED);

        // 9. The cost of the shortest route between the clients `A` and `E`.
        printCostOfShortestRoute(id++, A, E);
        resetDistances(A, B, C, D, E, F);

        // 10. The cost of the shortest route between the clients `C` and `E`.
        printCostOfShortestRoute(id++, C, E);
        resetDistances(A, B, C, D, E, F);

        // 11. The number of different routes between the clients `A` and `B`
        // that costs less than 40.
        printOutput(id++, NOT_IMPLEMENTED);

        // 12. The number of different routes between the clients `E` and `D`
        // that costs less than 60.
        printOutput(id++, NOT_IMPLEMENTED);
    }

    private static void printOutput(int id, String content) {
        System.out.println(String.format("Output #%s: %s", id, content));
    }

    private static void printPathCostSearchResult(int id, Node... args) {
        PathCostSearch pathCostSearchAlgorithm = new PathCostSearch();

        try {
            Integer cost = pathCostSearchAlgorithm.calculateCostBetweenNodes(args);
            printOutput(id, String.valueOf(cost));
        } catch (NoSuchRouteException e) {
            printOutput(id, e.getMessage());
        }
    }

    private static void printCostOfShortestRoute(int id, Node start, Node goal) {
        Dijkstra dijkstraAlgorithm = new Dijkstra();
        int shortesPath = dijkstraAlgorithm.searchPath(start, goal);
        printOutput(id++, String.valueOf(shortesPath));
    }

    private static void resetDistances(Node... args) {
        for (Node node : args) {
            node.setDistance(Node.DISTANCE_TO_INFINITY);
        }
    }
}
