package ����;

/**
 * 
 * @Description: һ�������а����������ҳ�������Ļ�����ڽ�㡣
 *
 * @author�� zxt
 *
 * @time: 2018��4��24�� ����4:26:35
 *
 */
public class �����л�����ڽڵ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode entryNodeOfLoop(ListNode pHead) {
		ListNode meetingNode = meetingNode(pHead);
		if(meetingNode == null) {
			return null;
		}
		
		// �õ����нڵ����Ŀ
		int nodesInLoop = 1;
		ListNode pNode1 = meetingNode;
		while(pNode1.next != meetingNode) {
			nodesInLoop = nodesInLoop + 1;
			pNode1 = pNode1.next;
		}
		
		// ���ƶ�pNode1������Ϊ���нڵ����Ŀ
		pNode1 = pHead;
		for(int i = 0; i < nodesInLoop; i++) {
			pNode1 = pNode1.next;
		}
		
		// ���ƶ�pNode1��pNode2
		ListNode pNode2 = pHead;
		while(pNode1 != pNode2) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		
		return pNode1;
	}
	
	/**
	 * 
	 * @Description:�������д��ڻ���ǰ�����ҵ�һ��һ������ָ�������Ľڵ㣨��������ڻ����򷵻�null��
	 * 
	 * @param pHead
	 * @return
	 */
	public static ListNode meetingNode(ListNode pHead) {
		if(pHead == null) {
			return pHead;
		}
		
		ListNode pSlow = pHead;
		ListNode pFast = pHead;
		while(pSlow != null && pFast.next != null) {
			pSlow = pSlow.next;
			pFast = pFast.next.next;
			
			if(pSlow == pFast) {
				return pFast;
			}
		}
		
		return pHead;
	}
}