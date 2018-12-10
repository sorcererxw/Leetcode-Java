import java.util.Arrays;

/**
 * Author: Sorcerer
 * Date: 2018/4/17
 * Description:
 */
public class _463_Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int h = grid.length, w = grid[0].length;
        int[][] map = new int[h + 2][w + 2];
        for (int[] row : map) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, map[i + 1], 1, grid[i].length);
        }
        int cnt = 0;
        for (int i = 0; i < h + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (map[i][j] != map[i + 1][j]) {
                    cnt++;
                }
                if (map[i][j] != map[i][j + 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        _463_Island_Perimeter solution = new _463_Island_Perimeter();
        System.out.println(solution.islandPerimeter(
                new int[][]{
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
                }
        ));
    }
}
