package basic_class_06;

import java.util.HashSet;
import java.util.Stack;

/**
 * 
 * @Description: ������ȱ���
 *
 * @author�� zxt
 *
 * @time: 2018��11��27�� ����3:52:47
 *
 */
public class Code_02_DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}

}
