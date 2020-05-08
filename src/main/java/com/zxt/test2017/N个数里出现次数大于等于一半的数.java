package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ����������n��������������ִ������ڵ������鳤��һ�������
 * 
 * ��������:ÿ������������� n���ո�ָ��n��������n������100��������һ���������ִ������ڵ���n/2��
 * �������:������ִ������ڵ���n/2������
 * 
 * ʾ��1
 * ����
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * ���
 * 3
 *
 * @author�� zxt
 *
 * @time: 2018��7��25�� ����8:44:22
 *
 */
public class N��������ִ������ڵ���һ����� {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String[] str = scanner.nextLine().split(" ");
			int[] array = new int[str.length];
			for(int i = 0; i < str.length; i++) {
				array[i] = Integer.valueOf(str[i]);
			}
			
			// ������һ�����ĳ��ִ������ڵ���2/n�����������ֵĴ������������������ֵĴ������ࣨ����ȣ�
			int result = array[0];
			int times = 1;
			for(int i = 1; i < array.length; i++) {
				if(times == 0) {
					result = array[i];
					times = 1;
					
				} else if (array[i] == result) {
					times++;
					
				} else {
					times--;
				}
			}
			
			// ������Ҫ��֤������ôһ��������˲����ж���
			System.out.println(result);
		}
	}

}
