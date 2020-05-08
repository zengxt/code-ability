package com.zxt.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @author： zxt
 *
 * @time: 2018年8月20日 下午8:30:22
 *
 */
public class 第一个只出现一次的字符 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @Description：统计次数的问题，适合使用HashMap来做
	 * 
	 * @param str
	 * @return
	 */
	public static int getFirstNotRepeatingChar(String str) {
		if(str == null || str.length() == 0) {
			return -1;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		
		int result = -1;
		for(int i = 0; i < str.length(); i++) {
			if(map.get(str.charAt(i)) == 1) {
				result = i;
				break;
			}
		}
		
		return result;
	}

}
