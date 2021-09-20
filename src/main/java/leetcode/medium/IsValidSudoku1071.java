package leetcode.medium;

import java.util.Arrays;

/**
 * 请你判断一个?9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字?1-9?在每一行只能出现一次。
 * 数字?1-9?在每一列只能出现一次。
 * 数字?1-9?在每一个以粗实线分隔的?3x3?宫内只能出现一次。
 */
public class IsValidSudoku1071 {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        int[] flag = new int[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(flag, 0);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    flag[board[i][j] - '0']++;
                    if (flag[board[i][j] - '0'] > 1) {
                        return false;
                    }
                }
            }

            Arrays.fill(flag, 0);
            for (int k = 0; k < 9; k++) {
                if (board[k][i] != '.') {
                    flag[board[k][i] - '0']++;
                    if (flag[board[k][i] - '0'] > 1) {
                        return false;
                    }
                }
            }
        }

        Arrays.fill(flag, 0);
        for (int i = 0; i < 3; i++) {

        }

        return true;
    }
}
