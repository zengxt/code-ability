package com.zxt.jianzhi.数组;

/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class ArraySearch {

	public static void main(String args[]) {
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, {6, 8, 11, 15} };
		
		ArraySearch as = new ArraySearch();
		// 查找7
		System.out.println(as.Find(7, array));
		// 查找10
		System.out.println(as.Find(16, array));
	}

	public boolean Find(int target, int[][] array) {
		if(array.length == 0 || array[0].length == 0) {
			return false;
		}
		
		// 从左下角或者右上角开始判断   row = array.length - 1,   col = 0 (左下角)
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
		
		// 从右上角开始判断   row = 0,   col = array.length - 1
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
