package org.hmk.baby_names;

import java.util.*;

public class Solution1 {
    Map<String, Integer> trulyMostPopular(Map<String, Integer> names, String[][] synonyms) {
        Graph graph = constructGraph(names);
        connectEdges(graph, synonyms);
        return getTrueFrequencies(graph);
    }

    private Map<String, Integer> getTrueFrequencies(Graph graph) {
        Map<String, Integer> rootNames = new HashMap<>();
        for (GraphNode node : graph.getNodes()) {
            if (!node.isVisited()) {
                int frequency = getComponentFrequency(node);
                String name = node.getName();
                rootNames.put(name, frequency);
            }
        }
        return rootNames;
    }

    private int getComponentFrequency(GraphNode node) {
        if (node.isVisited()) {
            return 0;
        }
        node.setIsVisited(true);
        int sum = node.getFrequency();
        for (GraphNode child : node.getNeighbors()) {
            sum += getComponentFrequency(child);
        }
        return sum;
    }

    private void connectEdges(Graph graph, String[][] synonyms) {
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            graph.addEdge(name1, name2);
        }
    }

    private Graph constructGraph(Map<String, Integer> names) {
        Graph graph = new Graph();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            graph.createNode(name, frequency);
        }
        return graph;
    }
}

class Graph {
    final private Map<String, GraphNode> nodes = new HashMap<>();

    public void createNode(String name, int frequency) {
        nodes.put(name, new GraphNode(name, frequency));
    }

    public void addEdge(String name1, String name2) {
        GraphNode node1 = nodes.get(name1);
        GraphNode node2 = nodes.get(name2);
        node1.getNeighbors().add(node2);
        node2.getNeighbors().add(node1);
    }

    public Collection<GraphNode> getNodes() {
        return nodes.values();
    }
}

class GraphNode {
    final private String name;
    final private int frequency;
    private boolean isVisited;

    final private List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public String getName() {
        return name;
    }

    public void setIsVisited(boolean b) {
        this.isVisited = b;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }
}
