import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sorcerer on 2016/1/9 0009.
 * <p>
 * https://leetcode.com/problems/rectangle-area/
 */
public class _223_Rectangle_Area {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (B >= H || F >= D || A >= G || E >= C) {
            return getRecArea(A, B, C, D) + getRecArea(E, F, G, H);
        }
        return getRecArea(A, B, C, D) + getRecArea(E, F, G, H) - getSubOfMid(A, E, C, G) * getSubOfMid(D, H, B, F);
    }

    private int getRecArea(int a, int b, int c, int d) {
        return Math.abs(a - c) * Math.abs(b - d);
    }

    private int getSubOfMid(int a, int b, int c, int d) {
        int[] arr = new int[]{a, b, c, d};
        Arrays.sort(arr);
        return Math.abs(arr[1] - arr[2]);
    }

    /*
    -2
    -2
    2
    2
    3
    3
    4
    4
     */

}
