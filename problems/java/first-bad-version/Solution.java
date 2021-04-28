package solution._278_First_Bad_Version;

/**
 * @author: Sorcerer
 * @date: 2/13/2019
 * @description: https://leetcode.com/problems/first-bad-version/
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                if (mid == 1) {
                    return mid;
                } else if (!isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = new Solution().firstBadVersion(5);
        System.out.println(result);
    }
}