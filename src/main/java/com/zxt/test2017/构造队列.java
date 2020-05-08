package com.zxt.test2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @Description: С��ͬѧ��1��n��n�����ְ���һ����˳�������һ������Q�С��������Զ���Qִ�������³���
 * while(!Q.empty())              //���в��գ�ִ��ѭ��
 * {
 * 		int x=Q.front();         //ȡ����ǰ��ͷ��ֵx
 * 		Q.pop();                 //������ǰ��ͷ
 * 		Q.push(x);               //��x�����β
 * 		x = Q.front();           //ȡ����ʱ���ͷ��ֵ
 * 		printf("%d\n",x);        //���x
 * 		Q.pop();                 //������ʱ��Ķ�ͷ
 * }
 * ��ȡ����ͷ��ֵ������ʱ�򣬲���������ǰ��ͷ��
 * 
 * С��ͬѧ���֣���γ���ǡ�ð�˳�������1,2,3,...,n������С�������㹹���ԭʼ�Ķ��У�����������
 * 
 * ��������:��һ��һ������T��T �� 100����ʾ����������ÿ����������һ����n��1 �� n �� 100000�������������n֮�Ͳ�����200000��
 * 
 * �������:����ÿ�����ݣ����һ�У���ʾԭʼ�Ķ��С�����֮����һ���ո��������Ҫ����ĩ�������Ŀո�.
 * 
 * ʾ��1
 * ����
 * 4
 * 1
 * 2
 * 3
 * 10
 * 
 * ���
 * 1
 * 2 1
 * 2 1 3
 * 8 1 6 2 10 3 7 4 9 5
 *
 * @author�� zxt
 *
 * @time: 2018��8��19�� ����3:12:43
 *
 */
public class ������� {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			
			int[] result = getQueue(n);
			for(int j = 0; j < result.length; j++) {
				if(j != result.length - 1) {
					System.out.print(result[j] + " ");
				} else {
					System.out.println(result[j]);
				}
			}
			
			ArrayList<Integer> result2 = getQueue2(n);
			for(int j = 0; j < result2.size(); j++) {
				if(j != result2.size() - 1) {
					System.out.print(result2.get(j) + " ");
				} else {
					System.out.println(result2.get(j));
				}
			}
			
		}
	}
	
	/**
	 * 
	 * @Description�����ڳ��ӵ�����Ϊ����ͷ�ŵ���β��Ȼ�������ͷ��ѭ�������������һ��Ҫ���ӵ�Ԫ�������ڵڶ���λ�ã����ÿ�μ��һ����λ���Ԫ�ؼ���
	 * 
	 * @param n
	 * @return
	 */
	public static int[] getQueue(int n) {
		int[] result = new int[n];
		
		if(n == 1) {
			result[0] = 1;
			
		} else {
			int data = 1;
			int index = 0;
			int times = n;
			boolean flag = false;
			while(times != 0) {
				
				// ���һ��0
				while(!flag) {
					if(result[index] == 0) {
						flag = true;
					}
					index = (index + 1) % n;
				}
				while(result[index] != 0) {
					index = (index + 1) % n;
				}
				flag = false;
				
				result[index] = data++;
				times--;
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @Description������˳�򣬶�ͷԪ�طŵ�����β��Ȼ����ӣ����¹���Ļ�����ȫ��������ÿ����ӣ���Ӻ󣬽���βԪ�طŵ���ͷ����������ҲҪ������
	 * 
	 * @param n
	 * @return
	 */
	public static ArrayList<Integer> getQueue2(int n) {
		// ��һ��������ģ����У������±�Ϊ0��ʾ��ͷ
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = n; i > 0; i--) {
			result.add(0, i);
			result.add(0, result.remove(result.size() - 1));
		}
		
		return result;
	}

}
