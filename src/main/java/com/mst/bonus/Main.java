package com.mst.bonus;

import com.mst.bonus.algos.MstBuilder;
import com.mst.bonus.model.Edge;
import com.mst.bonus.model.Graph;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Graph graph = createExampleGraph();
            System.out.println("Example graph created.");
            System.out.println("Total Vertices: " + graph.getNumVertices());
            System.out.println("Total Edges: " + graph.getAllEdges().size());
            System.out.println("---");

            MstBuilder builder = new MstBuilder();
            List<Edge> mstEdges = builder.buildMst(graph);

            System.out.println("Initial Minimum Spanning Tree (MST):");
            for (Edge edge : mstEdges) {
                System.out.println(edge);
            }

            int totalWeight = MstBuilder.calculateTotalWeight(mstEdges);
            System.out.println("Total MST Weight: " + totalWeight);
            System.out.println("---");


        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Graph createExampleGraph() {
        int numVertices = 6;
        List<Edge> allEdges = new ArrayList<>();

        allEdges.add(new Edge(0, 1, 4));
        allEdges.add(new Edge(0, 2, 3));
        allEdges.add(new Edge(1, 2, 2));
        allEdges.add(new Edge(1, 3, 5));
        allEdges.add(new Edge(2, 3, 7));
        allEdges.add(new Edge(2, 4, 6));
        allEdges.add(new Edge(3, 4, 1));
        allEdges.add(new Edge(3, 5, 8));
        allEdges.add(new Edge(4, 5, 9));

        return new Graph(numVertices, allEdges);
    }
}
