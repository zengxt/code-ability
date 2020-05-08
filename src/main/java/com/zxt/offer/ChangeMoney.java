package com.zxt.offer;

/**
 * 
 * @Description: 金额转换，阿拉伯数字的金额转换成中国传统的形式如：（￥1011）－>（一千零一拾一元整）输出。
 *
 * @author： zxt
 *
 * @time: 2018年3月2日 下午2:54:05
 *
 */
public class ChangeMoney {

	private static final char[] data = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
	private static final char[] units = { '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿' };

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
		
		return buf.toString() + "整";
	}
}
