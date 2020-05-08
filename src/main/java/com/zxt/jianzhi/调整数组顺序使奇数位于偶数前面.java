package com.zxt.jianzhi;

/**
 * 
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author： zxt
 *
 * @time: 2018年7月2日 上午10:21:12
 *
 */
public class 调整数组顺序使奇数位于偶数前面 {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		// 不考虑数组元素原来的相对位置，调整
		reOrderOddEven(array);
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		
		int[] array2 = {1, 2, 3, 7, 4, 5};
		for(int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		
		// 考虑数组元素原来奇数和偶数的相对位置，调整
		reOrderArray(array2);
		for(int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @Description：先考虑将奇数调整至数组前面，偶数调整至数组后面，不考虑数组元素原来的相对顺序，
	 * 设置两个指针，前后各一个，当前面指针指向偶数且后面指针指向奇数时交换。
	 * 
	 * @param array
	 */
	public static void reOrderOddEven(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		
		int left = 0;
		int right = array.length - 1;
		while(left < right) {
			// 向后移动left，直到它指向偶数
			while(left < right && ((array[left] & 1) == 1)) {
				left++;
			}
			
			// 向前移动right，直到它指向奇数
			while(left < right && ((array[right] & 1) == 0)) {
				right--;
			}
			
			if(left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
	}
	
	/**
	 * 
	 * @Description：需要保证数组奇偶元素的原来的相对顺序，那只能邻近的元素相互交换位置，这里有两种思路
	 * 一种是，使用冒泡排序或者插入排序的思想。另一种是，使用额外的存储空间，例如：两个栈，分别存储奇数和偶数
	 * 
	 * @param array
	 */
	public static void reOrderArray(int [] array) {
		if(array == null || array.length == 0) {
			return;
		}
		
		for(int i = 1; i < array.length; i++) {
			int current = array[i];
			// 前一个需要比较的元素
			int index = i - 1;
			
			// 当前元素是奇数，则需要将它前面的偶数一次后移
			while(index >= 0 && (array[index] & 1) == 0 && (current & 1) == 1) {
				array[index + 1] = array[index];
				index--;
			}
			
			// 当前元素则放在适当位置
			//（前面有元素移动则index是最后一个奇数的位置，因此index+1刚好放下一个奇数。如果没有元素移动，则index+1还是当前位置）
			array[index + 1] = current;
		}
    }
	
	/**
	 * 
	 * @Description：使用额外存储空间
	 * 
	 * @param array
	 */
	public static void reOrderArray2(int [] array) {
		if(array == null || array.length == 0) {
			return;
		}
		
		int[] temp = new int[array.length];
		System.arraycopy(array, 0, temp, 0, temp.length);
		
		int index = 0;
		// 奇数在前
		for(int i = 0; i < temp.length; i++) {
			if((temp[i] & 1) == 1) {
				array[index++] = temp[i];
			}
		}
		
		// 偶数在后
		for(int i = 0; i < temp.length; i++) {
			if((temp[i] & 1) == 0) {
				array[index++] = temp[i];
			}
		}
	}

}
