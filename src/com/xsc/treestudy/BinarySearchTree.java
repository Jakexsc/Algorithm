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

    public BinarySearchTree(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

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

    /**
     * 删除操作
     *
     * @param value 删除的值
     */
    private void deleteNode(int value) {
        // 记录当前节点，初始化为根节点
        TreeNode p = treeNode;
        // 记录父节点
        TreeNode pp = null;
        // 寻找要删除的值
        while (p != null && p.val != value) {
            pp = p;
            if (value > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没找到直接返回
        if (p == null) {
            return;
        }

        // 如果要删除的节点存在左节点和右节点，从右树寻找最小值来替换
        if (p.left != null && p.right != null) {
            /// 记录p
            TreeNode minP = p.right;
            // p的父节点
            TreeNode minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 把值替换
            p.val = minP.val;
            // 更新当前节点
            p = minP;
            // 更新父节点
            pp = minPP;
        }

        // 记录子节点
        TreeNode child;
        //如果它存在左节点或右节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
            // 不存在子节点
        } else {
            child = null;
        }

        // 删除的是根节点
        if (pp == null) {
            treeNode = child;
            // 指向父节点指向它的子节点，如果它不存在子节点，那么直接删除
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
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

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(33);
        TreeNode treeNode2 = new TreeNode(16);
        TreeNode treeNode3 = new TreeNode(50);
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(18);
        TreeNode treeNode6 = new TreeNode(34);
        TreeNode treeNode7 = new TreeNode(58);
        TreeNode treeNode8 = new TreeNode(15);
        TreeNode treeNode9 = new TreeNode(17);
        TreeNode treeNode10 = new TreeNode(25);
        TreeNode treeNode11 = new TreeNode(51);
        TreeNode treeNode12 = new TreeNode(66);
        TreeNode treeNode13 = new TreeNode(19);
        TreeNode treeNode14 = new TreeNode(27);
        TreeNode treeNode15 = new TreeNode(55);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.right = treeNode8;
        treeNode5.left = treeNode9;
        treeNode5.right = treeNode10;
        treeNode7.left = treeNode11;
        treeNode7.right = treeNode12;
        treeNode10.left = treeNode13;
        treeNode10.right = treeNode14;
        treeNode11.right = treeNode15;
        BinarySearchTree binarySearchTree = new BinarySearchTree(treeNode1);
        binarySearchTree.deleteNode(13);
    }
}
