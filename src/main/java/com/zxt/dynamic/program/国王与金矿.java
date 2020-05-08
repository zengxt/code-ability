package com.zxt.dynamic.program;

/**
 * @Description: ��һ�����ҷ�����5�����ÿ�����Ļƽ�����ͬ����Ҫ�����ھ�Ĺ�����Ҳ��ͬ�������ڿ��˵�������10�ˡ�
 * ÿ�����Ҫôȫ�ڣ�Ҫô���ڣ������ɳ�һ������ȡһ����Ҫ���ó���������Ҫ��õ������ܶ�Ļƽ�Ӧ��ѡ����ȡ�ļ������
 * <p>
 * ������Ϣ���ƽ��� / ���蹤������500/5��200/3��300/4��350/3��400/5
 * @author�� zxt
 * @time: 2018��6��30�� ����5:27:39
 */
public class �������� {

    public static void main(String[] args) {
        int N = 5;
        int W = 10;
        int[] G = {400, 500, 200, 300, 350};
        int[] P = {5, 5, 3, 4, 3};

        // �ݹ鷨
        System.out.println(getMostGlod(G, P, N, W));

        // ��̬�滮���������е����������Ž�
        System.out.println(getMostGlod(N, W, G, P));

        // ��̬�滮������ǰһ��������Ľ������
        System.out.println(getMostGlod2(N, W, G, P));
    }

    /**
     * @param G
     * @param P
     * @param N
     * @param W
     * @return
     * @Description��ʹ�õݹ�ķ�ʽ��⣨ʱ�临�ӶȽϸߣ�
     */
    public static int getMostGlod(int[] G, int[] P, int N, int W) {
        if (N <= 1 && W < P[0]) {
            return 0;
        }
        if (N == 1 && W >= P[0]) {
            return G[0];
        }

        if (N > 1 && W < P[N - 1]) {
            return getMostGlod(G, P, N - 1, W);
        }

        return Math.max(getMostGlod(G, P, N - 1, W), getMostGlod(G, P, N - 1, W - P[N - 1]) + G[N - 1]);
    }

    /**
     * @param N�������
     * @param W��������
     * @param G��ÿ�����Ļƽ���
     * @param P��ÿ�������Ҫ�Ĺ���
     * @return
     * @Description�������Ե����ϵĲ��ԣ����һ����ά������Ԫ�ر�ʾn�����w�����ڵ��������
     */
    public static int getMostGlod(int N, int W, int[] G, int[] P) {

        int[][] result = new int[N][W + 1];

        // ��ʼ��ʱ����ʾһ�����i�����˵��������
        for (int i = 1; i <= W; i++) {
            // �����������ڵ�һ�����
            if (i < P[0]) {
                result[0][i] = 0;
            } else {
                result[0][i] = G[0];
            }
        }

        // �Ե����ϣ��𲽵��ơ����ѭ���ǽ���������ڲ�ѭ���ǹ�����
        for (int i = 1; i < N; i++) {

            for (int j = 1; j <= W; j++) {
                // �˲����϶�����
                if (j < P[i]) {
                    result[i][j] = result[i - 1][j];

                } else {
                    // �˹��ˣ��ڲ��ڵ�i�����
                    result[i][j] = Math.max(result[i - 1][j], (result[i - 1][j - P[i]] + G[i]));
                }
            }
        }

        return result[N - 1][W];
    }

    /**
     * @param N�������
     * @param W��������
     * @param G��ÿ�����Ļƽ���
     * @param P��ÿ�������Ҫ�Ĺ���
     * @return
     * @Description��ʵ�ʲ����У�������Ҫ�����ı�ֻ��Ҫ֪��ǰһ�м���
     */
    public static int getMostGlod2(int N, int W, int[] G, int[] P) {

        int[] result = new int[W + 1];
        int[] preResult = new int[W + 1];

        // ��ʼ��ʱ����ʾһ�����i�����˵��������
        for (int j = 1; j <= W; j++) {
            // �����������ڵ�һ�����
            if (j < P[0]) {
                preResult[j] = 0;
            } else {
                preResult[j] = G[0];
            }
        }

        // �Ե����ϣ��𲽵��ơ����ѭ���ǽ���������ڲ�ѭ���ǹ�����
        for (int i = 1; i < N; i++) {

            for (int j = 1; j <= W; j++) {
                // �˲����϶�����
                if (j < P[i]) {
                    result[j] = preResult[j];

                } else {
                    // �˹��ˣ��ڲ��ڵ�i�����
                    result[j] = Math.max(preResult[j], (preResult[j - P[i]] + G[i]));
                }
            }

            // �ر�ע�⣺Java��������һ���������ֱ�ӵ��ڵĻ���preResult��result��ʵ��ָ��ͬһ��λ�ã������޷�������һ�εĽ��
            // preResult = result;
            System.arraycopy(result, 0, preResult, 0, preResult.length);
        }

        return result[W];
    }
}
