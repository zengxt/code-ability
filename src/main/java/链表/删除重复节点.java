package ����;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: ɾ�����������е��ظ�ֵ
 *
 * @author�� zxt
 *
 * @time: 2018��4��22�� ����3:21:17
 *
 */
public class ɾ���ظ��ڵ� {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 4, 4, 5 };
		ListNode list = ListNode.createList(arr);

		ListNode.printList(list);

		// list = removeNode(list, 3);
		// ListNode.printList(list);

		// ɾ���ظ�֮��
		// ListNode.printList(removeRepeteNode(list));

		// ɾ���ظ�֮��
		ListNode.printList(removeRepeteNode4(list));
	}

	/**
	 * 
	 * @Description:ɾ�������е��ظ�Ԫ��
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

			// �жϵ�ǰ�ڵ��Ƿ���Ҫɾ��
			boolean needDelete = false;
			if (nextNode != null && pNode.val == nextNode.val) {
				needDelete = true;
			}

			// ����Ҫɾ���Ľڵ�
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
	 * @Description:ɾ�������е��ظ�Ԫ��(�ݹ鷽ʽ)
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode removeRepeteNode2(ListNode head) {
		// ֻ��0����1����㣬�򷵻�
		if (head == null || head.next == null) {
			return head;
		}

		// ��ǰ������ظ����
		if (head.val == head.next.val) {
			ListNode pNode = head.next;
			while (pNode != null && pNode.val == head.val) {
				// ����ֵ�뵱ǰ�����ͬ��ȫ�����,�ҵ���һ���뵱ǰ��㲻ͬ�Ľ��
				pNode = pNode.next;
			}

			// �ӵ�һ���뵱ǰ��㲻ͬ�Ľ�㿪ʼ�ݹ�
			return removeRepeteNode2(pNode);

		} else { // ��ǰ��㲻���ظ����
			// ������ǰ��㣬����һ����㿪ʼ�ݹ�
			head.next = removeRepeteNode2(head.next);

			return head;
		}
	}

	/**
	 * 
	 * @Description:ɾ�����������е��ظ��ڵ㣨��ȻҲ����ɾ������ģ������������е�ÿ���ڵ㣬Ȼ���ж��Ƿ���ֹ����ǵĻ���ɾ��
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
			// �ڵ���ֹ�
			if (map.containsKey(pNode.val)) {
				head = removeNode(head, pNode.val);
				// �ִ�ͷ��ʼ�ж�
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
	 * @Description:ɾ������������ֵΪĳ����Ԫ��
	 * 
	 * @param head
	 * @param value
	 */
	public static ListNode removeNode(ListNode head, int value) {
		// �����Ҫɾ����ֵǡ����ͷ�ڵ��ֵ
		while (head != null && head.val == value) {
			// ������βε������޸���һ��ָ������������� head����ʱԭ����Ҫɾ���� ListNode ���ǲ���
			head = head.next;
		}
		
		if (head == null) {
			return head;
		}

		ListNode pNode = head;
		while (pNode.next != null) {
			// �ҵ���������Ҫɾ���Ľڵ�
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
	 * @Description:��һ������ķ������½�һ������ͷ�ڵ㡣 
	 * ������ɾ���ظ��ڵ����⸴������ͷ�ڵ�����ظ�����Ҫɾ������Ϊͷ�ڵ�û��ǰһ���ڵ㣬���ԱȽ����Դ���
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode removeRepeteNode4(ListNode head) {
		// ��Ϊ���һ��ͷ�ڵ�
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
		
		// ���ص�ʱ����Ҫ���½���ͷ�ڵ�����
		return first.next;
	}
}