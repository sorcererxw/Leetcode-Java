/**
 * Author: Sorcerer
 * Date: 2018/4/17
 * Description:
 */
public class _65_Valid_Number {
    private boolean isSign(char a) {
        return a == '+' || a == '-';
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (isSign(s.charAt(0))) {
            if (s.length() >= 2 && isSign(s.charAt(1))) {
                return false;
            }
            if (s.length() >= 2 && s.charAt(1) == ' ') {
                return false;
            }
            return isNumber(s.substring(1));
        }
        int pointIdx = -1, eIdx = -1, numCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numCnt++;
            } else if (s.charAt(i) == 'e') {
                if (i == 0) {
                    return false;
                }
                if (eIdx != -1) {
                    return false;
                }
                eIdx = i;
            } else if (s.charAt(i) == '.') {
                if (eIdx != -1) {
                    return false;
                }
                if (pointIdx != -1) {
                    return false;
                }
                pointIdx = i;
            } else {
                return false;
            }
        }
        if (eIdx == s.length() - 1 || numCnt == 0) {
            return false;
        }
        if (eIdx != -1) {
            String[] es = s.split("e");
            if (!isNumber(es[0]) || !isNumber(es[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _65_Valid_Number solution = new _65_Valid_Number();
        String[] checkList = new String[]{
                "--1",
                "-1.",
                "-1",
                "1",
                "+1.",
        };
        for (String item : checkList) {
            System.out.println(item + ": " + solution.isNumber(item));
        }
    }
}
