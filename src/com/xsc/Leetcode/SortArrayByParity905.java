package com.xsc.Leetcode;

/**
 * 按奇偶数排序数组
 *
 * @author Jakexsc
 * 2022/4/28
 */
public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] resultList = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                resultList[left++] = num;
            } else {
                resultList[right--] = num;
            }
        }
        return resultList;
    }
}
