package com.sharath.graph.prims;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph
{

    private int sizeOfGraph;

    public Vertex[] vertices;
    public List<Edge> allEdges;

    public static Graph create(int sizeOfGraph)
    {
        return new Graph(sizeOfGraph);
    }

    private Graph(int sizeOfGraph)
    {
        this.sizeOfGraph = sizeOfGraph;
        vertices = new Vertex[sizeOfGraph];
        allEdges = new ArrayList<>();
    }

    public Vertex[] getVertices()
    {
        return vertices;
    }

    public List<Edge> getAllEdges()
    {
        return allEdges;
    }

    public void addEdge(Vertex v, Vertex u, int w)
    {
        for (int i = 0; i < sizeOfGraph; i++)
        {
            if (vertices[i].getName().equals(v.getName()))
            {
                vertices[i].getAdjecentList().add(u);
                Edge e = new Edge(v, u, w);
                vertices[i].edges.add(e);
                allEdges.add(e);
            }
        }

    }

    public Vertex createVertex(String name, int weight)
    {
        return new Vertex(name);
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
        String name;
        LinkedList<Vertex> adjecentNodes;
        List<Edge> edges;

        public Vertex(String name)
        {
            this.name = name;
            adjecentNodes = new LinkedList<>();
            edges = new ArrayList<>();
        }

        public String getName()
        {
            return name;
        }

        public List<Edge> getEdges()
        {
            return edges;
        }

        public LinkedList<Vertex> getAdjecentList()
        {
            return adjecentNodes;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (this.name.equals(other.name))
                return true;
            return false;
        }

        @Override
        public String toString()
        {
            // StringBuilder sb = new StringBuilder(50).append(name).append(" ->
            // ");
            // for (Vertex v : adjecentNodes)
            // sb.append(v.name + ", ");
            // return sb.toString();
            return name;
        }
    }
}
