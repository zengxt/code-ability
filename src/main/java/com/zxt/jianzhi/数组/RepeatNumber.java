package com.zxt.jianzhi.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * @author： zxt
 *
 * @time: 2018年3月4日 下午5:41:46
 *
 */
public class RepeatNumber {

	public static void main(String[] args) {
		int[] arr = {2,3,1,0,2,5,3};
		
		System.out.println(repeatNumbers(arr));
		
		int[] duplication = new int[arr.length];
		System.out.println(duplicate(arr, duplication));
		System.out.println(Arrays.toString(duplication));
	}
	
	/**
	 * 方法一：使用Map，用数组的值作为key值，然后记录数组中每个数字的出现次数，则可以判断是否重复
	 */
	public static ArrayList<Integer> repeatNumbers(int[] arr) {
		if(arr == null) {
			return null;
		}
		
		// 判断边界，防止错误
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0 || arr[i] > arr.length - 1) {
				return null;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i < arr.length; i++) {
			Integer value = map.get(arr[i]);
			if(value == null) {
				value = 0;
			} else {
				list.add(arr[i]);
			}
			map.put(arr[i], value + 1);
		}
		
		return list;
	}
	
	/**
	 * 方法二：由于这里规定了数组中的数都在0到n-1的范围内，所以若数组中没有重复，则排序后数组下标和值始终相等
	 * 则可以从头扫描数组中的每个数字，假设下标为i的数值为m，若m == i，则下一个，
	 * 若下标与数值不相等，则判断下标m对应的数值是否与m相等，不等则交换，否则表示重复了，因为下标为i与m位置对应的都是m
	 */
	public static boolean duplicate(int[] numbers, int[] duplication) {
		if(numbers == null) {
			return false;
		}
		
		int index = 0;
		for(int i = 0; i < numbers.length; i++) {
			// 下标与对应值不等
			while(numbers[i] != i) {
				// i 与 numbers[i] 位置的值重复
				if(numbers[i] == numbers[numbers[i]]) {
					duplication[index++] = numbers[i];
					return true;
				}
				
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		
		return false;
    }
}