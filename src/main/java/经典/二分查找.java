package 经典;

import java.util.Scanner;

/**
 * 
 * @Description: 有序数组中的二分查找
 *
 * @author： zxt
 *
 * @time: 2018年5月5日 上午9:48:23
 *
 */
public class 二分查找 {

	private static Scanner scanner;

	public static void main(String[] args) {
		// 定义arr数组并赋值
		int arr[] = { 2, 5, 7, 12, 25 };

		scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int value = scanner.nextInt();
			
			System.out.println(binaryFind(arr, 0, arr.length - 1, value));
			System.out.println("---------------------------------------");
			System.out.println(binarySearch(arr, value));
		}
	}

	/**
	 * 
	 * @Description:二分查找法：找到返回查找值所在的下标，找不到返回-1
	 * 
	 * @param arr
	 * @param leftIndex
	 * @param rightIndex
	 * @param value
	 */
	public static int binaryFind(int arr[], int leftIndex, int rightIndex, int value) {
		if(arr.length == 0) {
			return -1;
		}
		
		// 首先找到中间的数
		int midIndex = (rightIndex + leftIndex) / 2;
		int midValue = arr[midIndex];
		if (rightIndex >= leftIndex) {
			if(value == midValue) {
				return midIndex;
			}
			
			if(midValue > value) {
				// 在arr数组左边数列中找
				return binaryFind(arr, leftIndex, midIndex - 1, value);
			} else {
				// 在arr数组右边数列中找
				return binaryFind(arr, midIndex + 1, rightIndex, value);
			}

		} else {
			return -1;
		}
	}
	
	/**
	 * 
	 * @Description:二分查找的非递归实现
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearch(int arr[], int value) {
		if(arr.length == 0) {
			return -1;
		}
		
		int leftIndex = 0;
		int rightIndex = arr.length - 1;
		while (rightIndex >= leftIndex) {
			// 首先找到中间的数
			int midIndex = (rightIndex + leftIndex) / 2;
			int midValue = arr[midIndex];
			if(value == midValue) {
				return midIndex;
			}
			
			if(midValue > value) {
				// 在arr数组左边数列中找
				rightIndex = midIndex - 1;
			} else {
				// 在arr数组右边数列中找
				leftIndex = midIndex + 1;
			}
		}
		
		return -1;
	}
}