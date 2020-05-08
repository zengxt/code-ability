package com.zxt.jianzhi.移位;

/**
 * 
 * @Description: 输入一个整数，求整数的二进制表示中1的个数。
 *
 * @author： zxt
 *
 * @time: 2018年6月21日 下午4:10:40
 *
 */
public class 二进制中1的个数 {

	public static void main(String[] args) {
		int n = 16786582;
		System.out.println(numberOf1(n));
		System.out.println(numberOf2(n));
		System.out.println(numberOf3(n));
	}
	
	/**
	 * 
	 * @Description：每次判断二进制表示的最右一位是否为1（和1作 与 操作即可），最右一位即每次判断完右移即可
	 * 这种方法只适用于正整数，因为负整数右移高位补1，会陷入死循环 (或无法判断)
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf1(int n) {
		int count = 0;
		
		while(n > 0) {
			if((n & 1) == 1) {
				count++;
			}
			
			n = n >> 1;
		}
		
		return count;
	}
	
	/**
	 * 
	 * @Description：上一个方法是将数右移，每次判断最右位，无法处理负数。现在考虑将1左移，从最右位开始一次判断这个整数
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf2(int n) {
		int count = 0;
		int flag = 1;
		
		while(flag > 0) {
			if((n & flag) > 0) {
				count++;
			}
			
			flag = flag << 1;
		}
		
		return count;
	}
	
	/**
	 * 
	 * @Description：快速法：整数二进制中有几个1，就与运算几次即可。
	 * 思路：一个数 和 该数-1 作与操作，相当于把这个数最右边的1取反置为0。
	 * 分析：整数最右一位为1，减1之后变为0，其他位不会改变，与操作之后，相当于最右一位变为0
	 *     整数最右边的1不是最右一位，设右起第m位为1，则该整数减1之后，m位变为0，m为右边都变成原来的反，m位左边不变
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf3(int n) {
		int count = 0;
		
		while(n != 0) {
			count++;
			n = (n - 1) & n;
		}
		
		return count;
	}

}
