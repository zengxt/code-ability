package binary.tree;

import java.util.Stack;

/**
 * @Description: �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * @author�� zxt
 * @time: 2018��7��5�� ����8:04:08
 */
public class �����ӽṹ {

    public static void main(String[] args) {

    }

    /**
     * @param root1
     * @param root2
     * @return
     * @Description�����ȿ������Ƿ����ҵ�һ���ڵ�R������subRoot�ĸ��ڵ�һ������һ�����ٱȽ�R������������subRoot�����������Ƿ�һ��
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            // �Ӹ��ڵ㿪ʼ�ж�����ĳ���ڵ�R�Ƿ�������ĸ��ڵ���ȣ������������ж�R���������������������������Ƿ�Ҳ���
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
     * @Description:����һ��˼·���ж�������ǰ����������Ƿ��Ǹ�����ǰ��������е������У��������ʾ���Ǹ���������
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
            // ǰ��������ȷ��ʸ��ڵ㣬�ٷ����������������������
            if (pNode != null) {
                // �ȷ�������ջ����˴�ջ�е����ڵ��丸�ڵ��븸�ڵ�����������ѷ��ʹ�
                preStr.append(pNode.getValue());
                stack.push(pNode);
                pNode = pNode.getLeft();

            } else {
                pNode = stack.pop();
                // ����ջ�еĽڵ���Է��ʹ��ˣ����Է����������ӽڵ�
                pNode = pNode.getRight();
            }
        }

        return preStr.toString();
    }
}
