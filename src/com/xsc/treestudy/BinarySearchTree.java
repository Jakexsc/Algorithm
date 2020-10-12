package com.xsc.treestudy;

/**
 * 二叉查找树
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/12 16:16
 */
public class BinarySearchTree {
    private TreeNode treeNode;

    /**
     * @param value 要找的值
     * @return TreeNode -> 找到的节点
     */
    private TreeNode findValue(int value) {
        // 记录根节点
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

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
