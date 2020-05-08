package com.zxt.jianzhi.��λ;

/*
 * java��λ���������
 * ���ȣ���λ����������֣����������ֻ֧�֣�byte / short / char / int��long���֡�
 * <<	���������������ʾ����ߵĲ������Ķ��������������ƶ�nλ���ƶ����ȱλ��0��䣬����λ����������ͬ�ڳ�2��n�η���
 * >>	����������������������������ƶ�nλ������ͬ�ڳ�2��n�η���  >>�Ǵ��������ƣ�������λ��1��������0
 * >>>	���޷�������������������ƶ�ǰ���λ��0����1�����ƺ��������Ŀ�λ���ֶ���0����䡣
 */
public class MoveBitTest {

	public static void main(String[] args) {
		int a = 13;
		System.out.println("�ƶ�ǰ a = " + a + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(a));

		int b = a << 2; // a������λ���൱��a * 2��2�η�
		System.out.println("���ƺ� a = " + b + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(b));

		int c = a >> 2; // a������λ���൱��a / 2��2�η�
		System.out.println("���ƺ� a = " + c + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(c));

		int d = -12;
		System.out.println("�ƶ�ǰ d = " + d + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(d));
		System.out.println(bitInfo(d));

		// ����������
		int e = d >> 2;
		System.out.println("���������ƺ� d = " + e + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(e));
		// �޷�������
		int f = d >>> 2;
		System.out.println("�޷������ƺ� d = " + f + ", �����Ʊ�ʾΪ��" + Integer.toBinaryString(f));
		
		System.out.println("=======================================================");
		/**
		 * ����int������ֻ��32λ��long������64λ�����Ե���λ�����ƶ���λ������32����64ʱ��ϵͳ����һ���Ĵ���
		 * ʵ���ϵ�  ��������Ϊint����ʱ���Ҳ������ֻ�е�5λ��Ч������0-31�����൱���Ҳ����������0x1f���루&��������������
		 * ���Ҳ������Ϊlong����ʱ���Ҳ������ֻ�е�6λ��Ч������0-63�����൱���Ҳ����������0x3f���루&��������������
		 */
		int i = 20;
		int j = 30;
		System.out.println("i << 3 = " + (i << 3));
		System.out.println("i << -29 = " + (i << -29));
		String str = Integer.toBinaryString(-29);
		System.out.println("-29��" + str + "�����5λΪ��" + str.substring(str.length() - 5));
		System.out.println("j >> 70 = " + (j >> 70));
		
		System.out.println("=======================================================");
		/**
		 * �������㣬����������ʱ�������0�ķ������룬��������ʱ�������룬����ʱ��������     9/2 = 4      -9/2 = -4
		 * ��������ʼ������������ģ����Ի�����������2^n�Ľ������ȵ����   9>>1 = 4    -9>>1 = -5
		 */
		System.out.println("9 >> 1 = " + (9 >> 1) + " and 9 / 2 = " + (9 / 2));
		System.out.println("-9 >> 1 = " + (-9 >> 1) + " but -9 / 2 = " + (-9 / 2));
	}
	
	private static String bitInfo(int num) {
		StringBuffer str = new StringBuffer();
		
		String binaryStr = Integer.toBinaryString(num);
		int i = 0;
		while(i < binaryStr.length()) {
			str.append(binaryStr.substring(i, i+4));
			str.append(" ");
			i += 4;
		}
		
		return str.toString();
	}
}