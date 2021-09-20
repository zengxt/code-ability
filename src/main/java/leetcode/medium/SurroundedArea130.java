package leetcode.medium;

/**
 * ����һ�� m x n �ľ��� board ���������ַ� 'X' �� 'O' ���ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣
 */
public class SurroundedArea130 {
    private static final int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if (board == null || board[0].length == 0) {
            return;
        }

        // ���к�ĩ��
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                markPoint(board, i, 0, 'O', '#');
            }

            if (board[i][board[0].length - 1] == 'O') {
                markPoint(board, i, board[0].length - 1, 'O', '#');
            }
        }

        // ���к�ĩ��
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                markPoint(board, 0, i, 'O', '#');
            }

            if (board[board.length - 1][i] == 'O') {
                markPoint(board, board.length - 1, i, 'O', '#');
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markPoint(char[][] board, int row, int col, char from, char to) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        if (board[row][col] == from) {
            board[row][col] = to;
            for (int k = 0; k < 4; k++) {
                markPoint(board, row + direction[k][0], col + direction[k][1], from, to);
            }
        }
    }
}
