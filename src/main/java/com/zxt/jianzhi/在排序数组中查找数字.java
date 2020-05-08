package com.zxt.jianzhi;

/**
 * 
 * @Description: 统计一个数字在排序数组中出现的次数。
 *
 * @author： zxt
 *
 * @time: 2018年8月27日 上午9:44:55
 *
 */
public class 在排序数组中查找数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1, 2, 3, 3, 3, 3, 4, 5};
		System.out.println(getFirstK(data, 3, 0, data.length - 1));
		System.out.println(getLastK(data, 3, 0, data.length - 1));
		
		System.out.println(getNumberOfK(data, 3));
	}
	
	/**
	 * 
	 * @Description：强调了排序数组的问题，一般需要使用二分查找来解决（直接遍历的时间复杂度可能不符合要求）
	 * 
	 * @param data
	 * @param k
	 * @return
	 */
	public static int getNumberOfK(int[] data, int k) {
		int number = 0;
		
		if(data != null && data.length > 0) {
			int first = getFirstK(data, k, 0, data.length - 1);
			int last = getLastK(data, k, 0, data.length - 1);
			
			if(first != -1 && last != -1) {
				number = last - first + 1;
			}
		}
		
		return number;
	}
	
	/**
	 * 
	 * @Description：查找k在排序数组中第一次出现的位置，如果数组中没有该数字，则返回-1
	 * 
	 * @param data
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getFirstK(int[] data, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		int middleValue = data[middleIndex];
		while(start <= end) {
			// 当前数字为k，如果它的前一个也为k的话，则继续查找
			if(middleValue == k) {
				if((middleIndex > 0 && data[middleIndex - 1] != k) || middleIndex == 0) {
					return middleIndex;
				} else {
					end = middleIndex - 1;
				}
				
			} else if(middleValue > k) {
				end = middleIndex - 1;
			} else {
				start = middleIndex + 1;
			}
			
			middleIndex = (start + end) / 2;
			middleValue = data[middleIndex];
		}
		
		return -1;
	}
	
	/**
	 * 
	 * @Description：查找k在排序数组中最后一次出现的位置，如果数组中没有该数字，则返回-1
	 * 
	 * @param data
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getLastK(int[] data, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		int middleValue = data[middleIndex];
		while(start <= end) {
			// 当前数字为k，如果它的后一个也为k的话，则继续查找
			if(middleValue == k) {
				if((middleIndex < data.length - 1 && data[middleIndex + 1] != k) || middleIndex == data.length - 1) {
					return middleIndex;
				} else {
					start = middleIndex + 1;
				}
				
			} else if(middleValue > k) {
				end = middleIndex - 1;
			} else {
				start = middleIndex + 1;
			}
			
			middleIndex = (start + end) / 2;
			middleValue = data[middleIndex];
		}
		
		return -1;
	}

}
