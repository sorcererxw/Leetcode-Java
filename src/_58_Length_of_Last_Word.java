/**
 * Created by Sorcerer on 2016/1/9 0009.
 * <p>
 * https://leetcode.com/problems/length-of-last-word/
 */
public class _58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        boolean flag = false;
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    break;
                }
            } else if (s.charAt(i) != ' ') {
                flag = true;
                cnt++;
            }
        }
        return cnt;
    }
}
