package com.zxt.jianzhi;

import java.util.Scanner;

/**
 * 
 * @Description: ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ���
 *
 * @author�� zxt
 *
 * @time: 2018��10��5�� ����5:12:20
 *
 */
public class N�����ӵĵ��� {
	private static Scanner scanner;
	// ���ӵĵ���
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
		
		// ��һ��Ͷ�����ӵ�ʱ����6�ֿ��ܣ�ÿ�ֿ��ܳ���һ��
		for(int i = 1; i <= maxValue; i++) {
			pProbability[flag][i] = 1;
		}
		
		/**
		 * �ӵڶ��ο�ʼ�����ӣ������һ�������еĵ�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ�����
		 * ����һѭ���У����Ǽ���һ�������ӣ���ʱ��Ϊn�����ӳ��ִ���Ӧ�õ�����һ��ѭ�������ӵ�����Ϊn-1,n-2,n-3,n-4n-5,n-6�Ĵ����ܺͣ�
		 * �������ǰ���һ������ĵ�n��������Ϊǰһ�������Ӧ��n-1,n-2,n-3,n-4n-5,n-6֮��
		 */
		for(int k = 2; k <= number; k++) {
			// ��k�������ӣ�����СΪk��С��k������ǲ����ܷ����ģ����������ܷ����Ĵ�������Ϊ0��
			for(int i = 0; i < k; i++) {
				pProbability[1 - flag][i] = 0;
			}
			// ��k�������ӣ�����СΪk�����ΪmaxValue*k
			for(int i = k; i <= maxValue * k; i++) {
				pProbability[1 - flag][i] = 0;
				for(int j = 1; j <= i && j <= maxValue; j++) {
					pProbability[1 - flag][i] += pProbability[flag][i - j];
				}
			}
			
			flag = 1 - flag;
		}
		
		// number�����ӣ����ֵ��������ֵ�����ܹ���maxValue^number��
		double total = Math.pow(maxValue, number);
		for(int i = number; i <= maxValue * number; i++) {
			double ratio = pProbability[flag][i] / total;
			System.out.printf("���ӵ���֮�ͣ�%d�����ʣ�%f\n", i, ratio);
		}
	}
}
