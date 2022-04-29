package com.xsc.Leetcode;

/**
 * 合并两个有序链表
 * LeetCode 21
 *
 * @author Jakexsc
 * 2022/4/29
 */
public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return result.next;
    }
}
