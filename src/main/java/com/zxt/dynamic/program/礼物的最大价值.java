package com.zxt.dynamic.program;

/**
 * @Description: 在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格，知道到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿多少价值的礼物？
 * @author： zxt
 * @time: 2018年7月14日 下午4:14:12
 */
public class 礼物的最大价值 {

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
     * @Description：典型的动态规划题，定义f(i,j)表示到达坐标为(i,j)的格子时能拿到的礼物总和最大值，根据题意，有两种方式到达(i,j) 所以：f(i,j) = max(f(i-1,j), (i,j-1)) + gift[i][j];
     */
    public static int getMaxGiftValue(int[][] giftArray) {
        if (giftArray == null || giftArray.length == 0 || giftArray[0].length == 0) {
            return 0;
        }

        int rows = giftArray.length;
        int cols = giftArray[0].length;
        // 定义一个数组，保存到坐标（i，j）时能拿到的礼物的最大价值
        int[][] maxValue = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 第一行
                if (row == 0) {
                    // 第一列
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

    // 同上面的实现
    public static int getMaxGiftValue2(int[][] giftArray) {
        if (giftArray == null || giftArray.length == 0 || giftArray[0].length == 0) {
            return 0;
        }

        int rows = giftArray.length;
        int cols = giftArray[0].length;
        // 定义一个数组，保存到坐标（i，j）时能拿到的礼物的最大价值
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
     * @Description：实际上f(i,j)只与f(i-1,j)和f(i,j-1)有关， 所以空间复杂度可以再优化，只用一个一维数组保存最大价值，计算下一行时，当前数组看成是上一行
     */
    public static int getMaxGiftValue3(int[][] giftArray) {
        if (giftArray == null || giftArray.length == 0 || giftArray[0].length == 0) {
            return 0;
        }

        int rows = giftArray.length;
        int cols = giftArray[0].length;
        // 定义一个数组，保存到坐标（i，j）时能拿到的礼物的最大价值
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

                // 计算col时，col前面的值已经更新，表示(row, 0) (row, 1).....(row, col-1)
                // 而col下标及其后面的值还未更新，表示(row-1, col) (row-1, col+1).....(row-1, cols-1)
                maxValue[col] = Math.max(left, up) + giftArray[row][col];
            }
        }

        return maxValue[cols - 1];
    }
}
