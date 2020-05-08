package ��Ϊ��ֵ������;

import java.util.ArrayList;

/**
 * 
 * @Description: С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 *
 * @author�� zxt
 *
 * @time: 2018��9��2�� ����4:55:46
 *
 */
public class ��ΪS�������������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindContinuousSequence(15));
	}
	
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		if(sum < 3) {
			return list;
		}
		
		int small = 1;
		int big = 2;
		// ��Ϊ������Ҫ������������small���middle
		int middle = (1 + sum) / 2;
		int currSum = small + big;
		while(small < middle) {
			if(currSum == sum) {
				list.add(addSequence(small, big));
			}
			
			while(currSum > sum && small < middle) {
				currSum -= small;
				small++;
				
				if(currSum == sum) {
					list.add(addSequence(small, big));
				}
			}
			
			big++;
			currSum += big;
		}
		
		return list;
    }
	
	public static ArrayList<Integer> addSequence(int small, int end) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = small; i <= end; i++) {
			list.add(i);
		}
		
		return list;
	}

}
