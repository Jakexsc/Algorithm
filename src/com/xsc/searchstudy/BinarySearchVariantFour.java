package com.xsc.searchstudy;

/**
 * 二分查找 -> 查找最后一个小于等于给定值的元素
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/6 19:27
 */
public class BinarySearchVariantFour {
    /**
     * 查找最后一个小于等于给定值的元素方法
     *
     * @param arr   查找的数组
     * @param n     数组的长度
     * @param value 查找的值
     * @return int -> 查找最后一个小于等于给定值的元素的下标
     */
    private static int bSearch(int[] arr, int n, int value) {
        // 最左边下标
        int low = 0;
        // 最右边下标
        int high = n - 1;
        // TODO 注意这里的条件是low <= high
        while (low <= high) {
            // 中间值
            int mid = low + ((high - low) >> 1);
            // 如果这个值小于等于给定值的元素
            if (arr[mid] <= value) {
                // 如果这个值是最后一个值或者它后面的一个值大于我们的给定值
                if (mid == n - 1 || arr[mid + 1] > value) {
                    // 直接返回下标
                    return mid;
                } else {
                    // 证明这个值不是最后一个小于等于给定值的下标
                    low = mid + 1;
                }
                // 如果这个值大于给定值
            } else {
                // 那么我们要找的值就在左边的区域
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 10};
        System.out.println(BinarySearchVariantFour.bSearch(arr, arr.length, 5));
    }
}
