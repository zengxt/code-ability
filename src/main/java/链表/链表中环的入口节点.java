package 链表;

/**
 * 
 * @Description: 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * @author： zxt
 *
 * @time: 2018年4月24日 下午4:26:35
 *
 */
public class 链表中环的入口节点 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode entryNodeOfLoop(ListNode pHead) {
		ListNode meetingNode = meetingNode(pHead);
		if(meetingNode == null) {
			return null;
		}
		
		// 得到环中节点的数目
		int nodesInLoop = 1;
		ListNode pNode1 = meetingNode;
		while(pNode1.next != meetingNode) {
			nodesInLoop = nodesInLoop + 1;
			pNode1 = pNode1.next;
		}
		
		// 先移动pNode1，次数为环中节点的数目
		pNode1 = pHead;
		for(int i = 0; i < nodesInLoop; i++) {
			pNode1 = pNode1.next;
		}
		
		// 再移动pNode1和pNode2
		ListNode pNode2 = pHead;
		while(pNode1 != pNode2) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		
		return pNode1;
	}
	
	/**
	 * 
	 * @Description:在链表中存在环的前提下找到一快一慢两个指针相遇的节点（如果不存在环，则返回null）
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