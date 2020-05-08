package com.zxt.jianzhi;

/**
 * 
 * @Description: 数字以0123456789101112131415………的格式序列化到一个字符序列中。在这个序列号中，第五位（从0开始计数）是5，第13位是1，
 *               第19位是4，等等，写一个函数求任意第n位对应的数字。
 *
 * @author： zxt
 *
 * @time: 2018年7月23日 下午4:45:07
 *
 */
public class 数字序列中某一位的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digitAtIndex(0));  // 0
		System.out.println(digitAtIndex(5));  // 5
		System.out.println(digitAtIndex(9));  // 9
		System.out.println(digitAtIndex(10)); // 1
		System.out.println(digitAtIndex(11)); // 0
		System.out.println(digitAtIndex(13)); // 1
		System.out.println(digitAtIndex(17));  // 3
		System.out.println(digitAtIndex(190));  // 1
		
		System.out.println("----------------------------");
		System.out.println(getNNum(0));  // 0
		System.out.println(getNNum(5));  // 5
		System.out.println(getNNum(9));  // 9
		System.out.println(getNNum(10)); // 1
		System.out.println(getNNum(11)); // 0
		System.out.println(getNNum(13)); // 1
		System.out.println(getNNum(17));  // 3
		System.out.println(getNNum(190));  // 1
	}

	/**
	 * 
	 * @Description：0-9有10个，10-99有90个，100-999有900个，......，首先先判断出n的所属区间，然后再计算在区间的位置
	 * 
	 * 例如：第1001位，前10位是0-9，所以直接跳过，接下来的180位数字是90个10-99，也直接跳过。1001 - 10 - 180 = 811
	 * 接下来的2700位数字是900个100-999的三位数。由于811 < 2700，所以第811位是某个三位数中的一位
	 * 由于811 = 270*3+1，这意味着第811位是从100开始的第270个数字，即370的中间一位，也就是7
	 * 
	 * @param n
	 * @return
	 */
	public static int getNNum(int n) {
		// 区间内数字的位数
		int digits = 1;
		
		int lengthDigit = 10;
		while (n >= lengthDigit * digits) {
			n -= lengthDigit * digits;
			
			digits++;
			lengthDigit = (int) (9 * Math.pow(10, digits - 1));
		}

		// num表示第n位对应的是区间内的哪个数（start表示区间起始的值）
		int start = digits == 1 ? 0 : (int) Math.pow(10, digits - 1);
		int num = start + n / digits;
		// 在该数的哪个索引
		int index = n % digits;

		return Integer.valueOf((num + "").charAt(index) - '0');
	}
	
	public static int digitAtIndex(int index) {
		if(index < 0) {
			return -1;
		}
		
		int digits = 1;
		while(true) {
			int numbers = countOfIntegers(digits);
			if(index < numbers * digits) {
				return digitAtIndex(index, digits);
			}
			
			index -= digits * numbers;
			digits++;
		}
	}
	
	/**
	 * 
	 * @Description：返回m位的数字总共有多少个，例如输入2，返回（10-99）的个数90
	 * 
	 * @param digits
	 * @return
	 */
	public static int countOfIntegers(int digits) {
		if(digits == 1) {
			return 10;
		}
		
		int count = (int) Math.pow(10, digits - 1);
		return count * 9;
	}
	
	/**
	 * 
	 * @Description：返回m位数字区间开头数字的值，例如两位数是10，三位数是100
	 * 
	 * @param digits
	 * @return
	 */
	public static int beginNumber(int digits) {
		if(digits == 1) {
			return 0;
		}
		
		return (int) Math.pow(10, digits - 1);
	}
	
	/**
	 * 
	 * @Description：已经找到某位的数字在m位数的区间内
	 * 
	 * @param index
	 * @param digits
	 * @return
	 */
	public static int digitAtIndex(int index, int digits){
		int number = beginNumber(digits) + index / digits;
		int indexFromRight = digits - index % digits;
		for(int i = 1; i < indexFromRight; i++) {
			number /= 10;
		}
		
		return number % 10;
	}
	
}
