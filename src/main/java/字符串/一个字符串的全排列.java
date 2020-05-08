package 字符串;

import java.util.TreeSet;

/**
 * 
 * @Description: 给定一个字符串，求出它的字符的所有排列
 *
 * @author： zxt
 *
 * @time: 2018年5月1日 下午11:21:13
 *
 */
public class 一个字符串的全排列 {
	
	private static TreeSet<String> result;

	public static void main(String[] args) {
		String str = new String("abcc");
		
		// permutateDeduplication(str.toCharArray(), 0, str.length());
		
		// 全排列并且按字典序排序
		result = new TreeSet<String>();
		permutate(str.toCharArray(), 0, str.length());
		System.out.println(result);
	}

	/**
	 * 
	 * @Description:全排列字符串中的字符，但是当字符串中存在重复字符时，全排列中也会存在重复
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void permutate(char[] arr, int start, int end) {
		if (end <= 1) {
			result.add(new String(arr));
			System.out.println(arr);
			return;
		}

		if (start == end) {
			result.add(new String(arr));
			System.out.println(arr);
			
		} else {
			for (int i = start; i < end; i++) {
				// 交换前缀，使其产生下一个前缀
				swap(arr, i, start);
				
				permutate(arr, start + 1, end);
				
				// 将前缀换回，继续做上一个前缀的排列
				swap(arr, start, i);
			}
		}
	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 
	 * @Description：去重复的全排列：就是从第一个字符起每个字符分别与它后面非重复出现的字符交换。
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void permutateDeduplication(char[] arr, int start, int end) {
		if (end <= 1) {
			System.out.println(arr);
			return;
		}

		if (start == end) {
			System.out.println(arr);
			
		} else {
			for (int i = start; i < end; i++) {
				
				// 先判断需要交换的字符在前面是否已经交换过相同的字符
				if(!isSwap(arr, start, i)) {
					// 交换前缀，使其产生下一个前缀
					swap(arr, i, start);
					
					permutateDeduplication(arr, start + 1, end);
					
					// 将前缀换回，继续做上一个前缀的排列
					swap(arr, start, i);
				}
			}
		}
	}
	
	public static boolean isSwap(char[] arr, int start, int end) {
		boolean isSwap = false;
		
		for(int i = start; i < end; i++) {
			if(arr[i] == arr[end]) {
				isSwap = true;
			}
		}
		
		return isSwap;
	}
	
}
