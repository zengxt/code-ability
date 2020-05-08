package �ַ���;

/**
 * 
 * @Description: �ж�һ���ַ����Ƿ�����һ�����Ӵ�
 *
 * @author�� zxt
 *
 * @time: 2018��5��2�� ����5:10:15
 *
 */
public class KMP {

	public static void main(String[] args) {
		String str1 = "ababaababacbde";
		String str2 = "ababacb";
		// indexOf�������Ӵ��������е����������������򷵻�-1
		System.out.println(str1.indexOf(str2));

		System.out.println(subSquence(str1, str2));
		
		// getNext("abcabcdd");
		
		System.out.println(kmp(str1, str2));
	}

	/**
	 * 
	 * @Description���ж�ע�������Ƿ�����Ӵ��������򷵻����һ�γ��ֵ����������������򷵻�-1
	 * 
	 * ����˼·��ѭ��������ÿ���ַ���ÿ�δ��Ӵ��ĵ�һ���ַ���ʼ�жϡ�
	 * 
	 * @param str1������
	 * @param str2���Ӵ�
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
	 * @Description:KMP�㷨��������⣬������ѭ�����Ǵ�ͷ��ʼ�������Ӵ���ƥ��ʱ������ÿ�ζ��ƶ���ͷָ�뿪ʼ�����������ϴ��Ѿ�ƥ��Ĳ�����Ϣ
	 * 
	 * @param str1������
	 * @param str2���Ӵ�
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
	 * @Description:��ⲿ��ƥ��ֵ next��ע��next������±��1��ʼ��
	 * 
	 * @param str2
	 * @return
	 */
	public static int[] getNext(String str2) {
		int length = str2.length();
		int j = 0;

		// next��ʾ����Ϊi���ַ���ǰ׺�ͺ�׺����������֣���1��ʼ
		int next[] = new int[length + 1];
		next[0] = next[1] = 0;
		
		// i��ʾ�ַ������±꣬��0��ʼ
		for(int i = 1; i < length; i++) {
			// j��ÿ��ѭ����ʼ����ʾnext[i]��ֵ��ͬʱҲ��ʾ��Ҫ�Ƚϵ���һ��λ��
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
