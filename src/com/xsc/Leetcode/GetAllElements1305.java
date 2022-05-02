package com.xsc.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 遍历树，获取有序数组
 *
 * @author Jakexsc
 * 2022/5/1
 */
public class GetAllElements1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        addNode(result, root1);
        addNode(result, root2);
        Collections.sort(result);
        return result;
    }

    public void addNode(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        addNode(result, treeNode.left);
        result.add(treeNode.val);
        addNode(result, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        treeNode1.left = new TreeNode(-10);
        treeNode1.right = new TreeNode(10);

        TreeNode treeNode2 = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        treeNode2.left = left;
        TreeNode right = new TreeNode(7);
        treeNode2.right = right;
        left.left = new TreeNode(0);
        right.right = new TreeNode(2);

        GetAllElements1305 getAllElements1305 = new GetAllElements1305();
        List<Integer> allElements = getAllElements1305.getAllElements(treeNode1, treeNode2);
        System.out.println(allElements);
    }
}
