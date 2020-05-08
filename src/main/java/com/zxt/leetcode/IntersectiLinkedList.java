package com.zxt.leetcode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
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

    // 方法二：哈希表法：遍历链表 A 并将每个结点的地址/引用存储在哈希表中。
    // 然后检查链表 B 中的每一个结点 bi 是否在哈希表中。若在，则 bi 为相交结点。

    // 方法三，每个指针先后把两个链表走一遍，必然同时到达交点
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

            // 如果两个链表相交，则它们必然会先同时到达交点，若不想交，各走一遍会同时达到末尾
            if (p1.next == null && p2.next == null) {
                return null;
            }

            p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;
        }
    }
}
