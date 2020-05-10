package binary.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: ���������Ķ�����������任ΪԴ�������ľ���
 * @author�� zxt
 * @time: 2018��7��5�� ����9:13:30
 */
public class �������ľ��� {

    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // ����һ������������
        TreeNode root = TreeNode.createBinaryTree(array);

        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(�������.layerOrder(root, list));

        // Mirror1(root);
        Mirror2(root);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(�������.layerOrder(root, list1));
    }

    /**
     * @param root
     * @Description���ݹ�ʵ��
     */
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        // ֻ��һ�����ڵ㣬����Ҳ�������Լ�
        if (root.getLeft() == null && root.getRight() == null) {
            return;
        }

        // �������ڵ����������
        TreeNode pTemp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(pTemp);

        // �������ڵ���������������������ڵ�
        if (root.getLeft() != null) {
            Mirror(root.getLeft());
        }
        if (root.getRight() != null) {
            Mirror(root.getRight());
        }
    }

    /**
     * @param root
     * @Description���ǵݹ�ʵ��
     */
    public static void Mirror2(TreeNode root) {
        if (root == null) {
            return;
        }

        // ֻ��һ�����ڵ㣬����Ҳ�������Լ�
        if (root.getLeft() == null && root.getRight() == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pNode = null;

        // ǰ�����ÿ���ڵ㣬Ȼ�󽻻�ÿ���ڵ�����������ڵ�
        while (!stack.isEmpty()) {
            pNode = stack.pop();

            TreeNode pTemp = pNode.getLeft();
            pNode.setLeft(pNode.getRight());
            pNode.setRight(pTemp);

            // ������ǰ��������������������������ʣ���������������ջ��Ȼ��󵯳�����������ÿ���ڵ㶼��������������
            // ʵ������ȷ��ǰ�����Ӧ��������������ջ��Ȼ�������������������ǵ�Ŀ��ֻ��Ҫ����ÿ���ڵ������������Ҷ�ӽڵ����������Ϊ�գ������벻����һ����
            if (pNode.getRight() != null) {
                stack.push(pNode.getRight());
            }
            if (pNode.getLeft() != null) {
                stack.push(pNode.getLeft());
            }
        }
    }
}
