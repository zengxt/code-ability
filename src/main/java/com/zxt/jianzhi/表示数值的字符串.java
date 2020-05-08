package com.zxt.jianzhi;

/**
 * 
 * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author zxt
 *
 * @date 2018年7月1日
 */
public class 表示数值的字符串 {
	private static int index = 0;
	
	public static void main(String[] args) {
		char[] str = {'+','3','.','1','4','1','6'};
		System.out.println(isNumeric(str));
		
		String str2 = "-1E-16";
		index = 0;
		System.out.println(isNumeric(str2.toCharArray()));
		
		String str3 = "1.2.3";
		index = 0;
		System.out.println(isNumeric(str3.toCharArray()));
		
		String str4 = "123.45e+6";
		index = 0;
		System.out.println(isNumeric(str4.toCharArray()));
	}
	
	/**
	 * 
	 * @Description: 数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，其中A和C都是整数
	 * （可以有正负号，也可以没有），而B是一个无符号整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(char[] str) {
		if(str == null) {
			return false;
		}
		
		// 首先数字开头可能有正负号（所以使用带符号的整数扫描）
		// 正负号后面可能有数字或者小数点，先判断数字
		boolean numeric = scanInteger(str);
		
		// 如果出现'.'，则接下来是数字的小数部分
		if(index < str.length && str[index] == '.') {
			index++;
			
			// 下面一行代码用||的原因
			// 1、小数可以没有整数部分，如.123等于0.123
			// 2、小数点后面可以没有数字，如233.等于233.0
			// 3、当然，小数前后都可以有数字，如233.666
			numeric = scanUnsignedInteger(str) || numeric;
		}
		
		// 如果出现'e'或者'E'，则接下来是数字的指数部分（指数部分需为整数，不能是小数）
		if(index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			
			// 下面一行代码用&&的原因
			// 1、当e或E的前面没有数字时，整个字符串不能表示数字，如.e1、e1
			// 2、当e或E的后面没有整数事，整个字符串不能表示数字，如12e、12e+5.4
			numeric = scanInteger(str) && numeric;
		}
		
		return numeric && index == str.length;
    }
	
	/**
	 * 
	 * @Description: 用来扫描字符串中0-9的数位（类似于一个无符号整数）
	 * 
	 * @param str
	 * @param index
	 * @return
	 */
	public static boolean scanUnsignedInteger(char[] str) {
		int start = index;
		while(index < str.length && str[index] >= '0' && str[index] <= '9') {
			index++;
		}
		
		// 是否存在整数
		return start < index;
	}
	
	/**
	 * 
	 * @Description: 扫描可能表示正负的'+'或者'-'为起始的0-9的数位（类似于一个可能带正负符号的整数）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean scanInteger(char[] str) {
		if(index < str.length && (str[index] == '+' || str[index] == '-')) {
			index++;
		}
		
		return scanUnsignedInteger(str);
	}
	
	/**
	 * 
	 * @Description: 挨个字符判断
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric2(char[] str) {
		// 标记正负号、小数点、e是否出现过
		boolean sign = false;
		boolean decimal = false;
		boolean hasE = false;
		
		for(int i = 0; i < str.length; i++) {
			// 如果出现正负号，
			if(str[i] == '+' || str[i] == '-') {
				// 第一次出现'+'或者'-'，且不是在字符串的开头，则必须紧跟在e后面
				if( (!sign && i > 0) && (str[i-1] != 'e' && str[i-1] != 'E')) {
					return false;
				}
				// 第二次出现，只能在e或者E后面
				if( sign && (str[i-1] != 'e' && str[i-1] != 'E') ) {
					return false;
				}
				sign = true;
				
			// 如果出现小数点，只能出现一次，且不能出现在e的后面
			} else if(str[i] == '.') {
				if(decimal || hasE) {
					return false;
				}
				decimal = true;
				
			// 如果出现e或者E
			} else if(str[i] == 'e' || str[i] == 'E') {
				// e只能出现一次
				if(hasE) {
					return false;
				}
				// e后面只能是数字
				if(i == str.length - 1) {
					return false;
				}
				hasE = true;
				
			// 出现不合法字符
			} else if(str[i] < '0' || str[i] > '9') {
				return false;
			}
		}
		
		return true;
	}
}
