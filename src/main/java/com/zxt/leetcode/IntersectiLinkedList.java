package com.zxt.leetcode;

/**
 * ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
 */
public class IntersectiLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        ListNode l1 = new ListNode(2);
        ListNode.add(l1, new ListNode(4));
        ListNode.add(l1, new ListNode(3));
        ListNode.add(l1, listNode1);
        ListNode.add(l1, listNode2);
        ListNode.add(l1, listNode3);

        ListNode l2 = new ListNode(5);
        ListNode.add(l2, new ListNode(4));
        ListNode.add(l2, new ListNode(3));
        ListNode.add(l2, new ListNode(3));
        ListNode.add(l2, listNode1);

        System.out.println(getIntersectionNode2(l1, l2).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lengthA = 0;
        int lengthB = 0;

        while (p1 != null) {
            lengthA++;
            p1 = p1.next;
        }

        while (p2 != null) {
            lengthB++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;
        int count = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (count > 0) {
                p1 = p1.next;
                count--;
            }
        } else {
            while (count > 0) {
                p2 = p2.next;
                count--;
            }
        }

        ListNode result = null;
        while (p1 != null || p2 != null) {
            if (p1 == p2) {
                result = p1;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return result;
    }

    // ����������ϣ������������ A ����ÿ�����ĵ�ַ/���ô洢�ڹ�ϣ���С�
    // Ȼ�������� B �е�ÿһ����� bi �Ƿ��ڹ�ϣ���С����ڣ��� bi Ϊ�ཻ��㡣

    // ��������ÿ��ָ���Ⱥ������������һ�飬��Ȼͬʱ���ｻ��
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while (true) {
            if (p1 == p2) {
                return p1;
            }

            // ������������ཻ�������Ǳ�Ȼ����ͬʱ���ｻ�㣬�����뽻������һ���ͬʱ�ﵽĩβ
            if (p1.next == null && p2.next == null) {
                return null;
            }

            p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;
        }
    }
}
