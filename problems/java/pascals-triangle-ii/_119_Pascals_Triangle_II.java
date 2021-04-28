import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/7 0007.
 * <p>
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class _119_Pascals_Triangle_II {

    public static void main(String[] args) {
        System.out.println(getRow(4));
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex += 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int tmp;
        for (int i = 1; i < rowIndex; i++) {
            tmp = 1;
            for (int j = 1; j <= i; j++) {
                if (j == 0) {
                    continue;
                } else if (j == i) {
                    list.add(1);
                } else {
                    int t = tmp;
                    tmp = list.get(j);
                    list.set(j, t + list.get(j));
                }
            }
        }
        return list;
    }
}
