package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author： zxt
 * @time: 2018年7月9日 下午7:37:16
 */
public class 对称二叉树 {

    public static void main(String[] args) {

    }

    /**
     * @param pRoot
     * @return
     * @Description：根据定义，实际上就是根节点左右子树需要一样，左子树的左子树和右子树的右子树一样，左子树的右子树和右子树的左子树一样
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }

        // 经过上面的一个判断意味着，pRoot1和pRoot2不可能同时为null，此时若存在一个为空，则说明树与其镜像是不一样的
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }

        if (pRoot1.getValue() != pRoot2.getValue()) {
            return false;
        }

        return isSymmetrical(pRoot1.getLeft(), pRoot2.getRight()) &&
                isSymmetrical(pRoot1.getRight(), pRoot2.getLeft());
    }

    /**
     * @param pRoot
     * @return
     * @Description：非递归实现
     */
    public boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        // 使用两个队列，由于树的镜像就是左右子树与原来相反，所以准备两个队列，存储左右，右左两个不同顺序的序列
        Queue<TreeNode> leftFirstQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rightFirstQueue = new LinkedList<TreeNode>();
        leftFirstQueue.add(pRoot.getLeft());
        rightFirstQueue.add(pRoot.getRight());

        TreeNode pLeft = null;
        TreeNode pRight = null;
        while (!leftFirstQueue.isEmpty() && !rightFirstQueue.isEmpty()) {
            pLeft = leftFirstQueue.poll();
            pRight = rightFirstQueue.poll();

            // 两边都为空
            if (pLeft == null && pRight == null) {
                continue;
            }
            // 一边为空
            if (pLeft == null || pRight == null) {
                return false;
            }

            if (pLeft.getValue() != pRight.getValue()) {
                return false;
            }

            leftFirstQueue.add(pLeft.getLeft());
            leftFirstQueue.add(pLeft.getRight());
            rightFirstQueue.add(pRight.getRight());
            rightFirstQueue.add(pRight.getLeft());
        }

        return true;
    }
}
