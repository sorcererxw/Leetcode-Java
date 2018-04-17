/**
 * Author: Sorcerer
 * Date: 2018/4/15
 * Description:
 */
public class _771_Jewels_and_Stones {
    static class Solution {
        public int numJewelsInStones(String J, String S) {
            int[] hash = new int[1000];
            for (char c : S.toCharArray()) {
                hash[c]++;
            }
            int cnt = 0;
            for (char c : J.toCharArray()) {
                cnt += hash[c];
            }
            return cnt;
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones("z", "ZZ"));
    }
}
