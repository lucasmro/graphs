package com.lucasmro.graphs.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lucasmro.graphs.entity.Direction;
import com.lucasmro.graphs.entity.Node;

public class DijkstraTest {

    Node A, B, C, D, E, F;
    Dijkstra algorithm;

    @Before
    public void setUp() {
        A = new Node('A');
        B = new Node('B');
        C = new Node('C');
        D = new Node('D');
        E = new Node('E');
        F = new Node('F');

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

        algorithm = new Dijkstra();
    }

    @Test
    public void testShouldReturnCostOfShortestRouteEqualsFiveWhenRouteIsAE() {
        int calculatedCost = algorithm.searchPath(A, E);

        Assert.assertEquals(5, calculatedCost);
        Assert.assertEquals(buildExpectedPathWhenRouteIsAE(), algorithm.getPath());
    }

    @Test
    public void testShouldReturnCostOfShortestRouteEqualsSixWhenRouteIsCE() {
        int calculatedCost = algorithm.searchPath(C, E);

        Assert.assertEquals(6, calculatedCost);
        Assert.assertEquals(buildExpectedPathWhenRouteIsCE(), algorithm.getPath());
    }

    private List<Node> buildExpectedPathWhenRouteIsAE() {
        List<Node> expectedPath = new ArrayList<Node>();

        expectedPath.add(A);
        expectedPath.add(D);
        expectedPath.add(E);

        return expectedPath;
    }

    private List<Node> buildExpectedPathWhenRouteIsCE() {
        List<Node> expectedPath = new ArrayList<Node>();

        expectedPath.add(C);
        expectedPath.add(B);
        expectedPath.add(D);
        expectedPath.add(E);

        return expectedPath;
    }
}
