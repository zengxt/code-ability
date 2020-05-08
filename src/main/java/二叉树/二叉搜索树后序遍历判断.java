package ������;

/**
 * 
 * @Description: ����һ�����У��жϸ������ǲ��Ƕ����������ĺ����������
 *
 * @author�� zxt
 *
 * @time: 2018��6��19�� ����8:48:59
 *
 */
public class ������������������ж� {

	public static void main(String[] args) {
		������������������ж� is = new ������������������ж�();
		
		int[] sequence = {5, 7, 6, 9, 11, 10, 8};
		System.out.println(is.verifySquenceOfBST(sequence));
		
		int[] sequence2 = {7, 4, 6, 5};
		System.out.println(is.verifySquenceOfBST(sequence2));
	}
	
	/**
	 * 
	 * @Description:������������һ���ڵ�Ϊ���ڵ㡣���ڶ����������У����ڵ��ֵ������������С�����������ݹ��ж�������������
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean verifySquenceOfBST(int [] sequence) {
		if(sequence == null || sequence.length == 0) {
			return false;
		}
		
		return verify(sequence, 0, sequence.length - 1);
    }
	
	public boolean verify(int [] sequence, int start, int end) {
		// ���ڵ�
		int root = sequence[end];
		
		// �ڶ������������������ڵ��ֵС�ڸ��ڵ��ֵ
		int leftIndex = 0;
		while(sequence[leftIndex] < root) {
			leftIndex++;
		}
		
		// �ڶ������������������ڵ��ֵ���ڸ��ڵ��ֵ
		int rightIndex = leftIndex;
		while(rightIndex < end) {
			if(sequence[rightIndex] < root) {
				return false;
			}
			rightIndex++;
		}
		
		// �ж��������ǲ��Ƕ���������
		boolean left = true;
		if(leftIndex > 0) {
			left = verify(sequence, start, leftIndex - 1);
		}
		
		// �ж��������ǲ��Ƕ���������
		boolean right = true;
		if(leftIndex < end) {
			right = verify(sequence, leftIndex, end - 1);
		}
		
		return (left && right);
	}
}
