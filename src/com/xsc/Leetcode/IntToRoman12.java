package com.xsc.Leetcode;

/**
 * 将数字转为罗马数字
 * 贪心算法
 *
 * @author Jakexsc
 * 2022/5/2
 */
public class IntToRoman12 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanStr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            while (num >= value) {
                sb.append(romanStr[i]);
                num -= value;
            }
        }
        return sb.toString();
    }
}
