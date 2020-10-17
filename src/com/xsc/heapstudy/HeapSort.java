package com.xsc.heapstudy;

/**
 * 堆
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/18 0:59
 */
public class HeapSort {
    /**
     * 堆 -> 完全二叉树用数组效率高
     */
    private int[] arr;
    /**
     * 数组现有个数
     */
    private int count;
    /**
     * 数组可存个数
     */
    private int n;

    public HeapSort(int capacity) {
        arr = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入操作
     *
     * @param data 插入的值
     */
    private void insert(int data) {
        // 如果数组已经满了，那么插入不成功
        if (count == n) {
            return;
        }
        // 插入值
        arr[count++] = data;
        // 记录插入的下标
        int i = count;
        // 如果不是根节点而且插入的值比父节点大
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            // 交换位置
            swap(arr, i, i / 2);
            // 将节点下标变为父节点下标
            i = i / 2;
        }
    }

    /**
     * 交换位置
     *
     * @param arr 数组
     * @param i   交换第一个值
     * @param j   交换第二个值
     */
    private void swap(int[] arr, int i, int j) {
        int value = arr[i];
        arr[i] = arr[j];
        arr[j] = value;
    }
}
