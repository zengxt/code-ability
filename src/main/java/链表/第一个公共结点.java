package ����;

/**
 * 
 * @Description: �������������ҳ����ǵĵ�һ��������㡣
 *
 * @author�� zxt
 *
 * @time: 2018��4��24�� ����1:48:50
 *
 */
public class ��һ��������� {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 6, 7};
		int[] arr2 = { 4, 5, 6, 7};
		ListNode list1 = ListNode.createList(arr1);
		ListNode list2 = ListNode.createList(arr2);
		
		ListNode.printList(FindFirstCommonNode2(list1, list2));
	}
	
	/**
	 * 
	 * @Description:��������Ƚϵ�������ڵ��ֵ���
	 * 
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		
		while(pHead1 != null && pHead2 != null) {
			if(pHead1.val == pHead2.val) {
				return pHead1;
				
			} else if(pHead1.val < pHead2.val) {
				pHead1 = pHead1.next;
				
			} else {
				pHead2 = pHead2.next;
			}
		}
		
		return null;
    }
	
	public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		
		int length1 = getListLength(pHead1);
		int length2 = getListLength(pHead2);
		int lengthDif = length1 - length2;
		
		ListNode pListLong = pHead1;
		ListNode pListShort = pHead2;
		if(length2 > length1) {
			pListLong = pHead2;
			pListShort = pHead1;
			lengthDif = length2 - length1;
		}
		
		// ���ڳ��������߼�������ͬʱ�����������ϱ���
		for(int i = 0; i < lengthDif; i++) {
			pListLong = pListLong.next;
		}
		
		// ��������pListLong �� pListShort���Ƕ�������Ҫ��ȵĻ�������ͬһ������ֵ��ȵĻ�Ҳ������ȣ�
		while(pListLong != null && pListShort != null && pListLong != pListShort) {
			pListLong = pListLong.next;
			pListShort = pListShort.next;
		}
		
		return pListLong;
	}
	
	public static int getListLength(ListNode head) {
		int length = 0;
		
		ListNode pNode = head;
		while(pNode != null) {
			++length;
			pNode = pNode.next;
		}
		
		return length;
	}
}
