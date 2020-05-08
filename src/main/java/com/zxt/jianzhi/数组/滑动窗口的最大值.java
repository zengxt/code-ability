package com.zxt.jianzhi.����;

import java.util.ArrayList;

/**
 * 
 * @Description: ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 *  {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 *   {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 *
 * @author�� zxt
 *
 * @time: 2018��9��3�� ����2:59:32
 *
 */
public class �������ڵ����ֵ {
	
	public static void main(String[] args) {
		System.out.println(maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
		
		System.out.println(maxInWindows2(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
	}
	
	/**
	 * 
	 * @Description��ÿ���±궼�����size���ȣ�Ȼ����С�������ֵ����СС�ļ�֦������Ƴ����ڵ�ֵ�����ֵС����ô�µ����ֵΪԭ�����ֵ����ֵ�����ֵ��
	 * 
	 * @param num
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// ���ڵĴ�С��������ĳ��ȣ�Ҳ��û������
		if(num == null || size <= 0 || size > num.length) {
			return list;
		}
		
		int tempMax = Integer.MIN_VALUE;
		// ��һ�����ڵ����ֵ
		for(int i = 0; i < size; i++) {
			if(num[i] > tempMax) {
				tempMax = num[i];
			}
		}
		list.add(tempMax);
		
		for(int i = 1; i <= num.length - size; i++) {
			// ����¼��봰�ڵ�ֵ��ԭ�������ֵ����ôֱ�Ӹ���
			if(num[i + size - 1] >= tempMax) {
				tempMax = num[i + size - 1];
			} else {
				// �Ƴ����ڵ�ֵ�����ֵС����ô���ø���
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
	 * @Description������ķ�����ֻ����һ�����ֵ�������ֵ�����ܣ��Ƴ���������ʱ������Ҫ���±���Ѱ�ң�������ﱣ�������ܳ�Ϊ���ֵ������
	 * ������Ҫ�жϱ����������Ƿ��ڴ����У���˱�����ʱ��Ӧ�ñ������ֶ�Ӧ�������±�
	 * 
	 * @param num
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// ���ڵĴ�С��������ĳ��ȣ�Ҳ��û������
		if(num == null || size <= 0 || size > num.length) {
			return list;
		}
		
		// ������ܳ�Ϊ���ֵ�������±꣨���ֵ�±�������ǰ��  index 0��
		ArrayList<Integer> probableMax = new ArrayList<Integer>();
		int start = 0;
		for(int i = 0; i < num.length; i++) {
			// �����ǰԪ�ر���ǰ���Ԫ�ش���ôǰ���Ԫ�ؿ϶�û�л����Ϊ���ֵ
			while(!probableMax.isEmpty() && num[i] > num[probableMax.get(probableMax.size() - 1)]) {
				probableMax.remove(probableMax.size() - 1);
			}
			// ���ȵ�ǰԪ��С�Ķ�ȥ���ˣ����ߵ�ǰԪ�ؽ�С��ǰ���Ԫ���뿪����ʱ�������л����Ϊ���ֵ����ֱ�Ӽ�����ܳ�Ϊ���ֵ��������
			probableMax.add(i);
			
			// ��i��Ԫ��Ϊ���ڵĽ�β��Ԫ��
			if((i + 1 - start) == size) {
				list.add(num[probableMax.get(0)]);
				start++;
				
				// ����λ���ƶ��ˣ���ô����Ŀ��ܳ�Ϊ���ֵ�����в��ڴ����е�Ԫ��Ҳ��Ҫɾ��
				if(!probableMax.isEmpty() && probableMax.get(0) < start) {
					probableMax.remove(0);
				}
			}
		}
		
		return list;
	}
}
