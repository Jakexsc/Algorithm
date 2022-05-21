package com.xsc.Leetcode;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 *
 * @author Jakexsc
 * 2022/5/21
 */
public class RepeatedNTimes961 {
    public int repeatedNTimes(int[] nums) {
        boolean[] flag = new boolean[10000];
        for(int num : nums) {
            if(flag[num]) {
                return num;
            }
            flag[num] = true;
        }
        return 0;
    }
}
