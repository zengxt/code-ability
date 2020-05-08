package basic_class_04;

/**
 * 
 * @Description: ����Ŀ�� ���һ��ֽ�����ŷ��������ϣ�Ȼ���ֽ�����±����Ϸ�����1�Σ�ѹ���ۺۺ�չ������ʱ�ۺ��ǰ���ȥ�ģ����ۺ�ͻ��ķ���ָ��ֽ���ı��档
 * �����ֽ�����±����Ϸ���������2�Σ�ѹ���ۺۺ�չ������ʱ�������ۺۣ����ϵ������������ۺۡ����ۺۺ����ۺۡ�
 * ����һ ���������N������ֽ�������±����Ϸ���������N�Σ�����ϵ��´�ӡ�����ۺ۵ķ��� ���磺N=1ʱ����ӡ�� down��N=2ʱ����ӡ�� down down up
 *
 * @author�� zxt
 *
 * @time: 2018��11��16�� ����9:56:07
 *
 */
public class Code_05_PaperFolding {

	public static void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	public static void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.println(down ? "down " : "up ");
		printProcess(i + 1, N, false);
	}

	public static void main(String[] args) {
		int N = 4;
		printAllFolds(N);
	}
}
