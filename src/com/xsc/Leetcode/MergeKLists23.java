package com.xsc.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个有序链表
 *
 * @author Jakexsc
 * 2022/4/29
 */
public class MergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 将链表数组传入优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        // 生成内存空间
        ListNode temp = new ListNode(0);
        ListNode result = temp;

        // 遍历优先队列
        while (queue.size() != 0) {
            ListNode poll = queue.poll();
            temp.next = poll;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
            temp = temp.next;
        }

        return result.next;
    }
}
