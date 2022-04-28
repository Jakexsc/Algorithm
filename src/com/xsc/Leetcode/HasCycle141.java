package com.xsc.Leetcode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * @author Jakexsc
 * 2022/4/28
 */
public class HasCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowNode = head;
        ListNode quickNode = head.next;
        while (slowNode != quickNode) {
            if (quickNode == null || quickNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }
        return true;
    }

}
