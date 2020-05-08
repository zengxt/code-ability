package 字符串;

/**
 * 
 * @Description: 判断一个字符串是否是另一个的子串
 *
 * @author： zxt
 *
 * @time: 2018年5月2日 下午5:10:15
 *
 */
public class KMP {

	public static void main(String[] args) {
		String str1 = "ababaababacbde";
		String str2 = "ababacb";
		// indexOf：返回子串在主串中的索引，若不存在则返回-1
		System.out.println(str1.indexOf(str2));

		System.out.println(subSquence(str1, str2));
		
		// getNext("abcabcdd");
		
		System.out.println(kmp(str1, str2));
	}

	/**
	 * 
	 * @Description：判断注主串中是否包含子串，包含则返回其第一次出现的索引，若不包含则返回-1
	 * 
	 * 基本思路：循环主串的每个字符，每次从子串的第一个字符开始判断。
	 * 
	 * @param str1：主串
	 * @param str2：子串
	 * @return
	 */
	public static int subSquence(String str1, String str2) {
		if (str1.isEmpty() || str2.isEmpty() || str1.length() == 0 || str2.length() == 0) {
			return -1;
		}

		int j = 0;
		for (int i = 0; i < str1.length(); i++) {
			for (j = 0; j < str2.length(); j++) {

				if (str1.charAt(i + j) != str2.charAt(j)) {
					break;
				}
			}

			if (j == str2.length()) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 
	 * @Description:KMP算法解决此问题，主串的循环还是从头开始，但是子串不匹配时，不是每次都移动到头指针开始，而是利用上次已经匹配的部分信息
	 * 
	 * @param str1：主串
	 * @param str2：子串
	 * @return
	 */
	public static int kmp(String str1, String str2) {
		if (str1.isEmpty() || str2.isEmpty() || str1.length() == 0 || str2.length() == 0) {
			return -1;
		}
		
		int[] next = getNext(str2);
		
		int index = 0;
		for(int i = 0; i < str1.length(); i++) {
			while(index > 0 && str1.charAt(i) != str2.charAt(index)) {
				index = next[index];
			}
			
			if(str1.charAt(i) == str2.charAt(index)) {
				index++;
			}
			
			if(index == str2.length()) {
				return i - index + 1;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @Description:求解部分匹配值 next【注意next数组的下标从1开始】
	 * 
	 * @param str2
	 * @return
	 */
	public static int[] getNext(String str2) {
		int length = str2.length();
		int j = 0;

		// next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
		int next[] = new int[length + 1];
		next[0] = next[1] = 0;
		
		// i表示字符串的下标，从0开始
		for(int i = 1; i < length; i++) {
			// j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
			while(j > 0 && str2.charAt(i) != str2.charAt(j)) {
				j = next[j];
			}
			
			if(str2.charAt(i) == str2.charAt(j)) {
				j++;
			}
			
			next[i + 1] = j;
		}

		return next;
	}
}
