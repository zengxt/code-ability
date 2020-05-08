package �����������к�����;

/**
 * 
 * @Description: ����������������⣬�����Լ������⣬
 * ���磺���� arr[] = {10, 9, 2, 5, 3, 7, 101, 18}������arr��������������� {2, 3, 7, 101}���������������г�����4��
 *
 * @author�� zxt
 *
 * @time: 2018��8��29�� ����3:51:38
 *
 */
public class �����к������������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(maxSubLength(array));
		System.out.println(maxSubSum(array));
	}
	
	/**
	 * 
	 * @Description������������еĳ��ȣ�������Ԫ��i��β������������еĳ���
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
			
			// �����ж�iǰ���ÿ����������ȵ�i����С��������������еĳ��ȿɼ�1
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
	 * @Description������������еĺͣ�˼·�� ����������еĳ��� ����һ��
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
			
			// �����ж�iǰ���ÿ����������ȵ�i����С��������������еĺͿɼ�array[i]
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
