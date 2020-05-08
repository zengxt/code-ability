package ����;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @Description: ���������㷨��ʵ��
 *
 * @author�� zxt
 *
 * @time: 2018��3��19�� ����8:49:26
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 49, 76 };

		// �����ʼ����
		System.out.print("��ʼ���飺");
		System.out.println(Arrays.toString(arr));

		// ����
		// quick_sort(arr, 0, arr.length - 1);
		
		// quick_sort2(arr, 0, arr.length - 1);

		quickSort2(arr, 0, arr.length - 1);

		// ��������
		System.out.print("���ս����");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 
	 * @Description:����һ��ÿ�����м������Ϊ����
	 * 
	 * @param left
	 * @param right
	 * @param arr
	 */
	public static void quick_sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int l = left;
		int r = right;
		// ���м�λ�õ�ֵ��Ϊ����
		int pivot = arr[(left + right) / 2];

		while (l < r) {
			// С�ڻ���
			while (l < r && arr[l] < pivot) {
				l++;
			}
			// ���ڻ���
			while (l < r && arr[r] > pivot) {
				r--;
			}

			if (l < r) {
				swap(arr, l, r);
			}
			// ���������������ָ��ָ������������м�ֵ����ʱ�����ж������ѭ��
			if (arr[l] == pivot) {
				--r;
			}
			if (arr[r] == pivot) {
				++l;
			}
		}

		if (l == r) {
			l++;
			r--;
		}
		quick_sort(arr, left, r);
		quick_sort(arr, l, right);
	}

	/**
	 * 
	 * @Description��ʹ�õ�һ������Ϊ����
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	@SuppressWarnings("unused")
	private static void quick_sort2(int[] arr, int left, int right) {
		// �ҵ��ݹ��㷨�ĳ���
		if (left >= right) {
			return;
		}
		
		int low = left;
		int high = right;
		int key = arr[left];
		
		// ���һ������
		while (low < high) {
			// ���������ҵ���һ��С��key����
			while (low < high && arr[high] > key) {
				high--;
			}
			// ���������ҵ���һ������key����
			while (low < high && arr[low] <= key) {
				low++;
			}
			
			// ����
			if (low < high) {
				swap(arr, low, high);
			}
		}
		
		// ����key��λ��
		swap(arr, low, left);
		// ��key��ߵ�������
		quick_sort2(arr, left, low - 1);
		// ��key�ұߵ�������
		quick_sort2(arr, low + 1, right);
	}

	/**
	 * 
	 * @Description:���������������λ�ã�������ֳ�������
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] array, int start, int end) {
		if (start == end) {
			return;
		}

		int index = partition(start, end, array);
		System.out.println(index);
		if (index > start) {
			quickSort(array, start, index - 1);
		}
		if (index < end) {
			quickSort(array, index + 1, end);
		}
	}

	/**
	 * 
	 * @Description:�������һ��λ�ã�Ȼ��С�ڸ�λ��ֵ�����ݶ���������λ��ǰ�棬�����ز����ڸ���������±�ֵ
	 * 
	 * @param start
	 * @param end
	 * @param array
	 * @return
	 */
	public static int partition(int start, int end, int[] array) {
		if (start >= end || array.length <= 0 || start < 0 || end >= array.length) {
			return -1;
		}

		Random random = new Random();
		int index = random.nextInt(end - start + 1) + start;
		swap(array, index, end);

		int small = start - 1;
		for (index = start; index < end; index++) {
			if (array[index] < array[end]) {
				small++;
				if (small != index) {
					swap(array, index, small);
				}
			}
		}

		++small;
		swap(array, small, end);

		return small;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * 
	 * @Description������num��ֵ��������е�����ʹС��num����������ߣ�����num�����м䣬����num�����ұߣ����ص�����������ֵ���ֱ�Ϊ����numֵ�������±�
	 * 
	 * @param arr
	 * @param statrt
	 * @param end
	 * @param num
	 * @return
	 */
	public static int[] partition(int[] arr, int start, int end, int num) {
		int left = start - 1;
		int right = end + 1;
		int current = start;
		
		while(current < right) {
			if(arr[current] < num) {
				swap(arr, ++left, current++);
			} else if(arr[current] > num) {
				swap(arr, --right, current);
			} else {
				current++;
			}
		}
		
		return new int[] {left + 1, right - 1};
	}
	
	public static void quickSort2(int[] array, int start, int end) {
		if(start < end) {
			// ��һ��ÿ�����ѡ��һ�������һ�������н�����Ȼ���Ե�һ����Ϊ�������ţ����൱�����ѡ��������п���
			swap(array, start + (int) (Math.random() * (end - start + 1)), start);
			// ÿ���Ե�һ����Ϊ�������п���
			int[] index = partition(array, start, end, array[start]);
			quickSort2(array, start, index[0] - 1);
			quickSort2(array, index[1] + 1, end);
		}
	}
}