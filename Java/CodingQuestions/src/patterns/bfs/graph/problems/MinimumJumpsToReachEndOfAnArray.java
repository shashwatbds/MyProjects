package patterns.bfs.graph.problems;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/minimum-jumps-to-same-value-or-adjacent-to-reach-end-of-array/
 * */

public class MinimumJumpsToReachEndOfAnArray {

    public static int minimizeJumps(int[] arr) {

        int n = arr.length;
        /**
         * Prepare index Map
         * This index map stores the each number and the ilst of indexes the number exists at.
         * */
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for(int i=0; i< n; i++) {
            if(indexMap.containsKey(arr[i])) {
                indexMap.get(arr[i]).add(i);//store number and list of index
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                indexMap.put(arr[i], indexList);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        // Push starting element into queue
        // and mark it visited
        queue.add(0);
        visited[0] = true;


        // Initialize a variable count for
        // counting the minimum number
        // of valid jump to reach at last index
        int count = 0;

        while(queue.size() > 0) {
            int size = queue.size();
            //Iterate on all elements of the queue
            for(int i=0; i < size; i++) {
                int curr = queue.poll();//fetch the current item
                //check if we have reached the end of the queue, if yes then return the count
                if(curr == n-1) {
                    return count/2;
                }

                //Allowed moves are one front, one back or same number at different index. We will check all 3 below -
                //1. Check if curr+1 is valid position to visit or not
                if(curr + 1 < n && !visited[curr+1]) {
                    queue.add(curr+1);
                    visited[curr+1] = true;
                }

                //2. Check if curr+1 is valid position to visit or not
                if(curr - 1 >= 0 && !visited[curr-1]) {
                    queue.add(curr-1);
                    visited[curr-1] = true;
                }

                //3. Now iterate over all elements which are similar to the current item
                if(indexMap.containsKey(arr[i])) {
                    for(int j=0; j<indexMap.get(arr[curr]).size(); j++) {
                        int child = indexMap.get(arr[curr]).get(j);//fetch first occurrence.
                        if(curr == child) {
                            continue;
                        }
                        //check if child is valid position to visit or not
                        if(!visited[child]) {
                            queue.add(child);
                            visited[child] = true;
                        }
                    }
                }
                //Erase all occurrences of curr from the map
                // sine we have already considered them for a valid jump in step 3.
                indexMap.remove(arr[curr]);
            }
            count++;
        }
        return count/2;
    }

    public static void main(String[] args) {

        int[] arr = {100, -23, -23, 404, 100,
                23,  23,  23,  3,   404};
        // Function call
        System.out.print(minimizeJumps(arr));
    }
}
