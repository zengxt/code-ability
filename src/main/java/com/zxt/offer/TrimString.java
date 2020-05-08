package com.zxt.offer;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @Description: ��дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������ֽ��������Ϊ���ֽڽ�ȡ���ַ�������Ҫ��֤���ֲ�����ȡ�����
 *               �硰��ABC����4��Ӧ�ý�ȡ����AB�������롰��ABC��DEF����6��Ӧ���������ABC���������ǡ���ABC+���İ������
 *
 * @author�� zxt
 *
 * @time: 2018��3��1�� ����9:53:10
 *
 */
public class TrimString {

	// �����ַ��ж��ֱ��룬��������Ҫ�̶����룬GBK����������������ֽڱ�ʾ
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "��ABC��";
		int num = trimGBK(str.getBytes("GBK"), 4);
		System.out.println(str.substring(0, num));
		
		num = trimGBK(str.getBytes("GBK"), 6);
		System.out.println(str.substring(0, num));
	}

	public static int trimGBK(byte[] buf, int n) {
		int num = 0;

		boolean bChineseFirstHalf = false;
		for (int i = 0; i < n; i++) {
			/**
			 * GBK����
			 *  ��һ���ֽ�                			      �ڶ����ֽ�
			 * x81-0xFE��129-254��    |   0x40-0xFE��64-254��
			 * ͨ�����֪����һ���ֽڵķ�Χ��129~254�������Χ�����������λ����1������int���ͽ���ʱ�����λ��1����ζ������һ��������
			 * һ��GBK����Ҫռ����char�ռ�(���ֽڣ������ҵ�һ���ֽ����ֵ��С��0�ġ����Ծݴ��ж��Ƿ�Ϊ���֡�
			 */
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}

		return num;
	}
}
