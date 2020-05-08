package com.zxt.jianzhi.移位;

/**
 * 
 * @Description: 在一个数组中除了一个数字只出现了一次之外，其他数字都出现了三次。请找出这个数字
 *
 * @author： zxt
 *
 * @time: 2018年6月22日 下午5:12:32
 *
 */
public class 数组中出现一次的数字 {

	public static void main(String[] args) {
		int[] array = {2, 4, 7, 8, 9, 8, 9, 4, 4, 2, 8, 9, 2};
		
		System.out.println(onlyAppearOnce(array));
	}
	
	/**
	 * 
	 * @Description：由于只有一个数出现一次，其余都出现三次，所以数组中所有数字二进制表示的每一位都加起来，
	 * 如果某一位的和可以被3整除，那个只出现一次的数字的这一位二进制也为0，否则为1
	 * 
	 * @param array
	 * @return
	 */
	public static int onlyAppearOnce(int[] array) {
		if(array.length <= 0) {
			System.out.println("Input error!!");
		}
		
		int[] bitSum = new int[32];
		for(int i = 0; i < 32; i++) {
			bitSum[i] = 0;
		}
		
		// 数组中每个数相加
		for(int j = 0; j < array.length; j++) {
			int bitMask = 1;
			// 低位在后，高位在前
			for(int i = 31; i >= 0; i--) {
				int bit = array[j] & bitMask;
				if(bit != 0) {
					bitSum[i] += 1;
				}
				bitMask = bitMask << 1;
			}
		}
		
		int result = 0;
		for(int i = 0; i < 32; i++) {
			result = result << 1;
			result += bitSum[i] % 3;
		}
		
		return result;
	}
}
