package com.zxt.leetcode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.add(head, new ListNode(2));
        ListNode.add(head, new ListNode(3));
        ListNode.add(head, new ListNode(4));
        ListNode.add(head, new ListNode(5));

        head.showList();

        System.out.println("==================");
        head = deleteNode(head, 1);
        head.showList();
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        // 要删除的是头结点         --->
        // 对头结点的特殊处理，也可以新构造一个头结点链接到 head上面，这样对head的处理就不用再特殊化，注意返回即可
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                break;
            }
            pre = node;
            node = node.next;
        }

        return head;
    }
}
