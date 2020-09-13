package com.xsc.queuestudy;

/**
 * 循环顺序队列
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/9/14 0:26
 */
public class ListQueue {
    /**
     * 数组
     */
    private String[] items;
    /**
     * 数组大小
     */
    private int size;
    /**
     * 头指针
     */
    private int head;
    /**
     * 尾指针
     */
    private int tail;

    public ListQueue(int size) {
        this.size = size;
        items = new String[size];
    }

    /**
     * 入队操作
     *
     * @param item 入队的值
     * @return boolean -> true入队成功，false入队失败
     */
    public boolean push(String item) {
        /**
         * 如果尾部等于3，头部等于4 (3+1)%8等于4 -> 即等于头部位置，即队列已满
         */
        if ((tail + 1) % size == head) {
            return false;
        }
        // 赋值
        items[tail] = item;
        // tail + 1
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 出队操作
     *
     * @return String -> 出队的值
     */
    public String pop() {
        // 如果头部尾部相等，则队列为空
        if (tail == head) {
            return "队列为空";
        }
        // 头部则是出队的值
        String item = items[head];
        // head + 1
        head = (head + 1) % size;
        return item;
    }
}
