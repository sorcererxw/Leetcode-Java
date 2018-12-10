/**
 * Author: Sorcerer
 * Date: 2018/4/28
 * Description:
 */
public class _62_Unique_Paths {
    private int c(int m, int n) {
        if (n <= 0) {
            return 0;
        }
        int p1 = 1, p2 = 1;
        while (n != 0) {
            p1 *= m;
            p2 *= n;
            m--;
            n--;
        }
        return p1 / p2;
    }

    public int uniquePaths(int m, int n) {
        return c(m + n - 2, n - 1);
    }
}
