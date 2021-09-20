package leetcode.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ����һ�� N ������������ڵ�ֵ�� ������� ��
 * <p>
 * N ���� �������а���������������л���ʾ��ÿ���ӽڵ��ɿ�ֵ null �ָ�����μ�ʾ������
 * <p>
 * ���ף�
 * �ݹ鷨�ܼ򵥣������ʹ�õ�������ɴ�����?
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

    // ����һ��ջ��ʹ��
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
