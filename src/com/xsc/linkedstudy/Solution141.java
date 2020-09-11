package com.xsc.linkedstudy;

/**
 * LeetCode141 判断链表是否存在环 -> 快慢节点碰头则存在
 *
 * @author Jakexsc
 * @date : 2020-09-11 20:28
 */
public class Solution141 {
    public static boolean hasCycle(ListNode head) {
        // 如果它为空,或者下一个节点为空，它构不成环
        if (head == null || head.next == null) {
            return false;
        }
        // 走一步节点
        ListNode slow = head;
        // 走两步节点
        ListNode fast = head.next;
        // 如果它们没碰到
        while(slow != fast) {
            // 走两步肯定会先碰到null值，如果它等于空或者下一个节点等于空，它构不成环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 再走一步
            slow = slow.next;
            // 再走两步
            fast = fast.next.next;
        }
        return true;
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
        listNode5.next = listNode3;
        System.out.println(hasCycle(listNode1));
    }
}
