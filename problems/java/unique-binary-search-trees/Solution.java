package solution._96_Unique_Binary_Search_Trees;

/**
 * 1 => 1
 * 2 => 1+1
 * 3 => 1+2+2
 * 4 => 5+5+2+2
 * 5 => (4)+(4)+(1)*(3)+(1)*(3)+(2)*(2)
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int l = 0; l < i; l++) {
                dp[i] += dp[l] * dp[i - 1 - l];
            }
        }
        return dp[n];
    }
}
