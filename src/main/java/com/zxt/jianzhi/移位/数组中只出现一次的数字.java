package com.zxt.jianzhi.��λ;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description: һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 *
 * @author�� zxt
 *
 * @time: 2018��6��22�� ����10:46:02
 *
 */
public class ������ֻ����һ�ε����� {

	public static void main(String[] args) {
		int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0]);
		System.out.println(num2[0]);
		
		
		int[] num3 = new int[1];
		int[] num4 = new int[1];
		
		FindNumsAppearOnce2(array, num3, num4);
		System.out.println(num3[0]);
		System.out.println(num4[0]);
	}

	/**
	 * 
	 * @Description��ʹ��������㣨������㣺��ͬΪ0��������ͬ����������Ϊ0�������������ֻ��һ�����ֳ���һ�Σ��������Σ���������򼴿ɣ�
	 * �������������������ֳ���һ�Σ�����������Ρ�����������ֳ������֣�һ����ֻ����һ������һ�ε����֣�������ͬ�����ֵַ�ͬһ�飩
	 * ����˼·���Ƚ�������ÿ������������򣬵õ�һ��������ҵ������������Ʊ�ʾ������һλ1���Ǹ�λ��Ϊn���������ж����������֣���λ��ֵ��Ϊ0��һ�飬Ϊ1��һ��
	 * ����е�nλΪ1����ʾֻ����һ�ε��������ֵĵ�nλ��ͬ������ͬ���ֵ���ͬλ�Ķ����ƿ϶���ͬ����˳������ε����ֻ�ֵ�ͬһ�飩
	 * 
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if(array.length < 2) {
			return;
		}
		
		// ���������һ�飨ʵ�ʽ����ֻ����һ�ε����������������
		int resultExclusiveOR = 0;
		for(int i = 0; i < array.length; i++) {
			resultExclusiveOR ^= array[i];
		}
		
		// ������������һ��1��λ��
		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		
		num1[0] = num2[0] = 0;
		for(int i = 0; i < array.length; i++) {
			if(isBit1(array[i], indexOf1)) {
				num1[0] ^= array[i];
				
			} else {
				num2[0] ^= array[i];
			}
		}
	}
	
	/**
	 * 
	 * @Description:����һ���������һ��������Ϊ1��λ��
	 * 
	 * @param num
	 * @return
	 */
	public static int findFirstBitIs1(int num) {
		int indexBit = 0;
		while(((num & 1) == 0) && (indexBit < 8 * 4)) {
			num = num >> 1;
			indexBit++;
		}
		
		return indexBit;
	}
	
	/**
	 * 
	 * @Description:�ж�һ�����Ķ�����ĳλ�Ƿ�Ϊ1
	 * 
	 * @param num
	 * @param indexBit
	 * @return
	 */
	public static boolean isBit1(int num, int indexBit) {
		
		num = num >> indexBit;
		return (num & 1) == 1;
	}
	
	/**
	 * 
	 * @Description��ʹ��Java���ü�����������
	 * 
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public static void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < array.length; i++) {
			if(list.contains(String.valueOf(array[i]))) {
				list.remove(String.valueOf(array[i]));
				
			} else {
				list.add(String.valueOf(array[i]));
			}
		}
		
		if(list.size() == 2) {
			num1[0] = Integer.parseInt(list.get(0));
			num2[0] = Integer.parseInt(list.get(1));
		}
	}

}
