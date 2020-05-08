package com.zxt.offer;

import java.util.ArrayList;

/**
 * 
 * @Description: ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 *
 * @author�� zxt
 *
 * @time: 2018��5��5�� ����11:10:42
 *
 */
public class ˳ʱ���ӡ���� {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		ArrayList<Integer> list = printMatrix(matrix);
		System.out.println(list);
		
		ArrayList<Integer> list2 = printMatrix2(matrix);
		System.out.println(list2);
	}
	
	/**
	 * 
	 * @Description:����˼·��һȦһȦ��ӡ����һȦ��ʼ��0,0���ڶ�Ȧ��ʼ��1,1��......�����һȦ��(start, start)�����㣺
	 * 				start * 2 < rows  && start * 2 < columns
	 * 
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		if(matrix == null) {
			return null;
		}
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// startʵ���ϱ�ʾ����˳ʱ��ĵڼ�Ȧ����start��start���ǵ�ǰ��ӡ��Ȧ�����Ͻǿ�ʼλ��
		// ͬʱ��Ҫע����ǣ���ӡһȦ��Ϊ�Ĳ�������һ��������Ҫ�ģ�����������Ҫ���ж�
		int start = 0;
		while(columns > start * 2 && rows > start * 2) {
			
			int endColumnsIndex = columns - 1 - start;
			int endRowsIndex = rows - 1- start;
			
			// ������һ��
			for(int i = start; i <= endColumnsIndex; i++) {
				list.add(matrix[start][i]);
			}
			
			// ���ϵ���һ��
			if(start < endRowsIndex) {
				for(int i = start + 1; i <= endRowsIndex; i++) {
					list.add(matrix[i][endColumnsIndex]);
				}
			}
			
			// ���ҵ���
			if(start < endRowsIndex && start < endColumnsIndex) {
				for(int i = endColumnsIndex - 1; i >= start; i--) {
					list.add(matrix[endRowsIndex][i]);
				}
			}
			
			// ���µ���
			if(start < endRowsIndex - 1 && start < endColumnsIndex) {
				for(int i = endRowsIndex - 1; i > start; i--) {
					list.add(matrix[i][start]);
				}
			}
			
			// ��һȦ
			start++;
		}
		
		return list;
    }
	
	/**
	 * 
	 * @Description:˼·��������ÿ�δ�ӡ�����ϽǺ����½�λ�ã����ϽǺ����½�ǰ��
	 * 
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix2(int [][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		if(rows == 0 || columns == 0) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// �����ĸ������������Ϻ����µķ�Χ
		int left = 0;
		int top = 0;
		int right = columns - 1;
		int bottom = rows - 1;
		while(left <= right && top <= bottom) {
			// ������һ��
			for(int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			
			// ���ϵ���һ��
			for(int i = top + 1; i <= bottom; i++) {
				list.add(matrix[i][right]);
			}
			
			// ���ҵ���һ��
			if(top != bottom) {
				for(int i = right - 1; i >= left; i--) {
					list.add(matrix[bottom][i]);
				}
			}
			
			// ���µ���һ��
			if(left != right) {
				for(int i = bottom - 1; i > top; i--) {
					list.add(matrix[i][left]);
				}
			}
			
			// ��һȦ
			left++;
			right--;
			top++;
			bottom--;
		}
		
		return list;
	}
}
