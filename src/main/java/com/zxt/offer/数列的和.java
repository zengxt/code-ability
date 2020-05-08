package com.zxt.offer;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述:数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 
 *               输入描述:输入数据有多组，每组占一行，由两个整数n（n < 10000）和m(m < 1000)组成，n和m的含义如前所述。
 * 
 *               输出描述:对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 *
 * @author： zxt
 *
 * @time: 2018年4月24日 下午4:31:30
 *
 */
public class 数列的和 {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			double result = n;
			double temp = n;
			for(int i = 1; i < m; i++) {
				temp = Math.sqrt(temp);
				result += temp;
			}
			
			System.out.printf("%.2f", result);
		}
	}
}
