package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述：牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，
 * 根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。
 * 注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
 * 
 * 输入描述:每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。
 * 输出描述:输出一行 “Yes” 或者 “No” 表示结果。
 * 
 * 示例1
 * 输入
 * x.nowcoder.com
 * ooo
 * 输出
 * Yes
 *
 * @author： zxt
 *
 * @time: 2018年7月24日 下午10:14:12
 *
 */
public class 藏宝图 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String s = scanner.nextLine();
			String t = scanner.nextLine();
			
			// t的所以字符只要按顺序出现在s中即可，因此只要t的前i位都能和s中的字符匹配上且（匹配至index），判断第i+1位时只需要判断index+1后面即可
			int indexS = 0;
			int indexT = 0;
			while(indexT < t.length() && indexS < s.length()) {
				if(s.charAt(indexS) == t.charAt(indexT)) {
					indexT++;
					indexS++;
				} else {
					indexS++;
				}
			}
			
			if(indexT == t.length()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		
	}

}
