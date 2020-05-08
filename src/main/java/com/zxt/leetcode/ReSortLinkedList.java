package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�������� L��L0��L1������Ln-1��Ln ��
 * �����������к��Ϊ�� L0��Ln��L1��Ln-1��L2��Ln-2����
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
                // ԭ���Ľ�㣨����β����next������ֵ�ģ������Ҫ�����ÿշ������ѭ��
                pnode.next = null;
                break;
            }

            index++;
        }
    }

    // �ݹ�ⷨ��������list���� head���Ѿ�����Ĳ��֣�tail ������
    // ������Ҫ֪�� tail β��㣬���չ���Ҫ����һ�Σ����Ҿ�ÿ�εݹ�� tail ����
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
        // �����ź��򲿷ֵ�β���
        if (length == 1) {
            return head;
        }

        if (length == 2) {
            return head.next;
        }

        // ���� reorderListHelper �ܹ����� β���
        // (������Ҫ�ú���⣬���Է����ź���Ĳ��ֵ�β��㣬Ҳ���Է����ź�������һ�����)
        // length -2 ������ ͷβ������һ�����
        ListNode orderedTail = reorderListHelper(head.next, length - 2);

        ListNode tail = orderedTail.next;
        ListNode subHead = head.next;
        orderedTail.next = tail.next;

        head.next = tail;
        tail.next = subHead;

        return orderedTail;
    }


    // ��ת��벿�֣�Ȼ�����������δ���һ��
    public static void reorderList3(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        // ��������ʱ��ǰ�벿�ֻ��һ��
        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        // ��벿��    ��ת
        node2 = node1.next;
        node1.next = null;  // ������� reorderList�����е����һ��β���

        ListNode pre = null;
        while (node2 != null) {
            ListNode next = node2.next;
            node2.next = pre;
            pre = node2;
            node2 = next;
        }

        // ���� pre �Ǻ�벿�ֵ� ͷ���
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
