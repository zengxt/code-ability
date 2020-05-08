package ������;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Description: ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 *
 * @author�� zxt
 *
 * @time: 2018��7��11�� ����9:04:49
 *
 */
public class �������к�Ϊ��ֵ��·�� {
	private static ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		int[] array = { 6, 4, 9, 2, 5, 3, 17, 8, 12 };
		// ����һ������������
		TreeNode root = TreeNode.createBinaryTree(array);
		
		int target = 15;
		
		ArrayList<ArrayList<Integer>> result = findPath(root, target);
		System.out.println(result);
		
		findPath2(root, target);
		System.out.println(paths);
	}
	
	/**
	 * 
	 * @Description��ǰ��������ǴӸ��ڵ�����ģ����Լ�¼ǰ����������У�ÿ�η��ʵ����ڵ���ж����Ƿ�Ϊ����������һ��·��
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
		// ǰ�����
		while(pNode != null || !stack.isEmpty()) {
			if(pNode != null) {
				// �ȷ�������ջ
				list.add(pNode.getValue());
				// sum += pNode.getValue();
				stack.push(pNode);
				
				// ������ʵ����ڵ㣬���жϸ�·���Ƿ�Ϸ�
				if(pNode.getLeft() == null && pNode.getRight() == null) {
					// if(target == sum) 
					if(target == sumList(list)) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for(int i = 0 ; i < list.size(); i++) {
							temp.add(list.get(i));
						}
						result.add(temp);

						// �Ѿ����ʵ����ڵ㣬��ʱҪ������һ��ڵ�
						list.remove(list.size() - 1);
						// sum -= list.get(list.size() - 1)
					}
				}
				
				pNode = pNode.getLeft();
				
			} else {
				pNode = stack.pop();
				// ���ӽ���Ѿ����ʹ���
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
	 * @Description��ʹ�õݹ�ķ���ʵ��
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
		
		// �����Ҷ�ӽڵ㣬����·���ϵĽڵ�ֵ����Ŀ��ֵ�����ǺϷ�·��
		if(currentSum == target && (root.getLeft() == null && root.getRight() == null)) {
			// ���浱ǰ·��
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 0 ; i < list.size(); i++) {
				temp.add(list.get(i));
			}
			paths.add(temp);
			
			// ����(������½��Ļ���ÿ����ӵĶ���list��ָ����ͬ����list����һֱ�޸�)
			// paths.add(new ArrayList<Integer>(list));
		}
		
		// �������Ҷ�ӽڵ㣬����������ӽڵ�
		if(root.getLeft() != null) {
			findPath2(root.getLeft(), target, currentSum, list);
		}
		if(root.getRight() != null) {
			findPath2(root.getRight(), target, currentSum, list);
		}
		
		// ���ظ��ڵ�֮ǰ����·����ɾ����ǰ�ڵ�
		list.remove(list.size() - 1);
		// currentSum���ñ䣬��Ϊ����֮��currentSum����֮ǰ��ֵ
	}

}
