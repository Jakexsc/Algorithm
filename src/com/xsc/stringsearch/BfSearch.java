package com.xsc.stringsearch;

/**
 * BF算法
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/21 16:02
 */
public class BfSearch {
    public static void main(String[] args) {
        String destStr = "JavaXsc";
        String subStr = "vaXsc";
        System.out.println(bfSearch(destStr, subStr));
    }

    /**
     * BF算法 -> 字符串匹配
     *
     * @param destStr 主串
     * @param subStr  模式串
     * @return int -> 找到返回模式串第一个字符在主串的索引
     */
    private static int bfSearch(String destStr, String subStr) {
        // 记录主串下标
        int x = 0;
        // 记录模式串下标
        int y = 0;
        // 如果主串没遍历完和模式串没遍历完
        while (x < destStr.length() && y < subStr.length()) {
            // 字符匹配
            if (destStr.charAt(x) == subStr.charAt(y)) {
                x++;
                y++;
                // 没匹配主串下标+1，模式串返回第一个字符的下标
            } else {
                x = x - y + 1;
                y = 0;
            }
        }
        // 如果模式串全部匹配完成
        if (y == subStr.length()) {
            // 返回下标
            return x - y;
        } else {
            // 否则返回-1
            return -1;
        }
    }
}
