package com.xsc.treestudy;

/**
 * 全排列
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/17 22:50
 */
public class PrintPermutations {
    /**
     * 全排列方法入口
     *
     * @param arr   排序数组
     * @param start 开始的下标
     * @param end   全排列的个数
     */
    private static void printPermutations(int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {
            for (int i = 0; i < end; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // 排列
        for (int i = start; i < end; i++) {
            // 先交换位置
            swap(arr, start, i);
            // 后面的位置再进行全排列
            printPermutations(arr, start + 1, end);
            // 然后再把位置换回来
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int value = arr[start];
        arr[start] = arr[end];
        arr[end] = value;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        PrintPermutations.printPermutations(arr, 0, arr.length);
    }
}
