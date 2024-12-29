package org.example.blind75.arraysandhashing.medium;

import java.util.*;

/**
 * Amazon
 * */
public class TopKFrequentElementsInList {

    public static void main(String[] args) {
        TopKFrequentElementsInList obj = new TopKFrequentElementsInList();
//        System.out.println(obj.topKFrequentBruteForce(new int[]{1,1,1,2,2,3}, 2));
//        System.out.println(obj.topKFrequentBruteForce(new int[]{7,7}, 1));
//
//        System.out.println("\nEfficient Solution");
//        System.out.println(obj.topKFrequentEfficient(new int[]{1,1,1,2,2,3}, 2));
//        System.out.println(obj.topKFrequentEfficient(new int[]{7,7}, 1));

        System.out.println("\nMost Efficient Solution");
        System.out.println(obj.topKFrequentMostEfficient(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(obj.topKFrequentMostEfficient(new int[]{7,7}, 1));
        System.out.println(obj.topKFrequentMostEfficient(new int[]{1,2,2,3,3,3}, 2));
    }


    /**
     * Uses bucket sort.
     * Time Complexity: O(nlogk)
     * Space Complexity: O(n)
     * */
    private int[] topKFrequentMostEfficient(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int key : hm.keySet()) {
            int freq = hm.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }


        int[] ans = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    ans[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return ans;
    }

    /**
     * Uses bucket sort.
     * Time Complexity: O(nlogk)
     * Space Complexity: O(n)
     * */
    private int[] topKFrequentEfficient(int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue());

        // Go through all numbers of the numFrequencyMap and push them into
        // topKElements, which will have
        // the top k frequent numbers. If the heap size is more than k, we remove the
        // smallest (top) number.
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            topKElements.add(entry);
            if (topKElements.size() > k) {
                topKElements.poll();
            }
        }

        // Create a list of top k numbers
        int[] topNumbers = new int[k];

        int i = 0;
        while (!topKElements.isEmpty()) {
            topNumbers[i] = topKElements.poll().getKey();
            i++;
        }

        return topNumbers;
    }

    /**
     * Time complexity: O(nlogn) - We are iterating the array once for n elements + sorting the map nlogn ~ O(nlogn)
     * */
    private int[] topKFrequentBruteForce(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                map.put(nums[i], val+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer> > list =
                new ArrayList<Map.Entry<Integer, Integer> >(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
