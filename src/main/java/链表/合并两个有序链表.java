package 链表;

/**
 * 
 * @Description: 合并两个有序的链表
 *
 * @author： zxt
 *
 * @time: 2018年4月18日 下午5:01:39
 *
 */
public class 合并两个有序链表 {

	public static void main(String[] args) {
		int[] arr1 = { 2 };
		int[] arr2 = { 1 };
		ListNode list1 = ListNode.createList(arr1);
		ListNode list2 = ListNode.createList(arr2);

		ListNode list = Merge(list1, list2);
		ListNode.printList(list);
	}

	/**
	 * 
	 * @Description:不创建新链表的情况下合并（这里需要满足第一个链表的第一个元素要最小）
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		
		ListNode p1 = list1;
		ListNode pre = null;
		
		while(p1 != null && list2 != null) {
			if(p1.val <= list2.val) {
				pre = p1;
				p1 = p1.next;
				
			} else {
				pre.next = list2;
				list2 = list2.next;
				pre.next.next = p1;
                pre = pre.next;
			}
		}
		
		if(list2 != null) {
			pre.next = list2;
		}
		
		return list1;
	}
	
	/**
	 * 
	 * @Description:创建新链表
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode Merge2(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		
		ListNode result = new ListNode(-1);
		ListNode pNode = result;
		while(list1 != null && list2 != null) {
			if(list1.val < list2.val) {
				pNode.next = list1;
				pNode = list1;
				list1 = list1.next;
				
			} else {
				pNode.next = list2;
				pNode = list2;
				list2 = list2.next;
			}
		}
		
		if(list1 == null) {
			pNode.next = list2;
		}
		if(list2 == null) {
			pNode.next = list1;
		}
		
		return result.next;
	}
	
	/**
	 * 
	 * @Description:创建新链表（递归形式）
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode Merge3(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		
		ListNode result = null;
		
		if(list1.val < list2.val) {
			result = list1;
			result.next = Merge3(list1.next, list2);
			
		} else {
			result = list2;
			result.next = Merge3(list1, list2.next);
		}
		
		return result;
	}
}