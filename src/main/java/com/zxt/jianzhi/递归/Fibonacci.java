package com.zxt.jianzhi.�ݹ�;

/**
 * 
 * @Description: ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 *
 * @author�� zxt
 *
 * @time: 2018��4��15�� ����9:06:45
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacciCycle(20));
	}
	
	/**
	 * 
	 * @Description:�ݹ�ⷨ
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
	 * @Description���ǵݹ�ⷨ
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
