package com.zxt.jianzhi;

/**
 * 
 * @Description: LL���������ر�ã���Ϊ��ȥ����һ���˿��ƣ����������Ȼ��2��������2��С��(һ����ԭ����54��^_^)...
 * ��������г����5���ƣ������Լ��������������ܲ��ܳ鵽˳�ӣ�����鵽�Ļ���������ȥ��������Ʊ���ٺ٣���
 * ������A������3��С������������Ƭ5������Oh My God!������˳��.....LL�������ˣ��������룬������\С �����Կ����κ����֣�����A����1��JΪ11��QΪ12��KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1��2��3��4��5��(��С���ֱ���2��4)����So Lucky!����LL����ȥ��������Ʊ���� 
 * ���ڣ�Ҫ����ʹ�������ģ������Ĺ��̣�Ȼ���������LL��������Σ�����������˳�Ӿ����true����������false��Ϊ�˷���������������Ϊ��С����0��
 *
 * @author�� zxt
 *
 * @time: 2018��10��5�� ����8:49:04
 *
 */
public class �˿���˳�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 2, 5, 4};
		System.out.println(isContinuous(numbers));
	}
	
	/**
	 * 
	 * @Description������һ���������ֻ��14����ֵ��0-13������˿��Զ���һ������Ϊ14������������5���ƣ�ͳ������0�ĸ������Լ�������֮��ļ����С
	 * 
	 * @param numbers
	 * @return
	 */
	public static boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length < 1) {
			return false;
		}
		
		int[] times = new int[14];
		for(int i = 0; i < numbers.length; i++) {
			times[numbers[i]]++;
		}
		
		// 0�ĸ���
		int numberOfZero = times[0];
		// ����ĸ������������ͨ��0��ת����������Ե� numberOfZero > numberOfGapʱ������ͻ��������ģ�
		int numberOfGap = 0;
		int pre = -1;
		// ע������j���Ƶ���ֵ��times[j]�Ǹ���ֵ���ֵĴ���
		for(int j = 1; j < times.length; j++) {
			// �����˶��ӣ���϶�����˳��
			if(times[j] > 1) {
				return false;
			}
			
			if(times[j] != 0) {
				if(pre == -1) {
					pre = j;
				} else {
					numberOfGap += j - pre - 1;
					pre = j;
				}
			}
			
			if(numberOfGap > numberOfZero) {
				return false;
			}
		}
		
		return numberOfZero >= numberOfGap;
    }
}
