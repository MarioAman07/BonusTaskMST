package com.mst.bonus.model;

import java.util.Objects;

public class Edge implements Comparable<Edge> {

    private final int u;
    private final int v;
    private final int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return String.format("(%d <-> %d, w: %d)", u, v, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (u == edge.u && v == edge.v && weight == edge.weight) ||
                (u == edge.v && v == edge.u && weight == edge.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.min(u, v), Math.max(u, v), weight);
    }
}