package com.zxt.jianzhi;

/**
 * 
 * @Description: ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 *
 * @author�� zxt
 *
 * @time: 2018��7��2�� ����10:21:12
 *
 */
public class ��������˳��ʹ����λ��ż��ǰ�� {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		// ����������Ԫ��ԭ�������λ�ã�����
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
		
		// ��������Ԫ��ԭ��������ż�������λ�ã�����
		reOrderArray(array2);
		for(int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @Description���ȿ��ǽ���������������ǰ�棬ż��������������棬����������Ԫ��ԭ�������˳��
	 * ��������ָ�룬ǰ���һ������ǰ��ָ��ָ��ż���Һ���ָ��ָ������ʱ������
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
			// ����ƶ�left��ֱ����ָ��ż��
			while(left < right && ((array[left] & 1) == 1)) {
				left++;
			}
			
			// ��ǰ�ƶ�right��ֱ����ָ������
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
	 * @Description����Ҫ��֤������żԪ�ص�ԭ�������˳����ֻ���ڽ���Ԫ���໥����λ�ã�����������˼·
	 * һ���ǣ�ʹ��ð��������߲��������˼�롣��һ���ǣ�ʹ�ö���Ĵ洢�ռ䣬���磺����ջ���ֱ�洢������ż��
	 * 
	 * @param array
	 */
	public static void reOrderArray(int [] array) {
		if(array == null || array.length == 0) {
			return;
		}
		
		for(int i = 1; i < array.length; i++) {
			int current = array[i];
			// ǰһ����Ҫ�Ƚϵ�Ԫ��
			int index = i - 1;
			
			// ��ǰԪ��������������Ҫ����ǰ���ż��һ�κ���
			while(index >= 0 && (array[index] & 1) == 0 && (current & 1) == 1) {
				array[index + 1] = array[index];
				index--;
			}
			
			// ��ǰԪ��������ʵ�λ��
			//��ǰ����Ԫ���ƶ���index�����һ��������λ�ã����index+1�պ÷���һ�����������û��Ԫ���ƶ�����index+1���ǵ�ǰλ�ã�
			array[index + 1] = current;
		}
    }
	
	/**
	 * 
	 * @Description��ʹ�ö���洢�ռ�
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
		// ������ǰ
		for(int i = 0; i < temp.length; i++) {
			if((temp[i] & 1) == 1) {
				array[index++] = temp[i];
			}
		}
		
		// ż���ں�
		for(int i = 0; i < temp.length; i++) {
			if((temp[i] & 1) == 0) {
				array[index++] = temp[i];
			}
		}
	}

}
