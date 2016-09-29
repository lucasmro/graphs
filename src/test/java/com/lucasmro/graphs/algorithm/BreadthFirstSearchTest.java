package com.lucasmro.graphs.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lucasmro.graphs.entity.Direction;
import com.lucasmro.graphs.entity.Node;

public class BreadthFirstSearchTest {

    Node A, B, C, D, F, G, H, I, J, K, L, S;
    BreadthFirstSearch algorithm;

    @Before
    public void setUp() {
        A = new Node('A');
        B = new Node('B');
        C = new Node('C');
        D = new Node('D');
        F = new Node('F');
        G = new Node('G');
        H = new Node('H');
        I = new Node('I');
        J = new Node('J');
        K = new Node('K');
        L = new Node('L');
        S = new Node('S');

        A.connect(B, Direction.BOTH);
        B.connect(F, Direction.BOTH);
        B.connect(C, Direction.BOTH);
        C.connect(D, Direction.BOTH);
        D.connect(H, Direction.BOTH);
        H.connect(I, Direction.BOTH);
        I.connect(S, Direction.BOTH);
        S.connect(L, Direction.BOTH);
        L.connect(K, Direction.BOTH);
        K.connect(J, Direction.BOTH);
        J.connect(G, Direction.BOTH);

        algorithm = new BreadthFirstSearch();
    }

    @Test
    public void testPathAndVisitedSequenceOfNodes() {
        List<Node> expectedPath = buildExpectedPath();
        LinkedHashSet<Node> expectedVisitedSequence = buildExpectedVisitedSequence();

        List<Node> path = algorithm.searchPath(S, A);
        LinkedHashSet<Node> visitedSequence = algorithm.getSequenceOfVisitedNodes();

        Assert.assertEquals(expectedPath, path);
        Assert.assertEquals(expectedVisitedSequence, visitedSequence);
    }

    private List<Node> buildExpectedPath() {
        List<Node> expectedPath = new ArrayList<Node>();

        expectedPath.add(S);
        expectedPath.add(I);
        expectedPath.add(H);
        expectedPath.add(D);
        expectedPath.add(C);
        expectedPath.add(B);
        expectedPath.add(A);

        return expectedPath;
    }

    private LinkedHashSet<Node> buildExpectedVisitedSequence() {
        LinkedHashSet<Node> expectedVisitedSequence = new LinkedHashSet<Node>();

        expectedVisitedSequence.add(S);
        expectedVisitedSequence.add(I);
        expectedVisitedSequence.add(L);
        expectedVisitedSequence.add(H);
        expectedVisitedSequence.add(K);
        expectedVisitedSequence.add(D);
        expectedVisitedSequence.add(J);
        expectedVisitedSequence.add(C);
        expectedVisitedSequence.add(G);
        expectedVisitedSequence.add(B);
        expectedVisitedSequence.add(A);

        return expectedVisitedSequence;
    }
}
