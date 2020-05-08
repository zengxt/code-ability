package 和为定值子序列;

import java.util.ArrayList;

/**
 * 
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author： zxt
 *
 * @time: 2018年9月2日 下午4:09:21
 *
 */
public class 和为s的两个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 4, 7, 11, 15};
		System.out.println(FindNumbersWithSum(array, 15));
	}
	
	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array == null || array.length < 2) {
			return list;
		}
		
		// 两个数字相距最远实际上他们的乘积会最小(所以找到的第一组即时符合要求的两数乘积最小的组合)
		// int minMulti = Integer.MAX_VALUE;
		int start = 0;
		int end = array.length - 1;
		while(start < end) {
			int currSum = array[start] + array[end];
			
			if(currSum == sum) {
				list.add(array[start]);
				list.add(array[end]);
				break;
				
			} else if(currSum < sum) {
				start++;
			} else {
				end--;
			}
		}
		
		return list;
    }

}
