package 链表;

/**
 * 
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author： zxt
 *
 * @time: 2018年7月13日 上午11:21:43
 *
 */
public class 复制复杂链表 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @Description：
	 * 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
	 * 2、遍历链表，A1->random = A->random->next;
	 * 3、将链表拆分成原链表和复制后的链表
	 * 
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		return reConnectNodes(pHead);
    }
	
	// 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		
		while(pNode != null) {
			// 首先新建一个节点
			RandomListNode pCloned = new RandomListNode(pNode.label);
			
			// 将该节点链接到当前节点后面
			pCloned.next = pNode.next;
			pNode.next = pCloned;
			
			pNode = pCloned.next;
		}
	}
	
	// 2、遍历链表，A1->random = A->random->next;
	public void connectRandomNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		
		while(pNode != null) {
			// 偶数位的节点为复制的节点
			RandomListNode pCloned = pNode.next;
			
			if(pNode.random != null) {
				// pNode.random的下一个节点刚好才是pNode.random的复制节点
				pCloned.random = pNode.random.next;
			}
			
			pNode = pCloned.next;
		}
	}
	
	// 3、将链表拆分成原链表和复制后的链表
	public RandomListNode reConnectNodes(RandomListNode pHead) {
		if(pHead == null) {
			return null;
		}
		
		// 遍历链表的指针
		RandomListNode pNode = pHead;
		// 复制链表的头指针
		RandomListNode pClonedHead = pNode.next;
		RandomListNode pClonedNode = pNode.next;
		pNode.next = pClonedNode.next;
		pNode = pNode.next;
		
		while(pNode != null) {
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		
		return pClonedHead;
	}
}

/**
 * 
 * @Description: 复杂链表节点
 *
 * @author： zxt
 *
 * @time: 2018年7月13日 上午11:22:48
 *
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
