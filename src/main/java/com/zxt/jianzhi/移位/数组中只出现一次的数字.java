package com.zxt.jianzhi.移位;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author： zxt
 *
 * @time: 2018年6月22日 上午10:46:02
 *
 */
public class 数组中只出现一次的数字 {

	public static void main(String[] args) {
		int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0]);
		System.out.println(num2[0]);
		
		
		int[] num3 = new int[1];
		int[] num4 = new int[1];
		
		FindNumsAppearOnce2(array, num3, num4);
		System.out.println(num3[0]);
		System.out.println(num4[0]);
	}

	/**
	 * 
	 * @Description：使用异或运算（异或运算：相同为0，所以相同的数字异或会为0，因此若数组中只有一个数字出现一次，其余两次，则依次异或即可）
	 * 现在数组中有两个数字出现一次，其余出现两次。（则把数组拆分成两部分，一部分只包含一个出现一次的数字，并且相同的数字分到同一组）
	 * 分组思路：先将数组中每个数字依次异或，得到一个结果。找到这个结果二进制表示中最右一位1，记该位置为n，则依次判断数组中数字，该位的值，为0的一组，为1的一组
	 * 结果中第n位为1，表示只出现一次的两个数字的第n位不同，而相同数字的相同位的二进制肯定相同（因此出现两次的数字会分到同一组）
	 * 
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array.length < 2) {
			return;
		}
		
		// 所有数异或一遍（实际结果即只出现一次的两个数的异或结果）
		int resultExclusiveOR = 0;
		for(int i = 0; i < array.length; i++) {
			resultExclusiveOR ^= array[i];
		}
		
		// 异或结果中右起第一个1的位置
		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		
		num1[0] = num2[0] = 0;
		for(int i = 0; i < array.length; i++) {
			if(isBit1(array[i], indexOf1)) {
				num1[0] ^= array[i];
				
			} else {
				num2[0] ^= array[i];
			}
		}
	}
	
	/**
	 * 
	 * @Description:返回一个数右起第一个二进制为1的位置
	 * 
	 * @param num
	 * @return
	 */
	public static int findFirstBitIs1(int num) {
		int indexBit = 0;
		while(((num & 1) == 0) && (indexBit < 8 * 4)) {
			num = num >> 1;
			indexBit++;
		}
		
		return indexBit;
	}
	
	/**
	 * 
	 * @Description:判断一个数的二进制某位是否为1
	 * 
	 * @param num
	 * @param indexBit
	 * @return
	 */
	public static boolean isBit1(int num, int indexBit) {
		
		num = num >> indexBit;
		return (num & 1) == 1;
	}
	
	/**
	 * 
	 * @Description：使用Java内置集合类来处理
	 * 
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public static void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < array.length; i++) {
			if(list.contains(String.valueOf(array[i]))) {
				list.remove(String.valueOf(array[i]));
				
			} else {
				list.add(String.valueOf(array[i]));
			}
		}
		
		if(list.size() == 2) {
			num1[0] = Integer.parseInt(list.get(0));
			num2[0] = Integer.parseInt(list.get(1));
		}
	}

}
