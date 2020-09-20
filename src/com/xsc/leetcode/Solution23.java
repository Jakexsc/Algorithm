package com.xsc.leetcode;

import com.xsc.linkedstudy.ListNode;

import java.util.PriorityQueue;

/**
 * LeetCode23
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/16 19:23
 */
public class Solution23 {
    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表
     *
     * @param lists 链表数组
     * @return ListNode -> 排序后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 创建优先级队列，会自动帮我们排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.value, l2.value));
        // 将链表数组中的链表添加到优先级队列中
        for (ListNode listNode : lists) {
            // 判空操作
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        // 创建虚拟节点
        ListNode dummy = new ListNode(0);
        // 指向同一块内存
        ListNode head = dummy;
        // 如果队列中有值
        while (!queue.isEmpty()) {
            // 取出头部最小的链表
            ListNode poll = queue.poll();
            // 下一个节点的指针指向poll
            head.next = poll;
            // 头部指向下一个节点的内存
            head = head.next;
            // 如果取出的链表还有节点
            if (poll.next != null) {
                // 再添加到优先级队列中
                queue.add(poll.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);

        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);

        System.out.println(new Solution23().mergeKLists(listNodes));
    }
}
