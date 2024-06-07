package org.hmk.min_cost_connected_points;

import java.util.*;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }
        Set<Point> rest = new HashSet<>();
        for (int i = 1; i < points.length; ++i) {
            rest.add(new Point(points[i][0], points[i][1]));
        }

        Point first = new Point(points[0][0], points[0][1]);
        Set<Point> visited = new HashSet<>();
        visited.add(first);
        Map<Point, PriorityQueue<Edge>> distMap = new HashMap<>();
        computeDist(first, distMap, rest);

        int sum = 0;
        while (!rest.isEmpty()) {
            Edge edge = null;
            for (Point point : visited) {
                Edge tmp = selectEdge(point, distMap, rest);
                if (tmp == null) {
                    continue;
                }
                if (edge == null) {
                    edge = tmp;
                } else {
                    edge = edge.distance > tmp.distance ? tmp : edge;
                }
            }
            visited.add(edge.end);
            distMap.get(edge.start).remove(edge);
            sum += edge.distance;
            rest.remove(edge.end);
            computeDist(edge.end, distMap, rest);
        }
        return sum;
    }

    private void computeDist(Point point, Map<Point, PriorityQueue<Edge>> distMap, Set<Point> set) {
        for (Point p : set) {
            int dist = Math.abs(point.x - p.x) + Math.abs(point.y - p.y);
            distMap.compute(point, (k, v) -> {
                if (v == null) {
                    PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
                    queue.add(new Edge(point, p, dist));
                    return queue;
                } else {
                    v.add(new Edge(point, p, dist));
                    return v;
                }
            });
        }
    }

    private Edge selectEdge(Point point, Map<Point, PriorityQueue<Edge>> distMap, Set<Point> rest) {
        PriorityQueue<Edge> queue = distMap.get(point);
        while (!queue.isEmpty()) {
            Edge e = queue.peek();
            if (rest.contains(e.end)) {
                return e;
            } else {
                queue.poll();
            }
        }
        return null;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

class Edge {
    Point start;
    Point end;
    int distance;

    public Edge(Point start, Point end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}