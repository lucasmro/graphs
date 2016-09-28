package com.lucasmro.graphs.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    Node A, B, C, D, E, F;

    @Before
    public void setUp() {
        A = new Node('A');
        B = new Node('B');
        C = new Node('C');
        D = new Node('D');
        E = new Node('E');
        F = new Node('F');
    }

    @Test
    public void testGetters() {
        Assert.assertEquals('A', A.getLabel());
        Assert.assertEquals('B', B.getLabel());
        Assert.assertEquals('C', C.getLabel());
        Assert.assertEquals('D', D.getLabel());
        Assert.assertEquals('E', E.getLabel());
        Assert.assertEquals('F', F.getLabel());
    }

    @Test
    public void testBidirectionalEdgeBetweenTwoNodes() {
        A.connect(B, Direction.BOTH);

        Assert.assertTrue(A.getOutNeighbors().containsKey(B));
        Assert.assertTrue(B.getInNeighbors().containsKey(A));
        Assert.assertTrue(B.getOutNeighbors().containsKey(A));
        Assert.assertTrue(A.getInNeighbors().containsKey(B));
    }

    @Test
    public void testEdgeConnectionFromNodeAToNodeBOnly() {
        A.connect(B, Direction.OUT);

        Assert.assertTrue(A.getOutNeighbors().containsKey(B));
        Assert.assertTrue(B.getInNeighbors().containsKey(A));
        Assert.assertFalse(B.getOutNeighbors().containsKey(A));
        Assert.assertFalse(A.getInNeighbors().containsKey(B));
    }

    @Test
    public void testEdgeConnectionFromNodeBToNodeAOnly() {
        A.connect(B, Direction.IN);

        Assert.assertFalse(A.getOutNeighbors().containsKey(B));
        Assert.assertFalse(B.getInNeighbors().containsKey(A));
        Assert.assertTrue(B.getOutNeighbors().containsKey(A));
        Assert.assertTrue(A.getInNeighbors().containsKey(B));
    }

    @Test
    public void testBidirectionalEdgeBetweenTwoNodesWithCost() {
        A.connect(B, Direction.BOTH, 5);

        Assert.assertEquals(5, A.getOutNeighbors().get(B).intValue());
        Assert.assertEquals(5, B.getInNeighbors().get(A).intValue());
        Assert.assertEquals(5, B.getOutNeighbors().get(A).intValue());
        Assert.assertEquals(5, A.getInNeighbors().get(B).intValue());
    }

    @Test
    public void testWhenDirectionHasDifferentCost() {
        A.connect(B, Direction.OUT, 3);
        B.connect(A, Direction.OUT, 6);

        Assert.assertEquals(3, A.getOutNeighbors().get(B).intValue());
        Assert.assertEquals(3, B.getInNeighbors().get(A).intValue());
        Assert.assertEquals(6, B.getOutNeighbors().get(A).intValue());
        Assert.assertEquals(6, A.getInNeighbors().get(B).intValue());
    }

    @Test
    public void testShouldReturnThreeWhenGettingRoutesArrivingCustomerC() {
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

        Assert.assertEquals(3, C.getInNeighbors().size());
    }
}
