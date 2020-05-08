package basic_class_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @Description: 有向无环图的拓扑排序：每一条有向边(u, v)，均有u（在排序记录中）比v先出现。亦可理解为对某点v而言，只有当v的所有源点均出现了，v才能出现。
 *
 * @author： zxt
 *
 * @time: 2018年11月27日 下午3:47:18
 *
 */
public class Code_03_TopologySort {

	// directed graph and no loop
	/**
	 * 
	 * @Description：
	 * 找出图中0入度的顶点；
	 * 依次在图中删除这些顶点，删除后再找出0入度的顶点；
	 * 然后再删除……再找出……
	 * 直至删除所有顶点，即完成拓扑排序
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
