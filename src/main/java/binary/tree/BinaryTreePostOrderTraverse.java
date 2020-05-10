package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树的后续遍历（因为后序遍历是先访问左右子树，然后再访问根节点（回溯），相比于前序与中序更复杂，需要记录哪些节点已经访问过了）
 * @author： zxt
 * @time: 2018年6月13日 下午5:30:25
 */
public class BinaryTreePostOrderTraverse {
    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // 构造一个二叉排序树
        TreeNode root = TreeNode.createBinaryTree(array);

        // 后序遍历
        System.out.println("--------------后序遍历--------------");
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(postOrder(root, list));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(postOrder1(root, list1));

        System.out.println(postOrder2(root));

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        System.out.println(postOrder3(root, list3));

    }

    /**
     * 递归后序遍历二叉树：左右根
     * （1）如果二叉树为空，空操作。
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     *
     * @param root
     */
    public static ArrayList<Integer> postOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        // 后序遍历左子树
        postOrder(root.getLeft(), list);
        // 后序遍历右子树
        postOrder(root.getRight(), list);
        // 访问根节点
        list.add(root.getValue());

        return list;
    }


    public static ArrayList<Integer> postOrder1(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        // 一个用来记录上一次访问的节点（只有当一个节点的右子树为空，或者右子树上一次已经访问，才访问自己）
        TreeNode pre = null;

        while (p != null) {
            // 左子树入栈
            while (p.getLeft() != null) {
                stack.push(p);
                p = p.getLeft();
            }

            // 当前节点无右子树，或者已经输出
            while (p != null && (p.getRight() == null || p.getRight() == pre)) {
                // 访问
                list.add(p.getValue());
                // 记录上一次访问的节点
                pre = p;

                if (stack.isEmpty()) {
                    return list;
                }
                p = stack.pop();
            }

            // 处理右子树
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
        // 一个用来记录上一次访问的节点（只有当一个节点的右子树为空，或者右子树上一次已经访问，才访问自己）
        TreeNode pre = null;

        while (pnode != null || !stack.isEmpty()) {
            // 左子树入栈
            while (pnode != null) {
                stack.push(pnode);
                pnode = pnode.getLeft();
            }

            if (!stack.isEmpty()) {
                TreeNode temp = stack.peek().getRight();
                if (temp == null || temp == pre) {
                    // 右子树为空，或者已经访问过
                    pnode = stack.pop();
                    list.add(pnode.getValue());

                    // 记录上一次访问的节点
                    pre = pnode;
                    // 当前结点访问完了，应该从栈里面重新取
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
     * @Description：双栈法后序遍历二叉树（构造一个中间栈来存储逆后序遍历的结果） 后序：左右根，根右左则刚好相反，而根右左的遍历可以参考前序遍历
     */
    public static ArrayList<Integer> postOrder3(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }

        // 遍历辅助栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 中间栈
        Stack<TreeNode> temp = new Stack<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                temp.push(p);
                // 根  右  左  则为后序遍历的逆序
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
