package com.zxt.leetcode;

/**
 * ʵ���Լ������� ����ͷβ��㣬˫��ָ�룩
 */
public class MyLinkedList {
    private int size = 0;
    private Node first;
    private Node last;

    public MyLinkedList() {
    }

    public void add(int value) {
        Node tail = last;
        // �¼���Ľ�㣬���뵽ĩβ����������ǰһ�����������ڵ�last���
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
     * ����������ݽṹ����
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
