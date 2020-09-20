package com.xsc.leetcode;

import java.util.PriorityQueue;

/**
 * LeetCode215 优先队列
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/20 23:04
 */
public class Solution215 {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
     *
     * @param nums 要检索的数组
     * @param k    找出第K大的数字
     * @return int 找出来的数据
     */
    public int findKthLargest(int[] nums, int k) {
        // 使用优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        // 遍历数组
        for (int num : nums) {
            // 如果优先队列的大小小于k，那么添加数据
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
                // 如果取出的头元素还小于这个num，那么移除头元素，添加这个num
            } else if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        return priorityQueue.poll();
    }
}
