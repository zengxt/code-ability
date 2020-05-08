package com.zxt.dynamic.program;

/**
 * @Description: ��һ��m*n�����̵�ÿһ�񶼷���һ�����ÿ�����ﶼ��һ���ļ�ֵ����ֵ����0����
 * ����Դ����̵����Ͻǿ�ʼ�ø�����������ÿ��������������ƶ�һ��֪���������̵����½ǡ�����һ�����̼������������������������ö��ټ�ֵ�����
 * @author�� zxt
 * @time: 2018��7��14�� ����4:14:12
 */
public class ���������ֵ {

    public static void main(String[] args) {
        int[][] giftArray = {{1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}};

        System.out.println(getMaxGiftValue(giftArray));
        System.out.println(getMaxGiftValue2(giftArray));
        System.out.println(getMaxGiftValue3(giftArray));
    }

    /**
     * @param giftArray
     * @return
     * @Description�����͵Ķ�̬�滮�⣬����f(i,j)��ʾ��������Ϊ(i,j)�ĸ���ʱ���õ��������ܺ����ֵ���������⣬�����ַ�ʽ����(i,j) ���ԣ�f(i,j) = max(f(i-1,j), (i,j-1)) + gift[i][j];
     */
    public static int getMaxGiftValue(int[][] giftArray) {
        if (giftArray == null || giftArray.length == 0 || giftArray[0].length == 0) {
            return 0;
        }

        int rows = giftArray.length;
        int cols = giftArray[0].length;
        // ����һ�����飬���浽���꣨i��j��ʱ���õ������������ֵ
        int[][] maxValue = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // ��һ��
                if (row == 0) {
                    // ��һ��
                    if (col == 0) {
                        maxValue[row][col] = giftArray[row][col];
                    } else {
                        maxValue[row][col] = maxValue[row][col - 1] + giftArray[row][col];
                    }

                } else {
                    if (col == 0) {
                        maxValue[row][col] = maxValue[row - 1][col] + giftArray[row][col];
                    } else {
                        maxValue[row][col] = Math.max(maxValue[row][col - 1], maxValue[row - 1][col])
                                + giftArray[row][col];
                    }
                }
            }
        }

        return maxValue[rows - 1][cols - 1];
    }

    // ͬ�����ʵ��
    public static int getMaxGiftValue2(int[][] giftArray) {
        if (giftArray == null || giftArray.length == 0 || giftArray[0].length == 0) {
            return 0;
        }

        int rows = giftArray.length;
        int cols = giftArray[0].length;
        // ����һ�����飬���浽���꣨i��j��ʱ���õ������������ֵ
        int[][] maxValue = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int left = 0;
                int up = 0;

                if (row > 0) {
                    up = maxValue[row - 1][col];
                }
                if (col > 0) {
                    left = maxValue[row][col - 1];
                }

                maxValue[row][col] = Math.max(left, up) + giftArray[row][col];
            }
        }

        return maxValue[rows - 1][cols - 1];
    }

    /**
     * @param giftArray
     * @return
     * @Description��ʵ����f(i,j)ֻ��f(i-1,j)��f(i,j-1)�йأ� ���Կռ临�Ӷȿ������Ż���ֻ��һ��һά���鱣������ֵ��������һ��ʱ����ǰ���鿴������һ��
     */
    public static int getMaxGiftValue3(int[][] giftArray) {
        if (giftArray == null || giftArray.length == 0 || giftArray[0].length == 0) {
            return 0;
        }

        int rows = giftArray.length;
        int cols = giftArray[0].length;
        // ����һ�����飬���浽���꣨i��j��ʱ���õ������������ֵ
        int[] maxValue = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int left = 0;
                int up = 0;

                if (row > 0) {
                    up = maxValue[col];
                }
                if (col > 0) {
                    left = maxValue[col - 1];
                }

                // ����colʱ��colǰ���ֵ�Ѿ����£���ʾ(row, 0) (row, 1).....(row, col-1)
                // ��col�±꼰������ֵ��δ���£���ʾ(row-1, col) (row-1, col+1).....(row-1, cols-1)
                maxValue[col] = Math.max(left, up) + giftArray[row][col];
            }
        }

        return maxValue[cols - 1];
    }
}
