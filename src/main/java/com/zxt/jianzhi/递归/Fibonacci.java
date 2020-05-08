package com.zxt.jianzhi.递归;

/**
 * 
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *
 * @author： zxt
 *
 * @time: 2018年4月15日 下午9:06:45
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacciCycle(20));
	}
	
	/**
	 * 
	 * @Description:递归解法
	 * 
	 * @param n
	 * @return
	 */
	public long fibonacciRecursive(int n) {
		if(n <= 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
	
	/**
	 * 
	 * @Description：非递归解法
	 * 
	 * @param n
	 * @return
	 */
	public static long fibonacciCycle(int n) {
		long[] temp = {0, 1};
		
		if(n < 2) {
			return temp[n];
		}
		
		long result = 0;
		for(int i = 2; i <= n; i++) {
			result = temp[0] + temp[1];
			
			temp[0] = temp[1];
			temp[1] = result;
		}
		
		return result;
	}
}
