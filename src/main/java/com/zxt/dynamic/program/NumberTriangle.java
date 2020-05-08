package com.zxt.dynamic.program;

import java.util.Scanner;

/**
 * @Description: 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * �������������������Ѱ��һ���Ӷ������ױߵ�·����ʹ��·����������������֮�����·���ϵ�ÿһ����ֻ�������»�
 * �����ߡ�ֻ��Ҫ���������ͼ��ɣ����ظ�������·���� �����ε���������1С�ڵ���100������Ϊ 0 - 99
 * <p>
 * �����ʽ��
 * 5 //��ʾ�����ε����� ����������������
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * <p>
 * Ҫ���������
 * <p>
 * ������������������һ�½���˼·�����ȣ��϶����ö�ά������������������Σ�Ȼ��������D(r, j) ����ʾ��r�е� j ������(r,j��1��ʼ��)
 * ������MaxSum(r, j)��ʾ��D(r,j)���ױߵĸ���·���У����·��������֮�͡�
 * ��ˣ��������������ͱ������ MaxSum(1,1)
 * @author�� zxt
 * @time: 2018��3��25�� ����12:11:40
 */
public class NumberTriangle {

    private static int[][] maxSum;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] D = new int[n][n];
        maxSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                D[i][j] = scanner.nextInt();
                maxSum[i][j] = -1;
            }
        }

        System.out.println(maxSumDynamicOptimize(D, 0, 0));
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:�ݹ鷽�����
     */
    public static int maxSum(int[][] D, int i, int j) {
        // �Ѿ��������һ�㣬ֱ�ӷ���
        if (i == D.length - 1) {
            return D[i][j];
        }

        int x = maxSum(D, i + 1, j);
        int y = maxSum(D, i + 1, j + 1);

        return Math.max(x, y) + D[i][j];
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:����ݹ��͵Ķ�̬�滮
     */
    public static int maxSumTable(int[][] D, int i, int j) {
        // �������������Ľ��Ѿ����������ֱ�ӷ���
        if (maxSum[i][j] != -1) {
            return maxSum[i][j];
        }

        if (i == D.length - 1) {
            maxSum[i][j] = D[i][j];

        } else {
            int x = maxSum(D, i + 1, j);
            int y = maxSum(D, i + 1, j + 1);
            maxSum[i][j] = Math.max(x, y) + D[i][j];
        }

        return maxSum[i][j];
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:��̬�滮���
     */
    public static int maxSumDynamic(int[][] D, int i, int j) {
        // ʹ��һ�ű���������Ե����ϵ�����������Ľ�
        int[][] table = new int[D.length][D[0].length];

        // �� table �����һ�и�ֵ
        for (int k = 0; k < D.length; k++) {
            table[D.length - 1][k] = D[D.length - 1][k];
        }

        // �Ե����ϼ������������Ľ�
        for (int p = D.length - 2; p >= 0; p--) {

            for (int q = 0; q <= p; q++) {
                table[p][q] = Math.max(table[p + 1][q], table[p + 1][q + 1]) + D[p][q];
            }
        }

        return table[0][0];
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:��̬�滮��⣨�ռ��Ż��⣩
     */
    public static int maxSumDynamicOptimize(int[][] D, int i, int j) {
        // ʹ��һά�����������Ե����ϵ�����������Ľ⣨ֻ����ǰһ�εļ��ɣ�
        int[] table = new int[D.length];

        // �� table ��ʼ��
        table = D[D.length - 1];

        // �Ե����ϼ������������Ľ�
        for (int p = D.length - 2; p >= 0; p--) {

            for (int q = 0; q <= p; q++) {
                table[q] = Math.max(table[q], table[q + 1]) + D[p][q];
            }
        }

        return table[0];
    }

}
