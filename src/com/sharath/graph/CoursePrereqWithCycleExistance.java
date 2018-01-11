package com.sharath.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class CoursePrereqWithCycleExistance
{

    public static void main(String[] args)
    {
        /**
         * This course info has three courses. course 0 has prereq as null(in
         * which case there are no prereqs and just return the course itself).
         * course 1 has 0 as prereq and so on. There is a cycle in this.
         */
        Integer[][] courseInfo = { { 0, 2 }, { 1, 0 }, { 2, 1 }, { 3, 2 } };
        Stack<Integer> preReqs = findPrereqOfACourse(courseInfo, 2);
        while (!preReqs.isEmpty())
        {
            System.out.println(preReqs.pop());
        }
    }

    private static Stack<Integer> findPrereqOfACourse(Integer[][] courseInfo, int courseToTake)
    {
        LinkedList<Integer>[] graph = buildGraph(courseInfo);
        final Set<Integer> visiting = new HashSet<>();
        final Stack<Integer> visited = new Stack<>();
        return detectCycleAndGetPrereqs(courseToTake, visiting, visited, graph);
    }

    private static LinkedList<Integer>[] buildGraph(Integer[][] courseInfo)
    {
        LinkedList<Integer>[] graph = new LinkedList[courseInfo.length];
        for (int i = 0; i < courseInfo.length; i++)
        {
            LinkedList<Integer> l = new LinkedList<>();
            l.add(courseInfo[i][1]);
            graph[i] = l;
        }
        return graph;
    }

    private static Stack<Integer> detectCycleAndGetPrereqs(int courseToTake, Set<Integer> visiting,
            Stack<Integer> visited, LinkedList<Integer>[] graph)
    {
        visiting.add(courseToTake);
        for (Integer adj : graph[courseToTake])
        {
            if (adj == null)
                continue;
            if (visiting.contains(adj))
                throw new RuntimeException("There is a cycle");
            visited = detectCycleAndGetPrereqs(adj, visiting, visited, graph);
        }
        visited.push(courseToTake);
        visiting.remove(courseToTake);
        return visited;
    }

}
