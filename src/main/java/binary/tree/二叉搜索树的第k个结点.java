package binary.tree;

import java.util.Stack;

/**
 * @Description: 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @author： zxt
 * @time: 2018年8月29日 上午10:42:29
 */
public class 二叉搜索树的第k个结点 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * @param pRoot
     * @param k
     * @return
     * @Description：二叉搜索树的中序遍历其实就是有序的序列
     */
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }

        TreeNode pNode = pRoot;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int index = 0;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.getLeft();
            } else {
                pNode = stack.pop();
                if (++index == k) {
                    return pNode;
                }
                pNode = pNode.getRight();
            }
        }

        return null;
    }

}
