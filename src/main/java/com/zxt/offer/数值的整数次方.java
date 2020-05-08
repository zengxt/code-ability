package com.zxt.offer;

/**
 * 
 * @Description: �ڲ�ʹ�ÿ⺯��������£�ʵ����һ����ֵ�������η����ص���Ҫ����baseΪ0���Լ�ָ��Ϊ���������
 *
 * @author�� zxt
 *
 * @time: 2018��5��7�� ����3:09:58
 *
 */
public class ��ֵ�������η� {

	public static void main(String[] args) {
		double base = -2;
		int exponent = -3;
		
		System.out.println(myPow(base, exponent));
		System.out.println(power(base, exponent));
	}
	
	public static double myPow(double base, int exponent) {
		// ׼ȷ��˵�����������ж��Ƿ���ȣ�Ӧ���ü���
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
	 * @Description:ʹ�ù�ʽ���㣬���Ч�ʣ�aΪż����a^n = a^(n/2) * a^(n/2)��aΪ������a^n = a^((n-1)/2) * a^((n-1)/2) * a
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
		
		// exponent >> 1��������λ����exponent / 2
		double result = powerWithExponent(base, exponent >> 1);
		result *= result;
		// �ж�exponent�Ƿ�Ϊż�������������һλΪ1����Ϊ������
		if((exponent & 1) == 1) {
			result *= base;
		}
		
		return result;
	}

}
