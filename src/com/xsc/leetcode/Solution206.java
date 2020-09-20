package com.xsc.leetcode;

import com.xsc.linkedstudy.ListNode;

/**
 * LeetCode206
 *
 * @author Jakexsc
 * @date : 2020-09-11 16:06
 */
public class Solution206 {
    /**
     * 反转链表
     *
     * @param head 头节点
     * @return ListNode 反转之后的链表
     */
    public static ListNode reverseList(ListNode head) {
        // 上一个节点
        ListNode prev = null;
        // 当前节点
        ListNode cur = head;
        // 如果当前节点不等于空
        while (cur != null) {
            // 保存当前节点的下一个节点的数据
            ListNode temp = cur.next;
            // 指针指向上一个节点
            cur.next = prev;
            // 保存上一个节点为本地节点
            prev = cur;
            // 把数据恢复
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        System.out.println(reverseList(listNode1));
    }
}
