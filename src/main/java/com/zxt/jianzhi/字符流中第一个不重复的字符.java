package com.zxt.jianzhi;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 
 * @Description: ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 *
 * @author�� zxt
 *
 * @time: 2018��8��26�� ����3:04:33
 *
 */
public class �ַ����е�һ�����ظ����ַ� {

	// ����Ҫ�󷵻ص�һ��ֻ����һ�ε��ַ�����HashMap������ģ�������Ҫʹ��LinkedHashMap��������֤�����˳�򲻱䣩
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
