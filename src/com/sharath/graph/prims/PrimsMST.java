package com.sharath.graph.prims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sharath.graph.prims.Graph.Vertex;

public class PrimsMST
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

        g.addEdge(a, d, 1);
        g.addEdge(a, b, 3);
        g.addEdge(b, a, 3);
        g.addEdge(b, d, 3);
        g.addEdge(b, c, 1);
        g.addEdge(c, b, 1);
        g.addEdge(c, d, 1);
        g.addEdge(c, e, 5);
        g.addEdge(c, f, 4);
        g.addEdge(d, a, 1);
        g.addEdge(d, b, 3);
        g.addEdge(d, c, 1);
        g.addEdge(d, e, 6);
        g.addEdge(e, d, 6);
        g.addEdge(e, c, 5);
        g.addEdge(e, f, 2);
        g.addEdge(f, e, 2);
        g.addEdge(f, c, 4);

        List<Edge> mst = findMST(g);
        for (Edge edge : mst)
        {
            System.out.print(edge + ", ");
        }
    }

    private static List<Edge> findMST(Graph g)
    {
        Map<Vertex, Edge> vertexToEdge = new HashMap<>();
        List<Edge> result = new ArrayList<>();
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.buildMinHeap(g);
        while (!binaryHeap.heap.isEmpty())
        {
            Vertex min = binaryHeap.getMin();
            binaryHeap.map.remove(min);
            if (vertexToEdge.containsKey(min))
            {
                result.add(vertexToEdge.get(min));
            }
            for (Edge e : min.getEdges())
            {
                Vertex otherVertex = e.getOtherVertex(min);

                if (binaryHeap.map.containsKey(otherVertex) && binaryHeap.map.get(otherVertex) > e.weight)
                {
                    binaryHeap.decrease(otherVertex, e.weight);
                    vertexToEdge.put(otherVertex, e);
                }
            }
        }
        return result;
    }
}
