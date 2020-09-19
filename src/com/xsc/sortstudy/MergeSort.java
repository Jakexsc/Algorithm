package com.xsc.sortstudy;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/19 15:34
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 8, 3, 9, 7, 1, 2, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分治递归
     *
     * @param arr   排序的数组
     * @param left  左边分区第一个下标
     * @param right 右边分区第一个下标
     */
    public void mergeSort(int[] arr, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        // 记录中间位置
        int mid = (left + right) / 2;
        // 分左边分区
        mergeSort(arr, left, mid);
        // 分右边分区
        mergeSort(arr, mid + 1, right);
        // 并操作
        merge(arr, left, mid, right);
    }

    /**
     * 并
     *
     * @param arr   并的数组
     * @param left  左边分区第一个下标
     * @param mid   中间下标
     * @param right 右边分区第一个下标
     */
    public void merge(int[] arr, int left, int mid, int right) {
        // 记录着左边分区第一个下标
        int i = left;
        // 记录着右边分区第一个下标
        int j = mid + 1;
        // 虚拟数组
        int[] temp = new int[arr.length];
        // 记录虚拟数组的下标
        int t = 0;
        // 如果两边都还没排序完
        while (i <= mid && j <= right) {
            // 如果左边的值小于等于右边的值，那么将左边的值赋值，并移动下标
            temp[t++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        // 如果左边还有值，那么将左边剩余的值赋值
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        // 如果右边还有值，那么将右边剩余的值赋值
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        // 先将虚拟数组的下标移动到第一位
        t = 0;
        // 记录arr左边的下标
        int tempLeft = left;
        // 将虚拟数组的值拷贝到arr数组
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

}
