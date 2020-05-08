package com.zxt.jianzhi;

/**
 * 
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *  
 *  思路：理论上可以从1开始，逐个数字判断，但是这样的话时间复杂度较高（存在大量的非丑数也需要判断），
 *  因此考虑使用一个数组把从小打大的丑数都按顺序保存下来，当要求下一个丑数时，由当前已经有的丑数序列得到。
 *
 * @author： zxt
 *
 * @time: 2018年8月20日 下午4:34:15
 *
 */
public class 丑数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getUglyNumber(1500));
	}
	
	public static int getUglyNumber(int index) {
		if(index <= 0) {
			return 0;
		}
		
		// 保存丑数的数组
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		// 需要求的下一个丑数
		int nextUglyIndex = 1;
		
		// 下一个丑数必然是原有丑数中乘以丑数因子得到的一个大于当前序列最大值的最小值。
		// 使用一个下标记录下分别成2、3、5之后会大于当前序列最大值的最小下标，（序列中前一部分丑数乘以丑数因子得到的数可能已经在序列中，因此不需要重复判断）
		int pMultiply2 = 0;
		int pMultiply3 = 0;
		int pMultiply5 = 0;
		
		while(nextUglyIndex < index) {
			int min = min(uglyNumbers[pMultiply2] * 2, 
					uglyNumbers[pMultiply3] * 3, uglyNumbers[pMultiply5] * 5);
			// 这个min也成为当前丑数序列的最大值
			uglyNumbers[nextUglyIndex] = min;
			
			// 更新pMultiply2、pMultiply3、pMultiply5的值
			while(uglyNumbers[pMultiply2] * 2 <= uglyNumbers[nextUglyIndex]) {
				pMultiply2++;
			}
			while(uglyNumbers[pMultiply3] * 3 <= uglyNumbers[nextUglyIndex]) {
				pMultiply3++;
			}
			while(uglyNumbers[pMultiply5] * 5 <= uglyNumbers[nextUglyIndex]) {
				pMultiply5++;
			}
			
			nextUglyIndex++;
		}
		
		return uglyNumbers[nextUglyIndex - 1];
	}
	
	public static int min(int number1, int number2, int number3) {
		int min = (number1 < number2) ? number1 : number2;
		min = (min < number3) ? min : number3;
		
		return min;
	}
}
