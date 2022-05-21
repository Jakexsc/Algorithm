package com.xsc.Leetcode;

/**
 * 查找二叉树的深度
 *
 * @author Jakexsc
 * 2022/5/21
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSize = maxDepth(root.left);
        int rightSize = maxDepth(root.right);
        return Math.max(leftSize, rightSize) + 1;
    }
}
