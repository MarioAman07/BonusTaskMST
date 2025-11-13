package com.mst.bonus;

import com.mst.bonus.algos.ComponentFinder;
import com.mst.bonus.algos.MstBuilder;
import com.mst.bonus.model.Edge;
import com.mst.bonus.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            Graph graph = createExampleGraph();
            System.out.println("Graph created with " + graph.getNumVertices() + " vertices and " + graph.getAllEdges().size() + " edges.");

            MstBuilder builder = new MstBuilder();
            List<Edge> mstEdges = builder.buildMst(graph);

            System.out.println("\n--- Initial MST Edges (Task Step 2) ---");
            printEdges(mstEdges);
            System.out.println("Initial MST Total Weight: " + MstBuilder.calculateTotalWeight(mstEdges));

            Edge edgeToRemove = new Edge(1, 2, 2);
            System.out.println("\n--- Removing Edge (Task Step 3) ---");
            System.out.println("Removing: " + edgeToRemove);

            ComponentFinder finder = new ComponentFinder();
            Map<Integer, Integer> components = finder.findComponents(graph.getNumVertices(), mstEdges, edgeToRemove);

            System.out.println("\n--- Resulting Components (Task Step 4) ---");
            printComponents(components);

            BonusTask task = new BonusTask();
            Edge replacementEdge = task.findReplacementEdge(graph, mstEdges, edgeToRemove);

            System.out.println("\n--- Finding Replacement Edge (Task Step 5) ---");
            if (replacementEdge != null) {
                System.out.println("Found replacement edge: " + replacementEdge);

                List<Edge> newMstEdges = new ArrayList<>(mstEdges);
                newMstEdges.remove(edgeToRemove);
                newMstEdges.add(replacementEdge);

                System.out.println("\n--- New MST Edges ---");
                printEdges(newMstEdges);
                System.out.println("New MST Total Weight: " + MstBuilder.calculateTotalWeight(newMstEdges));
            } else {
                System.out.println("No replacement edge found. The graph cannot be reconnected.");
            }

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

        allEdges.add(new Edge(0, 4, 10));

        return new Graph(numVertices, allEdges);
    }

    private static void printEdges(List<Edge> edges) {
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }

    private static void printComponents(Map<Integer, Integer> componentMap) {
        List<Integer> component0 = new ArrayList<>();
        List<Integer> component1 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : componentMap.entrySet()) {
            if (entry.getValue() == 0) {
                component0.add(entry.getKey());
            } else {
                component1.add(entry.getKey());
            }
        }
        System.out.println("Component 0: " + component0);
        System.out.println("Component 1: " + component1);
    }
}