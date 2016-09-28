package com.lucasmro.graphs.algorithm;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lucasmro.graphs.entity.Direction;
import com.lucasmro.graphs.entity.Node;

public class PathCostSearchTest {

    Node A, B, C, D, E, F;
    PathCostSearch algorithm;

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

        algorithm = new PathCostSearch();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowIllegalArgumentExceptionWhenOnlyOneNodeIsInformed() {
        Assert.assertEquals(5, algorithm.calculateCostBetweenNodes(A));
    }

    @Test
    public void testShouldReturnCostEqualsFiveWhenRouteIsADE() {
        Assert.assertEquals(5, algorithm.calculateCostBetweenNodes(A, D, E));
    }

    @Test(expected = NoSuchElementException.class)
    public void testShouldThrowNoSuchElementExceptionWhenRouteIsAFE() {
        algorithm.calculateCostBetweenNodes(A, F, E);
    }

    @Test
    public void testShouldReturnCostEqualsTenWhenRouteIsECB() {
        Assert.assertEquals(10, algorithm.calculateCostBetweenNodes(E, C, B));
    }

    @Test
    public void testShouldReturnCostEqualsNineteenWhenRouteIsBDFE() {
        Assert.assertEquals(19, algorithm.calculateCostBetweenNodes(B, D, F, E));
    }

    @Test
    public void testShouldReturnCostEqualsFiveWhenRouteIsFC() {
        Assert.assertEquals(5, algorithm.calculateCostBetweenNodes(F, C));
    }
}
