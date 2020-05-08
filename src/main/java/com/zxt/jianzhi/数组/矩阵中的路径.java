package com.zxt.jianzhi.数组;

/**
 * 
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *  例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 *  但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @author： zxt
 *
 * @time: 2018年6月27日 下午4:08:24
 *
 */
public class 矩阵中的路径 {

	public static void main(String[] args) {
		char[] matrix = {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
		int rows = 3;
		int cols = 4;
		
		char[] str1 = {'b', 'f', 'c', 'e'};
		System.out.println(hasPath(matrix, rows, cols, str1));
		
		char[] str2 = {'a', 'b', 'f', 'b'};
		System.out.println(hasPath(matrix, rows, cols, str2));
	}
	
	/**
	 * 
	 * @Description:TODO 
	 * 
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param str
	 * @return
	 */
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		
		// 默认都为false
		boolean[] visited = new boolean[rows * cols];
		
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < cols; col++) {
				if(hasPathCore(matrix, rows, cols, row, col, str, 0, visited)) {
					return true;
				}
			}
		}
		
		return false;
    }
	
	/**
	 * 
	 * @Description:当矩阵中坐标为（row，col）的格子和路径字符串中下标为pathLength的字符一样时，
	 * 从4个相邻的格子中去定位路径字符串中下标为pathLength的字符
	 * 如果4个相邻的格子都没有匹配pathLength+1，说明pathLength字符在矩阵中的定位不正确，需要回到pathLength-1重新定位。
	 * 
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param row
	 * @param col
	 * @param str
	 * @param pathLength
	 * @return
	 */
	public static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
			char[] str, int pathLength, boolean[] visited) {
		
		if(pathLength == str.length) {
			return true;
		}
		
		boolean hasPath = false;
		if( (row >= 0 && row < rows) && (col >= 0 && col < cols) && 
			(matrix[row * cols + col] == str[pathLength]) && !visited[row * cols + col]) {
			
			++pathLength;
			visited[row * cols + col] = true;
			
			hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);
			
			if(!hasPath) {
				--pathLength;
				visited[row * cols + col] = false;
			}
		}
		
		return hasPath;
	}

}
