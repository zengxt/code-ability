package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 
 * 18λ���֤�ı�������ǣ�
 * ǰ1��2λ���ֱ�ʾ������ʡ��ֱϽ�С����������Ĵ���
 * ��3��4λ���ֱ�ʾ�����ڵؼ��У������ݣ��Ĵ���
 * ��5��6λ���ֱ�ʾ�����������ء������ء��ؼ��У��Ĵ��룻
 * ��7��14λ���ֱ�ʾ�������ꡢ�¡��գ�
 * ��15��16λ���ֱ�ʾ�����ڵص��ɳ����Ĵ��룻
 * ��17λ���ֱ�ʾ�Ա�������ʾ���ԣ�ż����ʾŮ�ԣ�
 * ��18λ������У���룬�����������֤����ȷ�ԡ�
 * �û����������֤�Ĺ����о������������Ϊ�˷����û���ȷ������Ҫ����������ж��û������밴�� 6+8+4 �ĸ�ʽ���з��飬
 * ʵ��һ������������������е����֤�ţ����ط������ַ�
 *
 * @author�� zxt
 *
 * @time: 2018��7��18�� ����4:40:15
 *
 */
public class ���֤���� {
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			
			// ��������
			StringBuffer first = new StringBuffer();
			StringBuffer second = new StringBuffer();
			StringBuffer third = new StringBuffer();
			
			int index = 0;
			for(int i = 0; i < str.length(); i++) {
				
				if(str.charAt(i) != ' ') {
					if(index < 6) {
						first.append(str.charAt(i));
					} else if(index < 14) {
						second.append(str.charAt(i));
					} else {
						third.append(str.charAt(i));
					}
					
					index++;
				}
			}
			
			System.out.println(first + " " + second + " " + third);
		}
	}
	
	public void printGroups(String str) {
		String temp = str.replace(" ", "");
		for(int i = 0; i < temp.length(); i++) {
			System.out.print(temp.charAt(i));
			if(i == 5 || i == 13) {
				System.out.print(" ");
			}
		}
	}

}
