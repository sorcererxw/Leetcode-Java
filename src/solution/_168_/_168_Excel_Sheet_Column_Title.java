/**
 * Created by Sorcerer on 2016/1/16 0016.
 * <p>
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class _168_Excel_Sheet_Column_Title {

    public static void main(String[] args) {
        System.out.println(convertToTitle(100));
    }

    private static final char[] chars = new char[]{
            'A',
            'B',
            'C',
            'D',
            'E',
            'F',
            'G',
            'H',
            'I',
            'J',
            'K',
            'L',
            'M',
            'N',
            'O',
            'P',
            'Q',
            'R',
            'S',
            'T',
            'U',
            'V',
            'W',
            'X',
            'Y',
            'Z'
    };

    public static String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            n-=1;
            builder.append(chars[n%26]);
            n /= 26;
        }
        return builder.reverse().toString();
    }
}
