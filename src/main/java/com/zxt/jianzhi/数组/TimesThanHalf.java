package com.zxt.jianzhi.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *               例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author： zxt
 *
 * @time: 2018年3月13日 上午9:23:29
 *
 */
public class TimesThanHalf {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(moreThanHalfNum_Solution(array));
		
		System.out.println(moreThanHalfNum(array));
	}

	
	public static int moreThanHalfNum_Solution(int[] array) {
		// 边界条件判断
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

		// 当没有超过半数的那个数值出现，则需要返回0
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
