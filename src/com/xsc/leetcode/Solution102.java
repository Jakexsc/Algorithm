package com.xsc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode102
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/12 2:58
 */
public class Solution102 {
    /**
     * 链表类
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树的层序遍历 -> 非递归
     *
     * @param root 树的根节点
     * @return List<List < Integer>> -> 遍历后的数组
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 树为空，直接返回
        if (root == null) {
            return new ArrayList<>(0);
        }
        // 存放遍历后结果
        List<List<Integer>> result = new ArrayList<>();
        // 用队列特性来存放树
        Queue<TreeNode> queue = new LinkedList<>();
        // 存入树
        queue.offer(root);
        // 如果队列不为空
        while (!queue.isEmpty()) {
            // 存放每一层的数据
            List<Integer> list = new ArrayList<>();
            // 存放队列的大小
            int curNodeSize = queue.size();
            // 遍历队列
            for (int i = 1; i <= curNodeSize; i++) {
                // 取出节点
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                // 如果它有左节点，继续存入队列
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                // 如果它有右节点，继续存入队列
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            // 添加到结果数组里面
            result.add(list);
        }
        return result;
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
        Solution102.levelOrder(treeNode1);
    }

}
