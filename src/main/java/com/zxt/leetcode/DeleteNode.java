package com.zxt.leetcode;

/**
 * �������������ͷָ���һ��Ҫɾ���Ľڵ��ֵ������һ������ɾ���ýڵ㡣
 * <p>
 * ����ɾ����������ͷ�ڵ㡣
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

        // Ҫɾ������ͷ���         --->
        // ��ͷ�������⴦��Ҳ�����¹���һ��ͷ������ӵ� head���棬������head�Ĵ���Ͳ��������⻯��ע�ⷵ�ؼ���
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
