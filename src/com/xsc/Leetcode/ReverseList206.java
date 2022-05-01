package com.xsc.Leetcode;

/**
 * 力扣206 - 反转链表
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * @author Jakexsc
 * 2022/4/27
 */
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
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

        ReverseList206 reverseList206 = new ReverseList206();
        ListNode reverseList = reverseList206.reverseList(listNode1);
        System.out.println("reverseList = " + reverseList);
    }
}
