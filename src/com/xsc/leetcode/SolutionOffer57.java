package com.xsc.leetcode;

/**
 * LeetCode 剑指Offer 57
 *
 * @author Jakexsc
 * @date : 2020-09-12 23:52
 */
public class SolutionOffer57 {
    /**
     * 和为s的两个数字
     *
     * @param nums   检索的数组
     * @param target 和值
     * @return int[] 返回的数值
     */
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) {
                i++;
            } else if (s > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
