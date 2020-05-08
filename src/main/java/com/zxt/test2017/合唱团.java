package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ�������� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����
 *               Ҫ����������ѧ����λ�ñ�ŵĲ���� d��ʹ���� k ��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
 * 
 *               ����������ÿ��������� 1 ������������ÿ���������ݵĵ�һ�а���һ������ n (1 <= n <= 50)����ʾѧ���ĸ�����
 *               ��������һ�У����� n ����������˳���ʾÿ��ѧ��������ֵ ai��-50 <= ai <= 50����
 *               ��������һ�а�������������k �� d (1 <= k <= 10, 1 <= d <= 50)��
 *
 * @author�� zxt
 *
 * @time: 2018��7��18�� ����7:55:36
 *
 */
public class �ϳ��� {

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
	 * @Description�����Ƶ�ʱ����f[one][k]����ʽ��ʾ ���У�one��ʾ���һ���˵�λ�ã�kΪ��������ˣ�һ����k����
	 * ԭ�����������Ĺ�ϵ��f[one][k]=max{f[left][k-1]*arr[one], g[left][k-1]*arr[one]}
	 * 
	 * ���У�max{k-1,one-d} <= left <= one-1
	 * 
	 * @param array
	 * @param n
	 * @param k
	 * @param d
	 * @return
	 */
	public static long getMaxMultiValue(int[] array, int n, int kk, int dd) {
		// �滮����
		long[][] f = new long[n][kk];
		// ��Ϊ����ֵ����Ϊ����������Ҫ��¼��ǰ����Сֵ
		long[][] g = new long[n][kk];
		// ��ʼ��k=1�����
		for (int one = 0; one < n; one++) {
			f[one][0] = array[one];
			g[one][0] = array[one];
		}

		// �Ե����ϵ���
		for (int k = 1; k < kk; k++) {

			for (int one = k; one < n; one++) {
				// ��⵱one��k����ʱ�����ķָ��
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

		// nѡk������Ҫ�����һ������λ��ѡ
		long result = Long.MIN_VALUE;
		for (int one = kk - 1; one < n; one++) {
			if (result < f[one][kk - 1]) {
				result = f[one][kk - 1];
			}
		}

		return result;
	}

}
