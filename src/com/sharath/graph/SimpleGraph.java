package com.sharath.graph;

import java.util.LinkedList;
import java.util.List;

public class SimpleGraph
{
    private static List<Integer>[] graph;

    public static SimpleGraph create(int noOfVertices)
    {
        return new SimpleGraph(noOfVertices);
    }

    private SimpleGraph(int noOfVertices)
    {
        graph = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++)
        {
            graph[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int u)
    {
        graph[v].add(u);
    }

    public List<Integer>[] getGraph()
    {
        return graph;
    }

    public void printGraph()
    {
        for (int i = 0; i < graph.length; i++)
        {
            System.out.println(i + " -> " + graph[i]);
        }
    }
}
