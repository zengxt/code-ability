package binary.tree;

import java.util.ArrayList;

/**
 * @Description: ��ʵ�������������ֱ��������л��ͷ����л�������
 * @author�� zxt
 * @time: 2018��7��15�� ����3:36:02
 */
public class ���л������� {
    // ������
    private static int index = 0;

    public static void main(String[] args) {
        int[] array = {10, 6, 4, 8, 14, 12, 16};

        TreeNode root = TreeNode.createBinaryTree(array);
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(�������.layerOrder(root, list));

        System.out.println(Serialize(root));
        TreeNode root1 = Deserialize(Serialize(root));
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.println(�������.layerOrder(root1, list1));
    }

    /**
     * @param root
     * @return
     * @Description��ʹ��ǰ��������ڵ�Ŀ�������#��ʾ���ڵ�֮����','�ָ�
     */
    public static String Serialize(TreeNode root) {
        StringBuffer str = new StringBuffer();
        if (root == null) {
            return str.append("#,").toString();
        }

        str.append(root.getValue() + ",");
        str.append(Serialize(root.getLeft()));
        str.append(Serialize(root.getRight()));

        return str.toString();
    }

    public static TreeNode Deserialize(String str) {
        index = -1;
        return Deserialize(str.split(","));
    }

    public static TreeNode Deserialize(String[] str) {
        index++;
        if (index >= str.length) {
            return null;
        }

        TreeNode node = null;
        if (!str[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(str[index]));
            node.setLeft(Deserialize(str));
            node.setRight(Deserialize(str));
        }

        return node;
    }

}
