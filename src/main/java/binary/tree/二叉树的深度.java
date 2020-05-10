package binary.tree;

/**
 * @Description: 求一颗二叉树的深度
 * @author： zxt
 * @time: 2018年6月18日 下午4:57:00
 */
public class 二叉树的深度 {

    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // 构造一个二叉排序树
        TreeNode root = TreeNode.createBinaryTree(array);

        System.out.println(TreeDepth(root));
    }

    /**
     * @param root
     * @return
     * @Description:如果二叉树只有一个根节点则深度为1，如果只有左子树，则深度为左子树深度加1；如果只有右子树，则深度为右子树加1； 如果有左右子树，则深度为左右子树深度的较大值加1
     */
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左子树深度
        int nLeft = TreeDepth(root.getLeft());
        // 右子树深度
        int nRight = TreeDepth(root.getRight());

        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

}
