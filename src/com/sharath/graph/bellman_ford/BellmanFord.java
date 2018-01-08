package com.sharath.graph.bellman_ford;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sharath.graph.prims.Edge;
import com.sharath.graph.prims.Graph;
import com.sharath.graph.prims.Graph.Vertex;

/**
 * Bellman-Ford algorithm is a single-source shortest path algorithm, so when
 * you have negative edge weight then it can detect negative cycles in a graph.
 * The only difference between two is that Bellman Ford is capable also to
 * handle negative weights whereas Dijkstra Algorithm can only handle positives.
 * 
 * Time complexity of Dijkstras is better than this. This algo runs in O(V X E)
 * time complexity. In the worst case E can be V^2 so O(V^3).
 * 
 * Why dijkstras does not work for negative values?:
 * https://stackoverflow.com/questions/6799172/negative-weights-using-dijkstras-algorithm/6799344#6799344
 * 
 * @author sharath
 */
public class BellmanFord
{
    public static void main(String[] args)
    {
        final Graph g = Graph.create(5);
        final Vertex v0 = new Vertex("0");
        final Vertex v1 = new Vertex("1");
        final Vertex v2 = new Vertex("2");
        final Vertex v3 = new Vertex("3");
        final Vertex v4 = new Vertex("4");

        g.vertices[0] = v0;
        g.vertices[1] = v1;
        g.vertices[2] = v2;
        g.vertices[3] = v3;
        g.vertices[4] = v4;

        g.addEdge(v0, v3, 8);
        g.addEdge(v0, v2, 5);
        g.addEdge(v0, v1, 4);
        g.addEdge(v3, v4, 2);
        g.addEdge(v4, v3, 1);
        g.addEdge(v2, v4, 4);
        g.addEdge(v1, v2, -3);

        Map<Vertex, Vertex> path = getShortestPath(g, v0);
        for (Entry<Vertex, Vertex> entry : path.entrySet())
        {
            String key = entry.getKey().getName();
            String value = entry.getValue() == null ? "" : entry.getValue().getName();
            System.out.println(key + " -> " + value);
        }
    }

    private static Map<Vertex, Vertex> getShortestPath(final Graph g, Vertex source)
    {
        final Map<Vertex, Vertex> currentToParent = new HashMap<>();
        final Map<Vertex, Integer> distanceMap = new HashMap<>();

        int numberOfIterations = g.getVertices().length - 1;

        for (Vertex v : g.getVertices())
        {
            if (v.equals(source))
            {
                distanceMap.put(v, 0);
                continue;
            }
            distanceMap.put(v, Integer.MAX_VALUE);
        }
        currentToParent.put(source, null);

        while (numberOfIterations > 0)
        {
            for (Edge e : g.getAllEdges())
            {
                relax(e.getSource(), e.getDestination(), e.getWeight(), currentToParent, distanceMap);
            }
            numberOfIterations--;
        }

        // Running it for the Vth time to check if there is a cycle:
        for (Edge e : g.getAllEdges())
        {
            if (distanceMap.get(e.getDestination()) > distanceMap.get(e.getSource()) + e.getWeight())
            {
                throw new RuntimeException("There is a cycle in the graph.");
            }
        }
        return currentToParent;
    }

    private static void relax(Vertex u, Vertex v, int edgeWeight, Map<Vertex, Vertex> currentToParent,
            Map<Vertex, Integer> distanceMap)
    {
        if (distanceMap.get(v) > distanceMap.get(u) + edgeWeight)
        {
            distanceMap.put(v, distanceMap.get(u) + edgeWeight);
            currentToParent.put(v, u);
        }
    }
}
