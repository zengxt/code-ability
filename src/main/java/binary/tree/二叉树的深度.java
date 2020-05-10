package binary.tree;

/**
 * @Description: ��һ�Ŷ����������
 * @author�� zxt
 * @time: 2018��6��18�� ����4:57:00
 */
public class ����������� {

    public static void main(String[] args) {
        int[] array = {6, 4, 9, 2, 5, 3, 17, 8, 12};
        // ����һ������������
        TreeNode root = TreeNode.createBinaryTree(array);

        System.out.println(TreeDepth(root));
    }

    /**
     * @param root
     * @return
     * @Description:���������ֻ��һ�����ڵ������Ϊ1�����ֻ���������������Ϊ��������ȼ�1�����ֻ���������������Ϊ��������1�� ��������������������Ϊ����������ȵĽϴ�ֵ��1
     */
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // ���������
        int nLeft = TreeDepth(root.getLeft());
        // ���������
        int nRight = TreeDepth(root.getRight());

        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

}
