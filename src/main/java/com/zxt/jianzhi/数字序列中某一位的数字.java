package com.zxt.jianzhi;

/**
 * 
 * @Description: ������0123456789101112131415�������ĸ�ʽ���л���һ���ַ������С���������к��У�����λ����0��ʼ��������5����13λ��1��
 *               ��19λ��4���ȵȣ�дһ�������������nλ��Ӧ�����֡�
 *
 * @author�� zxt
 *
 * @time: 2018��7��23�� ����4:45:07
 *
 */
public class ����������ĳһλ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digitAtIndex(0));  // 0
		System.out.println(digitAtIndex(5));  // 5
		System.out.println(digitAtIndex(9));  // 9
		System.out.println(digitAtIndex(10)); // 1
		System.out.println(digitAtIndex(11)); // 0
		System.out.println(digitAtIndex(13)); // 1
		System.out.println(digitAtIndex(17));  // 3
		System.out.println(digitAtIndex(190));  // 1
		
		System.out.println("----------------------------");
		System.out.println(getNNum(0));  // 0
		System.out.println(getNNum(5));  // 5
		System.out.println(getNNum(9));  // 9
		System.out.println(getNNum(10)); // 1
		System.out.println(getNNum(11)); // 0
		System.out.println(getNNum(13)); // 1
		System.out.println(getNNum(17));  // 3
		System.out.println(getNNum(190));  // 1
	}

	/**
	 * 
	 * @Description��0-9��10����10-99��90����100-999��900����......���������жϳ�n���������䣬Ȼ���ټ����������λ��
	 * 
	 * ���磺��1001λ��ǰ10λ��0-9������ֱ����������������180λ������90��10-99��Ҳֱ��������1001 - 10 - 180 = 811
	 * ��������2700λ������900��100-999����λ��������811 < 2700�����Ե�811λ��ĳ����λ���е�һλ
	 * ����811 = 270*3+1������ζ�ŵ�811λ�Ǵ�100��ʼ�ĵ�270�����֣���370���м�һλ��Ҳ����7
	 * 
	 * @param n
	 * @return
	 */
	public static int getNNum(int n) {
		// ���������ֵ�λ��
		int digits = 1;
		
		int lengthDigit = 10;
		while (n >= lengthDigit * digits) {
			n -= lengthDigit * digits;
			
			digits++;
			lengthDigit = (int) (9 * Math.pow(10, digits - 1));
		}

		// num��ʾ��nλ��Ӧ���������ڵ��ĸ�����start��ʾ������ʼ��ֵ��
		int start = digits == 1 ? 0 : (int) Math.pow(10, digits - 1);
		int num = start + n / digits;
		// �ڸ������ĸ�����
		int index = n % digits;

		return Integer.valueOf((num + "").charAt(index) - '0');
	}
	
	public static int digitAtIndex(int index) {
		if(index < 0) {
			return -1;
		}
		
		int digits = 1;
		while(true) {
			int numbers = countOfIntegers(digits);
			if(index < numbers * digits) {
				return digitAtIndex(index, digits);
			}
			
			index -= digits * numbers;
			digits++;
		}
	}
	
	/**
	 * 
	 * @Description������mλ�������ܹ��ж��ٸ�����������2�����أ�10-99���ĸ���90
	 * 
	 * @param digits
	 * @return
	 */
	public static int countOfIntegers(int digits) {
		if(digits == 1) {
			return 10;
		}
		
		int count = (int) Math.pow(10, digits - 1);
		return count * 9;
	}
	
	/**
	 * 
	 * @Description������mλ�������俪ͷ���ֵ�ֵ��������λ����10����λ����100
	 * 
	 * @param digits
	 * @return
	 */
	public static int beginNumber(int digits) {
		if(digits == 1) {
			return 0;
		}
		
		return (int) Math.pow(10, digits - 1);
	}
	
	/**
	 * 
	 * @Description���Ѿ��ҵ�ĳλ��������mλ����������
	 * 
	 * @param index
	 * @param digits
	 * @return
	 */
	public static int digitAtIndex(int index, int digits){
		int number = beginNumber(digits) + index / digits;
		int indexFromRight = digits - index % digits;
		for(int i = 1; i < indexFromRight; i++) {
			number /= 10;
		}
		
		return number % 10;
	}
	
}
