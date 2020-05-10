package binary.tree;

/**
 * @Description: 定义二叉树节点
 * @author： zxt
 * @time: 2018年6月2日 下午4:24:30
 */
public class TreeNode {
    // 数据域
    private int value;
    // 左节点
    private TreeNode left;
    // 右节点
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // 新建一个二叉查找树
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


    // 向二叉树中新增一个节点（按排序的方式）二叉查找树
    public void add(int value) {
        // 新增节点值大于根节点（插入到右子树）
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
