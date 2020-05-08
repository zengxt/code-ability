package com.zxt.offer;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @Description: 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串，但要保证汉字不被截取半个，
 *               如“我ABC”，4，应该截取“我AB”，输入“我ABC汉DEF”，6，应该输出“我ABC”，而不是“我ABC+汉的半个”。
 *
 * @author： zxt
 *
 * @time: 2018年3月1日 下午9:53:10
 *
 */
public class TrimString {

	// 中文字符有多种编码，在这里需要固定编码，GBK编码的中文用连个字节表示
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "我ABC汉";
		int num = trimGBK(str.getBytes("GBK"), 4);
		System.out.println(str.substring(0, num));
		
		num = trimGBK(str.getBytes("GBK"), 6);
		System.out.println(str.substring(0, num));
	}

	public static int trimGBK(byte[] buf, int n) {
		int num = 0;

		boolean bChineseFirstHalf = false;
		for (int i = 0; i < n; i++) {
			/**
			 * GBK编码
			 *  第一个字节                			      第二个字节
			 * x81-0xFE（129-254）    |   0x40-0xFE（64-254）
			 * 通过这里，知道第一个字节的范围是129~254，这个范围的数，其最高位都是1，而以int类型解释时，最高位是1就意味着这是一个负数。
			 * 一个GBK汉字要占两个char空间(二字节），而且第一个字节里的值是小于0的。可以据此判断是否为汉字。
			 */
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}

		return num;
	}
}
