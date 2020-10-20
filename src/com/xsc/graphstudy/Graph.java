package com.xsc.graphstudy;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 标志是否找到值
     */
    private boolean found = false;

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

    /**
     * 广度优先搜索 -> 搜索顶点s 到 顶点t的路径
     *
     * @param s 顶点
     * @param t 顶点
     */
    private void bfs(int s, int t) {
        // 如果顶点s和顶点t一致，证明值相同，直接返回
        if (s == t) {
            return;
        }
        // 如果顶点被访问设置为true，用来避免顶点被重复访问
        boolean[] visited = new boolean[n];
        // 先设置第一个访问的顶点为true
        visited[s] = true;
        // 用来存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        // 先添加第一个顶点
        queue.add(s);
        // 路径
        int[] prev = new int[n];
        // 先遍历路径数组，默认值为-1
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
        }

        // 如果队列不为空
        while (queue.size() != 0) {
            // 取出值
            int poll = queue.poll();
            // 遍历顶点的边
            for (int i = 0; i < adj[poll].size(); i++) {
                // 先取出第一条边
                int q = adj[poll].get(i);
                // 如果它不为true
                if (visited[q] != true) {
                    // 将它设置为上一个顶点
                    prev[q] = poll;
                    // 如果找到我们搜索最后的顶点
                    if (q == t) {
                        // 打印出来
                        print(prev, s, t);
                        return;
                    }
                }
                // 将它设置为访问过
                visited[q] = true;
                // 并添加到队列里面
                queue.add(q);
            }
        }
    }

    private void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[n];
        // 路径
        int[] prev = new int[n];
        // 先遍历路径数组，默认值为-1
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        // 如果找到值
        if (found == true) {
            return;
        }
        // 设置已访问
        visited[w] = true;
        // 如果找到值
        if (w == t) {
            // 设置找到值
            found = true;
            return;
        }
        // 遍历顶点的相邻顶点
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            // 如果还没被访问
            if (!visited[q]) {
                // 如果顶点的上一个访问顶点
                prev[q] = w;
                // 继续遍历当前的顶点
                recurDfs(q, t, visited, prev);
            }
        }
    }

    /**
     * 递归打印路径，从后开始递归 顶点s -> 顶点t
     *
     * @param prev 路径数组
     * @param s    第一个顶点s
     * @param t    最后的顶点t
     */
    private void print(int[] prev, int s, int t) {
        // 如果不是我们开始搜索的顶点
        if (prev[t] != -1 && t != s) {
            // 继续向前递归，传入我们的这个顶点的向一个顶点
            print(prev, s, prev[t]);
        }
        // 如果是则打印
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.bfs(0, 6);
        System.out.println();
        graph.dfs(0, 6);
    }
}
