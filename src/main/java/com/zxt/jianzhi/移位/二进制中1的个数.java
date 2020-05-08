package com.zxt.jianzhi.��λ;

/**
 * 
 * @Description: ����һ���������������Ķ����Ʊ�ʾ��1�ĸ�����
 *
 * @author�� zxt
 *
 * @time: 2018��6��21�� ����4:10:40
 *
 */
public class ��������1�ĸ��� {

	public static void main(String[] args) {
		int n = 16786582;
		System.out.println(numberOf1(n));
		System.out.println(numberOf2(n));
		System.out.println(numberOf3(n));
	}
	
	/**
	 * 
	 * @Description��ÿ���ж϶����Ʊ�ʾ������һλ�Ƿ�Ϊ1����1�� �� �������ɣ�������һλ��ÿ���ж������Ƽ���
	 * ���ַ���ֻ����������������Ϊ���������Ƹ�λ��1����������ѭ�� (���޷��ж�)
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf1(int n) {
		int count = 0;
		
		while(n > 0) {
			if((n & 1) == 1) {
				count++;
			}
			
			n = n >> 1;
		}
		
		return count;
	}
	
	/**
	 * 
	 * @Description����һ�������ǽ������ƣ�ÿ���ж�����λ���޷������������ڿ��ǽ�1���ƣ�������λ��ʼһ���ж��������
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf2(int n) {
		int count = 0;
		int flag = 1;
		
		while(flag > 0) {
			if((n & flag) > 0) {
				count++;
			}
			
			flag = flag << 1;
		}
		
		return count;
	}
	
	/**
	 * 
	 * @Description�����ٷ����������������м���1���������㼸�μ��ɡ�
	 * ˼·��һ���� �� ����-1 ����������൱�ڰ���������ұߵ�1ȡ����Ϊ0��
	 * ��������������һλΪ1����1֮���Ϊ0������λ����ı䣬�����֮���൱������һλ��Ϊ0
	 *     �������ұߵ�1��������һλ���������mλΪ1�����������1֮��mλ��Ϊ0��mΪ�ұ߶����ԭ���ķ���mλ��߲���
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf3(int n) {
		int count = 0;
		
		while(n != 0) {
			count++;
			n = (n - 1) & n;
		}
		
		return count;
	}

}
