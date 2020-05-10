package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: ���������������
 * @author�� zxt
 * @time: 2018��6��13�� ����5:30:00
 */
public class BinaryTreeInOrderTraverse {
    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // ����һ������������
        TreeNode root = TreeNode.createBinaryTree(array);

        // �������
        System.out.println("--------------�������--------------");
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(inOrder(root, list));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(inOrder1(root, list1));

        System.out.println(inOrder2(root));
    }

    /**
     * �ݹ���������������������
     * ��1�����������Ϊ�գ��ղ�����
     * ��2�������������Ϊ�գ�������������������ʸ��ڵ㣬�������������
     *
     * @param root root
     */
    public static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        // �������������
        inOrder(root.getLeft(), list);
        // ���ʸ��ڵ�
        list.add(root.getValue());
        // �������������
        inOrder(root.getRight(), list);

        return list;
    }

    /**
     * @param root
     * @param list
     * @return
     * @Description���ǵݹ�������� �Ӹ��ڵ㿪ʼ����������ջ��ֱ�����·���Ȼ�����ε������ʣ�ͬ������������ջ��ֱ�����·���
     */
    public static ArrayList<Integer> inOrder1(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null) {
            stack.push(p);
            p = p.getLeft();
        }

        while (!stack.isEmpty()) {
            p = stack.pop();
            // ����
            list.add(p.getValue());

            // ��ջ��ȡ���Ľڵ㣬����������������ʹ��������ҽڵ�
            if (p.getRight() != null) {
                p = p.getRight();
                while (p != null) {
                    stack.push(p);
                    p = p.getLeft();
                }
            }
        }

        return list;
    }

    public static List<Integer> inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pnode = root;

        List<Integer> list = new ArrayList<>();
        while (pnode != null || !stack.isEmpty()) {
            if (pnode != null) {
                // ����ջ
                stack.push(pnode);
                pnode = pnode.getLeft();
            } else {
                pnode = stack.pop();
                // ����
                list.add(pnode.getValue());
                pnode = pnode.getRight();
            }
        }

        return list;
    }
}