package com.zxt.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static void add(ListNode head, ListNode listNode) {
        if (head == null) {
            return;
        }

        ListNode pNode = head;
        while (pNode.next != null) {
            pNode = pNode.next;
        }

        pNode.next = listNode;
    }

    public void showList() {
        if (this == null) {
            System.out.println("[]");
            return;
        }

        ListNode pNode = this;
        System.out.print("[");
        while (pNode.next != null) {
            System.out.print(pNode.val + ", ");
            pNode = pNode.next;
        }
        System.out.println(pNode.val + "]");
    }
}
