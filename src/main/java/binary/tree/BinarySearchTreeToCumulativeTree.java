package binary.tree;

import java.util.Stack;

/**
 * LeetCode 538. �Ѷ���������ת��Ϊ�ۼ���
 * ����һ��������������Binary Search Tree��������ת����Ϊ�ۼ�����Greater Tree)��
 * ʹ��ÿ���ڵ��ֵ��ԭ���Ľڵ�ֵ�������д������Ľڵ�ֵ֮�͡�
 */
public class BinarySearchTreeToCumulativeTree {
    public static void main(String[] args) {
        int[] array = {5, 2, 13};
        // ����һ������������
        TreeNode root = TreeNode.createBinaryTree(array);

        System.out.println(BinaryTreeInOrderTraverse.inOrder2(root));
        System.out.println(BinaryTreeInOrderTraverse.inOrder2(convertBST(root)));
    }

    // ��������������������ǵ������У�������������������ǵݼ����У����ѽ��ֵ�ۼӵ�ǰ��Ľ���ϾͿ�����
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pnode = root;
        // �ۼӺ�
        int result = 0;
        while (pnode != null || !stack.isEmpty()) {
            // �����������������Ƚ�ջ�ģ����ﷴ����
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
