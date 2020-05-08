package basic_class_06;

public class Dijkstra {
	// inf��ʾ�����ľ��벻�ɴ����ʹ��Integer�����ֵ������ӷ���������
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
	 * @Description����Դ���·������
	 * 
	 * @param dis
	 * @param startIndex
	 * @return
	 */
	public static int[] dijkstra(int[][] dis, int startIndex) {
		// ���·������
		int[] distance = new int[dis.length];
		// ǰ���ڵ�
		int[] prev = new int[dis.length];
		// ��ǽڵ��Ƿ���뵽������
		boolean[] flag = new boolean[dis.length];
		
		// ��ʼ��
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
			// �ҵ���ǰδʹ�ýڵ����̾���
			for(int j = 0; j < dis.length; j++) {
				if(j != startIndex && !flag[j] && distance[j] < mindis) {
					u = j;
					mindis = distance[j];
				}
			}
			flag[u] = true;
			
			// ���µ������ڵ�ľ���
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
