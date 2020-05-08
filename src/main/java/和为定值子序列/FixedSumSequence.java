package 和为定值子序列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 求数组中和为给定值的所有子序列
 * 
 * 如：数组[1,2,3,4,5,6]，sum=7时，满足条件的子数组有[1,2,4],[3,4],[2,5],[1,6];
 * 
 * @author zxt
 *
 */
public class FixedSumSequence {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 5, 5, 6, 1, 4, 4 };
		// 数组升序排序
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[arr.length];
		
		// 求和为sum的所有组合数
		backTrack(arr, visited, 0, 0, 7, lists);
		System.out.println(lists);
		System.out.println(lists.size());
	}

	// 求一个数组中和为定值的所有子序列
	public static void backTrack(int[] input, boolean[] visited, int n, int sum, int key,
			ArrayList<ArrayList<Integer>> lists) {

		// 如果条件为：if (sum % key == 0 && sum != 0) 则是求所有和为定值整数倍的序列
		if (sum == key) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= n; j++) {
				if (visited[j]) {
					list.add(input[j]);
				}
			}
			lists.add(list);
			return;
		}

		for (int i = n; i < input.length; i++) {
			if (!visited[i]) {
				sum += input[i];
				visited[i] = true;
				if (i != input.length - 1) {
					backTrack(input, visited, i + 1, sum, key, lists);
				} else {
					backTrack(input, visited, i, sum, key, lists);
				}

				visited[i] = false;
				sum -= input[i];
				
				// 重复的元素只统计一次，否则会出现重复（而次操作的前提是，序列已经排序。所以参数input数组是排序好的）
				while (i < input.length - 1 && input[i] == input[i + 1]) {
					i++;
				}
			}
		}
	}
}