package com.zxt.offer;

import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ����:��һ��X*Y������С��Ҫ�ڴ������ϴ����Ͻǵ����½ǣ�ֻ���߸����ֻ�����һ������ߡ�
 *               �����һ���㷨������С���ж������߷�����������������int x,int y���뷵��С�ŵ��߷���Ŀ��
 * 
 *               ��������:�������һ�У����Ÿ���������������x��y��ȡֵ��Χ[1,10]��
 * 
 *               �������:�������һ�У�Ϊ�߷�����Ŀ��
 *
 * 				@author�� zxt
 *
 * @time: 2018��4��24�� ����4:38:57
 *
 */
public class �����߷���Ŀ {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			int[][] f = new int[x + 1][y + 1];
			for(int i = 0; i <= x; i++) {
				f[i][0] = 1;
			}
			for(int j = 0; j <= y; j++) {
				f[0][j] = 1;
			}
			for(int i = 1; i <= x; i++) {
				for(int j = 1; j <= y; j++) {
					f[i][j] = f[i - 1][j] + f[i][j - 1];
				}
			}
			
			System.out.println(f[x][y]);
		}
	}
}
