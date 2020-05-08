package com.zxt.leetcode;

/**
 * 给你一个由?'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
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
                    // 走遍这个岛屿
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

        // 走过的地方标记为 2
        grid[row][col] = '2';
        walkTheIsland(grid, row + 1, col);
        walkTheIsland(grid, row - 1, col);
        walkTheIsland(grid, row, col + 1);
        walkTheIsland(grid, row, col - 1);
    }
}
