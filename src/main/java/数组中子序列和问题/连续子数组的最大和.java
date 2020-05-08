package 数组中子序列和问题;

/**
 * 
 * @Description: 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * @author： zxt
 *
 * @time: 2018年7月22日 下午4:44:12
 *
 */
public class 连续子数组的最大和 {

	public static void main(String[] args) {
		int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
		
		System.out.println(FindGreatestSumOfSubArray(array));
		
		System.out.println(FindGreatestSumOfSubArray2(array));
	}
	
	/**
	 * 
	 * @Description：从头开始累加，当到数组中的第i个元素时，若当前的子数组和为负数，加上当前的元素反而还不如以当前元素开头的子数组的和大，所以不加
	 * 
	 * @param array
	 * @return
	 */
	public static int FindGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(currentSum <= 0) {
				currentSum = array[i];
				
			} else {
				currentSum += array[i];
			}
			
			if(currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
		
		return maxSum;
    }
	
	/**
	 * 
	 * @Description：动态规划的思路：用一个数组maxSum保存以第i个元素结尾的子数组的和，
	 * 同理于累加的过程，如果maxSum[i-1] < 0，则maxSum[i]不加前面的和反而更大。
	 * 
	 * @param array
	 * @return
	 */
	public static int FindGreatestSumOfSubArray2(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		int[] maxSum = new int[array.length];
		maxSum[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			if(maxSum[i - 1] <= 0) {
				maxSum[i] = array[i];
			} else {
				maxSum[i] = maxSum[i - 1] + array[i];
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < maxSum.length; i++) {
			if(maxSum[i] > maxValue) {
				maxValue = maxSum[i];
			}
			
			System.out.print(maxSum[i] + " ");
		}
		System.out.println();
		
		return maxValue;
	}

}
