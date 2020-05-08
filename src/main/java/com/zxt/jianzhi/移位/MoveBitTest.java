package com.zxt.jianzhi.移位;

/*
 * java移位操作符详解
 * 首先，移位运算符有三种，其操作类型只支持：byte / short / char / int和long五种。
 * <<	：左移运算符，表示将左边的操作数的二进制数据向左移动n位，移动后空缺位以0填充，多余位舍弃。（等同于乘2的n次方）
 * >>	：右移运算符，二进制数据向右移动n位，（等同于除2的n次方）  >>是带符号右移，负数高位补1，正数补0
 * >>>	：无符号右移运算符，不管移动前最高位是0还是1，右移后左侧产生的空位部分都以0来填充。
 */
public class MoveBitTest {

	public static void main(String[] args) {
		int a = 13;
		System.out.println("移动前 a = " + a + ", 二进制表示为：" + Integer.toBinaryString(a));

		int b = a << 2; // a左移两位，相当于a * 2的2次方
		System.out.println("左移后 a = " + b + ", 二进制表示为：" + Integer.toBinaryString(b));

		int c = a >> 2; // a右移两位，相当于a / 2的2次方
		System.out.println("右移后 a = " + c + ", 二进制表示为：" + Integer.toBinaryString(c));

		int d = -12;
		System.out.println("移动前 d = " + d + ", 二进制表示为：" + Integer.toBinaryString(d));
		System.out.println(bitInfo(d));

		// 带符号右移
		int e = d >> 2;
		System.out.println("带符号右移后 d = " + e + ", 二进制表示为：" + Integer.toBinaryString(e));
		// 无符号右移
		int f = d >>> 2;
		System.out.println("无符号右移后 d = " + f + ", 二进制表示为：" + Integer.toBinaryString(f));
		
		System.out.println("=======================================================");
		/**
		 * 由于int型数据只有32位，long型数据64位，所以当移位操作移动的位数多余32或者64时，系统做了一定的处理。
		 * 实际上当  左侧操作数为int类型时，右侧操作数只有低5位有效，即（0-31），相当于右侧操作数先与0x1f做与（&）操作，再运算
		 * 当右侧操作数为long类型时，右侧操作数只有低6位有效，即（0-63），相当于右侧操作数先与0x3f做与（&）操作，再运算
		 */
		int i = 20;
		int j = 30;
		System.out.println("i << 3 = " + (i << 3));
		System.out.println("i << -29 = " + (i << -29));
		String str = Integer.toBinaryString(-29);
		System.out.println("-29：" + str + "，最后5位为：" + str.substring(str.length() - 5));
		System.out.println("j >> 70 = " + (j >> 70));
		
		System.out.println("=======================================================");
		/**
		 * 除法运算，当不能整除时，结果向0的方向舍入，所以正数时向下舍入，负数时向上舍入     9/2 = 4      -9/2 = -4
		 * 但是右移始终是向下舍入的，所以会存在右移与除2^n的结果不相等的情况   9>>1 = 4    -9>>1 = -5
		 */
		System.out.println("9 >> 1 = " + (9 >> 1) + " and 9 / 2 = " + (9 / 2));
		System.out.println("-9 >> 1 = " + (-9 >> 1) + " but -9 / 2 = " + (-9 / 2));
	}
	
	private static String bitInfo(int num) {
		StringBuffer str = new StringBuffer();
		
		String binaryStr = Integer.toBinaryString(num);
		int i = 0;
		while(i < binaryStr.length()) {
			str.append(binaryStr.substring(i, i+4));
			str.append(" ");
			i += 4;
		}
		
		return str.toString();
	}
}