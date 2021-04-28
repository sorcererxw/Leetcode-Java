package solution._3_;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Sorcerer
 * Date: 2018/4/19
 * Description:
 */
public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int ans = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _3_Longest_Substring_Without_Repeating_Characters solution =
                new _3_Longest_Substring_Without_Repeating_Characters();
        System.out.println(solution.lengthOfLongestSubstring("bbbb"));
    }
}
