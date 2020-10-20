package com.xsc.graphstudy;

import java.util.LinkedList;

/**
 * 无向图
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/20 20:30
 */
public class Graph {
    /**
     * 顶点的数量
     */
    private int n;
    /**
     * 邻链表
     */
    private LinkedList<Integer>[] adj;

    public Graph(int n) {
        this.n = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图添加
     *
     * @param i 顶点
     * @param j 顶点
     */
    private void addEdge(int i, int j) {
        adj[i].add(j);
        adj[j].add(i);
    }
}
