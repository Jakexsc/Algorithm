package com.xsc.Leetcode;

/**
 * 合并两棵树，进行累加
 *
 * @author Jakexsc
 * 2022/5/21
 */
public class MergeTree617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergeTree = new TreeNode(root1.val + root2.val);
        mergeTree.left = mergeTrees(root1.left, root2.left);
        mergeTree.right = mergeTrees(root1.right, root2.right);
        return mergeTree;
    }
}
