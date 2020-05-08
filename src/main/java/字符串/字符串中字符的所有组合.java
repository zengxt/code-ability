package 字符串;

import java.util.ArrayList;

/**
 * 
 * @Description: 给定一个字符串，求出其所有可能的字符组合． 比如：abc 其所有组合是:a, b, c, ab, ac, bc, abc
 *
 * @author： zxt
 *
 * @time: 2018年5月3日 上午11:32:49
 *
 */
public class 字符串中字符的所有组合 {

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> list = new ArrayList<String>();
		
		// 将参数转换为StringBuffer是因为StringBuffer可以修改，而String不可以
		// allCombination(new StringBuffer(str), list);
		
		// 要求一个字符串的字符的所有组合，则子串的长度应该从 1 到 字符串本身长度
		for(int i = 1; i <= str.length(); i++) {
			StringBuffer temp = new StringBuffer();
			combinationAll(new StringBuffer(str), list, 0, i, temp);
		}
		
		System.out.println(list);
	}
	
	/**
	 * 
	 * @Description:基本思路：拿到一个字符串，首先输出自己  abc， 然后依次去除字符串中一个字符得到：ab、ac、bc，再去除一个，得到：a、b、c，无法再去
	 * 
	 * @param sb
	 * @param list
	 * @return
	 */
	public static void allCombination(StringBuffer sb, ArrayList<String> list) {
		if(sb.length() == 0) {
			return ;
			
		} else {
			if(!list.contains(sb.toString())) {
				list.add(sb.toString());
			}
		}
		
		for(int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			
			allCombination(sb, list);
			
			//从i处删除，则从i处添加
			sb.insert(i, c);
		}
	}
	
	/**
	 * 
	 * @Description:另一种思路：同样是用递归求解。可以考虑求长度为n的字符串中m个字符的组合，设为C(n,m)。
	 * 				原问题的解即为C(n, 1), C(n, 2),...C(n, n)的总和。
	 * 				对于求C(n, m)，从第一个字符开始扫描，每个字符有两种情况，要么被选中，要么不被选中，如果被选中，递归求解C(n-1, m-1)。
	 * 				如果未被选中，递归求解C(n-1, m)。不管哪种方式，n的值都会减少，递归的终止条件n=0或m=0。
	 * 
	 * @param sb
	 * @param list
	 * @param index：当前需要被处理的元素：选择  or 不选择
	 * @param subLength：子字符串的长度
	 * @param temp：当前选中的字符集合
	 */
	public static void combinationAll(StringBuffer sb, ArrayList<String> list, 
			int index, int subLength, StringBuffer temp) {

		// 选择的字符串长度和要求的长度一致
		if(0 == subLength && !list.contains(temp.toString())) {
			list.add(temp.toString());
			return ;
		}
	
		// sb为空或者 判断完了所有的字符  (  如果这个条件先判断则要改成： (index == sb.length() && 0 != subLength) )
		// 因为有可能选择了最后一个字符，然后符合了条件，所以......
		if(sb.length() == 0 || index == sb.length()) {
			return ;
		}

		// 不管当前字符是否选择，下一个要判断的字符不变
		// 选择当前字符
		temp.append(sb.charAt(index));
		combinationAll(sb, list, index + 1, subLength - 1, temp);
		temp.deleteCharAt(temp.length() - 1);

		// 不选择当前字符
		combinationAll(sb, list, index + 1, subLength, temp);
	}
}
