package com.sharath.graph;

import java.util.LinkedList;

public class Graph
{

    private int sizeOfGraph;

    Vertex[] vertices;

    public static Graph create(int sizeOfGraph)
    {
        return new Graph(sizeOfGraph);
    }

    private Graph(int sizeOfGraph)
    {
        this.sizeOfGraph = sizeOfGraph;
        vertices = new Vertex[sizeOfGraph];
    }

    public Vertex[] getVertices()
    {
        return vertices;
    }

    public void addEdge(Vertex v, Vertex u)
    {
        for (int i = 0; i < sizeOfGraph; i++)
        {
            if (vertices[i] == null)
            {
                v.getAdjecentList().add(u);
                vertices[i] = v;
                break;
            }
            if (vertices[i].getData() == v.getData())
            {
                vertices[i].getAdjecentList().add(u);
            }
        }

    }

    public Vertex createVertex(int data)
    {
        return new Vertex(data);
    }

    public void printGraph()
    {
        for (Vertex v : vertices)
        {
            System.out.println(v);
        }
    }

    /**
     * Represents each vertex in the graph
     * 
     * @author sharath
     *
     */
    public static class Vertex
    {
        int data;
        LinkedList<Vertex> adjecentNodes;

        public Vertex(int data)
        {
            this.data = data;
            adjecentNodes = new LinkedList<>();
        }

        public int getData()
        {
            return data;
        }

        public LinkedList<Vertex> getAdjecentList()
        {
            return adjecentNodes;
        }

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder(50).append(data).append(" -> ");
            for (Vertex v : adjecentNodes)
                sb.append(v.data + ", ");
            return sb.toString();
        }
    }
}
