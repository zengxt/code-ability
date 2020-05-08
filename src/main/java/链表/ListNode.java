package ����;

/**
 * 
 * @Description: ����Ľڵ�����ر���Ҫע��һ�����⣺��ʹ��������Ϊ����ʱ�����Ըı�ԭ����
 *               �����ں����н�����ָ����µ������������޸�ʱ��ԭ����ָ���ϵ����ı䡣
 *
 * @author�� zxt
 *
 * @time: 2018��4��18�� ����9:40:58
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
	 * @Description:�½�����
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
	 * @Description:��ӡ����
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
	 * @Description:��һ��Ԫ�ز��뵽�����β��
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode addToTail(ListNode head, int value) {
		ListNode node = new ListNode(value);

		if (head == null) {
			// ������βε������޸���һ��ָ������������� head����ʱԭ����Ҫ�޸ĵ� ListNode ����Ϊ��
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
	 * @Description:ɾ�������е�ĳ��Ԫ��
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode removeNode(ListNode head, int value) {
		if (head == null) {
			return null;
		}

		// �����Ҫɾ����ֵǡ����ͷ�ڵ��ֵ
		if (head.val == value) {
			// ������βε������޸���һ��ָ������������� head����ʱԭ����Ҫɾ���� ListNode ���ǲ���
			head = head.next;

		} else {
			ListNode pNode = head;
			// �ҵ������е�һ����Ҫɾ���Ľڵ�
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
	 * ����������������е�ĳ���ڵ㣨���ǽڵ��ֵ��������ɾ��������������ǣ����������ҵ�����ǰһ���ڵ㣬����ǰһ���ڵ��nextָ��Ҫɾ���ڵ��next����
	 * 
	 * ��һ��˼·���ǣ�����Ҫ�ҵ��ýڵ��ǰһ���ڵ㣬��������Ҫɾ���ڵ�i���Ȱ�i����һ���ڵ�j�����ݸ��Ƶ�i��Ȼ���i��nextָ��ڵ�j��next����ɾ���ڵ�j
	 * ��Ҫע�⣺���������ֻ��һ���ڵ㣬Ҫ����ɾ������ô��Ҫ��ɾ�����ͷָ����Ϊnull�����Ҫɾ���Ľڵ�Ϊβ�ڵ㣬������Ҫ�ҵ�������һ�ڵ㡣
	 */
}