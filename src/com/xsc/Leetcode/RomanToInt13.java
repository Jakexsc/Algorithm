package com.xsc.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author Jakexsc
 * 2022/5/2
 */
public class RomanToInt13 {
    Map<Character, Integer> valueMap = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Integer value = valueMap.get(s.charAt(i));
            if (i < length - 1 && value < valueMap.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt13 romanToInt13 = new RomanToInt13();
        int i = romanToInt13.romanToInt("MCMXCIV");
        System.out.println(i);
    }
}
