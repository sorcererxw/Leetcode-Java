package solution._12_;

/**
 * Author: Sorcerer
 * Date: 2018/4/26
 * Description:
 */
public class _12_Integer_to_Roman {

    public String intToRoman(int num) {
        int[] nums = new int[]{1, 5, 10, 50, 100, 500, 1000,};
        char[] romans = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M',};
        for (int i = nums.length - 1; i >= 0; i++) {

        }
        return "";
    }

    public static void main(String[] args) {
        _12_Integer_to_Roman solution = new _12_Integer_to_Roman();
        System.out.println(solution.intToRoman(1994));
    }
}
