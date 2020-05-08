package ����;

import java.util.ArrayList;

/**
 * 
 * @Description: �ϲ��������������
 *
 * @author�� zxt
 *
 * @time: 2018��4��18�� ����9:44:07
 *
 */
public class �ϲ�������������� {

	public static void main(String[] args) {
		int[] arrayOne = { 1, 3, 5 };
		int[] arrayTwo = { 2, 4, 6 };

		System.out.println(mergeArrays(arrayOne, arrayTwo));
	}

	/**
	 * 
	 * @Description���ϲ�������������
	 * 
	 * @param arrayOne
	 * @param arrayTwo
	 * @return
	 */
	public static ArrayList<Integer> mergeArrays(int[] arrayOne, int[] arrayTwo) {
		int arrayOneLen = arrayOne.length;
		int arrayTwoLen = arrayTwo.length;
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		
		int i = 0, j = 0;
		while (i < arrayOneLen || j < arrayTwoLen) {
			// �������һ�������Ѿ��ϲ���ϣ������һ��������ʣ��İ�˳����ӵ������鼴��
			// �൱��ֵ�ϴ��������ʣ���Ԫ��ֱ��ƴ���ںϲ�����ĺ��棬����Ҳ������������Сѭ��������
			if (i == arrayOneLen && j < arrayTwoLen) {
				resultArray.add(arrayTwo[j++]);
			} else if (i < arrayOneLen && j == arrayTwoLen) {
				resultArray.add(arrayOne[i++]);
				
			} else {
				// ������������е�ǰ��С��ֵ
				if (arrayOne[i] <= arrayTwo[j]) {
					resultArray.add(arrayOne[i++]);
				} else if (arrayOne[i] > arrayTwo[j]) {
					resultArray.add(arrayTwo[j++]);
				}
			}
		}

		return resultArray;
	}
}
