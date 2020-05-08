package com.zxt.bianchengzhimei;

/**
 * 
 * @Description: 只用一个字节的存储空间，将将帅的所有可能的组合输出
 * （一种思路是：将帅都只有9中可能位置，分别用4bit位即可表示，所以将一字节分为高低为部分各四位来存储将帅的位置）
 *
 * @author： zxt
 *
 * @time: 2018年6月26日 上午11:25:05
 *
 */
public class 象棋将帅问题 {

	public static void main(String[] args) {
		byte flag = 81;
		while(flag-- > 0) {
			// System.out.println(flag / 9 + "  " + flag % 9);
			if( (flag / 9) % 3 == (flag % 9) % 3 ) {
				continue;
			}
			System.out.println("A = " + (flag / 9 + 1) + ", " + (flag % 9 + 1));
		}
	}

}
