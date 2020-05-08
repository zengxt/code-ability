package 二叉树;

/**
 * 
 * @Description: 给定一个序列，判断该序列是不是二叉搜索树的后序遍历序列
 *
 * @author： zxt
 *
 * @time: 2018年6月19日 上午8:48:59
 *
 */
public class 二叉搜索树后序遍历判断 {

	public static void main(String[] args) {
		二叉搜索树后序遍历判断 is = new 二叉搜索树后序遍历判断();
		
		int[] sequence = {5, 7, 6, 9, 11, 10, 8};
		System.out.println(is.verifySquenceOfBST(sequence));
		
		int[] sequence2 = {7, 4, 6, 5};
		System.out.println(is.verifySquenceOfBST(sequence2));
	}
	
	/**
	 * 
	 * @Description:后序遍历的最后一个节点为根节点。而在二叉搜索树中，根节点的值大于左子树，小于右子树。递归判断左右子树即可
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean verifySquenceOfBST(int [] sequence) {
		if(sequence == null || sequence.length == 0) {
			return false;
		}
		
		return verify(sequence, 0, sequence.length - 1);
    }
	
	public boolean verify(int [] sequence, int start, int end) {
		// 根节点
		int root = sequence[end];
		
		// 在二叉搜索树中左子树节点的值小于根节点的值
		int leftIndex = 0;
		while(sequence[leftIndex] < root) {
			leftIndex++;
		}
		
		// 在二叉搜索树中右子树节点的值大于根节点的值
		int rightIndex = leftIndex;
		while(rightIndex < end) {
			if(sequence[rightIndex] < root) {
				return false;
			}
			rightIndex++;
		}
		
		// 判断左子树是不是二叉搜索树
		boolean left = true;
		if(leftIndex > 0) {
			left = verify(sequence, start, leftIndex - 1);
		}
		
		// 判断左子树是不是二叉搜索树
		boolean right = true;
		if(leftIndex < end) {
			right = verify(sequence, leftIndex, end - 1);
		}
		
		return (left && right);
	}
}
