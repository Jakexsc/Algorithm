package com.xsc.leetcode;

/**
 * LeetCode34 时间复杂度为O(n) -> 暴力解法
 *
 * @author Jakexsc
 * @date : 2020-09-12 22:30
 */
public class Solution34 {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums   检索的数组
     * @param target 要检索的值
     * @return int[]
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] returnList = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                returnList[0] = i;
                break;
            }
        }
        if (returnList[0] == -1) {
            return returnList;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                returnList[1] = i;
                break;
            }
        }
        return returnList;
    }
}
