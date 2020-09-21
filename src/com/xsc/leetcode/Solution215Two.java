package com.xsc.leetcode;

import java.util.Random;

/**
 * LeetCode215 -> 快排思想加随机基数
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/21 21:18
 */
public class Solution215Two {
    static Random random = new Random();

    /**
     * 查找入口
     *
     * @param nums 查找的数据
     * @param k    第K大元素
     * @return int
     */
    public int findKthLargest(int[] nums, int k) {
        // 如果只有一个元素，直接返回
        if (nums.length == 1) {
            return nums[0];
        }
        // 先分区
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 分区
     *
     * @param nums  分区的数组
     * @param p     最左下标
     * @param r     最有下标
     * @param index 第K大元素，等于换位后元素的下标
     * @return int
     */
    private int quickSelect(int[] nums, int p, int r, int index) {
        // 先调用随机基数函数，降低O(n^2)的概率
        int pivot = randomPivot(nums, p, r);
        /**
         * 因为分区后，从小到大排序，第K大元素就是数组的下标，它位置是固定的
         */
        if (index == pivot) {
            // 直接返回。
            return nums[index];
        } else {
            // 递归分区等于 n/2
            return index > pivot ? quickSelect(nums, pivot + 1, r, index) : quickSelect(nums, p, pivot - 1, index);
        }
    }

    /**
     * 产生随机基数
     *
     * @param arr 数组
     * @param p   最左边的下标
     * @param r   最右边的下标
     * @return int -> 分区后的基数下标
     */
    private int randomPivot(int[] arr, int p, int r) {
        // 产生随机基数下标
        int randomPivot = random.nextInt(r - p + 1) + p;
        // 和最后的元素调换位置
        swap(arr, randomPivot, r);
        // 然后进行分区
        return partition(arr, p, r);
    }

    /**
     * 分区函数
     *
     * @param arr 分区数组
     * @param p   最左边的下标
     * @param r   最右边的下标
     * @return int -> 基数下标
     */
    private int partition(int[] arr, int p, int r) {
        int q = p;
        int pivot = arr[r];
        for (int i = p; i < r; i++) {
            if (arr[i] <= pivot) {
                swap(arr, q++, i);
            }
        }
        swap(arr, q, r);
        return q;
    }

    /**
     * 换位函数
     *
     * @param nums        换位的数组
     * @param randomPivot 换位的元素下标
     * @param r           换位的元素下标
     */
    private void swap(int[] nums, int randomPivot, int r) {
        int temp = nums[randomPivot];
        nums[randomPivot] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        Solution215Two solution215Two = new Solution215Two();
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(solution215Two.findKthLargest(arr, 2));
    }
}
