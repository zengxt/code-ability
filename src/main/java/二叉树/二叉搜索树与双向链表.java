package 二叉树;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author： zxt
 *
 * @time: 2018年7月13日 下午9:30:18
 *
 */
public class 二叉搜索树与双向链表 {
	// 记录链表的最后一个节点（如果这个变量是个局部变量，则每次函数返回的时候，它的指向还是会变成null）
	private static TreeNode pLastNodeInList = null;

	public static void main(String[] args) {
		int[] array = {10, 6, 4, 8, 14, 12, 16};
		
		TreeNode root = TreeNode.createBinaryTree(array);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(层序遍历.layerOrder(root, list));
		
		// 双向链表
		TreeNode treeList = Convert(root);
		while(treeList != null) {
			System.out.print(treeList.getValue() + " ");
			treeList = treeList.getLeft();
		}
		System.out.println();
				
		// 双向链表
//		TreeNode treeList1 = Convert2(root);
//		while(treeList1 != null) {
//			System.out.print(treeList1.getValue() + " ");
//			treeList1 = treeList1.getLeft();
//		}
//		System.out.println();
	}
	
	/**
	 * 
	 * @Description：二叉搜索树的中序遍历恰好是有序序列（左子树序列  链接  根节点   再链接  右子树序列）、左子树指针指向上一节点，右子树指针指向下一个节点
	 * 
	 * @param pRootOfTree
	 * @return
	 */
	public static TreeNode Convert(TreeNode pRootOfTree) {
		pLastNodeInList = null;
		convertNode(pRootOfTree);
		
		// 返回的时候需要返回链表的头节点，所以由尾节点遍历到头节点
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
		
		// 这里由于需要改变当前节点的右子树指针，所以需要先记录下来
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
	 * @Description：二叉搜索树的中序遍历恰好是有序序列，所以将中序遍历序列串起来即可，这里需要一个指针记录中序遍历的上一个节点
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
		// 中序遍历的上一个节点
		TreeNode preNode = null;
		
		while(pNode != null || !stack.isEmpty()) {
			if(pNode != null) {
				stack.push(pNode);
				pNode = pNode.getLeft();
				
			} else {
				pNode = stack.pop();
				// 先记录下当前节点的右子树节点
				TreeNode right = pNode.getRight();
				
				// 中序访问树节点
				if(preNode == null) {
					preNode = pNode;
				} else {
					// 中序的上一个节点左子树指向当前节点
					preNode.setRight(pNode);
					// 当前节点的右子树指向中序上一个节点
					pNode.setLeft(preNode);
					
					preNode = pNode;
				}
				
				pNode = right;
			}
		}
		
		// 需要返回的时双向链表的头指针
		TreeNode pHeadList = preNode;
		while(pHeadList != null && pHeadList.getLeft() != null) {
			pHeadList = pHeadList.getLeft();
		}
		
		return pHeadList;
	}

}
