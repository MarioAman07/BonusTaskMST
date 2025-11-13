package com.mst.bonus.algos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {

    @Test
    void testUnionAndFind() {
        UnionFind uf = new UnionFind(10);

        assertEquals(10, uf.getCount());

        assertTrue(uf.union(1, 2));
        assertEquals(uf.find(1), uf.find(2));
        assertNotEquals(uf.find(1), uf.find(3));
        assertEquals(9, uf.getCount());

        uf.union(2, 3);
        assertEquals(uf.find(1), uf.find(3));
        assertEquals(8, uf.getCount());

        assertFalse(uf.union(1, 3));
        assertEquals(8, uf.getCount());

        uf.union(5, 6);
        uf.union(6, 7);
        assertEquals(uf.find(5), uf.find(7));
        assertEquals(6, uf.getCount());

        assertNotEquals(uf.find(1), uf.find(5));

        uf.union(1, 7);
        assertEquals(uf.find(3), uf.find(5));
        assertEquals(5, uf.getCount());

        System.out.println("UnionFindTest: All tests passed!");
    }
}