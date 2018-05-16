/**
 * Author: Sorcerer
 * Date: 2018/4/20
 * Description:
 */
public class _5_Longest_Palindromic_Substring {
    private int palindromeLength(String s, int idx) {
        int len = 0;
        for (int i = 0; i + idx < s.length() && idx - i >= 0; i++) {
            if (s.charAt(i + idx) == s.charAt(idx - i)) {
                len = i;
            } else {
                break;
            }
        }
        return len;
    }

    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int len = palindromeLength(s, i);
            if (len > max) {
                max = len;
                res = s.substring(i - len, i + len+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _5_Longest_Palindromic_Substring solution = new _5_Longest_Palindromic_Substring();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
