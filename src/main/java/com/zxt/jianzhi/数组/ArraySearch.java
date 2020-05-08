package com.zxt.jianzhi.����;

/*
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */

public class ArraySearch {

	public static void main(String args[]) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, {6, 8, 11, 15} };
		
		ArraySearch as = new ArraySearch();
		// ����7
		System.out.println(as.Find(7, array));
		// ����10
		System.out.println(as.Find(16, array));
	}

	public boolean Find(int target, int[][] array) {
		if(array.length == 0 || array[0].length == 0) {
			return false;
		}
		
		// �����½ǻ������Ͻǿ�ʼ�ж�   row = array.length - 1,   col = 0 (���½�)
		// target > array[row][col]  col++
		// target < array[row][col]  row--
		int row = array.length - 1;
		int col = 0;
		while(row >= 0 && col < array.length) {
			if(target == array[row][col]) {
				return true;
				
			} else if(target > array[row][col]) {
				col++;
				
			} else if(target < array[row][col]) {
				row--;
			}
		}

		return false;
	}
	
	public boolean Find2(int target, int[][] array) {
		int length = array.length;
		
		if(length == 0 || array[0].length == 0) {
			return false;
		}
		
		// �����Ͻǿ�ʼ�ж�   row = 0,   col = array.length - 1
		int row = 0;
		int col = length - 1;
		while(row < length && col >= 0) {
			if(target == array[row][col]) {
				return true;
				
			} else if(target > array[row][col]) {
				row++;
				
			} else if(target < array[row][col]) {
				col--;
			}
		}

		return false;
	}
}
