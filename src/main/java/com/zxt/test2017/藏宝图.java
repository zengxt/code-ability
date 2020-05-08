package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ������ţţ�õ���һ���ر�ͼ��˳�Ųر�ͼ��ָʾ��ţţ������һ���ر��У��ر�������һ�����أ�����ÿ�λ���ʾ�����ַ��� s �� t��
 * ���ݹ��ϵĴ�˵��ţţ��Ҫÿ�ζ��ش� t �Ƿ��� s �������С�
 * ע�⣬�����в�Ҫ����ԭ�ַ������������ģ����紮 abc�����������о��� {�մ�, a, b, c, ab, ac, bc, abc} 8 �֡�
 * 
 * ��������:ÿ���������һ������������ÿ�����������������г��Ȳ����� 10 �Ĳ������ո�Ŀɼ� ASCII �ַ�����
 * �������:���һ�� ��Yes�� ���� ��No�� ��ʾ�����
 * 
 * ʾ��1
 * ����
 * x.nowcoder.com
 * ooo
 * ���
 * Yes
 *
 * @author�� zxt
 *
 * @time: 2018��7��24�� ����10:14:12
 *
 */
public class �ر�ͼ {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String s = scanner.nextLine();
			String t = scanner.nextLine();
			
			// t�������ַ�ֻҪ��˳�������s�м��ɣ����ֻҪt��ǰiλ���ܺ�s�е��ַ�ƥ�����ң�ƥ����index�����жϵ�i+1λʱֻ��Ҫ�ж�index+1���漴��
			int indexS = 0;
			int indexT = 0;
			while(indexT < t.length() && indexS < s.length()) {
				if(s.charAt(indexS) == t.charAt(indexT)) {
					indexT++;
					indexS++;
				} else {
					indexS++;
				}
			}
			
			if(indexT == t.length()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		
	}

}
