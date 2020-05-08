package 经典;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @Description: 快速排序算法的实现
 *
 * @author： zxt
 *
 * @time: 2018年3月19日 上午8:49:26
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 49, 76 };

		// 输出初始数组
		System.out.print("初始数组：");
		System.out.println(Arrays.toString(arr));

		// 排序
		// quick_sort(arr, 0, arr.length - 1);
		
		// quick_sort2(arr, 0, arr.length - 1);

		quickSort2(arr, 0, arr.length - 1);

		// 输出最后结果
		System.out.print("最终结果：");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 
	 * @Description:方法一：每次让中间的数作为基数
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
		// 找中间位置的值作为基数
		int pivot = arr[(left + right) / 2];

		while (l < r) {
			// 小于基数
			while (l < r && arr[l] < pivot) {
				l++;
			}
			// 大于基数
			while (l < r && arr[r] > pivot) {
				r--;
			}

			if (l < r) {
				swap(arr, l, r);
			}
			// 如果出现左右两个指针指向的数都等于中间值，这时候不做判断则会死循环
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
	 * @Description：使用第一个数作为基数
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	@SuppressWarnings("unused")
	private static void quick_sort2(int[] arr, int left, int right) {
		// 找到递归算法的出口
		if (left >= right) {
			return;
		}
		
		int low = left;
		int high = right;
		int key = arr[left];
		
		// 完成一趟排序
		while (low < high) {
			// 从右往左找到第一个小于key的数
			while (low < high && arr[high] > key) {
				high--;
			}
			// 从左往右找到第一个大于key的数
			while (low < high && arr[low] <= key) {
				low++;
			}
			
			// 交换
			if (low < high) {
				swap(arr, low, high);
			}
		}
		
		// 调整key的位置
		swap(arr, low, left);
		// 对key左边的数快排
		quick_sort2(arr, left, low - 1);
		// 对key右边的数快排
		quick_sort2(arr, low + 1, right);
	}

	/**
	 * 
	 * @Description:方法三：随机生成位置，将数组分成俩部分
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
	 * @Description:随机生成一个位置，然后将小于该位置值的数据都交换到该位置前面，并返回不大于该数的最大下标值
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
	 * @Description：根据num数值对数组进行调整，使小于num的在数组左边，等于num的在中间，大于num的在右边，返回的数组中两个值，分别为等于num值的左右下标
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
			// 这一句每次随机选择一个数与第一个数进行交换，然后以第一个数为基数快排，就相当于随机选择基数进行快排
			swap(array, start + (int) (Math.random() * (end - start + 1)), start);
			// 每次以第一个数为基数进行快排
			int[] index = partition(array, start, end, array[start]);
			quickSort2(array, start, index[0] - 1);
			quickSort2(array, index[1] + 1, end);
		}
	}
}