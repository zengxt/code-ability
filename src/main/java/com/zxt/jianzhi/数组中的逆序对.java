package com.zxt.jianzhi;

/**
 * 
 * @Description: �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
 *
 * @author�� zxt
 *
 * @time: 2018��8��26�� ����10:11:32
 *
 */
public class �����е������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7, 5, 6, 4};
		System.out.println(inversePairs(array));
		
		System.out.println(inversePairs2(array));
	}
	
	/**
	 * 
	 * @Description����ֱ�۵ķ�����ÿ�����ֺ�������������Ƚ�һ�飬�㷨ʱ�临�Ӷ�ΪO(n^2)����������ʱʱ�临�Ӷȸ�
	 * 
	 * @param array
	 * @return
	 */
	public static int inversePairs(int[] array) {
		int result = 0;
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j]) {
					result++;
				}
			}
		}
		
		return result % 1000000007;
    }
	
	/**
	 * 
	 * @Description�������ڹ鲢�����㷨��ÿ�������ʱ���¼���������Ҹı����λ�ã������Ļ�ֻ�ͺ���һ�����ֱȽϼ���
	 * 
	 * @param array
	 * @return
	 */
	public static int inversePairs2(int[] data) {
		if(data == null || data.length == 0) {
			return 0;
		}
		
		int[] copy = new int[data.length];
		for(int i = 0; i < data.length; i++) {
			copy[i] = data[i];
		}
		return inversePairs2(copy, data, 0, data.length - 1);
    }
	
	public static int inversePairs2(int[] data, int[] copy, int start, int end) {
		if(start == end) {
			copy[start] = data[start];
			return 0;
		}
		
		int length = (end - start) / 2;
		int left = inversePairs2(copy, data, start, start + length) % 1000000007;
		int right = inversePairs2(copy, data, start + length + 1, end)  % 1000000007;
		
		// i��ʼ��Ϊǰ������һ�����ֵ��±�
		int i = start + length;
		// j��ʼ��Ϊ�������һ�����ֵ��±�
		int j = end;
		int indexCopy = end;
		int count = 0;
		while(i >= start && j >= start + length + 1) {
			if(data[i] > data[j]) {
				copy[indexCopy--] = data[i--];
				count += j - start - length;
				if(count >= 1000000007) {
					count %= 1000000007;
				}
			} else {
				copy[indexCopy--] = data[j--];
			}
		}
		
		for(; i >= start; --i) {
			copy[indexCopy--] = data[i];
		}
		for(; j >= start + length + 1; --j) {
			copy[indexCopy--] = data[j];
		}
		
		return (left + right + count) % 1000000007;
	}

}
