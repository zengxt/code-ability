package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: 删除有序链表中的重复值
 *
 * @author： zxt
 *
 * @time: 2018年4月22日 下午3:21:17
 *
 */
public class 删除重复节点 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 4, 4, 5 };
		ListNode list = ListNode.createList(arr);

		ListNode.printList(list);

		// list = removeNode(list, 3);
		// ListNode.printList(list);

		// 删除重复之后
		// ListNode.printList(removeRepeteNode(list));

		// 删除重复之后
		ListNode.printList(removeRepeteNode4(list));
	}

	/**
	 * 
	 * @Description:删除链表中的重复元素
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode removeRepeteNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode preNode = null;
		ListNode pNode = head;
		while (pNode != null) {
			ListNode nextNode = pNode.next;

			// 判断当前节点是否需要删除
			boolean needDelete = false;
			if (nextNode != null && pNode.val == nextNode.val) {
				needDelete = true;
			}

			// 不需要删除的节点
			if (!needDelete) {
				preNode = pNode;
				pNode = pNode.next;

			} else {
				int value = pNode.val;
				while (pNode != null && pNode.val == value) {
					nextNode = pNode.next;

					if (preNode == null) {
						head = nextNode;
					} else {
						preNode.next = nextNode;
					}

					pNode = nextNode;
				}
			}
		}

		return head;
	}

	/**
	 * 
	 * @Description:删除链表中的重复元素(递归方式)
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode removeRepeteNode2(ListNode head) {
		// 只有0个或1个结点，则返回
		if (head == null || head.next == null) {
			return head;
		}

		// 当前结点是重复结点
		if (head.val == head.next.val) {
			ListNode pNode = head.next;
			while (pNode != null && pNode.val == head.val) {
				// 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
				pNode = pNode.next;
			}

			// 从第一个与当前结点不同的结点开始递归
			return removeRepeteNode2(pNode);

		} else { // 当前结点不是重复结点
			// 保留当前结点，从下一个结点开始递归
			head.next = removeRepeteNode2(head.next);

			return head;
		}
	}

	/**
	 * 
	 * @Description:删除无序链表中的重复节点（当然也可以删除有序的），遍历链表中的每个节点，然后判断是否出现过，是的话则删除
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode removeRepeteNode3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pNode = head;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (pNode != null) {
			// 节点出现过
			if (map.containsKey(pNode.val)) {
				head = removeNode(head, pNode.val);
				// 又从头开始判断
				pNode = head;
				map.clear();

			} else {
				map.put(pNode.val, 1);
				pNode = pNode.next;
			}
		}

		return head;

	}

	/**
	 * 
	 * @Description:删除链表中所有值为某数的元素
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode removeNode(ListNode head, int value) {
		// 如果需要删除的值恰好是头节点的值
		while (head != null && head.val == value) {
			// 这里把形参的引用修改了一个指向，因此若不返回 head，此时原来需要删除的 ListNode 还是不变
			head = head.next;
		}
		
		if (head == null) {
			return head;
		}

		ListNode pNode = head;
		while (pNode.next != null) {
			// 找到链表中需要删除的节点
			if (pNode.next.val == value) {
				pNode.next = pNode.next.next;

			} else {
				pNode = pNode.next;
			}
		}

		return head;
	}

	/**
	 * 
	 * @Description:另一种巧妙的方法：新建一个链表头节点。 
	 * （由于删除重复节点问题复杂在于头节点可能重复，需要删除，因为头节点没有前一个节点，所以比较难以处理）
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode removeRepeteNode4(ListNode head) {
		// 人为添加一个头节点
		ListNode first = new ListNode(-1);
		first.next = head;

		ListNode pNode = head;
		ListNode preNode = first;
		while (pNode != null && pNode.next != null) {
			if (pNode.val == pNode.next.val) {
				int val = pNode.val;
				while (pNode != null && pNode.val == val) {
					pNode = pNode.next;
				}
				preNode.next = pNode;
				
			} else {
				preNode = pNode;
				pNode = pNode.next;
			}
		}
		
		// 返回的时候需要把新建的头节点跳过
		return first.next;
	}
}