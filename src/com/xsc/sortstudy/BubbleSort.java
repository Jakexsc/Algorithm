package com.xsc.sortstudy;

/**
 * 冒泡排序
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/18 16:01
 */
public class BubbleSort {
    /**
     * 排序方法
     *
     * @param a 排序的数组
     * @param n 数组长度
     */
    public void sort(int[] a, int n) {
        // 如果数组只有一个或者空，直接不排序
        if (n <= 1) {
            return;
        }
        // n等于冒泡的次数
        for (int i = 0; i < n; i++) {
            // 提前结束标记
            Boolean flag = false;
            // n - i表示减去已经冒泡的次数，-1，因为是跟下一个做对比，如果是末尾那么下一个是空
            for (int j = 0; j < n - i - 1; j++) {
                // 如果当前值大于后面的值
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 如果没有数据交换，则不进行冒泡了
            if (!flag) {
                break;
            }
        }
    }
}
