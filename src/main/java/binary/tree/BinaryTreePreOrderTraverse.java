package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树的前序遍历
 * @author： zxt
 * @time: 2018年6月13日 下午5:29:41
 */
public class BinaryTreePreOrderTraverse {
    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // 构造一个二叉排序树
        TreeNode root = TreeNode.createBinaryTree(array);

        // 前序遍历
        System.out.println("--------------前序遍历--------------");
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(preOrder(root, list));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(preOrder1(root, list1));

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.println(preOrder2(root, list2));

        System.out.println(preOrder3(root));
    }

    /**
     * 前序遍历的访问顺序：根左右
     * 前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     *
     * @param root
     */
    public static ArrayList<Integer> preOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        // 访问根节点
        list.add(root.getValue());
        // 前序遍历左子树
        preOrder(root.getLeft(), list);
        // 前序遍历右子树
        preOrder(root.getRight(), list);

        return list;
    }

    /**
     * 非递归前序遍历
     * 遍历思想：先让根进栈，只要栈不为空，就可以做弹出操作，每次弹出一个结点，
     * 记得把它的左右结点都进栈，记得右子树先进栈，这样可以保证右子树在栈中总处于左子树的下面。(先进后出)
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

            // 右子树先进栈
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
     * 非递归前序遍历
     * 思路是：从根节点开始访问，然后访问左子树，一直到最下方。
     * 然后访问最近访问的左子树的右子树，同样地访问到最下方。
     *
     * @param root
     */
    public static ArrayList<Integer> preOrder2(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        // 从根节点开始首先访问左子树的根节点，并入栈
        while (p != null) {
            // 访问
            list.add(p.getValue());
            stack.push(p);
            p = p.getLeft();
        }

        while (!stack.isEmpty()) {
            p = stack.pop();

            // 从栈中取出的节点，其左子树已经访问过，所以访问其右子树
            if (p.getRight() != null) {
                // 同样地先访问左子树到最下方
                p = p.getRight();
                while (p != null) {
                    // 访问
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
                // 先访问再入栈
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
