package com.zxt.jianzhi;

import java.util.Scanner;

/**
 * 
 * @Description: ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 *
 * @author�� zxt
 *
 * @time: 2018��3��5�� ����4:33:12
 *
 */
public class Sum1ToN {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sum_solution(n));
		
		// Java��������ֻ�Ǵ����������������ã�����Ķ���û�д����������޷�ʹ���������
		// Temp[] a = new Temp[n];
		
		// int[] sum = new int[1];
		// System.out.println(sum(n, sum)[0]);
		
		// ����ֱ��ʹ�ù�ʽ��������ʹ�ó˳�
		System.out.println((int)(Math.pow(n, 2) + n ) >> 1);
	}
	
	/**
	 * ʹ���߼���Ķ�·��������ϵݹ����
	 */
	public static int[] sum(int n, int[] sum) {
		@SuppressWarnings("unused")
		boolean f = (0 < n) && sum(n-1, sum).length > 0;
		sum[0] = sum[0] + n;
		return sum;
	}
	
	public static int sum_solution(int n) {
		int sum = n;
		@SuppressWarnings("unused")
		// �߼������㣬 ��ǰ����Ϊ��ʱ�������жϺ󲿷ֵ���������·��
		boolean t = (n != 0) && (sum += sum_solution(n - 1)) != 0;
		return sum;
	}

}

class Temp {
	public static int sum = 0;
	public static int n = 0;
	
	public Temp() {
		n++;
		sum += n;
		System.out.println("ddd");
	}
}
