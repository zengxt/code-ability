package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: ��������ǰ�����
 * @author�� zxt
 * @time: 2018��6��13�� ����5:29:41
 */
public class BinaryTreePreOrderTraverse {
    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // ����һ������������
        TreeNode root = TreeNode.createBinaryTree(array);

        // ǰ�����
        System.out.println("--------------ǰ�����--------------");
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(preOrder(root, list));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(preOrder1(root, list1));

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.println(preOrder2(root, list2));

        System.out.println(preOrder3(root));
    }

    /**
     * ǰ������ķ���˳�򣺸�����
     * ǰ������ݹ�ⷨ��
     * ��1�����������Ϊ�գ��ղ���
     * ��2�������������Ϊ�գ����ʸ��ڵ㣬ǰ�������������ǰ�����������
     *
     * @param root
     */
    public static ArrayList<Integer> preOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        // ���ʸ��ڵ�
        list.add(root.getValue());
        // ǰ�����������
        preOrder(root.getLeft(), list);
        // ǰ�����������
        preOrder(root.getRight(), list);

        return list;
    }

    /**
     * �ǵݹ�ǰ�����
     * ����˼�룺���ø���ջ��ֻҪջ��Ϊ�գ��Ϳ���������������ÿ�ε���һ����㣬
     * �ǵð��������ҽ�㶼��ջ���ǵ��������Ƚ�ջ���������Ա�֤��������ջ���ܴ��������������档(�Ƚ����)
     *
     * @param root
     */
    public static ArrayList<Integer> preOrder1(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode p = null;

        while (!stack.isEmpty()) {
            p = stack.pop();
            list.add(p.getValue());

            // �������Ƚ�ջ
            if (p.getRight() != null) {
                stack.push(p.getRight());
            }
            if (p.getLeft() != null) {
                stack.push(p.getLeft());
            }
        }

        return list;
    }

    /**
     * �ǵݹ�ǰ�����
     * ˼·�ǣ��Ӹ��ڵ㿪ʼ���ʣ�Ȼ�������������һֱ�����·���
     * Ȼ�����������ʵ�����������������ͬ���ط��ʵ����·���
     *
     * @param root
     */
    public static ArrayList<Integer> preOrder2(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        // �Ӹ��ڵ㿪ʼ���ȷ����������ĸ��ڵ㣬����ջ
        while (p != null) {
            // ����
            list.add(p.getValue());
            stack.push(p);
            p = p.getLeft();
        }

        while (!stack.isEmpty()) {
            p = stack.pop();

            // ��ջ��ȡ���Ľڵ㣬���������Ѿ����ʹ������Է�����������
            if (p.getRight() != null) {
                // ͬ�����ȷ��������������·�
                p = p.getRight();
                while (p != null) {
                    // ����
                    list.add(p.getValue());
                    stack.push(p);
                    p = p.getLeft();
                }
            }
        }

        return list;
    }

    public static List<Integer> preOrder3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pnode = root;

        List<Integer> list = new ArrayList<>();
        while (pnode != null || !stack.isEmpty()) {
            if (pnode != null) {
                // �ȷ�������ջ
                list.add(pnode.getValue());
                stack.push(pnode);
                pnode = pnode.getLeft();
            } else {
                pnode = stack.pop();
                pnode = pnode.getRight();
            }
        }

        return list;
    }
}
