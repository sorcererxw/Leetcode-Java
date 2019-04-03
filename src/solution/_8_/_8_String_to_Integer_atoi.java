package solution._8_;

import java.util.Arrays;

/**
 * Author: Sorcerer
 * Date: 2018/4/20
 * Description:
 */
public class _8_String_to_Integer_atoi {

    public int convert(String str, int sign) {
        if (str.length() == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (sum * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            sum = sum * 10 + num;
        }
        if (sum * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sign * sum < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) (sum * sign);
    }

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int sign = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
        } else if (str.charAt(0) == '+') {
            sign = 1;
        }
        StringBuilder num = new StringBuilder();
        for (int i = (sign == 0 ? 0 : 1); i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num.append(str.charAt(i));
            } else {
                break;
            }
        }
        return convert(num.toString(), sign == -1 ? -1 : 1);
    }

    public static void main(String[] args) {
        _8_String_to_Integer_atoi solution = new _8_String_to_Integer_atoi();
        String[] testCase = new String[]{
                "42", "   -42", "4193 with words", "words and 987", "-91283472332",
                "2147483648", "-2147483648"
        };
        Arrays.stream(testCase)
                .forEach(s -> System.out.println(s + ": " + solution.myAtoi(s)));
    }
}
