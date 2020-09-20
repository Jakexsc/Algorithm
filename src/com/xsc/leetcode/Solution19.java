package com.xsc.leetcode;

import com.xsc.linkedstudy.ListNode;

/**
 * Leetcode19
 *
 * @author Jakexsc
 * @date : 2020-09-12 19:56
 */
public class Solution19 {
    /**
     * 删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * @param head 链表
     * @param n    删除位置
     * @return ListNode
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        // 关键思想：fast要比slow快n+1个位置。
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        // 判断快指针是否到达最后一个值
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        return dummy.next;
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
        System.out.println(removeNthFromEnd(listNode1, 2));
    }
}
