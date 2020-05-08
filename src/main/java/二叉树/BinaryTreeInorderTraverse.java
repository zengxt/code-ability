package 二叉树;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Description: 二叉树的中序遍历
 *
 * @author： zxt
 *
 * @time: 2018年6月13日 下午5:30:00
 *
 */
public class BinaryTreeInorderTraverse {

	public static void main(String[] args) {
		int[] array = { 6, 4, 9, 2, 5, 3, 17, 8, 12 };
		// 构造一个二叉排序树
		TreeNode root = TreeNode.createBinaryTree(array);
		
		// 中序遍历
		System.out.println("--------------中序遍历--------------");
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(inOrder(root, list));
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		System.out.println(inOrder1(root, list1));
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		System.out.println(inOrder2(root, list2));
	}

	/**
	 * 递归中序遍历二叉树：左根右
	 * （1）如果二叉树为空，空操作。
	 * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
	 * 
	 * @param root
	 */
	public static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return null;
		}

		// 中序遍历左子树
		inOrder(root.getLeft(), list);
		// 访问根节点
		list.add(root.getValue());
		// 中序遍历右子树
		inOrder(root.getRight(), list);
		
		return list;
	}
	
	/**
	 * 
	 * @Description：非递归中序遍历
	 * 从根节点开始将左子树入栈，直到最下方。然后依次弹出访问，同样将左子树入栈，直到最下方。
	 * 
	 * @param root
	 * @param list
	 * @return
	 */
	public static ArrayList<Integer> inOrder1(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		
		while(p != null) {
			stack.push(p);
			p = p.getLeft();
		}
		
		while(!stack.isEmpty()) {
			p = stack.pop();
			// 访问
			list.add(p.getValue());
			
			// 从栈中取出的节点，其左子树与根都访问过，考虑右节点
			if(p.getRight() != null) {
				p = p.getRight();
				while(p != null) {
					stack.push(p);
					p = p.getLeft();
				}
			}
		}
		
		return list;
	}
	
	public static ArrayList<Integer> inOrder2(TreeNode root, ArrayList<Integer> list) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		
		while(p != null || !stack.isEmpty()) {
			if(p != null) {
				// 先入栈
				stack.push(p);
				p = p.getLeft();
				
			} else {
				p = stack.pop();
				// 访问
				list.add(p.getValue());
				p = p.getRight();
			}
		}
		
		return list;
	}
}