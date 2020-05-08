package ����;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * �������к�Ϊ����ֵ������������
 * 
 * �磺����[1,2,3,4,5,6]��sum=7ʱ��������������������[1,2,4],[3,4],[2,5],[1,6];
 * 
 * @author zxt
 *
 */
public class �����к�Ϊ��ֵ�������� {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 5, 5, 6, 1, 4, 4 };
		// ������������
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[arr.length];
		
		// ���Ϊsum�����������
		backTrack(arr, visited, 0, 0, 7, lists);
		System.out.println(lists);
		System.out.println(lists.size());
	}

	/**
	 * 
	 * @Description:��һ�������к�Ϊ��ֵ������������
	 * 
	 * @param input����Ҫ����������
	 * @param visited����¼�����е�Ԫ���Ƿ񱻷���
	 * @param start������Ŀ�ʼ����
	 * @param currentSum����ǰ�Ѿ���õĺ�
	 * @param needSum����Ҫ�������
	 * @param lists����¼���������к�Ϊָ����ֵ��������
	 */
	public static void backTrack(int[] input, boolean[] visited, int start, int currentSum, int needSum,
			ArrayList<ArrayList<Integer>> lists) {

		// �������Ϊ��if (currentSum % needSum == 0 && currentSum != 0) ���������к�Ϊ��ֵ������������
		if (currentSum == needSum) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= start; j++) {
				if (visited[j]) {
					list.add(input[j]);
				}
			}
			lists.add(list);
			return;
		}

		for (int i = start; i < input.length; i++) {
			if (!visited[i]) {
				currentSum += input[i];
				visited[i] = true;
				
				backTrack(input, visited, i, currentSum, needSum, lists);

				visited[i] = false;
				currentSum -= input[i];
				
				// �ظ���Ԫ��ֻͳ��һ�Σ����������ظ������˲�����ǰ���ǣ������Ѿ��������Բ���input����������õģ�
				while (i < input.length - 1 && input[i] == input[i + 1]) {
					i++;
				}
			}
		}
	}
}