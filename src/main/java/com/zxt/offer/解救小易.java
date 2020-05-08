package com.zxt.offer;

import java.util.Scanner;

/**
 * 
 * @Description: ��һƬ1000*1000�Ĳݵأ�С�׳�ʼվ��(1,1)(�����Ͻǵ�λ��)��С����ÿһ��������������ƶ������ڵĲݵ��ϳԲ�(С�ײ����߳��߽�)��
 *               ���ɳ�����ȥ��׽�ɰ���С�ף���������n�����塣��i�����屻�����ں�����Ϊxi ��������Ϊyi��λ���ϣ�С��һ������һ�����壬���ᱻ������׽��
 *               ��Ϊ��ȥ���С�ף���Ҫ֪��С�����ٶ�������ܻ�����һ�����壬�Ӷ���ǰ���С�ס�
 * 
 *               ��������:��һ��Ϊһ������n(n �� 1000)����ʾ����һ��ӵ��n�����塣�ڶ�����n������xi����ʾ��i������ĺ����꣬��������n������yi����ʾ��i�������������
 *               ��֤���궼�ڲݵط�Χ�ڡ�
 * 
 *               �������:���һ������,��ʾС�����ٿ��ܶ���������볬��������
 * 
 *               ʾ��1 
 *               ���� 
 *               3 
 *               4 6 8
 *               1 2 1
 * 
 *               ��� 3
 *
 * @author�� zxt
 *
 * @time: 2018��4��16�� ����3:07:02
 *
 */
public class ���С�� {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] xi = new int[n];
		int[] yi = new int[n];
		for (int i = 0; i < n; i++) {
			xi[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			yi[i] = scanner.nextInt();
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = xi[i] + yi[i];
			if (result > temp) {
				result = temp;
			}
		}

		System.out.println(result - 2);
	}
}
