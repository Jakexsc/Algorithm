package com.xsc.sortstudy;

import java.util.Arrays;

/**
 * 快速排序 -> 分治思想
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/20 14:32
 */
public class QuickSort {
    /**
     * 分区并排序
     *
     * @param array      排序的数组
     * @param leftBound  左指针
     * @param rightBound 右指针
     */
    public static void quickSort(int[] array, int leftBound, int rightBound) {
        // 如果只有一个或者等于0个，那么不需要排序
        if (leftBound >= rightBound) {
            return;
        }
        // 左指针 -> 记录小于pivot的区域的下标
        int left = leftBound;
        // 右指针 -> 记录大于pivot的区域的下标
        int right = rightBound - 1;
        // 使用数组的最后一个元素作为基数来进行分区
        int pivot = array[rightBound];
        // 如果左边的指针大于等于右边的指针，那么不需要交换位置了
        while (left < right) {
            // 如果左边指针小于右边指针，而且值小于等于中间基数
            while (left < right && array[left] <= pivot) {
                // 指针移动到下一位
                left++;
            }
            // 如果左边指针小于右边指针，而且值大于等于中间基数
            while (left < right && array[right] >= pivot) {
                right--;
            }
            // 交换位置两边分区的位置
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        /**
         * 把基数放到左右分区的中间
         * 加上if是为了防止最后一个数大于前面所有的数，让它不用换位置
         */
        if (array[left] > pivot) {
            array[rightBound] = array[left];
            array[left] = pivot;
        }
        // 对左边分区进行排序
        quickSort(array, leftBound, left - 1);
        // 对右边分区进行排序
        quickSort(array, left + 1, rightBound);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 7, 6, 3, 5, 9, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
