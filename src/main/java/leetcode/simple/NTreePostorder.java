package leetcode.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class NTreePostorder {

    public List<Integer> postorder(Node root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }

        Stack<Node> resultStack = new Stack();
        Stack<Node> pointStack = new Stack();
        pointStack.add(root);
        while (!pointStack.isEmpty()) {
            Node pNode = pointStack.pop();
            resultStack.add(pNode);
            if (pNode.children != null) {
                for (Node node : pNode.children) {
                    pointStack.add(node);
                }
            }
        }

        while (!resultStack.isEmpty()) {
            nodes.add(resultStack.pop().val);
        }

        return nodes;
    }

    // 减少一个栈的使用
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> nodes = new LinkedList<>();
        if (root == null) {
            return nodes;
        }

        Deque<Node> resultStack = new ArrayDeque<>();
        resultStack.addLast(root);
        while (!resultStack.isEmpty()) {
            Node pNode = resultStack.removeLast();
            nodes.addFirst(pNode.val);
            if (pNode.children != null) {
                for (Node node : pNode.children) {
                    resultStack.addLast(node);
                }
            }
        }

        return nodes;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
