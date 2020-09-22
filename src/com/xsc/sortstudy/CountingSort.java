package com.xsc.sortstudy;

import java.util.Arrays;

/**
 * 计数排序 - 时间复杂度O(n)
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/22 21:26
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        countingSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 排序入口
     *
     * @param arr 排序的数组
     * @param n   数组长度
     */
    private static void countingSort(int[] arr, int n) {
        // 如果数组只有一个，直接返回
        if (n <= 1) {
            return;
        }
        // 记录最大的值
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        /**
         * 生成一个长度为最大值的数组，这里面保存着数组每个数的数量
         * 比如0有两个数，那么c[0] = 2; 表示0有两个
         */
        int[] c = new int[max + 1];
        for (int i = 0; i < n; ++i) {
            c[arr[i]]++;
        }

        /**
         * 将每个数都顺序增加，里面包含自己在内的数量
         * 比如c[0] = 2，c[1] = 0; 那么 c[1] = 2 + 0 = 2;
         */
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 生成一个临时数组拷贝用
        int[] r = new int[n];
        // 访问c数组的下标，即a数组某个数，来得到这个数应该存放的下标，访问之后将里面的数量 - 1
        for (int i = n - 1; i >= 0; i--) {
            // 得到下标
            int index = c[arr[i]]-- - 1;
            // 将元素排序
            r[index] = arr[i];
        }

        // 将排序后的数组拷贝给arr
        for (int i = 0; i < n; i++) {
            arr[i] = r[i];
        }
    }
}
