package com.sharath.graph;

import com.sharath.graph.Graph.Vertex;

public class GenericGraphOperations
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Graph g = Graph.create(5);

        Vertex v1 = g.createVertex(1);
        Vertex v2 = g.createVertex(2);
        Vertex v3 = g.createVertex(3);
        Vertex v4 = g.createVertex(4);
        Vertex v5 = g.createVertex(5);

        Vertex[] vertices = g.getVertices();

        vertices[0] = v1;
        vertices[1] = v2;
        vertices[2] = v3;
        vertices[3] = v4;
        vertices[4] = v5;

        g.addEdge(v2, v3);

        g.addEdge(v2, v1);

        g.addEdge(v1, v4);
        g.addEdge(v3, v4);

        g.addEdge(v3, v5);
        g.addEdge(v2, v4);

        g.printGraph();
    }

}
