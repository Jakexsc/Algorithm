package com.xsc.linkedstudy;

/**
 * LeetCode21
 *
 * @author Jakexsc
 * @date : 2020-09-12 13:34
 */
public class Solution21 {
    /**
     * 把单链表合并
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 标记下一个指针
        ListNode prev = new ListNode(0);
        // 保存数据
        ListNode temp = prev;
        // 如果它们都不为空
        while (l1 != null && l2 != null) {
            // 如果l1和l2值相等或l1比l2小
            if (l1.value <= l2.value) {
                // 把l1赋值
                prev.next = l1;
                // l1指向下一个值
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // 值赋值为下一个指针
            prev = prev.next;
        }
        // 肯定有一个先为空，那先把下一个指针赋值为一个链表，如果它等于空，那把另一个链表剩余的值，否则赋值当前链表
        prev.next = l1 == null ? l2 : l1;
        // 因为头部为0，那么返回要next一下
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        Solution21 solution21 = new Solution21();
        System.out.println(solution21.mergeTwoLists(l1, l2));
    }
}
