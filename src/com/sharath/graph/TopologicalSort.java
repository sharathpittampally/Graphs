package com.sharath.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.sharath.graph.Graph.Vertex;

public class TopologicalSort
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Graph g = Graph.create(7);

        Vertex v1 = g.createVertex(1);
        Vertex v2 = g.createVertex(2);
        Vertex v3 = g.createVertex(3);
        Vertex v4 = g.createVertex(4);
        Vertex v5 = g.createVertex(5);
        Vertex v6 = g.createVertex(6);
        Vertex v7 = g.createVertex(7);

        g.addEdge(v1, v3);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v2, v5);
        g.addEdge(v4, v6);
        g.addEdge(v6, v7);
        g.addEdge(v5, v6);

        Stack<Vertex> sortedOrder = topologicalSort(g);
        while (!sortedOrder.isEmpty())
        {
            System.out.print(sortedOrder.pop().data + ", ");
        }
    }

    private static Stack<Vertex> topologicalSort(final Graph g)
    {
        final Stack<Vertex> topSortStack = new Stack<Vertex>();
        final Set<Vertex> visitedSet = new HashSet<>();
        Vertex[] vertices = g.getVertices();
        for (Vertex v : vertices)
        {
            if (visitedSet.contains(v))
                continue;
            topSortUtil(v, topSortStack, visitedSet);
        }
        return topSortStack;
    }

    private static void topSortUtil(final Vertex v, final Stack<Vertex> stack, final Set<Vertex> visitedSet)
    {
        visitedSet.add(v);
        for (Vertex adj : v.adjecentNodes)
        {
            if (visitedSet.contains(adj))
                continue;
            topSortUtil(adj, stack, visitedSet);
        }
        stack.push(v);
    }
}
