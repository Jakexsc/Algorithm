package com.xsc.graphstudy;

import java.util.LinkedList;

/**
 * 无向图 -> 邻接表
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
     * 顶点
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
     * 无向图添加边
     *
     * @param i 顶点
     * @param j 顶点
     */
    private void addEdge(int i, int j) {
        adj[i].add(j);
        adj[j].add(i);
    }
}
