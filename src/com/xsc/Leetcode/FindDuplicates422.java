package com.xsc.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中的重复数据
 * Leetcode422
 *
 * @author Jakexsc
 * 2022/5/8
 */
public class FindDuplicates422 {
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if(i != nums[i] - 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        FindDuplicates422 findDuplicates422 = new FindDuplicates422();
        List<Integer> duplicates = findDuplicates422.findDuplicates(new int[]{1, 2, 3, 4, 5, 1, 2});
        System.out.println(duplicates);
    }
}
