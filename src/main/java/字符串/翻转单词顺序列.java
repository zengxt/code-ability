package �ַ���;

/**
 * 
 * @Description: ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼�����磬��student. a am I����
 * ��������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 *
 * @author�� zxt
 *
 * @time: 2018��9��3�� ����1:32:55
 *
 */
public class ��ת����˳���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReverseSentence(" "));
	}
	
	/**
	 * 
	 * @Description��Ҫʵ�����еĵ��ʷ�ת�����ǵ������ַ���˳�򲻱䣬������Ȱ��������ӵ������ַ���תһ�飬Ȼ��ÿ�������ڲ��ڷ�ת��������ȷ�ĵ���˳��
	 * 
	 * @param str
	 * @return
	 */
	public static String ReverseSentence(String str) {
		//  || str.trim().equals("")  ���ܴ��ڶ���ո���ַ���
		if(str == null || str.length() <= 1 || str.trim().equals("")) {
			return str;
		}
		
		// ���ַ���ת�����ַ��������
		char[] data = str.toCharArray();
		// �����巭תһ��
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
				// ��������֮������ж���ո�
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
	 * @Description��ֱ��ʹ��String���ÿ⺯���ķ���
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
