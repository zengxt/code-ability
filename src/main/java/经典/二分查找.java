package ����;

import java.util.Scanner;

/**
 * 
 * @Description: ���������еĶ��ֲ���
 *
 * @author�� zxt
 *
 * @time: 2018��5��5�� ����9:48:23
 *
 */
public class ���ֲ��� {

	private static Scanner scanner;

	public static void main(String[] args) {
		// ����arr���鲢��ֵ
		int arr[] = { 2, 5, 7, 12, 25 };

		scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int value = scanner.nextInt();
			
			System.out.println(binaryFind(arr, 0, arr.length - 1, value));
			System.out.println("---------------------------------------");
			System.out.println(binarySearch(arr, value));
		}
	}

	/**
	 * 
	 * @Description:���ֲ��ҷ����ҵ����ز���ֵ���ڵ��±꣬�Ҳ�������-1
	 * 
	 * @param arr
	 * @param leftIndex
	 * @param rightIndex
	 * @param value
	 */
	public static int binaryFind(int arr[], int leftIndex, int rightIndex, int value) {
		if(arr.length == 0) {
			return -1;
		}
		
		// �����ҵ��м����
		int midIndex = (rightIndex + leftIndex) / 2;
		int midValue = arr[midIndex];
		if (rightIndex >= leftIndex) {
			if(value == midValue) {
				return midIndex;
			}
			
			if(midValue > value) {
				// ��arr���������������
				return binaryFind(arr, leftIndex, midIndex - 1, value);
			} else {
				// ��arr�����ұ���������
				return binaryFind(arr, midIndex + 1, rightIndex, value);
			}

		} else {
			return -1;
		}
	}
	
	/**
	 * 
	 * @Description:���ֲ��ҵķǵݹ�ʵ��
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int binarySearch(int arr[], int value) {
		if(arr.length == 0) {
			return -1;
		}
		
		int leftIndex = 0;
		int rightIndex = arr.length - 1;
		while (rightIndex >= leftIndex) {
			// �����ҵ��м����
			int midIndex = (rightIndex + leftIndex) / 2;
			int midValue = arr[midIndex];
			if(value == midValue) {
				return midIndex;
			}
			
			if(midValue > value) {
				// ��arr���������������
				rightIndex = midIndex - 1;
			} else {
				// ��arr�����ұ���������
				leftIndex = midIndex + 1;
			}
		}
		
		return -1;
	}
}