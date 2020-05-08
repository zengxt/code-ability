package 二叉树;

/**
 * 
 * @Description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。(即二叉树任意节点的左右子树的深度相差不超过1)
 *
 * @author： zxt
 *
 * @time: 2018年8月29日 上午11:22:04
 *
 */
public class 是否平衡二叉树 {
	// 静态变量只会在类加载的时候初始化一次，后面遇到初始化语句也会被忽略，你改变静态变量的值之后，下次这个变量可不是你的默认值了。
	private boolean isBalanced = true;
	
	// 最简便的方法，直接调用求二叉树深度的代码，分别求二叉树每个节点的左右子树的深度，判断他们的深度相差是否为1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		是否平衡二叉树 charge = new 是否平衡二叉树();
		System.out.println(charge.isBalanced(root));
	}
	
	public boolean isBalanced(TreeNode root) {
		getDepth(root);
		return isBalanced;
    }
	
	/**
	 * 
	 * @Description：按后序遍历的顺序遍历，可以防止重复访问节点
	 * 
	 * @param root
	 * @return
	 */
	public int getDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = getDepth(root.getLeft());
		int right = getDepth(root.getRight());
		if(Math.abs(left - right) > 1) {
			isBalanced = false;
		}
		
		return 1 + (left > right ? left : right);
	}

}
