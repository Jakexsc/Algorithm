package com.xsc.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jakexsc
 * 2022/4/29
 */
public class TwoNum01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
