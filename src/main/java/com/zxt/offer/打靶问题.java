package com.zxt.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @Description: 一个射击运动员打靶，靶一共有10环，连开10 枪打中90环的可能性有多少？
 *               思路：这道题的思路与字符串的组合很像，用递归解决。一次射击有11种可能，命中1环至10环，或脱靶(0)。
 *
 * @author： zxt
 *
 * @time: 2018年5月3日 下午5:27:26
 *
 */
public class 打靶问题 {

	// 用来记录符合条件的组合的每次打靶数  ArrayList<Integer>：记录符合要求的一个组合
	// LinkedList 的删除与增加操作的效率比  ArrayList 高
	private static ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
	
	public static int count = 0;
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		countResult(3, 20, list);
		System.out.println(count);
		
		System.out.println(result);
	}
	
	/**
	 * 
	 * @Description:每一次打靶所得的分数，都有11中可能即：0-11
	 * 
	 * @param number：总共打靶次数
	 * @param sum：需要打中的环数
	 * @param list：当前各次打靶的组合
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static void countResult(int number, int sum, LinkedList<Integer> list) {
		// number * 10 < sum   可以过滤掉一部分无用数据
		if(sum < 0 || number * 10 < sum) {
			return ;
		}
		
		// 最后一枪
		if(number == 1) {
			// 如果剩余环数小于10，只要最后一枪打sum环就可以了
			if(sum <= 10) {
				count++;
				
				// 这里顺便把每次打靶环数的组合也记录下来
				list.add(sum);
				// 这里的list是一个引用，而且一直在修改,所以在函数结束之后，result中有元素，但都是空的
				// result.add(list);
				
				// 这里添加一个当前list的拷贝，就可以把它保存下来
				result.add((LinkedList<Integer>)list.clone());
				list.removeLast();
			}
			return ;
		}
		
		// 每次打靶可能命中的环数  0—10
		for(int i = 0; i <= 10; i++) {
			list.add(i);
			// 剩余打靶次数
			countResult(number - 1, sum - i, list);
			list.removeLast();
		}
	}
}
