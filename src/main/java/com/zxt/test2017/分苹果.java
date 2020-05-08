package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ������n ֻ��ţ����һ�ţ�ÿ����ţӵ�� ai ��ƻ����������Ҫ������֮��ת��ƻ����ʹ�����������ţӵ�е�ƻ��������ͬ��
 * ÿһ�Σ���ֻ�ܴ�һֻ��ţ��������ǡ������ƻ������һ����ţ�ϣ���������Ҫ�ƶ����ٴο���ƽ��ƻ�������������������� -1��
 * 
 * ����������ÿ���������һ������������ÿ�����������ĵ�һ�а���һ������ n��1 <= n <= 100������������һ�а��� n ������ ai��1 <= ai <= 100����
 * �������:���һ�б�ʾ������Ҫ�ƶ����ٴο���ƽ��ƻ���������������������� -1��
 * 
 * ʾ��1
 * ����
 * 4
 * 7 15 9 5
 * ���
 * 3
 *
 * @author�� zxt
 *
 * @time: 2018��7��24�� ����9:39:57
 *
 */
public class ��ƻ�� {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] array = new int[n];
			int sum = 0;
			for(int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
				sum += array[i];
			}
			
			int result = -1;
			if(sum % n == 0) {
				// �������������ţ��ƻ����Ҫһ�������Ա�Ȼ����һ��ƽ��������ÿͷ��ţ��ƻ�������ֵʱ��Ĳ�ֵ��Ȼ��2�ı��������ƶ��ɹ�
				int avg = sum / n;
				int times = 0;
				int index = 0;
				for(; index < n; index++) {
					if((array[index] - avg) % 2 == 0) {
						times += Math.abs(array[index] - avg);
					} else {
						break;
					}
				}
				
				if(index == array.length) {
					result = times / 4;
				}
			}
			
			System.out.println(result);
		}
	}

}
