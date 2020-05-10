package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * @author�� zxt
 * @time: 2018��7��9�� ����7:37:16
 */
public class �Գƶ����� {

    public static void main(String[] args) {

    }

    /**
     * @param pRoot
     * @return
     * @Description�����ݶ��壬ʵ���Ͼ��Ǹ��ڵ�����������Ҫһ����������������������������������һ����������������������������������һ��
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }

        // ���������һ���ж���ζ�ţ�pRoot1��pRoot2������ͬʱΪnull����ʱ������һ��Ϊ�գ���˵�������侵���ǲ�һ����
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
     * @Description���ǵݹ�ʵ��
     */
    public boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        // ʹ���������У��������ľ����������������ԭ���෴������׼���������У��洢���ң�����������ͬ˳�������
        Queue<TreeNode> leftFirstQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rightFirstQueue = new LinkedList<TreeNode>();
        leftFirstQueue.add(pRoot.getLeft());
        rightFirstQueue.add(pRoot.getRight());

        TreeNode pLeft = null;
        TreeNode pRight = null;
        while (!leftFirstQueue.isEmpty() && !rightFirstQueue.isEmpty()) {
            pLeft = leftFirstQueue.poll();
            pRight = rightFirstQueue.poll();

            // ���߶�Ϊ��
            if (pLeft == null && pRight == null) {
                continue;
            }
            // һ��Ϊ��
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
