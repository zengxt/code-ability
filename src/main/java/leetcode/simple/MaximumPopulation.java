package leetcode.simple;

/**
 * ����һ����ά�������� logs ������ÿ�� logs[i] = [birthi, deathi] ��ʾ�� i ���˵ĳ�����������ݡ�
 * ��� x �� �˿� ����Ϊ��һ���ڼ���ŵ��˵���Ŀ���� i ���˱�������� x ���˿���Ҫ���㣺x �ڱ����� [birthi, deathi - 1] �ڡ�
 * ע�⣬�˲�Ӧ��������������������˿��С�
 * <p>
 * ���� �˿���� �� ���� ����ݡ�
 * <p>
 * ʾ�� 1��
 * ���룺logs = [[1993,1999],[2000,2010]]
 * �����1993
 * ���ͣ��˿����Ϊ 1 ���� 1993 ���˿�Ϊ 1 ��������ݡ�
 * <p>
 * ʾ�� 2��
 * ���룺logs = [[1950,1961],[1960,1971],[1970,1981]]
 * �����1960
 * ���ͣ��˿����Ϊ 2 ���ֱ������ 1960 �� 1970 ��
 * ������������� 1960 ��
 * <p>
 * ��ʾ��
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 */
public class MaximumPopulation {
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
        System.out.println(maximumPopulation(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}));
        System.out.println(maximumPopulation1(new int[][]{{1993, 1999}, {2000, 2010}}));
        System.out.println(maximumPopulation1(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}));
    }

    // ��������项
    public static int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        for (int[] log : logs) {
            years[log[0] - 1950]++; // ��һ���˿�����
            years[log[1] - 1950]--; // ��һ���˿ڼ���
        }

        int result = 0;
        int maxPopulation = years[0];
        for (int i = 1; i < years.length; i++) {
            years[i] += years[i - 1];
            if (years[i] > maxPopulation) {
                maxPopulation = years[i];
                result = i;
            }
        }

        return result + 1950;
    }

    // ������
    public static int maximumPopulation1(int[][] logs) {
        int[] years = new int[101];
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                years[i - 1950]++;
            }
        }

        int result = 0;
        int maxPopulation = Integer.MIN_VALUE;
        for (int i = 0; i < years.length; i++) {
            if (years[i] > maxPopulation) {
                maxPopulation = years[i];
                result = i;
            }
        }

        return result + 1950;
    }

}
