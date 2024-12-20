package org.example.blind75.arraysandhashing.medium;

import java.util.*;

/**
 * Amazon
 * */
public class TopKElementsInList {

    public static void main(String[] args) {
        TopKElementsInList obj = new TopKElementsInList();
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
        Map<Integer, Integer> count = new HashMap<>();
        int[] freq = new int[nums.length+1];

        for (int n : nums)//Creating a map of value and it's number of occurrences in array
            count.put(n, count.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : count.entrySet())//If element exits n times then add that the index which is equal to number of occurrences. Example - if 1 exits 3 times then at index 3 add 1.
            freq[entry.getValue()]= entry.getKey();

        int[] result = new int[k];
        int counter = 0;
        for(int i=nums.length; i>=0; i--)//The freq would be in ascending order hence we need to iterate from behind and only pick up values with non 0 values.
            if(freq[i] != 0 && counter < k) {//
                result[counter] = freq[i];
                counter++;
            }
        return result;
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
