package 链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Description: 反转链表：尽量使用不需要额外辅助空间的两种方法
 *
 * @author： zxt
 *
 * @time: 2018年4月19日 下午12:21:35
 *
 */
public class 反转链表 {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7 };
		ListNode list = ListNode.createList(arr);
		
		ListNode.printList(list);
		
		// 反转之后
		ListNode.printList(ReverseList4(list));
	}
	
	/**
	 * 
	 * @Description:反转链表  （使用辅助内存来逆序），其实这里最直观得应该使用一个栈，遍历链表，然后入栈，打印的时候依次出栈就可以
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
		// 因为放入ArrayList中的元素为 ListNode 节点，所以会保留原来的一些指向关系
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
		
		// 因为放入ArrayList中的元素为 ListNode 节点，所以会保留原来的一些指向关系
		p.next = null;
		
		return result;
    }
	
	/**
	 * 
	 * @Description:反转链表（在新链表的表头插入）
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
			
			// 原链表的下一个节点
			head = head.next;
			
			// 插入当前节点到 result 链表的头部
			node.next = result;
			result = node;
		}
		
		return result;
    }
	
	/**
	 * 
	 * @Description:改变原链表的指针指向
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList4(ListNode head) {
		// 0 个 或 1 个节点
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode preNode = null;
		ListNode pNode = head;
		ListNode nextNode = null;
		while(pNode != null) {
			// 先记录下一个要处理的节点
			nextNode = pNode.next;
			pNode.next = preNode;
			preNode = pNode;
			pNode = nextNode;
		}
		
		return preNode;
	}
}
