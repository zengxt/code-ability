package com.zxt.jianzhi;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * @author： zxt
 *
 * @time: 2018年8月26日 下午3:04:33
 *
 */
public class 字符流中第一个不重复的字符 {

	// 由于要求返回第一个只出现一次的字符，而HashMap是无序的，所以需要使用LinkedHashMap（这样保证插入的顺序不变）
	// private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Insert one char from stringstream
    public void Insert(char ch) {
    	Integer value = map.get(ch);
        if(value == null) {
        	value = 1;
        } else {
        	value++;
        }
        
        map.put(ch, value);
    }
    
    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
    	char result = '#';
    	
    	for(Character key : map.keySet()) {
    		if(map.get(key) == 1) {
    			result = key;
    			break;
    		}
    	}
    	
		return result;
    }

}
