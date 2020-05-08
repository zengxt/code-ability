package 经典;

import java.util.ArrayList;

/**
 * 
 * @Description: 合并两个有序的数组
 *
 * @author： zxt
 *
 * @time: 2018年4月18日 下午9:44:07
 *
 */
public class 合并两个有序的数组 {

	public static void main(String[] args) {
		int[] arrayOne = { 1, 3, 5 };
		int[] arrayTwo = { 2, 4, 6 };

		System.out.println(mergeArrays(arrayOne, arrayTwo));
	}

	/**
	 * 
	 * @Description：合并两个有序数组
	 * 
	 * @param arrayOne
	 * @param arrayTwo
	 * @return
	 */
	public static ArrayList<Integer> mergeArrays(int[] arrayOne, int[] arrayTwo) {
		int arrayOneLen = arrayOne.length;
		int arrayTwoLen = arrayTwo.length;
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		
		int i = 0, j = 0;
		while (i < arrayOneLen || j < arrayTwoLen) {
			// 如果其中一个数组已经合并完毕，则把另一个数组中剩余的按顺序添加到新数组即可
			// 相当于值较大的序列中剩余的元素直接拼接在合并数组的后面，这里也可以另起两个小循环来操作
			if (i == arrayOneLen && j < arrayTwoLen) {
				resultArray.add(arrayTwo[j++]);
			} else if (i < arrayOneLen && j == arrayTwoLen) {
				resultArray.add(arrayOne[i++]);
				
			} else {
				// 添加两个数组中当前较小的值
				if (arrayOne[i] <= arrayTwo[j]) {
					resultArray.add(arrayOne[i++]);
				} else if (arrayOne[i] > arrayTwo[j]) {
					resultArray.add(arrayTwo[j++]);
				}
			}
		}

		return resultArray;
	}
}
