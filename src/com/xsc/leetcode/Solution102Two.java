package com.xsc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode102 第二种解法 -> 递归
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/12 3:50
 */
public class Solution102Two {
    /**
     * 链表类
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 遍历入口
     * 二叉树的层序遍历 -> 递归
     *
     * @param root 节点
     * @return List<List < Integer>> -> 遍历后的数组
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 结果数组
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 递归
        bfsHelper(res, root, 0);
        return res;
    }

    /**
     * 递归方法
     *
     * @param res   遍历后的结果数组
     * @param root  节点
     * @param level 数组的下标
     */
    private static void bfsHelper(List<List<Integer>> res, TreeNode root, int level) {
        // 递归结束条件
        if (null == root) {
            return;
        }
        // 如果开启新的一层，那么创建一个子数组
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        // 添加到子数组里面
        res.get(level).add(root.val);
        // 遍历左节点
        bfsHelper(res, root.left, level + 1);
        // 遍历右节点
        bfsHelper(res, root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = null;
        treeNode2.right = null;
        treeNode3.left = new TreeNode(15);
        treeNode3.right = new TreeNode(7);
        Solution102Two.levelOrder(treeNode1);
    }

}
