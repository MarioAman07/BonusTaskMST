package com.mst.bonus;

import com.mst.bonus.algos.MstBuilder;
import com.mst.bonus.model.Edge;
import com.mst.bonus.model.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class BonusTaskTest {

    private Graph graph;
    private List<Edge> mst;
    private BonusTask bonusTask;

    private Edge e1 = new Edge(0, 1, 10);
    private Edge e2 = new Edge(0, 2, 6);
    private Edge e3 = new Edge(0, 3, 5);
    private Edge e4 = new Edge(1, 3, 15);
    private Edge e5 = new Edge(2, 3, 4);

    @BeforeEach
    void setUp() {
        // 1. Создаем граф
        List<Edge> edges = List.of(e1, e2, e3, e4, e5);
        graph = new Graph(4, edges);

        MstBuilder builder = new MstBuilder();
        mst = builder.buildMst(graph);

        bonusTask = new BonusTask();
    }

    @Test
    void testFindReplacementEdge() {

        Edge edgeToRemove = e3;

        Edge replacement = bonusTask.findReplacementEdge(graph, mst, edgeToRemove);

        assertNotNull(replacement, "Replacement edge should be found");
        assertEquals(e2, replacement, "The cheapest replacement should be e2(0, 2, 6)");
        assertEquals(6, replacement.getWeight());

        System.out.println("BonusTaskTest: Integration test passed! Found replacement: " + replacement);
    }
}