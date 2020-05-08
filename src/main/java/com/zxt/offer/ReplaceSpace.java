package com.zxt.offer;

/*
 * 将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
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
