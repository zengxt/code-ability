package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @Description: 层序遍历二叉树（广度优先遍历）
 *
 * @author： zxt
 *
 * @time: 2018年6月13日 下午10:00:46
 *
 */
public class 层序遍历 {

	public static void main(String[] args) {
		int[] array = { 6, 4, 9, 2, 5, 3, 17, 8, 12 };
		// 构造一个二叉排序树
		TreeNode root = TreeNode.createBinaryTree(array);
		
		// 层序遍历
		System.out.println("--------------层序遍历--------------");
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(layerOrder(root, list));
		
		ArrayList<ArrayList<Integer>> list1 = printZhiZi(root);
		System.out.println(list1);
		
		ArrayList<ArrayList<Integer>> list2 = layerOrder3(root);
		System.out.println(list2);
		
		ArrayList<ArrayList<Integer>> list3 = layerOrder3(root);
		System.out.println(list3);
	}
	
	/**
	 * 
	 * @Description：层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，接着将访问节点的左右子树依次入队列
	 * 
	 * @param root
	 * @param list
	 * @return
	 */
	public static ArrayList<Integer> layerOrder(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return null;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.getValue());
			
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
		
		return list;
	}
	
	/**
	 * 
	 * @Description：层序遍历，并且要求每层的节点分开。
	 * 
	 * 两种做法：一种使用两个变量，一个表示当前层中还没有打印的节点数，另一个变量表示下一层节点的数目
	 * 
	 * @param pRoot
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> layerOrder2(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(pRoot);
		// 当前层需要打印的节点数
		int toBePrinted = 1;
		// 下一层需要打印的节点数
		int nextLevel = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			--toBePrinted;
			list.add(node.getValue());
			
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
				++nextLevel;
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
				++nextLevel;
			}
			
			if(toBePrinted == 0) {
				result.add(list);
				list = new ArrayList<Integer>();
				// 当前层节点已经遍历完了
				toBePrinted = nextLevel;
				nextLevel = 0;
			}
		}
		
		return result;
    }
	
	/**
	 * 
	 * @Description：另一种是每次先确定下一层要打印的节点的个数
	 * 
	 * @param pRoot
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> layerOrder3(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(pRoot);
		
		while(!queue.isEmpty()) {
			int count = queue.size();
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			int i = 0;
			while(i < count) {
				TreeNode node = queue.poll();
				list.add(node.getValue());
				
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
				
				i++;
			}
			
			result.add(list);
			list = new ArrayList<Integer>();
		}
		
		return result;
    }
	
	
	/**
	 * 
	 * @Description：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
	 * 其他行以此类推。
	 * 
	 * 问题分析：由于不同层的打印顺序不同，所以这里需要使用两个辅助容器，且每一行的打印顺序都和上一行相反，因此使用栈，且注意不同的入栈顺序
	 * 
	 * @param pRoot
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> printZhiZi(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null) {
			return list;
		}
		
		// 保存奇数层节点（入栈顺序与打印顺序应该相反，右节点先入栈）
		Stack<TreeNode> oddStack = new Stack<TreeNode>();
		// 保存偶数层节点（入栈顺序与打印顺序应该相反，左节点先入栈）
		Stack<TreeNode> evenStack = new Stack<TreeNode>();
		oddStack.add(pRoot);
		
		TreeNode pNode = null;
		while(!oddStack.isEmpty() || !evenStack.isEmpty()) {
			// 打印奇数层
			ArrayList<Integer> odd = new ArrayList<Integer>();
			while(!oddStack.isEmpty()) {
				pNode = oddStack.pop();
				odd.add(pNode.getValue());
				
				// 保存偶数层（左节点先入栈）
				if(pNode.getLeft() != null) {
					evenStack.push(pNode.getLeft());
				}
				if(pNode.getRight() != null) {
					evenStack.push(pNode.getRight());
				}
			}
			
			if(!odd.isEmpty()) {
				list.add(odd);
			}
			
			// 打印偶数层
			ArrayList<Integer> even = new ArrayList<Integer>();
			while(!evenStack.isEmpty()) {
				pNode = evenStack.pop();
				even.add(pNode.getValue());
				
				// 保存奇数层（右节点先入栈）
				if(pNode.getRight() != null) {
					oddStack.push(pNode.getRight());
				}
				if(pNode.getLeft() != null) {
					oddStack.push(pNode.getLeft());
				}
			}
			
			if(!even.isEmpty()) {
				list.add(even);
			}
		}
		
		return list;
    }
}
