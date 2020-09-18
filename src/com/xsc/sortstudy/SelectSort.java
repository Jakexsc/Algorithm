package com.xsc.sortstudy;

import java.util.Arrays;

/**
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/18 22:52
 */
public class SelectSort {
    public void selectSort(int[] a, int n) {
        // 如果长度小于等于1，不需要排序
        if (n <= 1) {
            return;
        }
        // 每个位置都需要选择最小值
        for (int i = 0; i < n; i++) {
            // 设置已未分区下标
            int min = i;
            // 寻找整个数组的最小值
            for (int j = i + 1; j < n; j++) {
                // 选择最小值
                if (a[j] < a[min]) {
                    // 记录最小值下标
                    min = j;
                }
            }
            // 如果下标已经改变
            if (min != i) {
                // 先记录当前位置
                int temp = a[i];
                // 把当前位置设置为最小值
                a[i] = a[min];
                // 把最小值的位置的值与当前位置调换
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 1, 3, 2};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
