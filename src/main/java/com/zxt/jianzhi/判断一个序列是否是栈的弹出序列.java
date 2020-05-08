package com.zxt.jianzhi;

import java.util.Stack;

/**
 * 
 * @Description: 给定两个整数序列，第一个表示栈的压入顺序，判断第二个序列是否为该栈的弹出顺序
 *
 * @author： zxt
 *
 * @time: 2018年6月20日 下午3:50:22
 *
 */
public class 判断一个序列是否是栈的弹出序列 {

	public static void main(String[] args) {
		// 入栈顺序
		int[] sequence1 = { 1, 2, 3, 4, 5 };
		// 判断是否为出栈顺序
		int[] sequence2 = { 4, 5, 3, 2, 1 };

		System.out.println(isStackSequence(sequence1, sequence2));
		
		// 判断是否为出栈顺序
		int[] sequence3 = { 4, 3, 5, 1, 2 };
		System.out.println(isStackSequence(sequence1, sequence3));
	}

	/**
	 * 
	 * @Description:TODO
	 * 
	 * @param sequence1：入栈顺序
	 * @param sequence2：判断是否为出栈顺序
	 * @return
	 */
	public static boolean isStackSequence(int[] sequence1, int[] sequence2) {
		// 使用一个辅助栈
		Stack<Integer> stack = new Stack<Integer>();

		int indexSequence2 = 0;
		// 判断需要判断的序列中的每个元素
		for (int indexSequence1 = 0; indexSequence1 < sequence1.length; indexSequence1++) {
			stack.push(sequence1[indexSequence1]);
			
			while (!stack.isEmpty() && stack.peek() == sequence2[indexSequence2]) {
				stack.pop();
				indexSequence2++;
			}
		}

		return stack.isEmpty();
	}

}
