package com.zxt.leetcode;

/**
 * @Description: <pre>
 *               给出两个非空的链表用来表示两个非负的整数。
 *               其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *               如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *               您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *               示例： <br/>
 *               输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) <br/>
 *               输出：7 -> 0 -> 8 <br/>
 *               原因：342 + 465 = 807 <br/>
 *
 *               <pre/>
 *
 * @Package com.zxt.leetcode
 * @Title: AddTwoNum.java
 * @author: zxt
 * @date: 2020年2月15日 下午9:12:22
 */
public class AddTwoNum {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        printListNode(l1);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printListNode(l2);

        printListNode(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode result = null;
        ListNode pResult = null;

        int upsit = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            int temp = p1.val + p2.val + upsit;
            upsit = 0;
            if (temp >= 10) {
                upsit = 1;
                temp -= 10;
            }

            if (pResult == null) {
                result = new ListNode(temp);
                pResult = result;
            } else {
                pResult.next = new ListNode(temp);
                pResult = pResult.next;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int temp = p1.val + upsit;
            upsit = 0;
            if (temp >= 10) {
                upsit = 1;
                temp -= 10;
            }
            pResult.next = new ListNode(temp);
            pResult = pResult.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int temp = p2.val + upsit;
            upsit = 0;
            if (temp >= 10) {
                upsit = 1;
                temp -= 10;
            }
            pResult.next = new ListNode(temp);
            pResult = pResult.next;
            p2 = p2.next;
        }

        if (upsit > 0) {
            pResult.next = new ListNode(upsit);
            pResult = pResult.next;
        }

        return result;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode pResult = null;

        int upsit = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null) {
            int value1 = p1 != null ? p1.val : 0;
            int value2 = p2 != null ? p2.val : 0;
            int temp = (value1 + value2 + upsit) % 10;
            upsit = (value1 + value2 + upsit) / 10;

            if (pResult == null) {
                result = new ListNode(temp);
                pResult = result;
            } else {
                pResult.next = new ListNode(temp);
                pResult = pResult.next;
            }

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }

        if (upsit > 0) {
            pResult.next = new ListNode(upsit);
            pResult = pResult.next;
        }

        return result;
    }

    private static void printListNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }

        ListNode p = listNode;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}

