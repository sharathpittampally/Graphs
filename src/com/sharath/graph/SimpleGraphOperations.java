package com.sharath.graph;

public class SimpleGraphOperations
{
    public static void main(String[] args)
    {
        SimpleGraph g = SimpleGraph.create(5);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 10);
        g.addEdge(4, 9);
        g.addEdge(4, 11);
        g.addEdge(0, 1);
        g.addEdge(0, 11);
        g.addEdge(0, 15);

        g.printGraph();
    }
}
