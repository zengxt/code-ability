package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: �������ĺ�����������Ϊ����������ȷ�������������Ȼ���ٷ��ʸ��ڵ㣨���ݣ��������ǰ������������ӣ���Ҫ��¼��Щ�ڵ��Ѿ����ʹ��ˣ�
 * @author�� zxt
 * @time: 2018��6��13�� ����5:30:25
 */
public class BinaryTreePostOrderTraverse {
    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // ����һ������������
        TreeNode root = TreeNode.createBinaryTree(array);

        // �������
        System.out.println("--------------�������--------------");
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(postOrder(root, list));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(postOrder1(root, list1));

        System.out.println(postOrder2(root));

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        System.out.println(postOrder3(root, list3));

    }

    /**
     * �ݹ������������������Ҹ�
     * ��1�����������Ϊ�գ��ղ�����
     * ��2�������������Ϊ�գ����������������������������������ʸ��ڵ�
     *
     * @param root
     */
    public static ArrayList<Integer> postOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        // �������������
        postOrder(root.getLeft(), list);
        // �������������
        postOrder(root.getRight(), list);
        // ���ʸ��ڵ�
        list.add(root.getValue());

        return list;
    }


    public static ArrayList<Integer> postOrder1(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        // һ��������¼��һ�η��ʵĽڵ㣨ֻ�е�һ���ڵ��������Ϊ�գ�������������һ���Ѿ����ʣ��ŷ����Լ���
        TreeNode pre = null;

        while (p != null) {
            // ��������ջ
            while (p.getLeft() != null) {
                stack.push(p);
                p = p.getLeft();
            }

            // ��ǰ�ڵ����������������Ѿ����
            while (p != null && (p.getRight() == null || p.getRight() == pre)) {
                // ����
                list.add(p.getValue());
                // ��¼��һ�η��ʵĽڵ�
                pre = p;

                if (stack.isEmpty()) {
                    return list;
                }
                p = stack.pop();
            }

            // ����������
            stack.push(p);
            p = p.getRight();
        }

        return list;
    }

    public static List<Integer> postOrder2(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pnode = root;
        // һ��������¼��һ�η��ʵĽڵ㣨ֻ�е�һ���ڵ��������Ϊ�գ�������������һ���Ѿ����ʣ��ŷ����Լ���
        TreeNode pre = null;

        while (pnode != null || !stack.isEmpty()) {
            // ��������ջ
            while (pnode != null) {
                stack.push(pnode);
                pnode = pnode.getLeft();
            }

            if (!stack.isEmpty()) {
                TreeNode temp = stack.peek().getRight();
                if (temp == null || temp == pre) {
                    // ������Ϊ�գ������Ѿ����ʹ�
                    pnode = stack.pop();
                    list.add(pnode.getValue());

                    // ��¼��һ�η��ʵĽڵ�
                    pre = pnode;
                    // ��ǰ���������ˣ�Ӧ�ô�ջ��������ȡ
                    pnode = null;
                } else {
                    pnode = temp;
                }
            }
        }

        return list;
    }

    /**
     * @param root
     * @param list
     * @return
     * @Description��˫ջ���������������������һ���м�ջ���洢���������Ľ���� �������Ҹ�����������պ��෴����������ı������Բο�ǰ�����
     */
    public static ArrayList<Integer> postOrder3(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        // ��������ջ
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // �м�ջ
        Stack<TreeNode> temp = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                temp.push(p);
                // ��  ��  ��  ��Ϊ�������������
                p = p.getRight();
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.getLeft();
            }
        }

        while (!temp.isEmpty()) {
            p = temp.pop();
            list.add(p.getValue());
        }

        return list;
    }
}
