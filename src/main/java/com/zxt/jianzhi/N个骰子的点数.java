package com.zxt.jianzhi;

import java.util.Scanner;

/**
 * 
 * @Description: 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率
 *
 * @author： zxt
 *
 * @time: 2018年10月5日 下午5:12:20
 *
 */
public class N个骰子的点数 {
	private static Scanner scanner;
	// 骰子的点数
	private static int maxValue = 6;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		printProbability(n);
	}

	public static void printProbability(int number) {
		if(number < 1) {
			return ;
		}
		
		int[][] pProbability = new int[2][maxValue * number + 1];
		int flag = 0;
		
		// 第一次投掷骰子的时候，有6种可能，每种可能出现一次
		for(int i = 1; i <= maxValue; i++) {
			pProbability[flag][i] = 1;
		}
		
		/**
		 * 从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
		 * 在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4n-5,n-6的次数总和，
		 * 所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4n-5,n-6之和
		 */
		for(int k = 2; k <= number; k++) {
			// 第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
			for(int i = 0; i < k; i++) {
				pProbability[1 - flag][i] = 0;
			}
			// 第k次掷骰子，和最小为k，最大为maxValue*k
			for(int i = k; i <= maxValue * k; i++) {
				pProbability[1 - flag][i] = 0;
				for(int j = 1; j <= i && j <= maxValue; j++) {
					pProbability[1 - flag][i] += pProbability[flag][i - j];
				}
			}
			
			flag = 1 - flag;
		}
		
		// number个骰子，出现的所有数字的情况总共有maxValue^number种
		double total = Math.pow(maxValue, number);
		for(int i = number; i <= maxValue * number; i++) {
			double ratio = pProbability[flag][i] / total;
			System.out.printf("骰子点数之和：%d，概率：%f\n", i, ratio);
		}
	}
}
