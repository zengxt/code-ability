package ����;

/**
 * 
 * @Description: ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 *
 * @author�� zxt
 *
 * @time: 2018��7��13�� ����11:21:43
 *
 */
public class ���Ƹ������� {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @Description��
	 * 1������ÿ���ڵ㣬�磺���ƽڵ�A�õ�A1����A1����ڵ�A����
	 * 2����������A1->random = A->random->next;
	 * 3���������ֳ�ԭ����͸��ƺ������
	 * 
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		return reConnectNodes(pHead);
    }
	
	// 1������ÿ���ڵ㣬�磺���ƽڵ�A�õ�A1����A1����ڵ�A����
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		
		while(pNode != null) {
			// �����½�һ���ڵ�
			RandomListNode pCloned = new RandomListNode(pNode.label);
			
			// ���ýڵ����ӵ���ǰ�ڵ����
			pCloned.next = pNode.next;
			pNode.next = pCloned;
			
			pNode = pCloned.next;
		}
	}
	
	// 2����������A1->random = A->random->next;
	public void connectRandomNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		
		while(pNode != null) {
			// ż��λ�Ľڵ�Ϊ���ƵĽڵ�
			RandomListNode pCloned = pNode.next;
			
			if(pNode.random != null) {
				// pNode.random����һ���ڵ�պò���pNode.random�ĸ��ƽڵ�
				pCloned.random = pNode.random.next;
			}
			
			pNode = pCloned.next;
		}
	}
	
	// 3���������ֳ�ԭ����͸��ƺ������
	public RandomListNode reConnectNodes(RandomListNode pHead) {
		if(pHead == null) {
			return null;
		}
		
		// ���������ָ��
		RandomListNode pNode = pHead;
		// ���������ͷָ��
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
 * @Description: ��������ڵ�
 *
 * @author�� zxt
 *
 * @time: 2018��7��13�� ����11:22:48
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
