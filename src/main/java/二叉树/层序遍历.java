package ������;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @Description: ���������������������ȱ�����
 *
 * @author�� zxt
 *
 * @time: 2018��6��13�� ����10:00:46
 *
 */
public class ������� {

	public static void main(String[] args) {
		int[] array = { 6, 4, 9, 2, 5, 3, 17, 8, 12 };
		// ����һ������������
		TreeNode root = TreeNode.createBinaryTree(array);
		
		// �������
		System.out.println("--------------�������--------------");
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
	 * @Description������������������ö���ʵ�֣��Ƚ����ڵ�����У�ֻҪ���в�Ϊ�գ�Ȼ������У������ʣ����Ž����ʽڵ�������������������
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
	 * @Description���������������Ҫ��ÿ��Ľڵ�ֿ���
	 * 
	 * ����������һ��ʹ������������һ����ʾ��ǰ���л�û�д�ӡ�Ľڵ�������һ��������ʾ��һ��ڵ����Ŀ
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
		// ��ǰ����Ҫ��ӡ�Ľڵ���
		int toBePrinted = 1;
		// ��һ����Ҫ��ӡ�Ľڵ���
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
				// ��ǰ��ڵ��Ѿ���������
				toBePrinted = nextLevel;
				nextLevel = 0;
			}
		}
		
		return result;
    }
	
	/**
	 * 
	 * @Description����һ����ÿ����ȷ����һ��Ҫ��ӡ�Ľڵ�ĸ���
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
	 * @Description����ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ��
	 * �������Դ����ơ�
	 * 
	 * ������������ڲ�ͬ��Ĵ�ӡ˳��ͬ������������Ҫʹ������������������ÿһ�еĴ�ӡ˳�򶼺���һ���෴�����ʹ��ջ����ע�ⲻͬ����ջ˳��
	 * 
	 * @param pRoot
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> printZhiZi(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null) {
			return list;
		}
		
		// ����������ڵ㣨��ջ˳�����ӡ˳��Ӧ���෴���ҽڵ�����ջ��
		Stack<TreeNode> oddStack = new Stack<TreeNode>();
		// ����ż����ڵ㣨��ջ˳�����ӡ˳��Ӧ���෴����ڵ�����ջ��
		Stack<TreeNode> evenStack = new Stack<TreeNode>();
		oddStack.add(pRoot);
		
		TreeNode pNode = null;
		while(!oddStack.isEmpty() || !evenStack.isEmpty()) {
			// ��ӡ������
			ArrayList<Integer> odd = new ArrayList<Integer>();
			while(!oddStack.isEmpty()) {
				pNode = oddStack.pop();
				odd.add(pNode.getValue());
				
				// ����ż���㣨��ڵ�����ջ��
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
			
			// ��ӡż����
			ArrayList<Integer> even = new ArrayList<Integer>();
			while(!evenStack.isEmpty()) {
				pNode = evenStack.pop();
				even.add(pNode.getValue());
				
				// ���������㣨�ҽڵ�����ջ��
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
