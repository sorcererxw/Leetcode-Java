/**
 * Created by Sorcerer on 2016/1/9 0009.
 * <p>
 * https://leetcode.com/problems/valid-sudoku/
 */
public class _36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        char current;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    current = board[i][j];
                    for (int k = 0; k < 9; k++) {
                        if (board[i][k] == current || board[k][j] == current) {
                            return false;
                        }
                    }
                    for (int k = (i / 3) * 3; k < (i / 3 + 1) * 3; k++) {
                        for (int l = (j / 3) * 3; l < (j / 3 + 1) * 3; k++) {
                            if (k == i && l == j) {
                                continue;
                            }
                            if (board[k][j] == current) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
