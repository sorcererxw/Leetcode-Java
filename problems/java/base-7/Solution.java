package solution._504_Base_7;

class Solution {
    public String convertToBase7(int num) {
        boolean flag = num < 0;
        num = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append(num % 7);
            num /= 7;
        }
        if (builder.length() == 0)
            return "0";
        if (flag) {
            builder.append("-");
        }
        return builder.reverse().toString();
    }
}