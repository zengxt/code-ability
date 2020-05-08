package com.zxt.jianzhi.����;

import java.util.Arrays;

/**
 * 
 * @Description: ����һ������A[0,1,...,n-1], �빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 *
 * @author�� zxt
 *
 * @time: 2018��3��6�� ����10:37:15
 *
 */
public class MultiplyArray {

	public static void main(String[] args) {
		int[] A = {1, 3, 5, 7, 2, 3};
		
		System.out.println(Arrays.toString(multiply(A)));
	}
	
	public static int[] multiply(int[] A) {
		int length = A.length;
		if(length <= 0) {
			return null;
		}
		
		// C[i] = A[0]*A[1]*...*A[i-1]
		int[] B = new int[length];
		B[0] = 1;
		for(int i = 1; i < length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		
		// D[i] = A[i+1]*...*A[n-1]
		int temp = 1;
		for(int i = length - 2; i >= 0; i--) {
			temp = temp * A[i + 1];
			B[i] = temp * B[i];
		}
		
		return B;
    }
}
