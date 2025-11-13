package com.mst.bonus.algos;

import com.mst.bonus.model.Edge;
import com.mst.bonus.model.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MstBuilder {

    public List<Edge> buildMst(Graph graph) {
        int numVertices = graph.getNumVertices();

        List<Edge> allEdges = new ArrayList<>(graph.getAllEdges());
        Collections.sort(allEdges);

        UnionFind uf = new UnionFind(numVertices);

        List<Edge> mstEdges = new ArrayList<>();

        for (Edge edge : allEdges) {
            int u = edge.getU();
            int v = edge.getV();

            if (uf.union(u, v)) {
                mstEdges.add(edge);
            }

            if (mstEdges.size() == numVertices - 1) {
                break;
            }
        }

        if (mstEdges.size() != numVertices - 1) {
            System.err.println("Warning: Graph is not fully connected. MST could not be built.");
        }

        return mstEdges;
    }

    public static int calculateTotalWeight(List<Edge> mstEdges) {
        int totalWeight = 0;
        for (Edge edge : mstEdges) {
            totalWeight += edge.getWeight();
        }
        return totalWeight;
    }
}