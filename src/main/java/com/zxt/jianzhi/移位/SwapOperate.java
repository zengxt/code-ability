package com.zxt.jianzhi.��λ;

/**
 * 
 * @Description: �ڲ�ʹ���м������������������ֵ�Ľ�������
 *
 * @author�� zxt
 *
 * @time: 2018��3��5�� ����10:32:51
 *
 */
public class SwapOperate {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		System.out.println("a = " + a + ", b = " + b);
		
		// ����һ��ʹ�üӷ�
		a = a + b; // ��ʱaΪa��b�ĺ�
		b = a - b; // sum(a, b) - b
		a = a - b;
		System.out.println("a = " + a + ", b = " + b);
		
		
		int num1 = 12;
		int num2 = 44;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		// ��������ʹ��������
		// ����������ͬ��Ϊ0�� ��ͬ��Ϊ1
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
	}
}
