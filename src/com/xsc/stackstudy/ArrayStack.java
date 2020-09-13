package com.xsc.stackstudy;

/**
 * 顺序栈
 *
 * @author Jakexsc
 * @date : 2020-09-13 13:29
 */
public class ArrayStack {
    /**
     * 顺序栈数组
     */
    private String[] items;
    /**
     * 数组长度
     */
    private int n;
    /**
     * 数组下标
     */
    private int count;

    public ArrayStack(int n) {
        items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 进栈操作
     *
     * @param item 进栈的元素
     * @return boolean -> 添加成功返回true，失败返回false
     */
    public boolean push(String item) {
        // 如果count已满则进栈失败
        if (count == n) {
            return false;
        }
        // 进栈操作
        items[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈操作
     *
     * @return 返回后进栈的元素
     */
    public String pop() {
        // 如果栈为空
        if (count == 0) {
            return null;
        }
        // 返回count - 1的元素
        String item = items[count - 1];
        count--;
        return item;
    }
}
