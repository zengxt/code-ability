package com.zxt.jianzhi.数组;

import java.util.ArrayList;

/**
 * 
 * @Description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *   {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author： zxt
 *
 * @time: 2018年9月3日 下午2:59:32
 *
 */
public class 滑动窗口的最大值 {
	
	public static void main(String[] args) {
		System.out.println(maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
		
		System.out.println(maxInWindows2(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
	}
	
	/**
	 * 
	 * @Description：每个下标都向后走size长度，然后求小区间最大值。（小小的剪枝：如果移出窗口的值比最大值小，那么新的最大值为原来最大值与新值得最大值）
	 * 
	 * @param num
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 窗口的大小大于数组的长度，也算没有区间
		if(num == null || size <= 0 || size > num.length) {
			return list;
		}
		
		int tempMax = Integer.MIN_VALUE;
		// 第一个窗口的最大值
		for(int i = 0; i < size; i++) {
			if(num[i] > tempMax) {
				tempMax = num[i];
			}
		}
		list.add(tempMax);
		
		for(int i = 1; i <= num.length - size; i++) {
			// 如果新加入窗口的值比原来的最大值大，那么直接更新
			if(num[i + size - 1] >= tempMax) {
				tempMax = num[i + size - 1];
			} else {
				// 移出窗口的值比最大值小，那么不用更新
				if(num[i - 1] >= tempMax) {
					tempMax = Integer.MIN_VALUE;
					for(int j = i; j < i + size; j++) {
						if(num[j] > tempMax) {
							tempMax = num[j];
						}
					}
				}
			}
			
			list.add(tempMax);
		}
		
		return list;
    }
	
	/**
	 * 
	 * @Description：上面的方法中只保留一个最大值，当最大值（可能）移出滑动窗口时，则需要重新遍历寻找，因此这里保存多个可能成为最大值的数字
	 * 由于需要判断保留的数字是否在窗口中，因此保留的时候应该保留数字对应的数组下标
	 * 
	 * @param num
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 窗口的大小大于数组的长度，也算没有区间
		if(num == null || size <= 0 || size > num.length) {
			return list;
		}
		
		// 保存可能成为最大值的数字下标（最大值下标总是在前面  index 0）
		ArrayList<Integer> probableMax = new ArrayList<Integer>();
		int start = 0;
		for(int i = 0; i < num.length; i++) {
			// 如果当前元素比它前面的元素大，那么前面的元素肯定没有机会成为最大值
			while(!probableMax.isEmpty() && num[i] > num[probableMax.get(probableMax.size() - 1)]) {
				probableMax.remove(probableMax.size() - 1);
			}
			// 将比当前元素小的都去除了，或者当前元素较小（前面大元素离开窗口时，还是有机会成为最大值），直接加入可能成为最大值的序列中
			probableMax.add(i);
			
			// 第i个元素为窗口的结尾处元素
			if((i + 1 - start) == size) {
				list.add(num[probableMax.get(0)]);
				start++;
				
				// 窗口位置移动了，那么保存的可能成为最大值的序列不在窗口中的元素也需要删除
				if(!probableMax.isEmpty() && probableMax.get(0) < start) {
					probableMax.remove(0);
				}
			}
		}
		
		return list;
	}
}
