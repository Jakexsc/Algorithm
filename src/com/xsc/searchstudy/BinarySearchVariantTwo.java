package com.xsc.searchstudy;

/**
 * 二分查找 -> 查找最后一个值等于给定值的元素
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/6 19:00
 */
public class BinarySearchVariantTwo {
    /**
     * 二分查找方法 -> 查找最后一个值等于给定值的元素
     *
     * @param arr   查找数组
     * @param n     数组长度
     * @param value 要查找的值
     * @return int 查找的值的下标 -> 数组最后一个出现该值的下标
     */
    private static int lastBinarySearch(int[] arr, int n, int value) {
        // 最左边的下标
        int low = 0;
        // 最右边的下标
        int high = n - 1;
        // TODO 注意这里的条件是low <= high
        while (low <= high) {
            // 中间值下标 TODO 使用异或更快
            int mid = low + ((high - low) >> 1);
            // 如果中间值小于我们要的值，证明值在右边区域
            if (arr[mid] < value) {
                low = mid + 1;
                // 如果中间值大于我们要的值，证明值在左边区域
            } else if (arr[mid] > value) {
                high = mid - 1;
                //如果值相等
            } else {
                // 判断它是不是数组的最后一个元素，或者它后面的值是不是也一样
                if (mid == n - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    // 继续在右边区域查找
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(BinarySearchVariantTwo.lastBinarySearch(arr, arr.length, 8));
    }
}
