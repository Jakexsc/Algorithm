package com.xsc.searchstudy;

/**
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/3 23:38
 */
public class BinarySearch {
    public static int bSearch(int[] arr, int n, int value) {
        // 左边指针
        int low = 0;
        // 右边指针
        int high = n - 1;
        // TODO 注意这里的条件是low <= high
        while (low <= high) {
            // 中间值下标
            int mid = low + (high - low) / 2;
            // 如果中间值刚好是我们要的值
            if (arr[mid] == value) {
                // 返回中间值下标
                return mid;
                // 如果中间值小于我们要的值，证明值在右边区域
            } else if (arr[mid] < value) {
                low = mid + 1;
                // // 如果中间值大于我们要的值，证明值在左边区域
            } else {
                high = mid - 1;
            }
        }
        // 没有我们要的值，直接返回-1;
        return - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        System.out.println(BinarySearch.bSearch(arr, arr.length, 23));
    }
}
