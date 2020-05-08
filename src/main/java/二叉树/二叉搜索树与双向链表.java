package ������;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Description: ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 *
 * @author�� zxt
 *
 * @time: 2018��7��13�� ����9:30:18
 *
 */
public class ������������˫������ {
	// ��¼��������һ���ڵ㣨�����������Ǹ��ֲ���������ÿ�κ������ص�ʱ������ָ���ǻ���null��
	private static TreeNode pLastNodeInList = null;

	public static void main(String[] args) {
		int[] array = {10, 6, 4, 8, 14, 12, 16};
		
		TreeNode root = TreeNode.createBinaryTree(array);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(�������.layerOrder(root, list));
		
		// ˫������
		TreeNode treeList = Convert(root);
		while(treeList != null) {
			System.out.print(treeList.getValue() + " ");
			treeList = treeList.getLeft();
		}
		System.out.println();
				
		// ˫������
//		TreeNode treeList1 = Convert2(root);
//		while(treeList1 != null) {
//			System.out.print(treeList1.getValue() + " ");
//			treeList1 = treeList1.getLeft();
//		}
//		System.out.println();
	}
	
	/**
	 * 
	 * @Description���������������������ǡ�����������У�����������  ����  ���ڵ�   ������  ���������У���������ָ��ָ����һ�ڵ㣬������ָ��ָ����һ���ڵ�
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public static TreeNode Convert(TreeNode pRootOfTree) {
		pLastNodeInList = null;
		convertNode(pRootOfTree);
		
		// ���ص�ʱ����Ҫ���������ͷ�ڵ㣬������β�ڵ������ͷ�ڵ�
		TreeNode pHeadOfList = pLastNodeInList;
		while(pHeadOfList != null && pHeadOfList.getRight() != null) {
			pHeadOfList = pHeadOfList.getRight();
		}
		
		return pHeadOfList;
    }
	
	public static void convertNode(TreeNode pNode) {
		if(pNode == null) {
			return;
		}
		
		TreeNode pCurrent = pNode;
		
		if(pCurrent.getLeft() != null) {
			convertNode(pCurrent.getLeft());
		}
		
		// ����������Ҫ�ı䵱ǰ�ڵ��������ָ�룬������Ҫ�ȼ�¼����
		TreeNode right = pCurrent.getRight();
		pCurrent.setRight(pLastNodeInList);
		if(pLastNodeInList != null) {
			pLastNodeInList.setLeft(pCurrent);
		}
		pLastNodeInList = pCurrent;
		
		if(right != null) {
			// convertNode(pCurrent.getRight());
			convertNode(right);
		}
	}
	
	/**
	 * 
	 * @Description���������������������ǡ�����������У����Խ�����������д��������ɣ�������Ҫһ��ָ���¼�����������һ���ڵ�
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public static TreeNode Convert2(TreeNode pRootOfTree) {
		if(pRootOfTree == null || (pRootOfTree.getLeft() == null && pRootOfTree.getRight() == null)) {
			return pRootOfTree;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = pRootOfTree;
		// �����������һ���ڵ�
		TreeNode preNode = null;
		
		while(pNode != null || !stack.isEmpty()) {
			if(pNode != null) {
				stack.push(pNode);
				pNode = pNode.getLeft();
				
			} else {
				pNode = stack.pop();
				// �ȼ�¼�µ�ǰ�ڵ���������ڵ�
				TreeNode right = pNode.getRight();
				
				// ����������ڵ�
				if(preNode == null) {
					preNode = pNode;
				} else {
					// �������һ���ڵ�������ָ��ǰ�ڵ�
					preNode.setRight(pNode);
					// ��ǰ�ڵ��������ָ��������һ���ڵ�
					pNode.setLeft(preNode);
					
					preNode = pNode;
				}
				
				pNode = right;
			}
		}
		
		// ��Ҫ���ص�ʱ˫�������ͷָ��
		TreeNode pHeadList = preNode;
		while(pHeadList != null && pHeadList.getLeft() != null) {
			pHeadList = pHeadList.getLeft();
		}
		
		return pHeadList;
	}

}
