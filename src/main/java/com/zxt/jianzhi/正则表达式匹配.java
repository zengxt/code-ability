package com.zxt.jianzhi;

/**
 * 
 * @Description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 *  在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @author zxt
 *
 * @date 2018年7月1日
 */
public class 正则表达式匹配 {

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
		// 字符串匹配完了，并且模式串也没有了
		if(strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		// pattern先到尾，匹配失败
		if(strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		
		// str到尾了，模式串没有到尾，但是模式可能可以匹配空串
		if(strIndex == str.length && patternIndex != pattern.length) {
			while(patternIndex != pattern.length) {
				// 模式串匹配空串，必然是要有*，*出现在开头或者第二位都可以
				if(pattern[patternIndex] != '*' 
						&& (patternIndex + 1 >= pattern.length || pattern[patternIndex + 1] != '*')) {
					return false;
				}
				patternIndex++;
			}
			
			return true;
		}
		
		// 第二位为'*'
		if((patternIndex < pattern.length - 1) && pattern[patternIndex + 1] == '*') {
			
			// 第一位匹配
			if(pattern[patternIndex] == str[strIndex] || 
					(pattern[patternIndex] == '.' && strIndex != str.length)) {
				
						// '*'前字符出现一次，字符串判断下一个，模式串跳两位
				return matchCore(str, strIndex + 1, pattern, patternIndex + 2)
						// '*'前字符出现多次，字符串判断下一个，模式串在原位
					|| matchCore(str, strIndex + 1, pattern, patternIndex)
						// '*'前字符出现0次，字符串继续判断当前一个，模式串跳两位
					|| matchCore(str, strIndex, pattern, patternIndex + 2);
				
			} else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		
		// 第二位不为'*'时，第一位匹配，直接继续判断下一位就好了
		if(( strIndex != str.length && pattern[patternIndex] == str[strIndex] ) || 
				(pattern[patternIndex] == '.' && strIndex != str.length)) {
			
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		
		return false;
	}
}
