package com.zxt.offer;

/**
 * 
 * @Description: ���ת�������������ֵĽ��ת�����й���ͳ����ʽ�磺����1011����>��һǧ��һʰһԪ���������
 *
 * @author�� zxt
 *
 * @time: 2018��3��2�� ����2:54:05
 *
 */
public class ChangeMoney {

	private static final char[] data = { '��', 'Ҽ', '��', '��', '��', '��', '½', '��', '��', '��' };
	private static final char[] units = { 'Ԫ', 'ʰ', '��', 'Ǫ', '��', 'ʰ', '��', 'Ǫ', '��' };

	public static void main(String[] args) {
		System.out.println(convert(135689123));
	}
	
	public static String convert(int money) {
		StringBuffer buf = new StringBuffer();
		
		int unit = 0;
		while(money != 0) {
			buf.insert(0, units[unit++]);
			int number = money % 10;
			buf.insert(0, data[number]);
			money /= 10;
		}
		
		return buf.toString() + "��";
	}
}
