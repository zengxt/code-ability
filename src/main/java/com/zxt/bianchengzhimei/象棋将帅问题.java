package com.zxt.bianchengzhimei;

/**
 * 
 * @Description: ֻ��һ���ֽڵĴ洢�ռ䣬����˧�����п��ܵ�������
 * ��һ��˼·�ǣ���˧��ֻ��9�п���λ�ã��ֱ���4bitλ���ɱ�ʾ�����Խ�һ�ֽڷ�Ϊ�ߵ�Ϊ���ָ���λ���洢��˧��λ�ã�
 *
 * @author�� zxt
 *
 * @time: 2018��6��26�� ����11:25:05
 *
 */
public class ���彫˧���� {

	public static void main(String[] args) {
		byte flag = 81;
		while(flag-- > 0) {
			// System.out.println(flag / 9 + "  " + flag % 9);
			if( (flag / 9) % 3 == (flag % 9) % 3 ) {
				continue;
			}
			System.out.println("A = " + (flag / 9 + 1) + ", " + (flag % 9 + 1));
		}
	}

}
