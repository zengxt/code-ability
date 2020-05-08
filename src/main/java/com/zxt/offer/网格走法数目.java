package com.zxt.offer;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述:有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 *               请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 * 
 *               输入描述:输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
 * 
 *               输出描述:输出包括一行，为走法的数目。
 *
 * 				@author： zxt
 *
 * @time: 2018年4月24日 下午4:38:57
 *
 */
public class 网格走法数目 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			int[][] f = new int[x + 1][y + 1];
			for(int i = 0; i <= x; i++) {
				f[i][0] = 1;
			}
			for(int j = 0; j <= y; j++) {
				f[0][j] = 1;
			}
			for(int i = 1; i <= x; i++) {
				for(int j = 1; j <= y; j++) {
					f[i][j] = f[i - 1][j] + f[i][j - 1];
				}
			}
			
			System.out.println(f[x][y]);
		}
	}
}
