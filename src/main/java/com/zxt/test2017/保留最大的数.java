package com.zxt.test2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @Description:给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。 
 * 
 * 输入描述:输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。
 * 第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。
 * 
 * 输出描述:输出保留下来的结果。
 * 
 * 示例：输入325 1，输出35
 *
 * @author： zxt
 *
 * @time: 2018年7月19日 下午4:22:07
 *
 */
public class 保留最大的数 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while((str = bf.readLine()) != null) {
			StringBuffer value = new StringBuffer(str);
			int cnt = Integer.valueOf(bf.readLine());
			
			System.out.println(getMaxRemainValue2(value, cnt));
		}
	}
	
	/**
	 * 
	 * @Description：由于每去除一位，数字的位数肯定少了，所以要尽可能让大的数字往前移，所以每次去除的时候选择从左往右第一个比后面数字小的数
	 * 
	 * @param value
	 * @param cnt
	 * @return
	 */
	public static StringBuffer getMaxRemainValue(StringBuffer value, int cnt) {
		int index = 0;
		
		while(cnt != 0 && index < value.length() && index + 1 < value.length()) {
			// 当前位置的数字小于它后一位的数字
			if(value.charAt(index) <= value.charAt(index + 1)) {
				value.deleteCharAt(index);
				cnt--;
				// 由于每次删除之后下标改变
				if(index > 0) {
					index--;
				}
				
			} else {
				index++;
			}
		}
		
		// 经过上面的循环，删除的数字个数还没有达到要求的个数，则剩下的都是左边比右边大，所以每次删除最后一位
		while(cnt != 0) {
			value.deleteCharAt(value.length() - 1);
			cnt--;
		}
		
		return value;
	}
	
	public static StringBuffer getMaxRemainValue2(StringBuffer value, int cnt) {
		while(cnt != 0) {
			int currentLength = value.length() - 1;
			
			// 当前位置的数字小于它后一位的数字
			int deleteIndex = 0;
			while(deleteIndex < currentLength && value.charAt(deleteIndex) > value.charAt(deleteIndex + 1)) {
				deleteIndex++;
			}
			
			value.deleteCharAt(deleteIndex);
			cnt--;
		}
		
		return value;
	}

}
