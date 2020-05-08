package basic_class_06;

/**
 * 
 * @Description: 最短路径算法Floyd
 *
 * @author： zxt
 *
 * @time: 2019年1月5日 上午11:08:46
 *
 */
public class Floyd {

	public static void main(String[] args) {
		// inf表示两点间的距离不可达，不能使用Integer的最大值，否则加法运算会溢出
		int inf = 100000000;
		int[][] dis = {{0, 2, 6, 4},
					   {inf, 0, 3, inf},
					   {7, inf, 0, 1},
					   {5, inf, 12, 0}};

		System.out.println("初始时路径：");
		print(dis);
		
		// Floyd算法实现
		for(int k = 0; k < dis.length; k++) {
			for(int i = 0; i < dis.length; i++) {
				for(int j = 0; j < dis[0].length; j++) {
					if(dis[i][j] > dis[i][k] + dis[k][j]) {
						dis[i][j] = dis[i][k] + dis[k][j];
					}
				}
			}
		}
		System.out.println("Floyd后路径：");
		print(dis);
	}
	
	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.printf("%15d", array[i][j]);
			}
			System.out.println();
		}
	}

}
