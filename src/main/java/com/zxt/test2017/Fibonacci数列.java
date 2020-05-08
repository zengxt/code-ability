package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述：Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。
 * 给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 * 
 * 输入描述:输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 * 输出描述:输出一个最小的步数变为Fibonacci数"
 * 
 * 示例1
 * 输入
 * 15
 * 输出
 * 2
 *
 * @author： zxt
 *
 * @time: 2018年7月25日 下午2:11:24
 *
 */
public class Fibonacci数列 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			
			int currentTimes = 0;
			int preTimes = n;
			
			int f0 = 0;
			int f1 = 1;
			currentTimes = Math.abs(n - f0);
			// 总会有一个Fibonacci数（或者两个）离n最近，而越远离该Fibonacci数的其他数列中数也相应得离n越远
			while(preTimes >= currentTimes) {
				preTimes = currentTimes;
				
				int temp = f1;
				f1 = f1 + f0;
				f0 = temp;
				
				currentTimes = Math.abs(n - f0);
			}
			
			System.out.println(preTimes);
		}
	}

}
