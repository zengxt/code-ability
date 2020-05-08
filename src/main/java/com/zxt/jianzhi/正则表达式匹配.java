package com.zxt.jianzhi;

/**
 * 
 * @Description: ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 *  �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 *
 * @author zxt
 *
 * @date 2018��7��1��
 */
public class ������ʽƥ�� {

	public static void main(String[] args) {
		char[] str = {'a', 'a', 'a'};
		char[] pattern = {'a', 'b', '*', 'a', 'c', '*', '.'};
		System.out.println(match(str, pattern));
		
		char[] str1 = { };
		char[] pattern1 = {'.', '*'};
		System.out.println(match(str1, pattern1));
	}
	
	/**
	 * 
	 * @Description: TODO
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null) {
			return false;
		}
		
		return matchCore(str, 0, pattern, 0);
    }
	
	public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		// �ַ���ƥ�����ˣ�����ģʽ��Ҳû����
		if(strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		// pattern�ȵ�β��ƥ��ʧ��
		if(strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		
		// str��β�ˣ�ģʽ��û�е�β������ģʽ���ܿ���ƥ��մ�
		if(strIndex == str.length && patternIndex != pattern.length) {
			while(patternIndex != pattern.length) {
				// ģʽ��ƥ��մ�����Ȼ��Ҫ��*��*�����ڿ�ͷ���ߵڶ�λ������
				if(pattern[patternIndex] != '*' 
						&& (patternIndex + 1 >= pattern.length || pattern[patternIndex + 1] != '*')) {
					return false;
				}
				patternIndex++;
			}
			
			return true;
		}
		
		// �ڶ�λΪ'*'
		if((patternIndex < pattern.length - 1) && pattern[patternIndex + 1] == '*') {
			
			// ��һλƥ��
			if(pattern[patternIndex] == str[strIndex] || 
					(pattern[patternIndex] == '.' && strIndex != str.length)) {
				
						// '*'ǰ�ַ�����һ�Σ��ַ����ж���һ����ģʽ������λ
				return matchCore(str, strIndex + 1, pattern, patternIndex + 2)
						// '*'ǰ�ַ����ֶ�Σ��ַ����ж���һ����ģʽ����ԭλ
					|| matchCore(str, strIndex + 1, pattern, patternIndex)
						// '*'ǰ�ַ�����0�Σ��ַ��������жϵ�ǰһ����ģʽ������λ
					|| matchCore(str, strIndex, pattern, patternIndex + 2);
				
			} else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		
		// �ڶ�λ��Ϊ'*'ʱ����һλƥ�䣬ֱ�Ӽ����ж���һλ�ͺ���
		if(( strIndex != str.length && pattern[patternIndex] == str[strIndex] ) || 
				(pattern[patternIndex] == '.' && strIndex != str.length)) {
			
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		
		return false;
	}
}
