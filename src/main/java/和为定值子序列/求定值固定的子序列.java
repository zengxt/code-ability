package 和为定值子序列;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @Description: 题目描述:输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m,要求将其中所有的可能组合列出来
 * 
 *               输入描述:每个测试输入包含2个整数,n和m
 * 
 *               输出描述:按每个组合的字典序排列输出,每行输出一种组合
 *
 * @author： zxt
 *
 * @time: 2018年4月24日 下午8:22:12
 *
 */
public class 求定值固定的子序列 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			
			ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
			boolean[] visited = new boolean[n];
			
			sumFixedArr(arr, visited, 0, 0, m, lists);
			// 输出结果
			for(int i = 0; i < lists.size(); i++) {
				ArrayList<Integer> list = lists.get(i);
				for(int j = 0; j < list.size() - 1; j++) {
					System.out.print(list.get(j) + " ");
				}
				System.out.println(list.get(list.size() - 1));
			}
		}
	}
	
	/**
	 * 
	 * @Description:定值为needSum的所有组合
	 * 
	 * @param arr
	 * @param visited
	 * @param start
	 * @param currentSum
	 * @param needSum
	 * @param lists
	 */
	public static void sumFixedArr(int[] arr, boolean[] visited, int start, int currentSum, int needSum,
			ArrayList<ArrayList<Integer>> lists) {
		
		// 当当前的和等于需要求的和时，记录当前组合
		if(currentSum == needSum) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < arr.length; i++) {
				if(visited[i]) {
					list.add(arr[i]);
				}
			}
			
			lists.add(list);
			
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				currentSum += arr[i];
				
				sumFixedArr(arr, visited, i + 1, currentSum, needSum, lists);
				
				// 恢复原来的状态
				visited[i] = false;
				currentSum -= arr[i];
			}
		}
	}
}
