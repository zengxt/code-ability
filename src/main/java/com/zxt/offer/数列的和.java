package com.zxt.offer;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ����:���еĵ�һ��Ϊn���Ժ����Ϊǰһ���ƽ�����������е�ǰm��ĺ͡�
 * 
 *               ��������:���������ж��飬ÿ��ռһ�У�����������n��n < 10000����m(m < 1000)��ɣ�n��m�ĺ�����ǰ������
 * 
 *               �������:����ÿ���������ݣ���������еĺͣ�ÿ������ʵ��ռһ�У�Ҫ�󾫶ȱ���2λС����
 *
 * @author�� zxt
 *
 * @time: 2018��4��24�� ����4:31:30
 *
 */
public class ���еĺ� {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			double result = n;
			double temp = n;
			for(int i = 1; i < m; i++) {
				temp = Math.sqrt(temp);
				result += temp;
			}
			
			System.out.printf("%.2f", result);
		}
	}
}
