package com.zxt.jianzhi;

/**
 * 
 * @Description: ��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ������������7��
 *  ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 *  
 *  ˼·�������Ͽ��Դ�1��ʼ����������жϣ����������Ļ�ʱ�临�ӶȽϸߣ����ڴ����ķǳ���Ҳ��Ҫ�жϣ���
 *  ��˿���ʹ��һ������Ѵ�С���ĳ�������˳�򱣴���������Ҫ����һ������ʱ���ɵ�ǰ�Ѿ��еĳ������еõ���
 *
 * @author�� zxt
 *
 * @time: 2018��8��20�� ����4:34:15
 *
 */
public class ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getUglyNumber(1500));
	}
	
	public static int getUglyNumber(int index) {
		if(index <= 0) {
			return 0;
		}
		
		// �������������
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		// ��Ҫ�����һ������
		int nextUglyIndex = 1;
		
		// ��һ��������Ȼ��ԭ�г����г��Գ������ӵõ���һ�����ڵ�ǰ�������ֵ����Сֵ��
		// ʹ��һ���±��¼�·ֱ��2��3��5֮�����ڵ�ǰ�������ֵ����С�±꣬��������ǰһ���ֳ������Գ������ӵõ����������Ѿ��������У���˲���Ҫ�ظ��жϣ�
		int pMultiply2 = 0;
		int pMultiply3 = 0;
		int pMultiply5 = 0;
		
		while(nextUglyIndex < index) {
			int min = min(uglyNumbers[pMultiply2] * 2, 
					uglyNumbers[pMultiply3] * 3, uglyNumbers[pMultiply5] * 5);
			// ���minҲ��Ϊ��ǰ�������е����ֵ
			uglyNumbers[nextUglyIndex] = min;
			
			// ����pMultiply2��pMultiply3��pMultiply5��ֵ
			while(uglyNumbers[pMultiply2] * 2 <= uglyNumbers[nextUglyIndex]) {
				pMultiply2++;
			}
			while(uglyNumbers[pMultiply3] * 3 <= uglyNumbers[nextUglyIndex]) {
				pMultiply3++;
			}
			while(uglyNumbers[pMultiply5] * 5 <= uglyNumbers[nextUglyIndex]) {
				pMultiply5++;
			}
			
			nextUglyIndex++;
		}
		
		return uglyNumbers[nextUglyIndex - 1];
	}
	
	public static int min(int number1, int number2, int number3) {
		int min = (number1 < number2) ? number1 : number2;
		min = (min < number3) ? min : number3;
		
		return min;
	}
}
