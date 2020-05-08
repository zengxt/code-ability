package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
public class ReSortLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.add(head, new ListNode(2));
        ListNode.add(head, new ListNode(3));
        ListNode.add(head, new ListNode(4));
        ListNode.add(head, new ListNode(5));

        head.showList();

        System.out.println("==================");
        reorderList2(head);
        head.showList();
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int index = 0;
        ListNode pnode = new ListNode(-1);
        while (true) {
            pnode.next = list.get(index);
            pnode = pnode.next;

            int next = list.size() - 1 - index;
            if (next > index) {
                pnode.next = list.get(next);
                pnode = pnode.next;
            } else {
                // 原来的结点（除了尾结点的next域是有值的），因此要给它置空否则会死循环
                pnode.next = null;
                break;
            }

            index++;
        }
    }

    // 递归解法，把整个list看成 head、已经处理的部分，tail 三部分
    // 由于需要知道 tail 尾结点，那终归是要遍历一次，那我就每次递归把 tail 返回
    public static void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        reorderListHelper(head, length);
    }

    private static ListNode reorderListHelper(ListNode head, int length) {
        // 返回排好序部分的尾结点
        if (length == 1) {
            return head;
        }

        if (length == 2) {
            return head.next;
        }

        // 假设 reorderListHelper 能够返回 尾结点
        // (这里需要好好理解，可以返回排好序的部分的尾结点，也可以返回排好序后面的一个结点)
        // length -2 看成是 头尾各少了一个结点
        ListNode orderedTail = reorderListHelper(head.next, length - 2);

        ListNode tail = orderedTail.next;
        ListNode subHead = head.next;
        orderedTail.next = tail.next;

        head.next = tail;
        tail.next = subHead;

        return orderedTail;
    }


    // 反转后半部分，然后将两部分依次串在一起
    public static void reorderList3(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        // 基数个数时，前半部分会多一个
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        // 后半部分    反转
        node2 = node1.next;
        node1.next = null;  // 这个就是 reorderList方法中的最后一个尾结点

        ListNode pre = null;
        while (node2 != null) {
            ListNode next = node2.next;
            node2.next = pre;
            pre = node2;
            node2 = next;
        }

        // 现在 pre 是后半部分的 头结点
        node1 = head;
        node2 = pre;
        while (node2 != null) {
            ListNode node2Next = node2.next;
            node2.next = node1.next;
            node1.next = node2;

            node1 = node2.next;
            node2 = node2Next;
        }
    }
}
