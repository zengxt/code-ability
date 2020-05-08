package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述：输入n个整数，输出出现次数大于等于数组长度一半的数。
 * 
 * 输入描述:每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 * 输出描述:输出出现次数大于等于n/2的数。
 * 
 * 示例1
 * 输入
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * 输出
 * 3
 *
 * @author： zxt
 *
 * @time: 2018年7月25日 下午8:44:22
 *
 */
public class N个数里出现次数大于等于一半的数 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String[] str = scanner.nextLine().split(" ");
			int[] array = new int[str.length];
			for(int i = 0; i < str.length; i++) {
				array[i] = Integer.valueOf(str[i]);
			}
			
			// 由于有一个数的出现次数大于等于2/n，所以它出现的次数比其他所有数出现的次数更多（或相等）
			int result = array[0];
			int times = 1;
			for(int i = 1; i < array.length; i++) {
				if(times == 0) {
					result = array[i];
					times = 1;
					
				} else if (array[i] == result) {
					times++;
					
				} else {
					times--;
				}
			}
			
			// 输入需要保证存在这么一个数，因此不再判断了
			System.out.println(result);
		}
	}

}
