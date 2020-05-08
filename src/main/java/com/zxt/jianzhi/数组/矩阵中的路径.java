package com.zxt.jianzhi.����;

/**
 * 
 * @Description: �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ�
 *  ���� a b c e s f c s a d e e �����а���һ���ַ���"bcced"��·����
 *  ���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 *
 * @author�� zxt
 *
 * @time: 2018��6��27�� ����4:08:24
 *
 */
public class �����е�·�� {

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
		
		// Ĭ�϶�Ϊfalse
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
	 * @Description:������������Ϊ��row��col���ĸ��Ӻ�·���ַ������±�ΪpathLength���ַ�һ��ʱ��
	 * ��4�����ڵĸ�����ȥ��λ·���ַ������±�ΪpathLength���ַ�
	 * ���4�����ڵĸ��Ӷ�û��ƥ��pathLength+1��˵��pathLength�ַ��ھ����еĶ�λ����ȷ����Ҫ�ص�pathLength-1���¶�λ��
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
