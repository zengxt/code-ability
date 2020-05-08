package com.zxt.offer;

import java.util.Scanner;

/**
 * 
 * @Description: ����n����˳���ӡ����1������nλʮ����������������3�����ӡ1,2,3...999�����￼����ص���n�ķ�Χ�����ƣ�������Ҫ���Ǵ�����
 *
 * @author�� zxt
 *
 * @time: 2018��5��7�� ����4:42:06
 *
 */
public class ��ӡ1������nλ�� {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int n = scanner.nextInt();

			print1ToMaxOfNDigits(n);
			System.out.println("------------------------------");
			print1ToMaxOfNDigits2(n);
		}
	}

	/**
	 * 
	 * @Description:��һ��˼·��ʹ��n���ȵ��ַ������ַ�����ģ��������1����Ҫ�ж� 999...99 ��1�����
	 * 
	 * @param n
	 */
	public static void print1ToMaxOfNDigits(int n) {
		if (n <= 0) {
			return;
		}

		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}

		// ��1 ���
		while (true) {
			// �Ƿ����
			boolean isOverflow = false;
			// ��λ
			int nTakeOver = 0;

			// ĩβ��Ҫ��1��ÿһλ����Ҫ���Ͻ�λ������һλҲ��λ�����ʾ���������ѭ��
			for (int i = number.length - 1; i >= 0; i--) {
				int nSum = number[i] - '0' + nTakeOver;
				if (i == number.length - 1) {
					nSum++;
				}

				if (nSum >= 10) {
					// ��һλ���Ͻ�λ����10�������
					if (i == 0) {
						isOverflow = true;
					} else {
						nSum -= 10;
						nTakeOver = 1;
						number[i] = (char) ('0' + nSum);
					}

				} else {
					number[i] = (char) ('0' + nSum);
					// ʵ����ÿ�ζ�ֻ�����λ��1��ֻ���н�λʱ�Ÿ�����λ�ӽ�λ�������˳�ѭ�����¸���λ��1
					break;
				}
			}

			if (isOverflow) {
				break;
			}
			
			// ���
			printNumber(number);
		}
	}

	/**
	 * 
	 * @Description:��ӡ char[] �ַ� ��������������������鿪ͷ��0����ӡ��
	 * 
	 * @param number
	 */
	public static void printNumber(char[] number) {
		boolean isBeginning0 = true;

		for (int i = 0; i < number.length; i++) {
			if (isBeginning0 && number[i] != '0') {
				isBeginning0 = false;
			}

			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}

		System.out.println();
	}
	
	/**
	 * 
	 * @Description:�ڶ���˼·��ʹ�����еķ�ʽ��nλ��ÿһλ����0-9��ǰ��Ϊ0��ǡ�ñ�ʾλ��С��n�����
	 * 
	 * @param n
	 */
	public static void print1ToMaxOfNDigits2(int n) {
		if (n <= 0) {
			return;
		}

		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		
		// ����
		print1ToMaxNDigitsRecurisvely2(number, 0);
	}
	
	public static void print1ToMaxNDigitsRecurisvely2(char[] number, int index) {
		if(index == number.length) {
			printNumber(number);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			number[index] = (char) (i +'0');
			print1ToMaxNDigitsRecurisvely2(number, index + 1);
		}
	}
}
