package com.mst.bonus.algos;

import com.mst.bonus.model.Edge;
import com.mst.bonus.model.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MstBuilderTest {

    @Test
    void testBuildMst() {

        Edge e1 = new Edge(0, 1, 10);
        Edge e2 = new Edge(0, 2, 6);
        Edge e3 = new Edge(0, 3, 5);
        Edge e4 = new Edge(1, 3, 15);
        Edge e5 = new Edge(2, 3, 4);

        List<Edge> edges = List.of(e1, e2, e3, e4, e5);
        Graph graph = new Graph(4, edges);

        MstBuilder builder = new MstBuilder();
        List<Edge> mst = builder.buildMst(graph);


        assertEquals(3, mst.size(), "MST should have V-1 edges (3)");

        int totalWeight = MstBuilder.calculateTotalWeight(mst);
        assertEquals(19, totalWeight, "Total weight of MST should be 19");

        assertTrue(mst.contains(e5), "MST should contain edge (2, 3, w: 4)");
        assertTrue(mst.contains(e3), "MST should contain edge (0, 3, w: 5)");
        assertTrue(mst.contains(e1), "MST should contain edge (0, 1, w: 10)");

        assertFalse(mst.contains(e2), "MST should NOT contain edge (0, 2, w: 6)");
        assertFalse(mst.contains(e4), "MST should NOT contain edge (1, 3, w: 15)");

        System.out.println("MstBuilderTest: All tests passed!");
    }
}