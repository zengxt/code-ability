package com.zxt.jianzhi.数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @Description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author： zxt
 *
 * @time: 2018年3月19日 上午11:27:44
 *
 */
public class 最小的K个数 {

	public static void main(String[] args) {
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(GetLeastNumbers(input, 4));
	}

	/**
	 * 
	 * @Description：找出最小的K个数：使用Collections函数找出ArrayList中的最大值
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
					// remove函数，若参数是一个Object，则删除List中该元素，若参数是一个int，则删除该下标的值
					leastList.remove(maxValue);
					leastList.add(input[i]);
				}
			}
		}

		return leastList;
	}

	/**
	 * 
	 * @Description：找出最小的K个数：用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
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

		// 创建堆
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
