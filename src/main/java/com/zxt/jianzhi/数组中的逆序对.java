package com.zxt.jianzhi;

/**
 * 
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * @author： zxt
 *
 * @time: 2018年8月26日 下午10:11:32
 *
 */
public class 数组中的逆序对 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7, 5, 6, 4};
		System.out.println(inversePairs(array));
		
		System.out.println(inversePairs2(array));
	}
	
	/**
	 * 
	 * @Description：最直观的方法，每个数字和它后面的数都比较一遍，算法时间复杂度为O(n^2)，大数据量时时间复杂度高
	 * 
	 * @param array
	 * @return
	 */
	public static int inversePairs(int[] array) {
		int result = 0;
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j]) {
					result++;
				}
			}
		}
		
		return result % 1000000007;
    }
	
	/**
	 * 
	 * @Description：类似于归并排序算法，每次逆序的时候记录下来，并且改变这个位置，这样的话只和后面一个数字比较即可
	 * 
	 * @param array
	 * @return
	 */
	public static int inversePairs2(int[] data) {
		if(data == null || data.length == 0) {
			return 0;
		}
		
		int[] copy = new int[data.length];
		for(int i = 0; i < data.length; i++) {
			copy[i] = data[i];
		}
		return inversePairs2(copy, data, 0, data.length - 1);
    }
	
	public static int inversePairs2(int[] data, int[] copy, int start, int end) {
		if(start == end) {
			copy[start] = data[start];
			return 0;
		}
		
		int length = (end - start) / 2;
		int left = inversePairs2(copy, data, start, start + length) % 1000000007;
		int right = inversePairs2(copy, data, start + length + 1, end)  % 1000000007;
		
		// i初始化为前半段最后一个数字的下标
		int i = start + length;
		// j初始化为后半段最后一个数字的下标
		int j = end;
		int indexCopy = end;
		int count = 0;
		while(i >= start && j >= start + length + 1) {
			if(data[i] > data[j]) {
				copy[indexCopy--] = data[i--];
				count += j - start - length;
				if(count >= 1000000007) {
					count %= 1000000007;
				}
			} else {
				copy[indexCopy--] = data[j--];
			}
		}
		
		for(; i >= start; --i) {
			copy[indexCopy--] = data[i];
		}
		for(; j >= start + length + 1; --j) {
			copy[indexCopy--] = data[j];
		}
		
		return (left + right + count) % 1000000007;
	}

}
