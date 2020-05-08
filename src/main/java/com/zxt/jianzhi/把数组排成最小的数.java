package com.zxt.jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @Description: 输入一个正整数数组，把数组里所有的数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如{3， 32， 321}，则打印出最小组合321323.
 *
 * @author： zxt
 *
 * @time: 2018年7月24日 下午5:12:04
 *
 */
public class 把数组排成最小的数 {
	
	/**
	 * 
	 * @Description：首先一个潜在的问题需要考虑，那就是两个整数组合之后可能无法再用正数（int，溢出）表示，所以要用字符串，这是一个大数问题
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {3, 32, 321};
		
		System.out.println(minNumber(array));
	}
	
	/**
	 * 
	 * @Description：将两个数A和B分别前后组合，即AB，BA，若AB < BA则定于A小于B，打印最小数的时候A需要排在前面
	 * 
	 * @param array
	 * @return
	 */
	public static String minNumber(int[] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		// 自定义排序规则排序
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer integer1, Integer integer2) {
				String str1 = integer1 + "" + integer2;
				String str2 = integer2 + "" + integer1;
				return str1.compareTo(str2);
			}
		});
		
		StringBuffer bf = new StringBuffer();
		for(int i = 0; i < list.size(); i++) {
			bf.append(list.get(i));
		}
		
		return bf.toString();
	}

}
