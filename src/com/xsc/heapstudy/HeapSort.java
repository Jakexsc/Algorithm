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
     * 插入操作 -> 自下往上的堆化
     *
     * @param data 插入的值
     */
    private void insert(int data) {
        // 如果数组已经满了，那么插入不成功
        if (count == n) {
            return;
        }
        // 插入值
        arr[++count] = data;
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
     * 删除操作
     *
     * @param data 删除的值
     */
    private void delete(int data) {
        if (count == 0) {
            return;
        }
        arr[1] = arr[count--];
        heapify(arr, count, 1);
    }

    /**
     * 堆化 -> 自上往下的堆化
     *
     * @param arr   堆
     * @param count 最后一个值的小标
     * @param i     堆顶
     */
    private void heapify(int[] arr, int count, int i) {
        while (true) {
            // 记录交换的下标 -> 初始化为堆顶
            int maxPos = i;
            // 如果左节点比父节点还大
            if (i * 2 <= count && arr[i] < arr[i * 2]) {
                // 记录左节点位置
                maxPos = i * 2;
            }
            // 如果右节点比左节点或比父节点还大
            if (i * 2 + 1 <= count && arr[maxPos] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 如果堆顶是最大值，直接退出交换位置
            if (maxPos == i) {
                break;
            }
            // 交换父节点与最大值的位置
            swap(arr, i, maxPos);
            // 记录下一次循环的下标，就是左节点或右节点
            i = maxPos;
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
