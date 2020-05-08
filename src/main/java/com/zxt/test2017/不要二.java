package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ����������С����һ��W*H��������ӣ�������б��Ϊ0~H-1��������б��Ϊ0~W-1��
 * ÿ������������Է�һ�鵰�⣬�������鵰���ŷ����þ��벻�ܵ���2��
 * ����������������(x1,y1),(x2,y2)��ŷ����þ���Ϊ:( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) ������ƽ������
 * С����֪�������ԷŶ��ٿ鵰������������
 * 
 * ��������:ÿ������������񳤿�W,H���ÿո�ָ�.(1 �� W��H �� 1000)
 * �������:���һ�������Էŵĵ�����
 * 
 * ʾ��1
 * ����
 * 3 2
 * ���
 * 4
 *
 * @author�� zxt
 *
 * @time: 2018��7��25�� ����10:31:50
 *
 */
public class ��Ҫ�� {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			
			/**
			 * ÿ��������Ϊһ������pattern��ͬ��ÿ��4��4�п��Է�8�����⣩
			 * 1 1 x x 1 1 x x 1 1
			 * 1 1 x x 1 1 x x 1 1
			 * x x 1 1 x x 1 1 x x
			 * x x 1 1 x x 1 1 x x
			 * 1 1 x x 1 1 x x 1 1
			 * 1 1 x x 1 1 x x 1 1
			 */
			// �ȶ���һ�����飬��ʾ��������֮��ʣ�������п��Է��õ��������
			int[][] last = {{1, 2, 2, 2}, {2, 4, 4, 4}, {2, 4, 5, 6}, {2, 4, 6, 8}};
			
			// �й������������
			int blocks = (w / 4) * (h / 4);
			int result = blocks * 8;
			
			if(w % 4 != 0) {
				// ʣ���У������·����е�������
				result += (w % 4) * 2 * (h / 4);
			}
			
			if(h % 4 != 0) {
				// ʣ���У������ҷ����е�������
				result += (h % 4) * 2 * (w / 4);
			}
			
			if(w % 4 != 0 && h % 4 != 0) {
				// ����Խ�ʣ�����е�������
				result += last[w % 4 - 1][h % 4 - 1];
			}
			
			System.out.println(result);
		}

	}

}
