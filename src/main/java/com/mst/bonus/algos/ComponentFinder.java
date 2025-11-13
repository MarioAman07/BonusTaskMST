package com.mst.bonus.algos;

import com.mst.bonus.model.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentFinder {

    private Map<Integer, List<Integer>> adjList;

    private Map<Integer, Integer> componentMap;

    public Map<Integer, Integer> findComponents(int numVertices, List<Edge> mstEdges, Edge edgeToRemove) {
        this.adjList = new HashMap<>();
        this.componentMap = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.put(i, new ArrayList<>());
            componentMap.put(i, -1);
        }

        for (Edge edge : mstEdges) {
            if (edge.equals(edgeToRemove)) {
                continue;
            }
            adjList.get(edge.getU()).add(edge.getV());
            adjList.get(edge.getV()).add(edge.getU());
        }

        dfs(edgeToRemove.getU(), 0);

        for (int i = 0; i < numVertices; i++) {
            if (componentMap.get(i) == -1) {
                componentMap.put(i, 1);
            }
        }

        return componentMap;
    }

    private void dfs(int u, int componentId) {
        componentMap.put(u, componentId);

        for (int v : adjList.get(u)) {
            if (componentMap.get(v) == -1) {
                dfs(v, componentId);
            }
        }
    }
}