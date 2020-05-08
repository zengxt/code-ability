package com.zxt.offer;

import java.util.Scanner;

/**
 * 
 * @Description: 输入n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印1,2,3...999。这里考察的重点是n的范围不限制，所以需要考虑大整数
 *
 * @author： zxt
 *
 * @time: 2018年5月7日 下午4:42:06
 *
 */
public class 打印1到最大的n位数 {

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
	 * @Description:第一种思路：使用n长度的字符，在字符串上模拟整数加1，需要判断 999...99 加1的溢出
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

		// 加1 输出
		while (true) {
			// 是否溢出
			boolean isOverflow = false;
			// 进位
			int nTakeOver = 0;

			// 末尾需要加1，每一位都需要加上进位，若第一位也进位，则表示溢出，不再循环
			for (int i = number.length - 1; i >= 0; i--) {
				int nSum = number[i] - '0' + nTakeOver;
				if (i == number.length - 1) {
					nSum++;
				}

				if (nSum >= 10) {
					// 第一位加上进位大于10，则溢出
					if (i == 0) {
						isOverflow = true;
					} else {
						nSum -= 10;
						nTakeOver = 1;
						number[i] = (char) ('0' + nSum);
					}

				} else {
					number[i] = (char) ('0' + nSum);
					// 实际上每次都只给最低位加1，只有有进位时才给其他位加进位，否则退出循环重新给低位加1
					break;
				}
			}

			if (isOverflow) {
				break;
			}
			
			// 输出
			printNumber(number);
		}
	}

	/**
	 * 
	 * @Description:打印 char[] 字符 数组所代表的整数（数组开头的0不打印）
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
	 * @Description:第二种思路：使用排列的方式，n位数每一位都从0-9，前面为0，恰好表示位数小于n的情况
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
		
		// 或者
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
