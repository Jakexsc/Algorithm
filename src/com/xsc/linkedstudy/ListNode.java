package com.xsc.linkedstudy;

/**
 * 链表集合
 *
 * @author Jakexsc
 * @date : 2020-09-11 18:35
 */
public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public ListNode() {
    }
}
