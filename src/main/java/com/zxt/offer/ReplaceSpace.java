package com.zxt.offer;

/*
 * ��һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("We Are Happy");
		
		ReplaceSpace rs = new ReplaceSpace();
		System.out.println(rs.replaceSpace(str));
	}
	
	public String replaceSpace(StringBuffer str) {
    	return str.toString().replaceAll(" ", "%20");
    }
}
