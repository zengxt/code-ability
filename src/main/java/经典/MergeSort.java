package 经典;

/**
 * 
 * @Description: 归并排序
 *
 * @author： zxt
 *
 * @time: 2018年8月29日 下午5:09:15
 *
 */
public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49 };
		
		ms.print(arr);
		ms.merge_sort(arr, 0, arr.length - 1);
	}

	// 递归分成小部分
	public void merge_sort(int[] arrays, int start, int end) {
		if (start < end) {
			int m = (start + end) / 2;
			merge_sort(arrays, start, m);
			merge_sort(arrays, m + 1, end);
			combin_arrays(arrays, start, m, end);
			
			print(arrays);
		}
	}

	// 合并数组
	public void combin_arrays(int[] arrays, int start, int m, int end) {
		int length = end - start + 1;
		// 用来存放比较的数组，用完复制回到原来的数组
		int temp[] = new int[length];
		int i = start;
		int j = m + 1;
		int c = 0;
		
		while (i <= m && j <= end) {
			if (arrays[i] < arrays[j]) {
				temp[c++] = arrays[i++];
			} else {
				temp[c++] = arrays[j++];
			}
		}
		
		while (i <= m) {
			temp[c++] = arrays[i++];
		}
		while (j <= end) {
			temp[c++] = arrays[j++];
		}
		
		c = 0;
		for (int t = start; t <= end; t++) {
			arrays[t] = temp[c++];
		}
	}

	// 打印数组
	public void print(int[] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + "\t");
		}
		System.out.println();
	}
}