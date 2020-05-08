package ����;

/**
 * 
 * @Description: ����һ����������������е�����k����㡣
 *
 * @author�� zxt
 *
 * @time: 2018��4��23�� ����7:41:11
 *
 */
public class �����е�����k���ڵ� {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		ListNode list = ListNode.createList(arr);
		
		ListNode.printList(FindKthToTail2(list, 7));
	}
	
	/**
	 * 
	 * @Description:��������������k���ڵ㣬��ô������k���ڵ���Ǵ�ͷ�ڵ㿪ʼ�ĵ�  n-k+1 ���ڵ�
	 * ʹ������ָ�룬��һ������k-1�����ӵ�k����ʼ������һ���ߣ�����һ��ָ�뵽��ĩβʱ���ڶ�����ָ������k���ڵ�
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
	 * @Description:������
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
			// ��pNode1����k����pNode2����
			if(index++ >= k) {
				pNode2 = pNode2.next;
			}
			// pNode1��ǰ
			pNode1 = pNode1.next;
		}
		
		return index < k ? null : pNode2;
	}
}
