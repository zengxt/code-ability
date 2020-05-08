package com.zxt.jianzhi;

/**
 * 
 * @Description: ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 *
 * @author zxt
 *
 * @date 2018��7��1��
 */
public class ��ʾ��ֵ���ַ��� {
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
	 * @Description: ���ֵĸ�ʽ������A[.[B]][e|EC]����.B[e|EC]��ʾ������A��C��������
	 * �������������ţ�Ҳ����û�У�����B��һ���޷�������
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(char[] str) {
		if(str == null) {
			return false;
		}
		
		// �������ֿ�ͷ�����������ţ�����ʹ�ô����ŵ�����ɨ�裩
		// �����ź�����������ֻ���С���㣬���ж�����
		boolean numeric = scanInteger(str);
		
		// �������'.'��������������ֵ�С������
		if(index < str.length && str[index] == '.') {
			index++;
			
			// ����һ�д�����||��ԭ��
			// 1��С������û���������֣���.123����0.123
			// 2��С����������û�����֣���233.����233.0
			// 3����Ȼ��С��ǰ�󶼿��������֣���233.666
			numeric = scanUnsignedInteger(str) || numeric;
		}
		
		// �������'e'����'E'��������������ֵ�ָ�����֣�ָ��������Ϊ������������С����
		if(index < str.length && (str[index] == 'e' || str[index] == 'E')) {
			index++;
			
			// ����һ�д�����&&��ԭ��
			// 1����e��E��ǰ��û������ʱ�������ַ������ܱ�ʾ���֣���.e1��e1
			// 2����e��E�ĺ���û�������£������ַ������ܱ�ʾ���֣���12e��12e+5.4
			numeric = scanInteger(str) && numeric;
		}
		
		return numeric && index == str.length;
    }
	
	/**
	 * 
	 * @Description: ����ɨ���ַ�����0-9����λ��������һ���޷���������
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
		
		// �Ƿ��������
		return start < index;
	}
	
	/**
	 * 
	 * @Description: ɨ����ܱ�ʾ������'+'����'-'Ϊ��ʼ��0-9����λ��������һ�����ܴ��������ŵ�������
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
	 * @Description: �����ַ��ж�
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric2(char[] str) {
		// ��������š�С���㡢e�Ƿ���ֹ�
		boolean sign = false;
		boolean decimal = false;
		boolean hasE = false;
		
		for(int i = 0; i < str.length; i++) {
			// ������������ţ�
			if(str[i] == '+' || str[i] == '-') {
				// ��һ�γ���'+'����'-'���Ҳ������ַ����Ŀ�ͷ������������e����
				if( (!sign && i > 0) && (str[i-1] != 'e' && str[i-1] != 'E')) {
					return false;
				}
				// �ڶ��γ��֣�ֻ����e����E����
				if( sign && (str[i-1] != 'e' && str[i-1] != 'E') ) {
					return false;
				}
				sign = true;
				
			// �������С���㣬ֻ�ܳ���һ�Σ��Ҳ��ܳ�����e�ĺ���
			} else if(str[i] == '.') {
				if(decimal || hasE) {
					return false;
				}
				decimal = true;
				
			// �������e����E
			} else if(str[i] == 'e' || str[i] == 'E') {
				// eֻ�ܳ���һ��
				if(hasE) {
					return false;
				}
				// e����ֻ��������
				if(i == str.length - 1) {
					return false;
				}
				hasE = true;
				
			// ���ֲ��Ϸ��ַ�
			} else if(str[i] < '0' || str[i] > '9') {
				return false;
			}
		}
		
		return true;
	}
}
