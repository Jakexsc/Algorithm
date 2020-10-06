package com.xsc.leetcode;

/**
 * Leetcode 33
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/6 21:04
 */
public class Solution33 {
    /**
     * 搜索旋转排序数组
     *
     * @param nums   查询的数组
     * @param target 给定值
     * @return int -> 给定值下标
     */
    private static int search(int[] nums, int target) {
        // 声音最左边和最右边的下标
        int low = 0, high = nums.length - 1;
        // TODO 终止条件，注意是<=
        while (low <= high) {
            // 中间下标
            int mid = low + ((high - low) >> 1);
            // 如果中间值刚好等于给定值
            if (nums[mid] == target) {
                // 直接返回
                return mid;
                // 判断有序数组是在左边还是右边，如果最左边相等于中间值或者小于中间值，证明有序数组是在右边
            } else if (nums[low] <= nums[mid]) {
                // 如果给定值大于等于最左边的值且中间值大于给定值，那么我们要的给定值还在左边
                if (target >= nums[low] && nums[mid] > target) {
                    // 从左边搜索
                    high = mid - 1;
                } else {
                    // 从右边搜索
                    low = mid + 1;
                }
                // 如果有序数组是在右边的情况下
            } else {
                // 如果给定值大于中间值，且给定值小于等于最右边的值，证明还要从右边搜索
                if (target > nums[mid] && target <= nums[high]) {
                    // 从右边搜索
                    low = mid + 1;
                } else {
                    // 从左边搜索
                    high = mid - 1;
                }
            }
        }
        //没有我们要的值，直接返回-1;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3};
        System.out.println(Solution33.search(arr, 5));
    }
}
