package com.xsc.linkedstudy;

/**
 * LeetCode876
 *
 * @author Jakexsc
 * @date : 2020-09-12 15:01
 */
public class Solution876 {
    /**
     * 快慢指针解决 链表中间节点
     *
     * @param head 头部节点
     * @return ListNode -> 慢指针就是中间节点
     */
    public static ListNode middleNode(ListNode head) {
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;
        // 如果快指针不等于空而且下一个指针也不等于空
        while (fast != null && fast.next != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(middleNode(listNode1));
    }
}
