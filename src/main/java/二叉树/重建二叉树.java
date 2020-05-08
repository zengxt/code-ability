package ������;

import java.util.ArrayList;

/**
 * 
 * @Description: �ؽ���������������������ǰ�������������飬�ع���������
 *
 * @author�� zxt
 *
 * @time: 2018��6��17�� ����10:45:23
 *
 */
public class �ؽ������� {

	public static void main(String[] args) {
		// ǰ��
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		// ����
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		// �ع�������
		TreeNode root = reConstructBinaryTree(pre, in);
		
		// �ٴα���
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("pre��" + BinaryTreePreorderTraverse.preOrder(root, list));
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		System.out.println("in��" + BinaryTreeInorderTraverse.inOrder(root, list1));
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
		
		return constructBinaryTree2(pre, 0, pre.length - 1, in, 0, in.length -1);
    }
	
	/**
	 * 
	 * @Description�����������еĶ����������ڱ���Ҳ�ǵݹ�ģ�
	 * 
	 * @param pre
	 * @param startPreorder
	 * @param endPreorder
	 * @param in
	 * @param startInorder
	 * @param endInorder
	 * @return
	 */
	public static TreeNode constructBinaryTree(int [] pre, int startPreorder, int endPreorder, 
			int [] in, int startInorder, int endInorder) {
		
		// ǰ��������еĵ�һ�������Ǹ��ڵ��ֵ
		int rootValue = pre[startPreorder];
		TreeNode root = new TreeNode(rootValue);
		
		if(startPreorder == endPreorder) {
			if(startInorder == endInorder) {
				// ֻʣ��һ���ڵ㣬�򷵻�
				return root;
			} else {
				return null;
			}
		}
		
		
		// ������������ҵ����ڵ��ֵ
		int rootInorder = startInorder;
		while(rootInorder <= endInorder && in[rootInorder] != rootValue) {
			rootInorder++;
		}
		// �������������Ҳ������ĸ��ڵ㣨���벻��ȷ��
		if(rootInorder == endInorder && in[rootInorder] != rootValue) {
			return null;
		}
		
		
		// �����������ĳ��ȣ������������и��ڵ�ǰ���������
		int leftLength = rootInorder - startInorder;
		// ǰ�������У����ڵ����ľ��Ǹ������������У����ȿ϶��������еĳ���һ����
		int leftPreorderEnd = startPreorder + leftLength;
		
		// �õݹ�ķ�ʽ�������ڵ����������
		if(leftLength > 0) {
			// ����������
			root.setLeft(constructBinaryTree(pre, startPreorder + 1, leftPreorderEnd, 
					in, startInorder, rootInorder - 1));
		}
		if(leftLength < endPreorder - startPreorder) {
			// ����������
			root.setRight(constructBinaryTree(pre, leftPreorderEnd + 1, endPreorder, 
					in, rootInorder + 1, endInorder));
		}
		
		
		return root;
	}
	
	// �򻯰�
	public static TreeNode constructBinaryTree2(int [] pre, int startPreorder, int endPreorder, 
			int [] in, int startInorder, int endInorder) {
		
		if(endPreorder < startPreorder || endInorder < startInorder) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[startPreorder]);
		for(int i = startInorder; i <= endInorder; i++) {
			if(pre[startPreorder] == in[i]) {
				// ����������
				root.setLeft(constructBinaryTree2(pre, startPreorder + 1, startPreorder + i - startInorder, 
						in, startInorder, i - 1));
				// ����������
				root.setRight(constructBinaryTree2(pre, startPreorder + i - startInorder + 1, endPreorder, 
						in, i + 1, endInorder));
				break;
			}
		}
		
		return root;
	}

}
