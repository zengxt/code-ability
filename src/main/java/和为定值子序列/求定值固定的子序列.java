package ��Ϊ��ֵ������;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @Description: ��Ŀ����:������������ n �� m��������1��2��3.......n ������ȡ������,ʹ��͵��� m,Ҫ���������еĿ�������г���
 * 
 *               ��������:ÿ�������������2������,n��m
 * 
 *               �������:��ÿ����ϵ��ֵ����������,ÿ�����һ�����
 *
 * @author�� zxt
 *
 * @time: 2018��4��24�� ����8:22:12
 *
 */
public class ��ֵ�̶��������� {

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
			// ������
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
	 * @Description:��ֵΪneedSum���������
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
		
		// ����ǰ�ĺ͵�����Ҫ��ĺ�ʱ����¼��ǰ���
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
				
				// �ָ�ԭ����״̬
				visited[i] = false;
				currentSum -= arr[i];
			}
		}
	}
}
