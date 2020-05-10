package binary.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author： zxt
 * @time: 2018年7月5日 下午9:13:30
 */
public class 二叉树的镜像 {

    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // 构造一个二叉排序树
        TreeNode root = TreeNode.createBinaryTree(array);

        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(层序遍历.layerOrder(root, list));

        // Mirror1(root);
        Mirror2(root);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(层序遍历.layerOrder(root, list1));
    }

    /**
     * @param root
     * @Description：递归实现
     */
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        // 只有一个根节点，镜像也就是它自己
        if (root.getLeft() == null && root.getRight() == null) {
            return;
        }

        // 交换根节点的左右子树
        TreeNode pTemp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(pTemp);

        // 交换根节点的左右子树的左右子树节点
        if (root.getLeft() != null) {
            Mirror(root.getLeft());
        }
        if (root.getRight() != null) {
            Mirror(root.getRight());
        }
    }

    /**
     * @param root
     * @Description：非递归实现
     */
    public static void Mirror2(TreeNode root) {
        if (root == null) {
            return;
        }

        // 只有一个根节点，镜像也就是它自己
        if (root.getLeft() == null && root.getRight() == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pNode = null;

        // 前序遍历每个节点，然后交换每个节点的左右子树节点
        while (!stack.isEmpty()) {
            pNode = stack.pop();

            TreeNode pTemp = pNode.getLeft();
            pNode.setLeft(pNode.getRight());
            pNode.setRight(pTemp);

            // 正常的前序遍历，左子树先于右子树访问，所以先右子树入栈，然后后弹出。这里由于每个节点都交换左右子树，
            // 实际上正确的前序遍历应该是先左子树入栈，然后右子树。而这里我们的目标只是要交换每个节点的左右子树（叶子节点的左右子树为空，交换与不交换一样）
            if (pNode.getRight() != null) {
                stack.push(pNode.getRight());
            }
            if (pNode.getLeft() != null) {
                stack.push(pNode.getLeft());
            }
        }
    }
}
