/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class _171_Excel_Sheet_Column_Number {

    public static void main(String[] args){
        String s = "AA";
        System.out.println(titleToNumber(s));
    }

    /*
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
     */
    public static int titleToNumber(String s) {
        int sum = 0;
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            sum += Math.pow(26, k) * (ch - 'A' + 1);
            k++;
        }
        return sum;
    }
}
