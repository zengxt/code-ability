package 链表;

/**
 * 
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author： zxt
 *
 * @time: 2018年4月23日 下午7:41:11
 *
 */
public class 链表中倒数第k个节点 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		ListNode list = ListNode.createList(arr);
		
		ListNode.printList(FindKthToTail2(list, 7));
	}
	
	/**
	 * 
	 * @Description:假设整个链表有k个节点，那么倒数第k个节点就是从头节点开始的第  n-k+1 个节点
	 * 使用两个指针，第一个先走k-1步，从第k步开始，两个一起走，当第一个指针到达末尾时，第二个则指向倒数第k个节点
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode FindKthToTail(ListNode head, int k) {
		if(head == null || k <= 0) {
			return null;
		}
		
		ListNode pNode1 = head;
		for(int i = 0; i < k - 1; i++) {
			if(pNode1.next != null) {
				pNode1 = pNode1.next;
			} else {
				return null;
			}
		}
		
		ListNode pNode2 = head;
		while(pNode1.next != null) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		
		return pNode2;
	}
	
	/**
	 * 
	 * @Description:改良版
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode FindKthToTail2(ListNode head, int k) {
		if(head == null || k <= 0) {
			return null;
		}
		
		ListNode pNode1 = head;
		ListNode pNode2 = head;
		int index = 0;
		while(pNode1 != null) {
			// 等pNode1走了k步，pNode2再走
			if(index++ >= k) {
				pNode2 = pNode2.next;
			}
			// pNode1在前
			pNode1 = pNode1.next;
		}
		
		return index < k ? null : pNode2;
	}
}
