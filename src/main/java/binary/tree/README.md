# 二叉树的相关问题

参考CSDN博客：[数据结构之树（基本概念与二叉树的遍历）](https://blog.csdn.net/zengxiantao1994/article/details/80689139?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522158910357919724843327466%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=158910357919724843327466&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_v2~rank_v25-1-80689139.nonecase&utm_term=%E4%BA%8C%E5%8F%89%E6%A0%91)



## 二叉树的遍历

前序遍历：先访问根节点，再前序遍历左子树，前序遍历右子树

```java
public static List<Integer> preOrder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pnode = root;

    List<Integer> list = new ArrayList<>();
    while (pnode != null || !stack.isEmpty()) {
        if (pnode != null) {
            // 先访问再入栈
            list.add(pnode.getValue());
            stack.push(pnode);
            pnode = pnode.getLeft();
        } else {
            pnode = stack.pop();
            pnode = pnode.getRight();
        }
    }

    return list;
}
```



中序遍历：先中序遍历左子树，访问根节点，再中序遍历右子树

```java
public static List<Integer> inOrder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pnode = root;

    List<Integer> list = new ArrayList<>();
    while (pnode != null || !stack.isEmpty()) {
        if (pnode != null) {
            // 先入栈
            stack.push(pnode);
            pnode = pnode.getLeft();
        } else {
            pnode = stack.pop();
            // 访问
            list.add(pnode.getValue());
            pnode = pnode.getRight();
        }
    }

    return list;
}
```

和上面的前序遍历是一个套路，只不过注意一下访问根节点的顺序就好了。

还有一个很重要的点：二叉搜索树的中序遍历序列是一个递增的序列，这个性质很有帮助。例如：[LeetCode 538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)，二叉搜索树的中序遍历是递增序列，那中序遍历反过来就是递减序列，并把结点值累加到前面的结点上就可以了。



后续遍历：先后续遍历左子树，再后续遍历右子树，最后遍历根节点。和前两种不一样，由于需要先遍历完左右子树才遍历根节点，因此需要先把根节点记录下来，遍历完左右子树然后再访问。

```java
public static List<Integer> postOrder2(TreeNode root) {
    if (root == null) {
        return null;
    }

    List<Integer> list = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    TreeNode pnode = root;
    // 一个用来记录上一次访问的节点（只有当一个节点的右子树为空，或者右子树上一次已经访问，才访问自己）
    TreeNode pre = null;

    while (pnode != null || !stack.isEmpty()) {
        // 左子树入栈
        while (pnode != null) {
            stack.push(pnode);
            pnode = pnode.getLeft();
        }

        if (!stack.isEmpty()) {
            TreeNode temp = stack.peek().getRight();
            if (temp == null || temp == pre) {
                // 右子树为空，或者已经访问过
                pnode = stack.pop();
                list.add(pnode.getValue());

                // 记录上一次访问的节点
                pre = pnode;
                // 当前结点访问完了，应该从栈里面重新取
                pnode = null;
            } else {
                pnode = temp;
            }
        }
    }

    return list;
}
```

另一种遍历方法是双栈法，就是把前序遍历的序列反过来就是后续遍历了。