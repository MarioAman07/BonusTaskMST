package com.mst.bonus;

import com.mst.bonus.algos.ComponentFinder;
import com.mst.bonus.model.Edge;
import com.mst.bonus.model.Graph;

import java.util.List;
import java.util.Map;

public class BonusTask {

    private final ComponentFinder componentFinder;

    public BonusTask() {
        this.componentFinder = new ComponentFinder();
    }

    public Edge findReplacementEdge(Graph fullGraph, List<Edge> mstEdges, Edge edgeToRemove) {

        int numVertices = fullGraph.getNumVertices();
        Map<Integer, Integer> componentMap = componentFinder.findComponents(numVertices, mstEdges, edgeToRemove);

        Edge bestReplacementEdge = null;
        int minWeight = Integer.MAX_VALUE;

        for (Edge candidateEdge : fullGraph.getAllEdges()) {

            if (candidateEdge.equals(edgeToRemove)) {
                continue;
            }

            int u = candidateEdge.getU();
            int v = candidateEdge.getV();

            if (componentMap.get(u) != componentMap.get(v)) {

                if (candidateEdge.getWeight() < minWeight) {
                    minWeight = candidateEdge.getWeight();
                    bestReplacementEdge = candidateEdge;
                }
            }
        }

        return bestReplacementEdge;
    }
}