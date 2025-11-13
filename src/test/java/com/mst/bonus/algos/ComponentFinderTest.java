package com.mst.bonus.algos;

import com.mst.bonus.model.Edge;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ComponentFinderTest {

    @Test
    void testFindComponents() {
        int numVertices = 4;
        Edge e1 = new Edge(0, 1, 1);
        Edge e2 = new Edge(1, 2, 1);
        Edge e3 = new Edge(2, 3, 1);
        List<Edge> mst = List.of(e1, e2, e3);

        ComponentFinder finder = new ComponentFinder();
        Map<Integer, Integer> components = finder.findComponents(numVertices, mst, e2);

        assertEquals(4, components.size(), "Map should contain all vertices");

        assertEquals(components.get(0), components.get(1));

        assertEquals(components.get(2), components.get(3));

        assertNotEquals(components.get(1), components.get(2));

        System.out.println("ComponentFinderTest: All tests passed!");
    }
}