package com.sharath.graph.prims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sharath.graph.prims.Graph.Vertex;

public class BinaryHeap
{
    public List<Vertex> heap = new ArrayList<>();
    public Map<Vertex, Integer> map = new HashMap<>();

    public void buildMinHeap(Graph g)
    {
        for (int i = 0; i < g.vertices.length; i++)
        {
            heap.add(g.vertices[i]);
            if (i == 0)
            {
                map.put(g.vertices[0], 0);
                continue;
            }
            map.put(g.vertices[i], Integer.MAX_VALUE);
        }
        buildMinHeap();
    }

    public Vertex getMin()
    {
        Vertex min = heap.remove(0);
        buildMinHeap();
        return min;
    }

    public void decrease(Vertex v, int newWeight)
    {
        map.put(v, newWeight);
        buildMinHeap();
    }

    private void buildMinHeap()
    {
        if (heap.size() == 1)
            return;
        int nonLeaf = ((int) Math.floor(heap.size() / 2)) - 1;
        for (int i = nonLeaf; i >= 0; i--)
        {
            minHeapify(i);
        }
    }

    private void minHeapify(int index)
    {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < heap.size() && map.get(heap.get(left)) <= map.get(heap.get(smallest)))
        {
            smallest = left;
        }
        if (right < heap.size() && map.get(heap.get(right)) < map.get(heap.get(smallest)))
        {
            smallest = right;
        }
        if (smallest != index)
        {
            Vertex temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);
        }
        if (smallest == index)
            return;
        minHeapify(smallest);
    }
}
