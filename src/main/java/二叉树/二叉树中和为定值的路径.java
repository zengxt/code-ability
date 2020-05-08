package 二叉树;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @author： zxt
 *
 * @time: 2018年7月11日 上午9:04:49
 *
 */
public class 二叉树中和为定值的路径 {
	private static ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		int[] array = { 6, 4, 9, 2, 5, 3, 17, 8, 12 };
		// 构造一个二叉排序树
		TreeNode root = TreeNode.createBinaryTree(array);
		
		int target = 15;
		
		ArrayList<ArrayList<Integer>> result = findPath(root, target);
		System.out.println(result);
		
		findPath2(root, target);
		System.out.println(paths);
	}
	
	/**
	 * 
	 * @Description：前序遍历就是从根节点出发的，所以记录前序遍历的序列，每次访问到根节点就判断它是否为符合条件的一条路径
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = root;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// int sum = 0;
		// 前序遍历
		while(pNode != null || !stack.isEmpty()) {
			if(pNode != null) {
				// 先访问再入栈
				list.add(pNode.getValue());
				// sum += pNode.getValue();
				stack.push(pNode);
				
				// 如果访问到根节点，则判断该路径是否合法
				if(pNode.getLeft() == null && pNode.getRight() == null) {
					// if(target == sum) 
					if(target == sumList(list)) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for(int i = 0 ; i < list.size(); i++) {
							temp.add(list.get(i));
						}
						result.add(temp);

						// 已经访问到根节点，此时要返回上一层节点
						list.remove(list.size() - 1);
						// sum -= list.get(list.size() - 1)
					}
				}
				
				pNode = pNode.getLeft();
				
			} else {
				pNode = stack.pop();
				// 左子结点已经访问过了
				if(pNode.getLeft() != null) {
					list.remove(list.size() - 1);
					// sum -= list.get(list.size() - 1)
				}
				
				pNode = pNode.getRight();
			}
		}
		
		return result;
    }
	
	public static int sumList(ArrayList<Integer> list) {
		int result = 0;
		
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @Description：使用递归的方法实现
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> findPath2(TreeNode root, int target) {
		if(root == null) {
			return paths;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		findPath2(root, target, 0, list);
		
		return paths;
	}
	
	public static void findPath2(TreeNode root, int target, int currentSum, ArrayList<Integer> list) {
		currentSum += root.getValue();
		list.add(root.getValue());
		
		// 如果是叶子节点，并且路径上的节点值等于目标值，则是合法路径
		if(currentSum == target && (root.getLeft() == null && root.getRight() == null)) {
			// 保存当前路径
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 0 ; i < list.size(); i++) {
				temp.add(list.get(i));
			}
			paths.add(temp);
			
			// 或者(如果不新建的话则每次添加的都与list的指向相同，而list又在一直修改)
			// paths.add(new ArrayList<Integer>(list));
		}
		
		// 如果不是叶子节点，则遍历它的子节点
		if(root.getLeft() != null) {
			findPath2(root.getLeft(), target, currentSum, list);
		}
		if(root.getRight() != null) {
			findPath2(root.getRight(), target, currentSum, list);
		}
		
		// 返回父节点之前，在路径上删除当前节点
		list.remove(list.size() - 1);
		// currentSum不用变，因为返回之后currentSum还是之前的值
	}

}
