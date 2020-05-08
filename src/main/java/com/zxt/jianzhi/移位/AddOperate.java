package com.zxt.jianzhi.��λ;

import java.math.BigInteger;

/**
 * 
 * @Description: дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ�� +�� -�� *�� / ����������š�
 *
 * @author�� zxt
 *
 * @time: 2018��3��5�� ����10:31:46
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
			// �ֻ����㣬��ͬΪ0����ͬΪ1��  ������λ�Ķ����Ƽӷ�
			sum = num1 ^ num2;
			// �ټ����λ��ֻ��1��1��Ϊ10���н�λ��������û�н�λ
			carry = (num1 & num2) << 1;
			
			// ������λ�ӷ����λ�����Ӽ�Ϊ���պͣ����ڲ���ʹ��+���������ظ�ʹ�������ķ�����ֱ��û�н�λʱ��sum������֮��
			num1 = sum;
			num2 = carry;
			
		} while(num2 != 0);
		
		return sum;
		
		// return num2 ? Add(num1^num2, (num1&num2)<<1) : num1;
    }
	
	/**
	 * ʹ��BigInteger
	 */
	public static int my_add(int num1, int num2) {
		BigInteger b1 = new BigInteger(String.valueOf(num1));
		BigInteger b2 = new BigInteger(String.valueOf(num2));
		
		return b1.add(b2).intValue();
	}
}
