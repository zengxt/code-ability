package com.zxt.jianzhi.数组;

/**
 * 
 * @Description: 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author： zxt
 *
 * @time: 2018年6月27日 下午5:33:15
 *
 */
public class 机器人的运动范围 {

	public static void main(String[] args) {
		机器人的运动范围 test = new 机器人的运动范围();
		
		System.out.println(test.movingCount(100, 100, 18));
	}
	
	/**
	 * 
	 * @Description：返回机器人能够到达的格子的总数
	 * 
	 * @param threshold：数位之和的阈值
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
		
		// 判断机器人能否进入坐标为（row，col）的方格
		if((row >= 0 && row < rows) && (col >= 0 && col < cols) &&
				(getDigitSum(row) + getDigitSum(col) <= threshold) && !visited[row * cols + col]) {
			
			// 机器人可以达到位置（row，col）
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
	 * @Description：得到一个数的数位之和
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
