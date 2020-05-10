package binary.tree;

import java.util.Stack;

/**
 * LeetCode 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class BinarySearchTreeToCumulativeTree {
    public static void main(String[] args) {
        int[] array = {5, 2, 13};
        // 构造一个二叉排序树
        TreeNode root = TreeNode.createBinaryTree(array);

        System.out.println(BinaryTreeInOrderTraverse.inOrder2(root));
        System.out.println(BinaryTreeInOrderTraverse.inOrder2(convertBST(root)));
    }

    // 二叉搜索树的中序遍历是递增序列，那中序遍历反过来就是递减序列，并把结点值累加到前面的结点上就可以了
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pnode = root;
        // 累加和
        int result = 0;
        while (pnode != null || !stack.isEmpty()) {
            // 正常中序是左子树先进栈的，这里反过来
            if (pnode != null) {
                stack.push(pnode);
                pnode = pnode.getRight();
            } else {
                TreeNode node = stack.pop();
                result += node.getValue();
                node.setValue(result);

                pnode = node.getLeft();
            }
        }

        return root;
    }
}
