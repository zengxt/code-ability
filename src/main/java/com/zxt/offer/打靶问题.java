package com.zxt.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @Description: һ������˶�Ա��У���һ����10��������10 ǹ����90���Ŀ������ж��٣�
 *               ˼·��������˼·���ַ�������Ϻ����õݹ�����һ�������11�ֿ��ܣ�����1����10�������Ѱ�(0)��
 *
 * @author�� zxt
 *
 * @time: 2018��5��3�� ����5:27:26
 *
 */
public class ������� {

	// ������¼������������ϵ�ÿ�δ����  ArrayList<Integer>����¼����Ҫ���һ�����
	// LinkedList ��ɾ�������Ӳ�����Ч�ʱ�  ArrayList ��
	private static ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
	
	public static int count = 0;
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		countResult(3, 20, list);
		System.out.println(count);
		
		System.out.println(result);
	}
	
	/**
	 * 
	 * @Description:ÿһ�δ�����õķ���������11�п��ܼ���0-11
	 * 
	 * @param number���ܹ���д���
	 * @param sum����Ҫ���еĻ���
	 * @param list����ǰ���δ�е����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static void countResult(int number, int sum, LinkedList<Integer> list) {
		// number * 10 < sum   ���Թ��˵�һ������������
		if(sum < 0 || number * 10 < sum) {
			return ;
		}
		
		// ���һǹ
		if(number == 1) {
			// ���ʣ�໷��С��10��ֻҪ���һǹ��sum���Ϳ�����
			if(sum <= 10) {
				count++;
				
				// ����˳���ÿ�δ�л��������Ҳ��¼����
				list.add(sum);
				// �����list��һ�����ã�����һֱ���޸�,�����ں�������֮��result����Ԫ�أ������ǿյ�
				// result.add(list);
				
				// �������һ����ǰlist�Ŀ������Ϳ��԰�����������
				result.add((LinkedList<Integer>)list.clone());
				list.removeLast();
			}
			return ;
		}
		
		// ÿ�δ�п������еĻ���  0��10
		for(int i = 0; i <= 10; i++) {
			list.add(i);
			// ʣ���д���
			countResult(number - 1, sum - i, list);
			list.removeLast();
		}
	}
}
