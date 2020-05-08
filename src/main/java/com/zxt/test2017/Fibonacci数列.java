package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ������Fibonacci��������������ģ�
 * F[0] = 0
 * F[1] = 1
 * for each i �� 2: F[i] = F[i-1] + F[i-2]
 * ��ˣ�Fibonacci���о����磺0, 1, 1, 2, 3, 5, 8, 13, ...����Fibonacci�����е������ǳ�ΪFibonacci����
 * ����һ��N�����������Ϊһ��Fibonacci����ÿһ������԰ѵ�ǰ����X��ΪX-1����X+1�����ڸ���һ����N��������Ҫ���ٲ����Ա�ΪFibonacci����
 * 
 * ��������:����Ϊһ��������N(1 �� N �� 1,000,000)
 * �������:���һ����С�Ĳ�����ΪFibonacci��"
 * 
 * ʾ��1
 * ����
 * 15
 * ���
 * 2
 *
 * @author�� zxt
 *
 * @time: 2018��7��25�� ����2:11:24
 *
 */
public class Fibonacci���� {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			
			int currentTimes = 0;
			int preTimes = n;
			
			int f0 = 0;
			int f1 = 1;
			currentTimes = Math.abs(n - f0);
			// �ܻ���һ��Fibonacci����������������n�������ԽԶ���Fibonacci����������������Ҳ��Ӧ����nԽԶ
			while(preTimes >= currentTimes) {
				preTimes = currentTimes;
				
				int temp = f1;
				f1 = f1 + f0;
				f0 = temp;
				
				currentTimes = Math.abs(n - f0);
			}
			
			System.out.println(preTimes);
		}
	}

}
