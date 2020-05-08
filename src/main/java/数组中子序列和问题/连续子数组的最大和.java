package �����������к�����;

/**
 * 
 * @Description: ����һ���������飬������������Ҳ�и����������е�һ������������������һ�������顣������������ĺ͵����ֵ��
 *
 * @author�� zxt
 *
 * @time: 2018��7��22�� ����4:44:12
 *
 */
public class ��������������� {

	public static void main(String[] args) {
		int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
		
		System.out.println(FindGreatestSumOfSubArray(array));
		
		System.out.println(FindGreatestSumOfSubArray2(array));
	}
	
	/**
	 * 
	 * @Description����ͷ��ʼ�ۼӣ����������еĵ�i��Ԫ��ʱ������ǰ���������Ϊ���������ϵ�ǰ��Ԫ�ط����������Ե�ǰԪ�ؿ�ͷ��������ĺʹ����Բ���
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
	 * @Description����̬�滮��˼·����һ������maxSum�����Ե�i��Ԫ�ؽ�β��������ĺͣ�
	 * ͬ�����ۼӵĹ��̣����maxSum[i-1] < 0����maxSum[i]����ǰ��ĺͷ�������
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
