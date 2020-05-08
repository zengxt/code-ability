package com.zxt.offer;

import java.util.ArrayList;

/**
 * 
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 * @author： zxt
 *
 * @time: 2018年5月5日 下午11:10:42
 *
 */
public class 顺时针打印数组 {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		ArrayList<Integer> list = printMatrix(matrix);
		System.out.println(list);
		
		ArrayList<Integer> list2 = printMatrix2(matrix);
		System.out.println(list2);
	}
	
	/**
	 * 
	 * @Description:基本思路：一圈一圈打印，第一圈开始（0,0）第二圈开始（1,1）......。最后一圈：(start, start)会满足：
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
		
		// start实际上表示的是顺时针的第几圈，（start，start）是当前打印的圈的左上角开始位置
		// 同时需要注意的是：打印一圈分为四步，而第一步总是需要的，其他三步需要先判断
		int start = 0;
		while(columns > start * 2 && rows > start * 2) {
			
			int endColumnsIndex = columns - 1 - start;
			int endRowsIndex = rows - 1- start;
			
			// 从左到右一行
			for(int i = start; i <= endColumnsIndex; i++) {
				list.add(matrix[start][i]);
			}
			
			// 从上到下一列
			if(start < endRowsIndex) {
				for(int i = start + 1; i <= endRowsIndex; i++) {
					list.add(matrix[i][endColumnsIndex]);
				}
			}
			
			// 从右到左
			if(start < endRowsIndex && start < endColumnsIndex) {
				for(int i = endColumnsIndex - 1; i >= start; i--) {
					list.add(matrix[endRowsIndex][i]);
				}
			}
			
			// 从下到上
			if(start < endRowsIndex - 1 && start < endColumnsIndex) {
				for(int i = endRowsIndex - 1; i > start; i--) {
					list.add(matrix[i][start]);
				}
			}
			
			// 下一圈
			start++;
		}
		
		return list;
    }
	
	/**
	 * 
	 * @Description:思路二：控制每次打印的左上角和右下角位置，左上角和右下角前进
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
		// 定义四个变量控制左上和右下的范围
		int left = 0;
		int top = 0;
		int right = columns - 1;
		int bottom = rows - 1;
		while(left <= right && top <= bottom) {
			// 从左到右一行
			for(int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			
			// 从上到下一列
			for(int i = top + 1; i <= bottom; i++) {
				list.add(matrix[i][right]);
			}
			
			// 从右到左一行
			if(top != bottom) {
				for(int i = right - 1; i >= left; i--) {
					list.add(matrix[bottom][i]);
				}
			}
			
			// 从下到上一列
			if(left != right) {
				for(int i = bottom - 1; i > top; i--) {
					list.add(matrix[i][left]);
				}
			}
			
			// 下一圈
			left++;
			right--;
			top++;
			bottom--;
		}
		
		return list;
	}
}
