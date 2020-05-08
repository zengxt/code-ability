package basic_class_07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @Description: һЩ��ĿҪռ��һ�������������������Ҳ���ͬʱ����������Ŀ�������� ����ÿһ����Ŀ��ʼ��ʱ��ͽ�����ʱ��(����һ�����飬���� ��һ�����������Ŀ)��
 * ���������������ճ̣�Ҫ������ҽ��� �������ĳ�����ࡣ������������������Ρ�
 *
 * @author�� zxt
 *
 * @time: 2018��11��20�� ����8:29:42
 *
 */
public class Code_06_BestArrange {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (start <= programs[i].start) {
				result++;
				start = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
