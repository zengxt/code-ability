package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: С��ͬѧѧϰ�˲�ͬ�Ľ���֮��������һЩ������������Ϸ��
 * С��ͬѧ֪�������ճ�������������õ���ʮ�����������ڼ�����У���������Ҳ�ܳ��á�
 * ���ڶ���һ������x��С��ͬѧ���������������f(x)��g(x)�� f(x)��ʾ��x�������ʮ����д���������λ�ϵ�����֮�͡���f(123)=1+2+3=6�� 
 * g(x)��ʾ��x������ö�����д���������λ�ϵ�����֮�͡���123�Ķ����Ʊ�ʾΪ1111011����ô��g(123)=1+1+1+1+0+1+1=6�� 
 * С��ͬѧ���ֶ���һЩ������x����f(x)=g(x)��������������Ϊ����������������֪��������0��С�ڵ���n���������ж��ٸ���
 *
 * @author�� zxt
 *
 * @time: 2018��7��18�� ����3:09:50
 *
 */
public class ������ {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int result = 0;
		// ����ʮ���Ƹ�λ֮��
		int sumTen = 0;
		// ���������Ƹ�λ֮��
		int sumTwo = 0;
		int temp = n;
		
		for(int i = 1; i <= n; i++) {
			// ��n��ʮ���Ʊ�ʾ�ĸ�λ֮��
			sumTen = 0;
			temp = i;
			while(temp != 0) {
				sumTen += temp % 10;
				temp = temp / 10;
			}
			
			// ��n�Ķ����Ʊ�ʾ�ĸ�λ֮��
			sumTwo = 0;
			temp = i;
			while(temp != 0) {
				sumTwo += temp & 1;
				temp = temp >> 1;
			}
			
			if(sumTen == sumTwo) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
