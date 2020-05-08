package 字符串;

/**
 * 
 * @Description: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author： zxt
 *
 * @time: 2018年9月2日 下午10:09:33
 *
 */
public class 左旋转字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LeftRotateString2("abcXYZdef", 3));
	}
	
	/**
	 * 
	 * @Description：类似于翻转单词顺序列的思路：先翻转前一部分字符（要放到后面的），再翻转后面的字符，最后整个字符串整体翻转
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public static String LeftRotateString2(String str, int n) {
		if(str == null || n > str.length()) {
			return str;
		}
		
		char[] data = str.toCharArray();
		reverse(data, 0, n - 1);
		reverse(data, n, data.length - 1);
		reverse(data, 0, data.length - 1);
		
		return new String(data);
	}
	
	/**
	 * 
	 * @Description：表示翻转一个单词的左右字符，（当然也可以是整句话）
	 * 
	 * @param array
	 */
	public static void reverse(char[] array, int start, int end) {
		if(array == null || array.length == 1) {
			return ;
		}
		
		while(start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			
			start++;
			end--;
		}
	}
	
	/**
	 * 
	 * @Description：使用内置函数的方法（一般面试中不可以使用）
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public static String LeftRotateString(String str,int n) {
		if(str == null || n > str.length()) {
			return null;
		}
		
		StringBuffer result = new StringBuffer(str.substring(n, str.length()));
		result.append(str.substring(0, n));
		
		return result.toString();
    }

}
