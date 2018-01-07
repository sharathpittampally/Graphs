package com.sharath.graph.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sharath.graph.prims.BinaryHeap;
import com.sharath.graph.prims.Edge;
import com.sharath.graph.prims.Graph;
import com.sharath.graph.prims.Graph.Vertex;

/**
 * Single source shortest path - Given a single source, we need to know the
 * shortest path from the source to every other node in the graph.
 * 
 * @author sharath
 */
public class DijkstrasAlgorithm
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Graph g = Graph.create(6);
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        g.vertices[0] = a;
        g.vertices[1] = b;
        g.vertices[2] = c;
        g.vertices[3] = d;
        g.vertices[4] = e;
        g.vertices[5] = f;

        g.addEdge(a, b, 5);
        g.addEdge(a, d, 9);
        g.addEdge(a, e, 2);
        g.addEdge(b, a, 5);
        g.addEdge(b, c, 2);
        g.addEdge(c, b, 2);
        g.addEdge(c, d, 3);
        g.addEdge(d, a, 9);
        g.addEdge(d, c, 3);
        g.addEdge(d, f, 2);
        g.addEdge(e, a, 2);
        g.addEdge(e, f, 3);
        g.addEdge(f, e, 3);
        g.addEdge(f, d, 2);

        Map<Vertex, Vertex> path = findTheSingleSourceShortestPath(g, a);
        for (Entry<Vertex, Vertex> entry : path.entrySet())
        {
            String key = entry.getKey().getName();
            String value = entry.getValue() == null ? "" : entry.getValue().getName();
            System.out.println(key + " -> " + value);
        }
    }

    private static Map<Vertex, Vertex> findTheSingleSourceShortestPath(Graph g, Vertex source)
    {
        final Map<Vertex, Vertex> vertexToParent = new HashMap<>();
        final Map<Vertex, Integer> vertexToDist = new HashMap<>();
        vertexToParent.put(source, null);

        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.buildMinHeap(g);
        while (!binaryHeap.heap.isEmpty())
        {
            Vertex current = binaryHeap.getMin();
            vertexToDist.put(current, binaryHeap.map.get(current));
            binaryHeap.map.remove(current);
            for (Edge e : current.getEdges())
            {
                Vertex otherVertex = e.getOtherVertex(current);
                int distFromA = e.getWeight() + (vertexToDist.get(current) == null ? 0 : vertexToDist.get(current));
                if (binaryHeap.map.containsKey(otherVertex) && binaryHeap.map.get(otherVertex) > distFromA)
                {
                    binaryHeap.decrease(otherVertex, distFromA);
                    vertexToParent.put(otherVertex, current);
                }
            }
        }
        return vertexToParent;
    }
}
