package 数组中子序列和问题;

/**
 * 
 * @Description: 最大升序子序列问题，长度以及和问题，
 * 例如：数组 arr[] = {10, 9, 2, 5, 3, 7, 101, 18}，数组arr的最长升序子序列是 {2, 3, 7, 101}，因此最长升序子序列长度是4。
 *
 * @author： zxt
 *
 * @time: 2018年8月29日 下午3:51:38
 *
 */
public class 数组中和最大的升序序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(maxSubLength(array));
		System.out.println(maxSubSum(array));
	}
	
	/**
	 * 
	 * @Description：最长升序子序列的长度，考虑以元素i结尾的最长升序子序列的长度
	 * 
	 * @param array
	 * @return
	 */
	public static int maxSubLength(int[] array) {
		if(array == null || array.length == 0) {
			return -1;
		}
		
		if(array.length == 1) {
			return 1;
		}
		
		int[] maxLength = new int[array.length];
		maxLength[0] = 1;
		for(int i = 1; i < array.length; i++) {
			
			// 依次判断i前面的每个数，如果比第i个数小，则最长升序子序列的长度可加1
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i] && maxLength[j] + 1 > maxLength[i]) {
					maxLength[i] = maxLength[j] + 1;
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < maxLength.length; i++) {
			if(result < maxLength[i]) {
				result = maxLength[i];
			}
		}
		
		return result;
	}

	/**
	 * 
	 * @Description：最长升序子序列的和，思路与 最长升序子序列的长度 的求法一样
	 * 
	 * @param array
	 * @return
	 */
	public static int maxSubSum(int[] array) {
		if(array == null || array.length == 0) {
			return -1;
		}
		
		if(array.length == 1) {
			return array[0];
		}
		
		int[] maxLength = new int[array.length];
		maxLength[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			
			// 依次判断i前面的每个数，如果比第i个数小，则最长升序子序列的和可加array[i]
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i] && maxLength[j] + array[i] > maxLength[i]) {
					maxLength[i] = maxLength[j] + array[i];
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < maxLength.length; i++) {
			if(result < maxLength[i]) {
				result = maxLength[i];
			}
		}
		
		return result;
	}
}
