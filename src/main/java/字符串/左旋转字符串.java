package �ַ���;

/**
 * 
 * @Description: �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 *
 * @author�� zxt
 *
 * @time: 2018��9��2�� ����10:09:33
 *
 */
public class ����ת�ַ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LeftRotateString2("abcXYZdef", 3));
	}
	
	/**
	 * 
	 * @Description�������ڷ�ת����˳���е�˼·���ȷ�תǰһ�����ַ���Ҫ�ŵ�����ģ����ٷ�ת������ַ�����������ַ������巭ת
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
	 * @Description����ʾ��תһ�����ʵ������ַ�������ȻҲ���������仰��
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
	 * @Description��ʹ�����ú����ķ�����һ�������в�����ʹ�ã�
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
