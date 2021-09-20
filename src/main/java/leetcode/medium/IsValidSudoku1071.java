package leetcode.medium;

import java.util.Arrays;

/**
 * �����ж�һ��?9x9 �������Ƿ���Ч��ֻ��Ҫ �������¹��� ����֤�Ѿ�����������Ƿ���Ч���ɡ�
 * <p>
 * ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����?1-9?��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����?1-9?��ÿһ���Դ�ʵ�߷ָ���?3x3?����ֻ�ܳ���һ�Ρ�
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
