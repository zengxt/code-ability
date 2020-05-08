package com.zxt.test2017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ������ţţ����ҵ������һ������Ϊ n ������ A��������а����˴�1��n��n������������ΪһЩԭ��������һЩλ�ã������� 10 �����������ˣ�
 * ����ţţ�ǵ��������˳��Ե������� k��˳�����ָ���� i < j �� A[i] < A[j] �Ķ����������ţţ��������������Ҫ��ĺϷ����е���Ŀ��
 * 
 * ��������:ÿ���������һ������������ÿ�����������ĵ�һ�а����������� n �� k��1 <= n <= 100, 0 <= k <= 1000000000����
 * �������� 1 �У����� n �����ֱ�ʾ���� A�����е���0�����ʾ�������λ�ã������� 10 ������
 * 
 * �������:���һ�б�ʾ�Ϸ���������Ŀ��
 * 
 * ʾ��1
 * ����
 * 5 5
 * 4 0 0 2 0
 * ���
 * 2
 *
 * @author�� zxt
 *
 * @time: 2018��7��27�� ����7:18:10
 *
 */
public class ���л�ԭ {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			// ����һ�����з�
			scanner.nextLine();
			String[] str = scanner.nextLine().split(" ");
			
			// 1-n���Ӵ�С���У�û��˳��
			if(k == 0) {
				System.out.println(0);
				
			} else {
				// ��������
				ArrayList<Integer> array = new ArrayList<Integer>();
				// ����ȱʡ���ݵ�����λ��
				int[] defaultIndex = new int[10];
				// ����ȱʡ������
				List<Integer> defaultData = new ArrayList<Integer>();
				for(int i = 0; i < n; i++) {
					defaultData.add(i + 1);
				}
				
				int index = 0;
				boolean isNoLost = true;
				for(int i = 0; i < n; i++) {
					int temp = Integer.valueOf(str[i]);
					array.add(temp);
					if(temp == 0) {
						defaultIndex[index++] = i;
						isNoLost = false;
					} else {
						for(int j = 0; j < i; j++) {
							if(array.get(j) != 0 && array.get(j) < temp) {
								k--;
							}
						}
						defaultData.set(temp - 1, 0);
					}
				}
				
				// û��ȱʧ����
				if(isNoLost) {
					System.out.println(0);
					
				} else {
					// ȱʡ����ȫ����
					ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
					Iterator<Integer> iterator = defaultData.iterator();
					while(iterator.hasNext()) {
						if(iterator.next() == 0) {
							iterator.remove();
						}
					}
					permutate(defaultData.toArray(), 0, defaultData.size(), list);
					
					int result = 0;
					// ��ȱʡ�����ݲ��뵽�����п��Ƿ����Ҫ��
					for(int i = 0; i < list.size(); i++) {
						ArrayList<Integer> temp = list.get(i);
						ArrayList<Integer> data = new ArrayList<Integer>(array);
						int flag = k;
						
						for(int j = 0; j < temp.size(); j++) {
							data.set(defaultIndex[j], temp.get(j));
							// �²������������ǰ�������
							for(int p = 0; p < defaultIndex[j]; p++) {
								if(data.get(p) != 0 && data.get(p) < data.get(defaultIndex[j])) {
									flag--;
								}
							}
							// �²�������������������С
							for(int p = defaultIndex[j] + 1; p < data.size(); p++) {
								if(data.get(p) != 0 && data.get(defaultIndex[j]) < data.get(p)) {
									flag--;
								}
							}
						}
						
						if(flag == 0) {
							result++;
						}
					}
					
					System.out.println(result);
				}
				
			}
		}
	}
	
	/**
	 * 
	 * @Description�����ȱʡ���ֵ�ȫ����
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param list
	 */
	public static void permutate(Object[] arr, int start, int end, ArrayList<ArrayList<Integer>> list) {
		if(arr == null || arr.length == 0) {
			return ;
		}
		
		if(end == 1) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add((Integer) arr[start]);
			list.add(temp);
			return ;
		}
		
		if(start == end) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 0; i < arr.length; i++) {
				temp.add((Integer) arr[i]);
			}
			list.add(temp);
			
		} else {
			for(int i = start; i < end; i++) {
				swap(arr, start, i);
				
				permutate(arr, start + 1, end, list);
				
				swap(arr, i, start);
			}
		}
	}
	
	public static void swap(Object[] arr, int i, int j) {
		Object temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
