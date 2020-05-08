package com.zxt.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 *
 * @author�� zxt
 *
 * @time: 2018��8��20�� ����8:30:22
 *
 */
public class ��һ��ֻ����һ�ε��ַ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @Description��ͳ�ƴ��������⣬�ʺ�ʹ��HashMap����
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
