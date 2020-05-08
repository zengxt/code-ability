package basic_class_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @Description: �����޻�ͼ����������ÿһ�������(u, v)������u���������¼�У���v�ȳ��֡�������Ϊ��ĳ��v���ԣ�ֻ�е�v������Դ��������ˣ�v���ܳ��֡�
 *
 * @author�� zxt
 *
 * @time: 2018��11��27�� ����3:47:18
 *
 */
public class Code_03_TopologySort {

	// directed graph and no loop
	/**
	 * 
	 * @Description��
	 * �ҳ�ͼ��0��ȵĶ��㣻
	 * ������ͼ��ɾ����Щ���㣬ɾ�������ҳ�0��ȵĶ��㣻
	 * Ȼ����ɾ���������ҳ�����
	 * ֱ��ɾ�����ж��㣬�������������
	 * 
	 * @param graph
	 * @return
	 */
	public static List<Node> sortedTopology(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();
		Queue<Node> zeroInQueue = new LinkedList<>();
		for (Node node : graph.nodes.values()) {
			inMap.put(node, node.in);
			if (node.in == 0) {
				zeroInQueue.add(node);
			}
		}
		List<Node> result = new ArrayList<>();
		while (!zeroInQueue.isEmpty()) {
			Node cur = zeroInQueue.poll();
			result.add(cur);
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next) - 1);
				if (inMap.get(next) == 0) {
					zeroInQueue.add(next);
				}
			}
		}
		return result;
	}
}
