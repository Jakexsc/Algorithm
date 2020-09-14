package com.xsc.queuestudy;

/**
 * 链式队列
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/14 15:05
 */
public class LinkQueue {
    /**
     * 头部指针
     */
    private Node head;
    /**
     * 尾部指针
     */
    private Node tail;

    /**
     * 入队操作
     *
     * @param value 入队的值
     * @return Boolean -> 返回true入队成功，返回false入队失败
     */
    public Boolean push(Object value) {
        // 虚拟节点
        Node node = new Node(value);
        // 如果队列为空
        if (tail == null) {
            // 都指向虚拟节点
            tail = node;
            head = node;
        } else {
            // 尾部指针赋值并移动
            tail.next = node;
            tail = tail.next;
        }
        return true;
    }

    /**
     * 出队操作
     *
     * @return Object -> 出队的值
     */
    public Object pop() {
        // 如果头部为空，则队内没有数据
        if (head == null) {
            return null;
        }
        // 出队的数据
        Object value = head.value;
        // 移动指针
        head = head.next;
        // 如果头部为空，那么尾部指针也得为空
        if (head == null) {
            tail = null;
        }
        return value;
    }

    @Override
    public String toString() {
        return "LinkQueue{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        for (int i = 1; i < 8; i++) {
            System.out.println(linkQueue.push(i));
        }
        System.out.println(linkQueue);
        System.out.println(linkQueue.pop());
        System.out.println(linkQueue.pop());
        System.out.println(linkQueue);
    }

}
