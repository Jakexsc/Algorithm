package com.xsc.sortstudy;

import java.util.Arrays;
import java.util.Random;

/**
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/21 22:13
 */
public class QuickSortThree {
    static Random random = new Random();

    public static void quickSortThree(int[] arr, int p, int r) {
        /**
         * 递归终止条件
         */
        if (p >= r) {
            return;
        }
        // 获取pivot的下标
        int mid = randomPartition(arr, p, r);
        // 对左边的区域再进行分区
        quickSortThree(arr, p, mid - 1);
        // 对右边的区域再进行分区
        quickSortThree(arr, mid + 1, r);
    }

    private static int randomPartition(int[] arr, int p, int r) {
        int randomPovit = random.nextInt(r - p) + p;
        swap(arr, randomPovit, r);
        return partition(arr, p, r);
    }

    /**
     * 分区
     *
     * @param arr 分区的数组
     * @param p   左边分区
     * @param r   右边分区
     * @return int -> pivot所在位置
     */
    private static int partition(int[] arr, int p, int r) {
        // 记录比pivot小的下标
        int q = p;
        // 基数
        int pivot = arr[r];
        // < r 是用最后一个数作为基数来进行对比，所以不用<= r
        for (int i = p; i < r; i++) {
            // 如果当前的值小于 pivot
            if (arr[i] <= pivot) {
                /**
                 * 换完位置把下标+1
                 */
                //
                swap(arr, q++, i);
            }
        }
        // 极端情况下，所有元素原地换位置。时间复杂度为O(n^2) -> 所以我们可以随机选取为基数来提高效率
        swap(arr, q, r);
        // 返回当前pivot的下标回去
        return q;
    }

    /**
     * 交换位置 -> 交换比pivot小的和最后交换pivot到合适的位置
     *
     * @param arr 交换的数组
     * @param i   交换左边的位置
     * @param j   交换右边的位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 32) ? 32 : n + 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        quickSortThree(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
