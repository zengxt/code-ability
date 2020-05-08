package 链表;

/**
 * 
 * @Description: 链表的节点对象：特别需要注意一个问题：当使用链表作为参数时，可以改变原链表，
 *               但是在函数中将参数指向的新的链表对象进行修改时，原来的指向关系不会改变。
 *
 * @author： zxt
 *
 * @time: 2018年4月18日 下午9:40:58
 *
 */
public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	/**
	 * 
	 * @Description:新建链表
	 * 
	 * @param arr
	 * @return
	 */
	public static ListNode createList(int[] arr) {

		if (arr.length == 0) {
			return null;

		} else {
			ListNode list = new ListNode(arr[0]);
			ListNode p = list;

			for (int i = 1; i < arr.length; i++) {
				ListNode node = new ListNode(arr[i]);
				p.next = node;
				p = node;
			}

			return list;
		}
	}

	/**
	 * 
	 * @Description:打印链表
	 * 
	 * @param list
	 */
	public static void printList(ListNode list) {

		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}

		System.out.println();
	}

	/**
	 * 
	 * @Description:将一个元素插入到链表的尾部
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode addToTail(ListNode head, int value) {
		ListNode node = new ListNode(value);

		if (head == null) {
			// 这里把形参的引用修改了一个指向，因此若不返回 head，此时原来需要修改的 ListNode 还是为空
			head = node;

		} else {
			ListNode pNode = head;
			while (pNode.next != null) {
				pNode = pNode.next;
			}

			pNode.next = node;
		}

		return head;
	}

	/**
	 * 
	 * @Description:删除链表中的某个元素
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode removeNode(ListNode head, int value) {
		if (head == null) {
			return null;
		}

		// 如果需要删除的值恰好是头节点的值
		if (head.val == value) {
			// 这里把形参的引用修改了一个指向，因此若不返回 head，此时原来需要删除的 ListNode 还是不变
			head = head.next;

		} else {
			ListNode pNode = head;
			// 找到链表中第一个需要删除的节点
			while (pNode.next != null && pNode.next.val != value) {
				pNode = pNode.next;
			}

			if (pNode.next != null && pNode.next.val == value) {
				pNode.next = pNode.next.next;
			}
		}

		return head;
	}

	/**
	 * 假设给定的是链表中的某个节点（不是节点的值），把它删除，常规的做法是，遍历链表，找到它的前一个节点，让它前一个节点的next指向要删除节点的next即可
	 * 
	 * 另一种思路就是：不需要找到该节点的前一个节点，假设我们要删除节点i，先把i的下一个节点j的内容复制到i，然后把i的next指向节点j的next。再删除节点j
	 * 需要注意：如果链表在只有一个节点，要把它删除，那么需要在删除后把头指针置为null，如果要删除的节点为尾节点，则还是需要找到它的上一节点。
	 */
}