package com.zxt.jianzhi.����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @Description: ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 *
 * @author�� zxt
 *
 * @time: 2018��3��19�� ����11:27:44
 *
 */
public class ��С��K���� {

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(GetLeastNumbers(input, 4));
	}

	/**
	 * 
	 * @Description���ҳ���С��K������ʹ��Collections�����ҳ�ArrayList�е����ֵ
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
		ArrayList<Integer> leastList = new ArrayList<Integer>();

		if (input.length < 0 || k > input.length || k <= 0) {
			return leastList;
		}

		for (int i = 0; i < input.length; i++) {
			if (leastList.size() < k) {
				leastList.add(input[i]);

			} else {
				Integer maxValue = Collections.max(leastList);
				if (maxValue > input[i]) {
					// ArrayList
					// remove��������������һ��Object����ɾ��List�и�Ԫ�أ���������һ��int����ɾ�����±��ֵ
					leastList.remove(maxValue);
					leastList.add(input[i]);
				}
			}
		}

		return leastList;
	}

	/**
	 * 
	 * @Description���ҳ���С��K�����������ѱ�����k������ÿ��ֻ�ͶѶ��ȣ�����ȶѶ�С��ɾ���Ѷ���������ѡ�
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> GetLeastNumbers2(int[] input, int k) {
		ArrayList<Integer> leastList = new ArrayList<Integer>();

		if (input.length < 0 || k > input.length || k <= 0) {
			return leastList;
		}

		// ������
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < input.length; i++) {
			if (maxHeap.size() != k) {
				maxHeap.offer(input[i]);

			} else if (maxHeap.peek() > input[i]) {
				maxHeap.poll();
				maxHeap.offer(input[i]);
			}
		}

		for (Integer integer : maxHeap) {
			leastList.add(integer);
		}

		return leastList;
	}
}
