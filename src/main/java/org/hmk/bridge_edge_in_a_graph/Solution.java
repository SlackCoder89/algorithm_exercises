package org.hmk.bridge_edge_in_a_graph;

import java.util.*;

public class Solution {
    static int isBridge(int v, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        Graph g = new Graph(adj, c, d);

        return !g.isReachable(c, d) ? 1 : 0;
    }
}

class Graph {
    Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public Graph(ArrayList<ArrayList<Integer>> adj, int v1, int v2) {
        for (int i = 0; i < adj.size(); ++i) {
            graph.put(i, adj.get(i));
        }
        graph.getOrDefault(v1, new ArrayList<>()).remove(Integer.valueOf(v2));
        graph.getOrDefault(v2, new ArrayList<>()).remove(Integer.valueOf(v2));
    }

    public boolean isReachable(int v1, int v2) {
        boolean result = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> nodes = graph.get(node);
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            for (int n : nodes) {
                if (n == v2) {
                    return true;
                }
                if (visited.contains(n)) {
                    continue;
                }
                queue.offer(n);
            }
            visited.add(node);
        }
        return result;
    }
}
