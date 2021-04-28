package solution._64_Minimum_Path_Sum;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }

    public int minPathSum(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }
        int h = grid.length;
        int w = grid[0].length;
        for (int k = 0; k < h + w - 1; k++) {
            for (int i = 0; i <= k && i < h; i++) {
                int j = k - i;
                if (j >= w) {
                    continue;
                }
                System.out.println(i + " " + j);

                if (i >= 1 && j >= 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                } else if (i >= 1) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (j >= 1) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
            }
        }
        Arrays.stream(grid).forEach(it -> {
            System.out.println(Arrays.toString(it));
        });
        return grid[h - 1][w - 1];
    }
}
