package com.zxt.offer;

/**
 * 
 * @Description: 在不使用库函数的情况下，实现求一个数值的整数次方（重点需要考虑base为0，以及指数为负的情况）
 *
 * @author： zxt
 *
 * @time: 2018年5月7日 下午3:09:58
 *
 */
public class 数值的整数次方 {

	public static void main(String[] args) {
		double base = -2;
		int exponent = -3;
		
		System.out.println(myPow(base, exponent));
		System.out.println(power(base, exponent));
	}
	
	public static double myPow(double base, int exponent) {
		// 准确来说，浮点类型判断是否相等，应该用减法
		if(base == 0) {
			return 0;
		}
		
		double result = 1;
		for(int i = 0; i < Math.abs(exponent); i++) {
			result *= base;
		}
		
		if(exponent < 0) {
			result = 1 / result;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @Description:使用公式结算，提高效率：a为偶数：a^n = a^(n/2) * a^(n/2)；a为奇数：a^n = a^((n-1)/2) * a^((n-1)/2) * a
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double power(double base, int exponent) {
		if(base == 0) {
			return 0;
		}
		
		double result = powerWithExponent(base, Math.abs(exponent));
		if(exponent < 0) {
			result = 1 / result;
		}
		
		return result;
	}
	
	public static double powerWithExponent(double base, int exponent) {
		if(exponent == 0) {
			return 1;
		}
		if(exponent == 1) {
			return base;
		}
		
		// exponent >> 1：右移两位即：exponent / 2
		double result = powerWithExponent(base, exponent >> 1);
		result *= result;
		// 判断exponent是否为偶数（二进制最后一位为1，即为奇数）
		if((exponent & 1) == 1) {
			result *= base;
		}
		
		return result;
	}

}
