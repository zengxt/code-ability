package ��Ϊ��ֵ������;

import java.util.ArrayList;

/**
 * 
 * @Description: ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 *
 * @author�� zxt
 *
 * @time: 2018��9��2�� ����4:09:21
 *
 */
public class ��Ϊs�������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 4, 7, 11, 15};
		System.out.println(FindNumbersWithSum(array, 15));
	}
	
	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array == null || array.length < 2) {
			return list;
		}
		
		// �������������Զʵ�������ǵĳ˻�����С(�����ҵ��ĵ�һ�鼴ʱ����Ҫ��������˻���С�����)
		// int minMulti = Integer.MAX_VALUE;
		int start = 0;
		int end = array.length - 1;
		while(start < end) {
			int currSum = array[start] + array[end];
			
			if(currSum == sum) {
				list.add(array[start]);
				list.add(array[end]);
				break;
				
			} else if(currSum < sum) {
				start++;
			} else {
				end--;
			}
		}
		
		return list;
    }

}
