package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。
 * 小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，二进制数也很常用。
 * 现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。 f(x)表示把x这个数用十进制写出后各个数位上的数字之和。如f(123)=1+2+3=6。 
 * g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，那么，g(123)=1+1+1+1+0+1+1=6。 
 * 小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数称为幸运数，现在他想知道，大于0且小于等于n的幸运数有多少个？
 *
 * @author： zxt
 *
 * @time: 2018年7月18日 下午3:09:50
 *
 */
public class 幸运数 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int result = 0;
		// 保留十进制各位之和
		int sumTen = 0;
		// 保留二进制各位之和
		int sumTwo = 0;
		int temp = n;
		
		for(int i = 1; i <= n; i++) {
			// 求n的十进制表示的各位之和
			sumTen = 0;
			temp = i;
			while(temp != 0) {
				sumTen += temp % 10;
				temp = temp / 10;
			}
			
			// 求n的二进制表示的各位之和
			sumTwo = 0;
			temp = i;
			while(temp != 0) {
				sumTwo += temp & 1;
				temp = temp >> 1;
			}
			
			if(sumTen == sumTwo) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
