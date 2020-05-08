package com.zxt.jianzhi.移位;

/**
 * 
 * @Description: 在不使用中间变量的情况下完成两数值的交换工作
 *
 * @author： zxt
 *
 * @time: 2018年3月5日 下午10:32:51
 *
 */
public class SwapOperate {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		System.out.println("a = " + a + ", b = " + b);
		
		// 方法一：使用加法
		a = a + b; // 此时a为a和b的和
		b = a - b; // sum(a, b) - b
		a = a - b;
		System.out.println("a = " + a + ", b = " + b);
		
		
		int num1 = 12;
		int num2 = 44;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		// 方法二：使用异或操作
		// 异或操作：相同的为0， 不同的为1
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
	}
}
