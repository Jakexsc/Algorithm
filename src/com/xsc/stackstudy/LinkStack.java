package com.xsc.stackstudy;

/**
 * 链式栈
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/13 21:51
 */
public class LinkStack {
    /**
     * 链式栈
     */
    private Node cur = new Node(null);

    private class Node {
        private Object val;
        private Node next;

        public Node(Object val) {
            this.val = val;
        }
    }

    /**
     * 入栈操作，反转链表思想
     *
     * @param value 入栈的值
     */
    public void push(Object value) {
        Node node = new Node(value);
        node.next = cur;
        cur = node;
    }

    /**
     * 出栈操作
     *
     * @return Object 出栈的对象
     */
    public Object pop() {
        // 如果链式栈为空，则出栈失败
        if (cur == null) {
            return null;
        }
        // 出栈的值
        Object val = cur.val;
        // 指针指向下一个
        cur = cur.next;
        return val;
    }
}
