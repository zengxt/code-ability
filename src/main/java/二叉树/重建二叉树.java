package 二叉树;

import java.util.ArrayList;

/**
 * 
 * @Description: 重建二叉树（给出二叉树的前序和中序遍历数组，重构二叉树）
 *
 * @author： zxt
 *
 * @time: 2018年6月17日 下午10:45:23
 *
 */
public class 重建二叉树 {

	public static void main(String[] args) {
		// 前序
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		// 中序
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		// 重构二叉树
		TreeNode root = reConstructBinaryTree(pre, in);
		
		// 再次遍历
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("pre：" + BinaryTreePreorderTraverse.preOrder(root, list));
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		System.out.println("in：" + BinaryTreeInorderTraverse.inOrder(root, list1));
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
		
		return constructBinaryTree2(pre, 0, pre.length - 1, in, 0, in.length -1);
    }
	
	/**
	 * 
	 * @Description：构建子序列的二叉树（由于遍历也是递归的）
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
		
		// 前序遍历序列的第一个数字是根节点的值
		int rootValue = pre[startPreorder];
		TreeNode root = new TreeNode(rootValue);
		
		if(startPreorder == endPreorder) {
			if(startInorder == endInorder) {
				// 只剩下一个节点，则返回
				return root;
			} else {
				return null;
			}
		}
		
		
		// 在中序遍历中找到根节点的值
		int rootInorder = startInorder;
		while(rootInorder <= endInorder && in[rootInorder] != rootValue) {
			rootInorder++;
		}
		// 在中序序列中找不到树的根节点（输入不正确）
		if(rootInorder == endInorder && in[rootInorder] != rootValue) {
			return null;
		}
		
		
		// 计算左子树的长度，即中序序列中根节点前面的子序列
		int leftLength = rootInorder - startInorder;
		// 前序序列中，根节点后面的就是跟的左子树序列（长度肯定和中序中的长度一样）
		int leftPreorderEnd = startPreorder + leftLength;
		
		// 用递归的方式构建根节点的左右子树
		if(leftLength > 0) {
			// 构建左子树
			root.setLeft(constructBinaryTree(pre, startPreorder + 1, leftPreorderEnd, 
					in, startInorder, rootInorder - 1));
		}
		if(leftLength < endPreorder - startPreorder) {
			// 构建右子树
			root.setRight(constructBinaryTree(pre, leftPreorderEnd + 1, endPreorder, 
					in, rootInorder + 1, endInorder));
		}
		
		
		return root;
	}
	
	// 简化版
	public static TreeNode constructBinaryTree2(int [] pre, int startPreorder, int endPreorder, 
			int [] in, int startInorder, int endInorder) {
		
		if(endPreorder < startPreorder || endInorder < startInorder) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[startPreorder]);
		for(int i = startInorder; i <= endInorder; i++) {
			if(pre[startPreorder] == in[i]) {
				// 构建左子树
				root.setLeft(constructBinaryTree2(pre, startPreorder + 1, startPreorder + i - startInorder, 
						in, startInorder, i - 1));
				// 构建右子树
				root.setRight(constructBinaryTree2(pre, startPreorder + i - startInorder + 1, endPreorder, 
						in, i + 1, endInorder));
				break;
			}
		}
		
		return root;
	}

}
