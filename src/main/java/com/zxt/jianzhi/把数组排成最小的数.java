package com.zxt.jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @Description: ����һ�����������飬�����������е�����ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ����{3�� 32�� 321}�����ӡ����С���321323.
 *
 * @author�� zxt
 *
 * @time: 2018��7��24�� ����5:12:04
 *
 */
public class �������ų���С���� {
	
	/**
	 * 
	 * @Description������һ��Ǳ�ڵ�������Ҫ���ǣ��Ǿ��������������֮������޷�����������int���������ʾ������Ҫ���ַ���������һ����������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {3, 32, 321};
		
		System.out.println(minNumber(array));
	}
	
	/**
	 * 
	 * @Description����������A��B�ֱ�ǰ����ϣ���AB��BA����AB < BA����AС��B����ӡ��С����ʱ��A��Ҫ����ǰ��
	 * 
	 * @param array
	 * @return
	 */
	public static String minNumber(int[] array) {
		if(array == null || array.length == 0) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		
		// �Զ��������������
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer integer1, Integer integer2) {
				String str1 = integer1 + "" + integer2;
				String str2 = integer2 + "" + integer1;
				return str1.compareTo(str2);
			}
		});
		
		StringBuffer bf = new StringBuffer();
		for(int i = 0; i < list.size(); i++) {
			bf.append(list.get(i));
		}
		
		return bf.toString();
	}

}
