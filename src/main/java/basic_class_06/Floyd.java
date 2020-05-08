package basic_class_06;

/**
 * 
 * @Description: ���·���㷨Floyd
 *
 * @author�� zxt
 *
 * @time: 2019��1��5�� ����11:08:46
 *
 */
public class Floyd {

	public static void main(String[] args) {
		// inf��ʾ�����ľ��벻�ɴ����ʹ��Integer�����ֵ������ӷ���������
		int inf = 100000000;
		int[][] dis = {{0, 2, 6, 4},
					   {inf, 0, 3, inf},
					   {7, inf, 0, 1},
					   {5, inf, 12, 0}};

		System.out.println("��ʼʱ·����");
		print(dis);
		
		// Floyd�㷨ʵ��
		for(int k = 0; k < dis.length; k++) {
			for(int i = 0; i < dis.length; i++) {
				for(int j = 0; j < dis[0].length; j++) {
					if(dis[i][j] > dis[i][k] + dis[k][j]) {
						dis[i][j] = dis[i][k] + dis[k][j];
					}
				}
			}
		}
		System.out.println("Floyd��·����");
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
