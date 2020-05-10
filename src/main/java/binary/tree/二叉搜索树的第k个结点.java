package binary.tree;

import java.util.Stack;

/**
 * @Description: ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 * @author�� zxt
 * @time: 2018��8��29�� ����10:42:29
 */
public class �����������ĵ�k����� {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * @param pRoot
     * @param k
     * @return
     * @Description�����������������������ʵ�������������
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
