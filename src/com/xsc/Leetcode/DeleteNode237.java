package com.xsc.Leetcode;

/**
 * @author Jakexsc
 * 2022/5/1
 */
public class DeleteNode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
