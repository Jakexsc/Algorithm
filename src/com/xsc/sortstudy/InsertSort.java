package com.xsc.sortstudy;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/18 22:07
 */
public class InsertSort {
    /**
     * 插入排序方法
     *
     * @param a 排序的数组
     * @param n 数组的长度
     */
    public void insertSort(int[] a, int n) {
        // 如果数组长度小于等于1，那么不需要排序
        if (n <= 1) {
            return;
        }
        /**
         * 插入排序有两个分区，一个已排序分区，初始化只有一个，默认是数组的第一个元素
         * 一个是未排序分区，这里循环的是未分区的元素，从数组的第二个元素开始
         */
        for (int i = 1; i < n; i++) {
            // 未排序分区的第一个元素的值
            int value = a[i];
            // 已分区的最后一个元素
            int j = i - 1;
            // 从已排序分区最后元素开始对比
            for (; j >= 0; j--) {
                // 如果已排序分区的元素大于未排序的元素
                if (a[j] > value) {
                    // 往后移一位
                    a[j + 1] = a[j];
                } else {
                    // 没有可以排序的
                    break;
                }
            }
            // 插入元素
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 1, 3, 2};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
