package com.zxt.jianzhi.����;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 *               ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 *
 * @author�� zxt
 *
 * @time: 2018��3��13�� ����9:23:29
 *
 */
public class TimesThanHalf {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(moreThanHalfNum_Solution(array));
		
		System.out.println(moreThanHalfNum(array));
	}

	
	public static int moreThanHalfNum_Solution(int[] array) {
		// �߽������ж�
		if (array.length == 0) {
			return 0;
		}

		int result = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			Integer value = map.get(array[i]);
			if (value == null) {
				value = 1;
			} else {
				value++;
			}
			
			if (value * 2 > array.length) {
				result = array[i];
				break;
			}
			map.put(array[i], value);
		}

		return result;
	}
	

	public static int moreThanHalfNum(int[] array) {
		if (array.length == 0) {
			return 0;
		}

		int result = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
				
			} else if (array[i] == result) {
				times++;
				
			} else {
				times--;
			}
		}

		// ��û�г����������Ǹ���ֵ���֣�����Ҫ����0
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				temp++;
			}
		}

		if (temp * 2 <= array.length) {
			return 0;
			
		} else {
			return result;
		}
	}
}
