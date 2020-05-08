package com.zxt.jianzhi;

/**
 * 
 * @Description: 输入一个整数n，求1-n这n个整数的十进制表示中1出现的次数。例如：输入12, 1-12这些整数中包含1的数字有1、10、11、12，一共出现5次
 *
 * @author： zxt
 *
 * @time: 2018年7月23日 上午11:17:52
 *
 */
public class 整数1出现的次数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOf1Between1AndN(1)); // 1
		System.out.println(numberOf1Between1AndN(5)); // 1
		System.out.println(numberOf1Between1AndN(10)); // 2
		System.out.println(numberOf1Between1AndN(55)); // 16
		System.out.println(numberOf1Between1AndN(23154)); // 19991
	}
	
	/**
	 * 
	 * @Description：计算1-n每一位出现1的次数。以百位为例，百位为1时，十位和个位的的变化组合共有100中（00-99），
	 * 而大于百位（千）每变化一次，百位可以多一次置为1的机会
	 * 
	 * 设N = abcde, 其中abcde分别为十进制中各位上的数字。 如果要计算百位上1出现的次数，它要受到3方面的影响：
	 * 百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
	 * 
	 * ① 如果百位上数字为0，百位上可能出现1的次数由更高位决定。
	 * 比如：12013，则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，...，11100~11199，一共1200个。
	 * 可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（100）。
	 * 
	 * ② 如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。
	 * 比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，，....，11100~11199，一共1200个。
	 * 和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。
	 * 但同时它还受低位影响，百位出现1的情况是：12100~12113,一共114个，等于低位数字（113）+1。 
	 * 
	 * ③ 如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定.
	 * 比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，...，11100~11199,12100~12199,一共有1300个.
	 * 并且等于更高位数字+1（12+1）乘以当前位数（100）。
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf1Between1AndN(int n) {
		int result = 0;
		int temp = n;
		
		// 记录当前是哪一位
		int digit = 1;
		while(temp != 0) {
			// 当前位上的数字
			int currentNum = temp % 10;
			// 剩余数字的大小
			temp = temp / 10;
			
			if(currentNum == 0) {
				result += temp * digit;
			} else if(currentNum == 1) {
				// (n % digit)：当前位的低位数字
				result += (temp * digit) + (n % digit) + 1;
			} else {
				result += (temp + 1) * digit;
			}
			
			// 下一位
			digit *= 10;
		}
		
		return result;
    }

}
