package com.zxt.test2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @Description: ��Ŀ������ţţ�볢��һЩ�µ�����ÿ��������ҪһЩ��ͬ�Ĳ��ϣ���������е�������Ҫ׼�������ֲ�ͬ�Ĳ��ϡ�
 * ����������ÿ��������� 1 ������������ÿ�����������ĵ� i �У���ʾ��ɵ� i ��������Ҫ��Щ���ϣ����������ÿո������
 * ����ֻ������дӢ����ĸ�Ϳո������ļ������� 50 �У�ÿһ�в����� 50 ���ַ���
 * 
 * �������:���һ��һ�����ֱ�ʾ�������������Ҫ�����ֲ�ͬ�Ĳ��ϡ�
 * 
 * ʾ��1
 * ����
 * BUTTER FLOUR
 * HONEY FLOUR EGG
 * ���
 * 4
 *
 * @author�� zxt
 *
 * @time: 2018��7��24�� ����9:14:26
 *
 */
public class �³��� {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		// ʹ�ü����༴��
		Set<String> set = new HashSet<String>();
		while(scanner.hasNext()) {
			String[] str = scanner.nextLine().split(" ");
			for(int i = 0; i < str.length; i++) {
				set.add(str[i]);
			}
		}
		
		System.out.println(set.size());
	}
	
}
