package com.chuset.data_structures.graphs;

import java.util.HashMap;
import java.util.HashSet;

public class MyGraph<E> {

    private final HashMap<E, HashSet<E>> adjacencyList;
    private int numberOfNodes;

    public MyGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(final E value) {
        adjacencyList.put(value, new HashSet<>());
        numberOfNodes++;
    }

    public void addEdge(final E value1, final E value2) {
        adjacencyList.get(value1).add(value2);
        adjacencyList.get(value2).add(value1);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        adjacencyList.keySet().forEach(node -> sb.append(node).append(" --> ").
                append(adjacencyList.get(node).toString()).append('\n'));
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<>();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(6);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        System.out.printf("Number of nodes: %d%n", graph.getNumberOfNodes());

        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);
        System.out.println(graph);
    }
}
