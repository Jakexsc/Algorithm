package com.xsc.treestudy;

/**
 * 二叉树 -> 链式二叉树
 *
 * @author JakeXsc
 * @version 1.0
 * @date 2020/10/12 2:31
 */
public class TreeOrder {
    static class Node {
        public int value;
        public Node leftNode;
        public Node rightNode;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * 前序遍历 先打印根节点，在打印左节点，在打印右节点
     *
     * @param node 根节点
     */
    private static void preOrder(Node node) {
        // 遍历终止条件
        if (node == null) {
            return;
        }
        // 打印根节点
        System.out.print(node + " ");
        // 遍历左节点
        preOrder(node.leftNode);
        // 遍历右节点
        preOrder(node.rightNode);
    }

    /**
     * 中序遍历 -> 先遍历左节点，在打印根节点，在遍历右节点
     *
     * @param node 根节点
     */
    private static void inOrder(Node node) {
        // 遍历终止条件
        if (node == null) {
            return;
        }
        // 遍历左树
        inOrder(node.leftNode);
        // 打印根节点
        System.out.print(node + " ");
        // 遍历右节点
        inOrder(node.rightNode);
    }

    /**
     * 后序遍历 -> 先遍历左节点，在遍历右节点，在打印根节点
     *
     * @param node 根节点
     */
    private static void postOrder(Node node) {
        // 条件终止条件
        if (node == null) {
            return;
        }
        // 遍历左节点
        postOrder(node.leftNode);
        // 遍历右节点
        postOrder(node.rightNode);
        // 打印根节点
        System.out.print(node + " ");
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.leftNode = node2;
        node1.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        TreeOrder.preOrder(node1);
        System.out.println();
        TreeOrder.inOrder(node1);
        System.out.println();
        TreeOrder.postOrder(node1);
    }
}
