package com.zxt.leetcode;

/**
 * 实现自己的链表 （带头尾结点，双向指针）
 */
public class MyLinkedList {
    private int size = 0;
    private Node first;
    private Node last;

    public MyLinkedList() {
    }

    public void add(int value) {
        Node tail = last;
        // 新加入的结点，加入到末尾，所以它的前一个结点就是现在的last结点
        Node node = new Node(value, null, tail);
        last = node;
        if (first == null) {
            first = node;
        } else {
            tail.next = node;
        }
        size++;
    }

    public void remove(int val) {
        if (first == null) {
            return;
        }

        if (first.value == val) {
            first = first.next;
            first.pre = null;
            return;
        }

        if (last.value == val) {
            last = last.pre;
            last.next = null;
            return;
        }

        Node node = first.next;
        while (node != null) {
            if (node.value == val) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                break;
            }
            node = node.next;
        }
    }

    public void showList() {
        if (first == null) {
            System.out.println("[]");
            return;
        }

        Node node = first;
        System.out.print("[");
        while (node.next != null) {
            System.out.print(node.value + ", ");
            node = node.next;
        }
        System.out.println(node.value + "]");
    }

    public void showListWithPre() {
        if (last == null) {
            System.out.println("[]");
            return;
        }

        Node node = last;
        System.out.print("[");
        while (node.pre != null) {
            System.out.print(node.value + ", ");
            node = node.pre;
        }
        System.out.println(node.value + "]");
    }

    /**
     * 链表结点的数据结构定义
     */
    private static class Node {
        int value;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int value, Node next, Node pre) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }
}
