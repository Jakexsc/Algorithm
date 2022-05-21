package com.xsc.Leetcode;

/**
 * 翻转二叉树
 *
 * @author Jakexsc
 * 2022/5/21
 */
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
