package com.zxt.jianzhi;

import java.util.Scanner;

/**
 * 
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @author： zxt
 *
 * @time: 2018年3月5日 下午4:33:12
 *
 */
public class Sum1ToN {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sum_solution(n));
		
		// Java对象数组只是创建了数组对象的引用，具体的对象还没有创建，所以无法使用这个方法
		// Temp[] a = new Temp[n];
		
		// int[] sum = new int[1];
		// System.out.println(sum(n, sum)[0]);
		
		// 这里直接使用公式法，避免使用乘除
		System.out.println((int)(Math.pow(n, 2) + n ) >> 1);
	}
	
	/**
	 * 使用逻辑与的短路操作，结合递归操作
	 */
	public static int[] sum(int n, int[] sum) {
		@SuppressWarnings("unused")
		boolean f = (0 < n) && sum(n-1, sum).length > 0;
		sum[0] = sum[0] + n;
		return sum;
	}
	
	public static int sum_solution(int n) {
		int sum = n;
		@SuppressWarnings("unused")
		// 逻辑与运算， 当前部分为假时，不会判断后部分的条件（短路）
		boolean t = (n != 0) && (sum += sum_solution(n - 1)) != 0;
		return sum;
	}

}

class Temp {
	public static int sum = 0;
	public static int n = 0;
	
	public Temp() {
		n++;
		sum += n;
		System.out.println("ddd");
	}
}
