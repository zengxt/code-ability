package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述：n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，
 * 每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * 
 * 输入描述：每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 * 输出描述:输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 * 
 * 示例1
 * 输入
 * 4
 * 7 15 9 5
 * 输出
 * 3
 *
 * @author： zxt
 *
 * @time: 2018年7月24日 下午9:39:57
 *
 */
public class 分苹果 {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] array = new int[n];
			int sum = 0;
			for(int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
				sum += array[i];
			}
			
			int result = -1;
			if(sum % n == 0) {
				// 由于最后所有奶牛的苹果数要一样，所以必然存在一个平均数，且每头奶牛的苹果数与均值时间的差值必然是2的倍数才能移动成功
				int avg = sum / n;
				int times = 0;
				int index = 0;
				for(; index < n; index++) {
					if((array[index] - avg) % 2 == 0) {
						times += Math.abs(array[index] - avg);
					} else {
						break;
					}
				}
				
				if(index == array.length) {
					result = times / 4;
				}
			}
			
			System.out.println(result);
		}
	}

}
