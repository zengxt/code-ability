package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 
 * 18位身份证的编码规则是：
 * 前1、2位数字表示：所在省（直辖市、自治区）的代码
 * 第3、4位数字表示：所在地级市（自治州）的代码
 * 第5、6位数字表示：所在区（县、自治县、县级市）的代码；
 * 第7—14位数字表示：出生年、月、日；
 * 第15、16位数字表示：所在地的派出所的代码；
 * 第17位数字表示性别：奇数表示男性，偶数表示女性；
 * 第18位数字是校检码，用来检验身份证的正确性。
 * 用户在输入身份证的过程中经常会输入错误，为了方便用户正确输入需要在输入过程中对用户的输入按照 6+8+4 的格式进行分组，
 * 实现一个方法接收输入过程中的身份证号，返回分组后的字符
 *
 * @author： zxt
 *
 * @time: 2018年7月18日 下午4:40:15
 *
 */
public class 身份证分组 {
	
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			
			// 三个分组
			StringBuffer first = new StringBuffer();
			StringBuffer second = new StringBuffer();
			StringBuffer third = new StringBuffer();
			
			int index = 0;
			for(int i = 0; i < str.length(); i++) {
				
				if(str.charAt(i) != ' ') {
					if(index < 6) {
						first.append(str.charAt(i));
					} else if(index < 14) {
						second.append(str.charAt(i));
					} else {
						third.append(str.charAt(i));
					}
					
					index++;
				}
			}
			
			System.out.println(first + " " + second + " " + third);
		}
	}
	
	public void printGroups(String str) {
		String temp = str.replace(" ", "");
		for(int i = 0; i < temp.length(); i++) {
			System.out.print(temp.charAt(i));
			if(i == 5 || i == 13) {
				System.out.print(" ");
			}
		}
	}

}
