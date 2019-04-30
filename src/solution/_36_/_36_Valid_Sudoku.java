package solution._36_;

/**
 * Created by Sorcerer on 2016/1/9 0009.
 * <p>
 * https://leetcode.com/problems/valid-sudoku/
 */
public class _36_Valid_Sudoku {
    public static void main(String[] args) {
        char[][] a = new char[][]{
                new char[]{'.', '8', '7', '6', '5', '4', '3', '2', '1' },
                new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.' },
                new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.' },
                new char[]{'4', '.', '.', '.', '.', '.', '.', '.', '.' },
                new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.' },
                new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.' },
                new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.' },
                new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.' },
                new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.' },
        };
        System.out.println(isValidSudoku(a));
    }

    public static boolean isValidSudoku(char[][] board) {
        char current;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    current = board[i][j];
                    for (int k = 0; k < 9; k++) {
                        if ((board[i][k] == current && k != j) || (board[k][j] == current && i != k)) {
                            return false;
                        }
                    }
                    for (int k = (i / 3) * 3; k < (i / 3 + 1) * 3; k++) {
                        for (int l = (j / 3) * 3; l < (j / 3 + 1) * 3; l++) {
                            if (k == i && l == j) {
                                continue;
                            }
                            if (board[k][l] == current) {
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
