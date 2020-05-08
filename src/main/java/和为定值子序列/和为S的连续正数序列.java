package 和为定值子序列;

import java.util.ArrayList;

/**
 * 
 * @Description: 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * @author： zxt
 *
 * @time: 2018年9月2日 下午4:55:46
 *
 */
public class 和为S的连续正数序列 {

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
		// 因为至少需要两个数，所以small最大到middle
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
