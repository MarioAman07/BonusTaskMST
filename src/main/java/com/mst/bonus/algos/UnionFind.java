package com.mst.bonus.algos;

public class UnionFind {
    private final int[] parent;
    private int count;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return false;
        }

        parent[rootP] = rootQ;

        count--;
        return true;
    }

    public int getCount() {
        return count;
    }
}