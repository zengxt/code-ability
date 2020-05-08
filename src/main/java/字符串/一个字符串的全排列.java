package �ַ���;

import java.util.TreeSet;

/**
 * 
 * @Description: ����һ���ַ�������������ַ�����������
 *
 * @author�� zxt
 *
 * @time: 2018��5��1�� ����11:21:13
 *
 */
public class һ���ַ�����ȫ���� {
	
	private static TreeSet<String> result;

	public static void main(String[] args) {
		String str = new String("abcc");
		
		// permutateDeduplication(str.toCharArray(), 0, str.length());
		
		// ȫ���в��Ұ��ֵ�������
		result = new TreeSet<String>();
		permutate(str.toCharArray(), 0, str.length());
		System.out.println(result);
	}

	/**
	 * 
	 * @Description:ȫ�����ַ����е��ַ������ǵ��ַ����д����ظ��ַ�ʱ��ȫ������Ҳ������ظ�
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void permutate(char[] arr, int start, int end) {
		if (end <= 1) {
			result.add(new String(arr));
			System.out.println(arr);
			return;
		}

		if (start == end) {
			result.add(new String(arr));
			System.out.println(arr);
			
		} else {
			for (int i = start; i < end; i++) {
				// ����ǰ׺��ʹ�������һ��ǰ׺
				swap(arr, i, start);
				
				permutate(arr, start + 1, end);
				
				// ��ǰ׺���أ���������һ��ǰ׺������
				swap(arr, start, i);
			}
		}
	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 
	 * @Description��ȥ�ظ���ȫ���У����Ǵӵ�һ���ַ���ÿ���ַ��ֱ�����������ظ����ֵ��ַ�������
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void permutateDeduplication(char[] arr, int start, int end) {
		if (end <= 1) {
			System.out.println(arr);
			return;
		}

		if (start == end) {
			System.out.println(arr);
			
		} else {
			for (int i = start; i < end; i++) {
				
				// ���ж���Ҫ�������ַ���ǰ���Ƿ��Ѿ���������ͬ���ַ�
				if(!isSwap(arr, start, i)) {
					// ����ǰ׺��ʹ�������һ��ǰ׺
					swap(arr, i, start);
					
					permutateDeduplication(arr, start + 1, end);
					
					// ��ǰ׺���أ���������һ��ǰ׺������
					swap(arr, start, i);
				}
			}
		}
	}
	
	public static boolean isSwap(char[] arr, int start, int end) {
		boolean isSwap = false;
		
		for(int i = start; i < end; i++) {
			if(arr[i] == arr[end]) {
				isSwap = true;
			}
		}
		
		return isSwap;
	}
	
}
