package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述：有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 *               要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * 
 *               输入描述：每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
 *               接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
 *               接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 *
 * @author： zxt
 *
 * @time: 2018年7月18日 下午7:55:36
 *
 */
public class 合唱团 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] valueStr = scanner.nextLine().split(" ");
		String[] paramStr = scanner.nextLine().split(" ");

		int[] value = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = Integer.valueOf(valueStr[i]);
		}
		int k = Integer.valueOf(paramStr[0]);
		int d = Integer.valueOf(paramStr[1]);

		System.out.println(getMaxMultiValue(value, n, k, d));
	}

	/**
	 * 
	 * @Description：递推的时候，以f[one][k]的形式表示 其中：one表示最后一个人的位置，k为包括这个人，一共有k个人
	 * 原问题和子问题的关系：f[one][k]=max{f[left][k-1]*arr[one], g[left][k-1]*arr[one]}
	 * 
	 * 其中：max{k-1,one-d} <= left <= one-1
	 * 
	 * @param array
	 * @param n
	 * @param k
	 * @param d
	 * @return
	 */
	public static long getMaxMultiValue(int[] array, int n, int kk, int dd) {
		// 规划数组
		long[][] f = new long[n][kk];
		// 因为能力值可能为负，所以需要记录当前的最小值
		long[][] g = new long[n][kk];
		// 初始化k=1的情况
		for (int one = 0; one < n; one++) {
			f[one][0] = array[one];
			g[one][0] = array[one];
		}

		// 自底向上递推
		for (int k = 1; k < kk; k++) {

			for (int one = k; one < n; one++) {
				// 求解当one和k定的时候，最大的分割点
				long tempmax = Long.MIN_VALUE;
				long tempmin = Long.MAX_VALUE;

				for (int left = Math.max(k - 1, one - dd); left <= one - 1; left++) {
					if (tempmax < Math.max(f[left][k - 1] * array[one], g[left][k - 1] * array[one])) {
						tempmax = Math.max(f[left][k - 1] * array[one], g[left][k - 1] * array[one]);
					}
					if (tempmin > Math.min(f[left][k - 1] * array[one], g[left][k - 1] * array[one])) {
						tempmin = Math.min(f[left][k - 1] * array[one], g[left][k - 1] * array[one]);
					}
				}

				f[one][k] = tempmax;
				g[one][k] = tempmin;
			}
		}

		// n选k最大的需要从最后一个最大的位置选
		long result = Long.MIN_VALUE;
		for (int one = kk - 1; one < n; one++) {
			if (result < f[one][kk - 1]) {
				result = f[one][kk - 1];
			}
		}

		return result;
	}

}
