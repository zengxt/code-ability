package binary.tree;

import java.util.Stack;

/**
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author： zxt
 * @time: 2018年7月5日 下午8:04:08
 */
public class 树的子结构 {

    public static void main(String[] args) {

    }

    /**
     * @param root1
     * @param root2
     * @return
     * @Description：首先看树中是否能找到一个节点R与子树subRoot的根节点一样，若一样则再比较R的左右子树与subRoot的左右子树是否一样
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            // 从根节点开始判断树的某个节点R是否和子树的根节点相等，若相等则继续判断R的左右子树与子树的左右子树是否也相等
            if (root1.getValue() == root2.getValue()) {
                result = doesTree1HaveTree2(root1, root2);
            }

            if (!result) {
                result = HasSubtree(root1.getLeft(), root2) || HasSubtree(root1.getRight(), root2);
            }
        }

        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.getValue() != root2.getValue()) {
            return false;
        }

        return doesTree1HaveTree2(root1.getLeft(), root2.getLeft()) &&
                doesTree1HaveTree2(root1.getRight(), root2.getRight());
    }

    /**
     * @param root1
     * @param root2
     * @return
     * @Description:另外一种思路：判断子树的前序遍历序列是否是该树的前序遍历序列的子序列，若是则表示它是该树的子树
     */
    public static boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            String root1Str = preOrder(root1);
            String root2Str = preOrder(root2);

            result = root1Str.contains(root2Str);
        }

        return result;
    }

    public static String preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pNode = root;

        StringBuffer preStr = new StringBuffer();
        while (pNode != null || !stack.isEmpty()) {
            // 前序遍历，先访问根节点，再访问左子树，后访问右子树
            if (pNode != null) {
                // 先访问再入栈，因此从栈中弹出节点其父节点与父节点的左子树均已访问过
                preStr.append(pNode.getValue());
                stack.push(pNode);
                pNode = pNode.getLeft();

            } else {
                pNode = stack.pop();
                // 由于栈中的节点均以访问过了，所以访问它的右子节点
                pNode = pNode.getRight();
            }
        }

        return preStr.toString();
    }
}
