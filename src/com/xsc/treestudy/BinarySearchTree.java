package com.xsc.treestudy;

/**
 * 二叉查找树
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/12 16:16
 */
public class BinarySearchTree {
    // 记录根节点
    private TreeNode treeNode;

    /**
     * @param value 要找的值
     * @return TreeNode -> 找到的节点
     */
    private TreeNode findValue(int value) {
        TreeNode p = treeNode;
        // 如果节点不为空
        while (p != null) {
            // 如果查找的值比节点小，从左节点找
            if (value < p.val) {
                p = p.left;
                // 如果查找的值比节点小，从左节点找
            } else if (value > p.val) {
                p = p.right;
                // 如果查找的值与节点相等，直接返回
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入操作
     *
     * @param value 插入的值
     */
    private void insertValue(int value) {
        // 如果树为空，那么插入的值作为根节点
        if (treeNode == null) {
            treeNode = new TreeNode(value);
            return;
        }
        TreeNode p = treeNode;
        // 如果存在树
        while (p != null) {
            // 比根节点大，那么插入右树为空的位置上，如果不为空，一直找
            if (value > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(value);
                    return;
                }
                p = p.right;
                // 比根节点小，那么插入左树为空的位置上，如果不为空，一直找
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(value);
                    return;
                }
                p = p.left;
            }
        }

    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
