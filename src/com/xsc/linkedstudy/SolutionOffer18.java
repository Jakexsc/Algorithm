package com.xsc.linkedstudy;

/**
 * LeetCode 剑指Offer 18
 *
 * @author Jakexsc
 * @date : 2020-09-12 23:12
 */
public class SolutionOffer18 {
    /**
     * 给定单向链表的头指针和一个要删除的节点的值
     *
     * @param head 头节点
     * @param val  删除的值
     * @return ListNode -> 删除之后的头节点
     */
    public static ListNode deleteNode(ListNode head, int val) {
        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        // 连接链表
        dummy.next = head;
        ListNode temp = dummy;
        // 如果指针和下一个指针不为空
        while (temp != null && temp.next != null) {
            // 如果下一个指针的链表的值等于要删除的值
            if (temp.next.value == val) {
                // 删除链表
                temp.next = temp.next.next;
                // 直接返回
                return dummy.next;
            }
            //如果不是就指向下一个链表
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(deleteNode(listNode1, 1));
    }
}
