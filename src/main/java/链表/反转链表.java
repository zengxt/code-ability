package ����;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Description: ��ת��������ʹ�ò���Ҫ���⸨���ռ�����ַ���
 *
 * @author�� zxt
 *
 * @time: 2018��4��19�� ����12:21:35
 *
 */
public class ��ת���� {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7 };
		ListNode list = ListNode.createList(arr);
		
		ListNode.printList(list);
		
		// ��ת֮��
		ListNode.printList(ReverseList4(list));
	}
	
	/**
	 * 
	 * @Description:��ת����  ��ʹ�ø����ڴ������򣩣���ʵ������ֱ�۵�Ӧ��ʹ��һ��ջ����������Ȼ����ջ����ӡ��ʱ�����γ�ջ�Ϳ���
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList(ListNode head) {
		if(head == null) {
			return head;
		}
		
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		while(head != null) {
			list.add(0, head);
			head = head.next;
		}
		
		ListNode result = list.get(0);
		ListNode p = result;
		for(int i = 1; i < list.size(); i++) {
			p.next = list.get(i);
			p = list.get(i);
		}
		// ��Ϊ����ArrayList�е�Ԫ��Ϊ ListNode �ڵ㣬���Իᱣ��ԭ����һЩָ���ϵ
		p.next = null;
		
		return result;
    }
	
	public static ListNode ReverseList2(ListNode head) {
		if(head == null) {
			return head;
		}
		
		Stack<ListNode> stack = new Stack<ListNode>();
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		
		ListNode result = stack.pop();
		ListNode p = result;
		while(!stack.isEmpty()) {
			ListNode node = stack.pop();
			p.next = node;
			p = node;
		}
		
		// ��Ϊ����ArrayList�е�Ԫ��Ϊ ListNode �ڵ㣬���Իᱣ��ԭ����һЩָ���ϵ
		p.next = null;
		
		return result;
    }
	
	/**
	 * 
	 * @Description:��ת������������ı�ͷ���룩
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList3(ListNode head) {
		if(head == null) {
			return head;
		}
		
		ListNode result = new ListNode(head.val);
		head = head.next;
		
		ListNode node = null;
		while(head != null) {
			node = head;
			
			// ԭ�������һ���ڵ�
			head = head.next;
			
			// ���뵱ǰ�ڵ㵽 result �����ͷ��
			node.next = result;
			result = node;
		}
		
		return result;
    }
	
	/**
	 * 
	 * @Description:�ı�ԭ�����ָ��ָ��
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList4(ListNode head) {
		// 0 �� �� 1 ���ڵ�
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode preNode = null;
		ListNode pNode = head;
		ListNode nextNode = null;
		while(pNode != null) {
			// �ȼ�¼��һ��Ҫ����Ľڵ�
			nextNode = pNode.next;
			pNode.next = preNode;
			preNode = pNode;
			pNode = nextNode;
		}
		
		return preNode;
	}
}
