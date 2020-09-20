package com.xsc.leetcode;

import java.util.PriorityQueue;

/**
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/20 23:04
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        return priorityQueue.poll();
    }
}
