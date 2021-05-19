package com.zxt.leetcode;

public class RotationMatrix {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col - i; j++) {
                matrix[i][j] = matrix[j][col - 1 - i];
            }
        }
    }
}
