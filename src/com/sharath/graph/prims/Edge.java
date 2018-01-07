package com.sharath.graph.prims;

import com.sharath.graph.prims.Graph.Vertex;

public class Edge
{
    Vertex vertex1;
    Vertex vertex2;
    int weight;

    public Edge(Vertex v1, Vertex v2, int weight)
    {
        vertex1 = v1;
        vertex2 = v2;
        this.weight = weight;
    }

    public int getWeight()
    {
        return weight;
    }

    public Vertex getOtherVertex(Vertex v)
    {
        if (v == vertex1)
            return vertex2;
        return vertex1;
    }

    public String toString()
    {
        return vertex1.getName() + vertex2.getName();
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
        Edge other = (Edge) obj;
        if (vertex1 == null)
        {
            if (other.vertex1 != null)
                return false;
        }
        else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null)
        {
            if (other.vertex2 != null)
                return false;
        }
        else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }
}
