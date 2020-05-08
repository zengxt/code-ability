package com.zxt.leetcode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.add(head, new ListNode(2));
//        ListNode.add(head, new ListNode(3));
//        ListNode.add(head, new ListNode(4));
//        ListNode.add(head, new ListNode(5));

        head.showList();

        reverseBetween(head, 1, 2).showList();
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode p = head;
        // 记录下 m 的前一个节点 和 n 的后一个节点，中间的是需要反转的部分
        n--;
        m--;
        ListNode preM = null;
        ListNode nextN;

        ListNode pre;
        ListNode current;
        while (m > 0) {
            preM = p;
            p = p.next;
            m--;
            n--;
        }
        current = p;

        while (n > 0) {
            p = p.next;
            n--;
        }
        nextN = p.next;
        p.next = null;

        pre = nextN;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        if (preM != null) {
            preM.next = pre;
            return head;
        }
        return pre;
    }
}
