package com.zxt.test2017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @Description: 题目描述：牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，
 * 但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
 * 
 * 输入描述:每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），
 * 接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
 * 
 * 输出描述:输出一行表示合法的排列数目。
 * 
 * 示例1
 * 输入
 * 5 5
 * 4 0 0 2 0
 * 输出
 * 2
 *
 * @author： zxt
 *
 * @time: 2018年7月27日 下午7:18:10
 *
 */
public class 数列还原 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			// 消耗一个换行符
			scanner.nextLine();
			String[] str = scanner.nextLine().split(" ");
			
			// 1-n按从大到小排列，没有顺序
			if(k == 0) {
				System.out.println(0);
				
			} else {
				// 保存数组
				ArrayList<Integer> array = new ArrayList<Integer>();
				// 保存缺省数据的索引位置
				int[] defaultIndex = new int[10];
				// 保存缺省的数据
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
				
				// 没有缺失数据
				if(isNoLost) {
					System.out.println(0);
					
				} else {
					// 缺省数字全排列
					ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
					Iterator<Integer> iterator = defaultData.iterator();
					while(iterator.hasNext()) {
						if(iterator.next() == 0) {
							iterator.remove();
						}
					}
					permutate(defaultData.toArray(), 0, defaultData.size(), list);
					
					int result = 0;
					// 将缺省的数据插入到数组中看是否符合要求
					for(int i = 0; i < list.size(); i++) {
						ArrayList<Integer> temp = list.get(i);
						ArrayList<Integer> data = new ArrayList<Integer>(array);
						int flag = k;
						
						for(int j = 0; j < temp.size(); j++) {
							data.set(defaultIndex[j], temp.get(j));
							// 新插入的数，比它前面的数大
							for(int p = 0; p < defaultIndex[j]; p++) {
								if(data.get(p) != 0 && data.get(p) < data.get(defaultIndex[j])) {
									flag--;
								}
							}
							// 新插入的数，比它后面的数小
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
	 * @Description：求出缺省数字的全排列
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
