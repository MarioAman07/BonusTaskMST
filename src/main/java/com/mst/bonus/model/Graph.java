package com.mst.bonus.model;

import java.util.List;

public class Graph {

    private final int numVertices;
    private final List<Edge> allEdges;

    public Graph(int numVertices, List<Edge> allEdges) {
        this.numVertices = numVertices;
        this.allEdges = allEdges;
    }


    public int getNumVertices() {
        return numVertices;
    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }
}