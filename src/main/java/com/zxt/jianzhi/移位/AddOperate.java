package com.zxt.jianzhi.移位;

import java.math.BigInteger;

/**
 * 
 * @Description: 写一个函数，求两个整数之和，要求在函数体内不得使用 +、 -、 *、 / 四则运算符号。
 *
 * @author： zxt
 *
 * @time: 2018年3月5日 下午10:31:46
 *
 */
public class AddOperate {
	
	public static void main(String[] args) {
		int a = 5;
		int b = 17;
		
		System.out.println(myAdd(a, b));
		System.out.println(my_add(a, b));
	}
	
	public static int myAdd(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		
		do {
			// 抑或运算，相同为0，不同为1，  即不进位的二进制加法
			sum = num1 ^ num2;
			// 再计算进位，只有1和1，为10，有进位，其他都没有进位
			carry = (num1 & num2) << 1;
			
			// 将不进位加法与进位结果相加即为最终和，由于不能使用+，所以又重复使用上述的方法，直到没有进位时，sum即两数之和
			num1 = sum;
			num2 = carry;
			
		} while(num2 != 0);
		
		return sum;
		
		// return num2 ? Add(num1^num2, (num1&num2)<<1) : num1;
    }
	
	/**
	 * 使用BigInteger
	 */
	public static int my_add(int num1, int num2) {
		BigInteger b1 = new BigInteger(String.valueOf(num1));
		BigInteger b2 = new BigInteger(String.valueOf(num2));
		
		return b1.add(b2).intValue();
	}
}
