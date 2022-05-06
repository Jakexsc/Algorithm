package com.xsc.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 *
 * 1 <= t <= 109
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 104 次
 *
 * @author Jakexsc
 * 2022/5/6
 */
public class RecentCounter933 {
    private Queue<Integer> queue;

    public RecentCounter933() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
