/**
 * Author: Sorcerer
 * Date: 2018/4/10
 * Description:
 */
public class _28_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String... args) {
        _28_Implement_strStr target = new _28_Implement_strStr();
        System.out.println(
                target.strStr("aaaaa", "bba")
        );
    }
}
