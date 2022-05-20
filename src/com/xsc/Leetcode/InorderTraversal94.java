package com.xsc.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 *
 * @author Jakexsc
 * 2022/5/20
 */
public class InorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        outTreeNode(resultList, root);
        return resultList;
    }

    private void outTreeNode(List<Integer> resultList, TreeNode root) {
        if (root == null) {
            return;
        }
        outTreeNode(resultList, root.left);
        resultList.add(root.val);
        outTreeNode(resultList, root.right);
    }
}
