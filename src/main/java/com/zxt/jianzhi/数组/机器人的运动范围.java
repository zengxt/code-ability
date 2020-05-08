package com.zxt.jianzhi.����;

/**
 * 
 * @Description: ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 *
 * @author�� zxt
 *
 * @time: 2018��6��27�� ����5:33:15
 *
 */
public class �����˵��˶���Χ {

	public static void main(String[] args) {
		�����˵��˶���Χ test = new �����˵��˶���Χ();
		
		System.out.println(test.movingCount(100, 100, 18));
	}
	
	/**
	 * 
	 * @Description�����ػ������ܹ�����ĸ��ӵ�����
	 * 
	 * @param threshold����λ֮�͵���ֵ
	 * @param rows
	 * @param cols
	 * @return
	 */
	public int movingCount(int threshold, int rows, int cols) {
		
		if(threshold < 0 || rows <= 0 || cols <= 0) {
			return 0;
		}
		
		boolean[] visited = new boolean[rows * cols];
		int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
		
		return count;
	}
	
	public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		
		// �жϻ������ܷ��������Ϊ��row��col���ķ���
		if((row >= 0 && row < rows) && (col >= 0 && col < cols) &&
				(getDigitSum(row) + getDigitSum(col) <= threshold) && !visited[row * cols + col]) {
			
			// �����˿��Դﵽλ�ã�row��col��
			visited[row * cols + col] = true;
			
			count = 1 + movingCountCore(threshold, rows, cols, row, col - 1, visited)
					  + movingCountCore(threshold, rows, cols, row - 1, col, visited)
					  + movingCountCore(threshold, rows, cols, row, col + 1, visited)
					  + movingCountCore(threshold, rows, cols, row + 1, col, visited);
		}
		
		return count;
	}
	
	/**
	 * 
	 * @Description���õ�һ��������λ֮��
	 * 
	 * @param number
	 * @return
	 */
	public int getDigitSum(int number) {
		int sum = 0;
		while(number > 0) {
			sum += number % 10;
			number /= 10;
		}
		
		return sum;
	}
}
