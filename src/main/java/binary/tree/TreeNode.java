package binary.tree;

/**
 * @Description: ����������ڵ�
 * @author�� zxt
 * @time: 2018��6��2�� ����4:24:30
 */
public class TreeNode {
    // ������
    private int value;
    // ��ڵ�
    private TreeNode left;
    // �ҽڵ�
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // �½�һ�����������
    public static TreeNode createBinaryTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            root.add(array[i]);
        }

        return root;
    }


    // �������������һ���ڵ㣨������ķ�ʽ�����������
    public void add(int value) {
        // �����ڵ�ֵ���ڸ��ڵ㣨���뵽��������
        if (value > this.value) {
            if (right != null) {
                right.add(value);
            } else {
                TreeNode node = new TreeNode(value);
                right = node;
            }

        } else {
            if (left != null) {
                left.add(value);
            } else {
                TreeNode node = new TreeNode(value);
                left = node;
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
