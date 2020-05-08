package basic_class_06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @Description: ������ȱ���
 *
 * @author�� zxt
 *
 * @time: 2018��11��27�� ����3:53:04
 *
 */
public class Code_01_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}

}
