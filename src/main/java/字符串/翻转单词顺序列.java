package 字符串;

/**
 * 
 * @Description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author： zxt
 *
 * @time: 2018年9月3日 下午1:32:55
 *
 */
public class 翻转单词顺序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseSentence(" "));
	}
	
	/**
	 * 
	 * @Description：要实现所有的单词翻转，但是单词内字符的顺序不变，则可以先把整个句子的所有字符翻转一遍，然后每个单词内部在翻转调整至正确的单词顺序
	 * 
	 * @param str
	 * @return
	 */
	public static String ReverseSentence(String str) {
		//  || str.trim().equals("")  可能存在多个空格的字符串
		if(str == null || str.length() <= 1 || str.trim().equals("")) {
			return str;
		}
		
		// 把字符串转换成字符数组操作
		char[] data = str.toCharArray();
		// 先整体翻转一次
		reverse(data, 0, data.length - 1);
		
		int start = 0;
		int end = 0;
		for(int i = 0; i < data.length; i++) {
			if(i == data.length - 1) {
				reverse(data, start, i);
				
			} else if(data[i] == ' ') {
				end = i - 1;
				reverse(data, start, end);
				start = i + 1;
				// 两个单词之间可能有多个空格
				while(data[start] == ' ') {
					start = ++i;
				}
				
			} else {
				end++;
			}
		}
		
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
	 * @Description：直接使用String内置库函数的方法
	 * 
	 * @param str
	 * @return
	 */
	public static String ReverseSentence2(String str) {
		if(str == null || str.length() <= 1 || str.trim().equals("")) {
			return str;
		}
		
		String[] data = str.split(" ");
		StringBuffer bf = new StringBuffer();
		for(int i = data.length - 1; i >= 0; i++) {
			if(i != 0) {
				bf.append(data[i] + " ");
			} else {
				bf.append(data[i]);
			}
		}
		
		return bf.toString();
	}

}
