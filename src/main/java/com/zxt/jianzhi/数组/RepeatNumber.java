package com.zxt.jianzhi.����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
 * ���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 *
 * @author�� zxt
 *
 * @time: 2018��3��4�� ����5:41:46
 *
 */
public class RepeatNumber {

	public static void main(String[] args) {
		int[] arr = {2,3,1,0,2,5,3};
		
		System.out.println(repeatNumbers(arr));
		
		int[] duplication = new int[arr.length];
		System.out.println(duplicate(arr, duplication));
		System.out.println(Arrays.toString(duplication));
	}
	
	/**
	 * ����һ��ʹ��Map���������ֵ��Ϊkeyֵ��Ȼ���¼������ÿ�����ֵĳ��ִ�����������ж��Ƿ��ظ�
	 */
	public static ArrayList<Integer> repeatNumbers(int[] arr) {
		if(arr == null) {
			return null;
		}
		
		// �жϱ߽磬��ֹ����
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0 || arr[i] > arr.length - 1) {
				return null;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i < arr.length; i++) {
			Integer value = map.get(arr[i]);
			if(value == null) {
				value = 0;
			} else {
				list.add(arr[i]);
			}
			map.put(arr[i], value + 1);
		}
		
		return list;
	}
	
	/**
	 * ����������������涨�������е�������0��n-1�ķ�Χ�ڣ�������������û���ظ���������������±��ֵʼ�����
	 * ����Դ�ͷɨ�������е�ÿ�����֣������±�Ϊi����ֵΪm����m == i������һ����
	 * ���±�����ֵ����ȣ����ж��±�m��Ӧ����ֵ�Ƿ���m��ȣ������򽻻��������ʾ�ظ��ˣ���Ϊ�±�Ϊi��mλ�ö�Ӧ�Ķ���m
	 */
	public static boolean duplicate(int[] numbers, int[] duplication) {
		if(numbers == null) {
			return false;
		}
		
		int index = 0;
		for(int i = 0; i < numbers.length; i++) {
			// �±����Ӧֵ����
			while(numbers[i] != i) {
				// i �� numbers[i] λ�õ�ֵ�ظ�
				if(numbers[i] == numbers[numbers[i]]) {
					duplication[index++] = numbers[i];
					return true;
				}
				
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		
		return false;
    }
}