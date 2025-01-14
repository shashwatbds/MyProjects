package org.example.blind75.graphs.medium;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();

        for(int[] pre: prerequisites) {//graph structure where each node will contain linked list of courses it is dependent on.
            if(courseGraph.containsKey(pre[1])) {
                courseGraph.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> nextCourse = new LinkedList<>();
                nextCourse.add(pre[0]);
                courseGraph.put(pre[1], nextCourse);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        for(int currentCourse = 0; currentCourse<numCourses; currentCourse++) {
            if(courseSchedule(currentCourse, visited, courseGraph))
                return false;
        }
        return true;
    }

    /**Private method to find loop
     * returns true if there is a loop.
    **/
    private boolean courseSchedule(int currentCourse, HashSet<Integer> visited, HashMap<Integer, List<Integer>> courseGraph) {
        if(visited.contains(currentCourse))//if we have already visited the node this means we have encountered a loop
            return true;

        if(courseGraph.get(currentCourse) == null)//This means there are no dependencies of the course.
            return false;

        visited.add(currentCourse);//Since the course was not already present in visited, we must add it before we recursively loop
        // through its dependencies
        for(int pre : courseGraph.get(currentCourse)) {
            if(courseSchedule(pre, visited, courseGraph))
                return true;
        }
        visited.remove(currentCourse);//Once we have looped through their dependencies and the control has reached here,
        // this means this current course can be completed, and we must now eliminate its dependent course of the linked list.
        courseGraph.put(currentCourse, null);
        return false;
    }
}
