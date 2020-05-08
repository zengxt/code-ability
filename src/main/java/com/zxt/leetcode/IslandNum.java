package com.zxt.leetcode;

/**
 * ����һ����?'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
 * <p>
 * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�������ֱ���������ڵ�½�������γɡ�
 * <p>
 * ���⣬����Լ��������������߾���ˮ��Χ��
 * <p>
 */
public class IslandNum {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // �߱��������
                    walkTheIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void walkTheIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        // �߹��ĵط����Ϊ 2
        grid[row][col] = '2';
        walkTheIsland(grid, row + 1, col);
        walkTheIsland(grid, row - 1, col);
        walkTheIsland(grid, row, col + 1);
        walkTheIsland(grid, row, col - 1);
    }
}
