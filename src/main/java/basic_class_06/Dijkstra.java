package basic_class_06;

public class Dijkstra {
	// inf表示两点间的距离不可达，不能使用Integer的最大值，否则加法运算会溢出
	public static int inf = 100000000;

	public static void main(String[] args) {
		int[][] dis = {{0, 6, 3, inf, inf, inf},
					   {6, 0, 2, 5, inf, inf},
					   {3, 2, 0, 3, 4, inf},
					   {inf, 5, 3, 0, 2, 3},
					   {inf, inf, 4, 2, 0, 5},
					   {inf, inf, inf, 3, 5, 0}};

		int startIndex = 0;
		int[] distance = dijkstra(dis, startIndex);
		for(int i = 0; i < distance.length; i++) {
			System.out.print(distance[i] + "\t");
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @Description：单源最短路径距离
	 * 
	 * @param dis
	 * @param startIndex
	 * @return
	 */
	public static int[] dijkstra(int[][] dis, int startIndex) {
		// 最短路径距离
		int[] distance = new int[dis.length];
		// 前驱节点
		int[] prev = new int[dis.length];
		// 标记节点是否放入到集合中
		boolean[] flag = new boolean[dis.length];
		
		// 初始化
		for(int i = 0; i < dis.length; i++) {
			distance[i] = dis[startIndex][i];
			flag[i] = false;
			if(distance[i] == inf) {
				prev[i] = -1;
			} else {
				prev[i] = startIndex;
			}
		}
		
		flag[startIndex] = true;
		for(int i = 0; i < dis.length; i++) {
			int mindis = Integer.MAX_VALUE;
			int u = startIndex;
			// 找到当前未使用节点的最短距离
			for(int j = 0; j < dis.length; j++) {
				if(j != startIndex && !flag[j] && distance[j] < mindis) {
					u = j;
					mindis = distance[j];
				}
			}
			flag[u] = true;
			
			// 更新到其他节点的距离
			for(int k = 0; k < dis.length; k++) {
				if(!flag[k] && distance[k] > distance[u] + dis[u][k]) {
					distance[k] = distance[u] + dis[u][k];
					prev[k] = u;
				}
			}
		}
		
		return distance;
	}

}
