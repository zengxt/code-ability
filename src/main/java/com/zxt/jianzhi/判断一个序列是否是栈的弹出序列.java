package com.zxt.jianzhi;

import java.util.Stack;

/**
 * 
 * @Description: ���������������У���һ����ʾջ��ѹ��˳���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 *
 * @author�� zxt
 *
 * @time: 2018��6��20�� ����3:50:22
 *
 */
public class �ж�һ�������Ƿ���ջ�ĵ������� {

	public static void main(String[] args) {
		// ��ջ˳��
		int[] sequence1 = { 1, 2, 3, 4, 5 };
		// �ж��Ƿ�Ϊ��ջ˳��
		int[] sequence2 = { 4, 5, 3, 2, 1 };

		System.out.println(isStackSequence(sequence1, sequence2));
		
		// �ж��Ƿ�Ϊ��ջ˳��
		int[] sequence3 = { 4, 3, 5, 1, 2 };
		System.out.println(isStackSequence(sequence1, sequence3));
	}

	/**
	 * 
	 * @Description:TODO
	 * 
	 * @param sequence1����ջ˳��
	 * @param sequence2���ж��Ƿ�Ϊ��ջ˳��
	 * @return
	 */
	public static boolean isStackSequence(int[] sequence1, int[] sequence2) {
		// ʹ��һ������ջ
		Stack<Integer> stack = new Stack<Integer>();

		int indexSequence2 = 0;
		// �ж���Ҫ�жϵ������е�ÿ��Ԫ��
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
