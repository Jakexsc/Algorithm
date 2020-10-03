package com.xsc.searchstudy;

/**
 * 二分查找 -> 递归方式
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/4 0:17
 */
public class InternallyBinarySearch {
    /**
     * 查找入口
     *
     * @param arr   查找的数组
     * @param n     数组的长度
     * @param value 查找的值
     * @return int -> 值的下标
     */
    private static int binarySearch(int[] arr, int n, int value) {
        return internallyBinarySearch(arr, 0, n - 1, value);
    }

    /**
     * 递归方法
     *
     * @param arr   查找的数组
     * @param low   最左边的下标
     * @param high  最右边的下标
     * @param value 查找的值
     * @return int -> 值的下标
     */
    private static int internallyBinarySearch(int[] arr, int low, int high, int value) {
        // 递归终止条件，如果最左边的下标大于最右边的下标
        if (low > high) {
            return -1;
        }

        // 中间值
        int mid = low + (high - low) / 2;
        // 如果中间值等于要查找的值
        if (arr[mid] == value) {
            // 返回中间值下标
            return mid;
            // 如果中间值小于我们要的值，证明值在右边区域
        } else if (arr[mid] < value) {
            return internallyBinarySearch(arr, mid + 1, high, value);
            // 如果中间值大于我们要的值，证明值在左边区域
        } else {
            return internallyBinarySearch(arr, low, mid - 1, value);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        System.out.println(InternallyBinarySearch.binarySearch(arr, arr.length, 8));
    }

}
