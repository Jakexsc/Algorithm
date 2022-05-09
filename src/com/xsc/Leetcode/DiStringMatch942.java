package com.xsc.Leetcode;

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 *
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 *
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 *
 * @author Jakexsc
 * 2022/5/9
 */
public class DiStringMatch942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int min = 0;
        int max = n;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            result[i] = s.charAt(i) == 'I' ? min ++ : max --;
        }
        result[n] = min;
        return result;
    }

    public static void main(String[] args) {
        DiStringMatch942 diStringMatch942 = new DiStringMatch942();
        diStringMatch942.diStringMatch("IDIDD");
    }
}
