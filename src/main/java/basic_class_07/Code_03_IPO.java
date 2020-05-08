package basic_class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @Description: ���룺 ����1����������costs������2����������profits������3������k������4������m
 * costs[i]��ʾi����Ŀ�Ļ��ѣ�profits[i]��ʾi����Ŀ�ڿ۳�����֮����������Ǯ(����)��k��ʾ�㲻�ܲ��С�ֻ�ܴ��е������k����Ŀ��w��ʾ���ʼ���ʽ�
 * 
 * ˵������ÿ����һ����Ŀ�����ϻ�õ����棬����֧����ȥ����һ�� ��Ŀ��
 * ����� ������õ����Ǯ����
 *
 * @author�� zxt
 *
 * @time: 2018��11��20�� ����8:07:51
 *
 */
public class Code_03_IPO {
	
	public static class Node {
		public int p;  // ����
		public int c;  // ����

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	/**
	 * 
	 * @Description: ��������С����
	 *
	 * @author�� zxt
	 *
	 * @time: 2018��11��20�� ����8:15:18
	 *
	 */
	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}

	/**
	 * 
	 * @Description: �������������
	 *
	 * @author�� zxt
	 *
	 * @time: 2018��11��20�� ����8:15:40
	 *
	 */
	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}

		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		for (int i = 0; i < nodes.length; i++) {
			minCostQ.add(nodes[i]);
		}
		
		for (int i = 0; i < k; i++) {
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			if (maxProfitQ.isEmpty()) {
				return W;
			}
			W += maxProfitQ.poll().p;
		}
		
		return W;
	}
}
