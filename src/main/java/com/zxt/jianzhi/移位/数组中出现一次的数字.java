package com.zxt.jianzhi.��λ;

/**
 * 
 * @Description: ��һ�������г���һ������ֻ������һ��֮�⣬�������ֶ����������Ρ����ҳ��������
 *
 * @author�� zxt
 *
 * @time: 2018��6��22�� ����5:12:32
 *
 */
public class �����г���һ�ε����� {

	public static void main(String[] args) {
		int[] array = {2, 4, 7, 8, 9, 8, 9, 4, 4, 2, 8, 9, 2};
		
		System.out.println(onlyAppearOnce(array));
	}
	
	/**
	 * 
	 * @Description������ֻ��һ��������һ�Σ����඼�������Σ������������������ֶ����Ʊ�ʾ��ÿһλ����������
	 * ���ĳһλ�ĺͿ��Ա�3�������Ǹ�ֻ����һ�ε����ֵ���һλ������ҲΪ0������Ϊ1
	 * 
	 * @param array
	 * @return
	 */
	public static int onlyAppearOnce(int[] array) {
		if(array.length <= 0) {
			System.out.println("Input error!!");
		}
		
		int[] bitSum = new int[32];
		for(int i = 0; i < 32; i++) {
			bitSum[i] = 0;
		}
		
		// ������ÿ�������
		for(int j = 0; j < array.length; j++) {
			int bitMask = 1;
			// ��λ�ں󣬸�λ��ǰ
			for(int i = 31; i >= 0; i--) {
				int bit = array[j] & bitMask;
				if(bit != 0) {
					bitSum[i] += 1;
				}
				bitMask = bitMask << 1;
			}
		}
		
		int result = 0;
		for(int i = 0; i < 32; i++) {
			result = result << 1;
			result += bitSum[i] % 3;
		}
		
		return result;
	}
}
