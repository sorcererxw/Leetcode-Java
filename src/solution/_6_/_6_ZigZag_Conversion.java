import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Sorcerer
 * Date: 2018/4/20
 * Description:
 */
public class _6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        int loopSize = (numRows - 1) * 2;
        int loop = (int) Math.ceil(1.0 * s.length() / loopSize);
        List<char[][]> mapList = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            String output = s.substring(i * loopSize, i == loop - 1 ? s.length() : (i + 1) * loopSize);
            int idx = 0;
            char[][] map = new char[numRows][numRows - 1];
            for (char[] row : map) {
                Arrays.fill(row, ' ');
            }
            for (int j = 0; j < numRows - 1; j++) {
                if (idx < output.length()) {
                    map[j][0] = output.charAt(idx);
                    idx++;
                } else {
                    break;
                }
            }
            for (int j = numRows - 1; j > 0; j--) {
                if (idx < output.length()) {
                    map[j][numRows - 1 - j] = output.charAt(idx);
                    idx++;
                } else {
                    break;
                }
            }
            mapList.add(map);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (char[][] map : mapList) {
                for (int k = 0; k < numRows - 1; k++) {
                    if (map[i][k] != ' ') {
                        res.append(map[i][k]);
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _6_ZigZag_Conversion solution = new _6_ZigZag_Conversion();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}
