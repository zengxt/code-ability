package ����;

/**
 * 
 * @Description: �ϲ��������������
 *
 * @author�� zxt
 *
 * @time: 2018��4��18�� ����5:01:39
 *
 */
public class �ϲ������������� {

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
	 * @Description:�����������������ºϲ���������Ҫ�����һ������ĵ�һ��Ԫ��Ҫ��С��
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
	 * @Description:����������
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
	 * @Description:�����������ݹ���ʽ��
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