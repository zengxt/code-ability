package com.zxt.test2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @Description:����һ��ʮ���Ƶ�������number��ѡ�������ȥ��һ�������֣�ϣ������������������ɵ���������� 
 * 
 * ��������:����Ϊ�������ݣ���һ����������number��1 �� length(number) �� 50000��
 * �ڶ�����ϣ��ȥ������������cnt 1 �� cnt < length(number)��
 * 
 * �������:������������Ľ����
 * 
 * ʾ��������325 1�����35
 *
 * @author�� zxt
 *
 * @time: 2018��7��19�� ����4:22:07
 *
 */
public class ���������� {

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
	 * @Description������ÿȥ��һλ�����ֵ�λ���϶����ˣ�����Ҫ�������ô��������ǰ�ƣ�����ÿ��ȥ����ʱ��ѡ��������ҵ�һ���Ⱥ�������С����
	 * 
	 * @param value
	 * @param cnt
	 * @return
	 */
	public static StringBuffer getMaxRemainValue(StringBuffer value, int cnt) {
		int index = 0;
		
		while(cnt != 0 && index < value.length() && index + 1 < value.length()) {
			// ��ǰλ�õ�����С������һλ������
			if(value.charAt(index) <= value.charAt(index + 1)) {
				value.deleteCharAt(index);
				cnt--;
				// ����ÿ��ɾ��֮���±�ı�
				if(index > 0) {
					index--;
				}
				
			} else {
				index++;
			}
		}
		
		// ���������ѭ����ɾ�������ָ�����û�дﵽҪ��ĸ�������ʣ�µĶ�����߱��ұߴ�����ÿ��ɾ�����һλ
		while(cnt != 0) {
			value.deleteCharAt(value.length() - 1);
			cnt--;
		}
		
		return value;
	}
	
	public static StringBuffer getMaxRemainValue2(StringBuffer value, int cnt) {
		while(cnt != 0) {
			int currentLength = value.length() - 1;
			
			// ��ǰλ�õ�����С������һλ������
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
