import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/6 0006.
 * <p>
 * https://leetcode.com/problems/pascals-triangle/
 */
public class _118_Pascals_Triangle {

    public static void main(String[] args){
        System.out.println(generate(9));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> last = lists.get(i - 1);
                    list.add(last.get(j) + last.get(j - 1));
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
