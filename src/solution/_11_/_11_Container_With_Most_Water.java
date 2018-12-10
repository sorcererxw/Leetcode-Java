/**
 * Author: Sorcerer
 * Date: 2018/4/26
 * Description:
 */
public class _11_Container_With_Most_Water {
    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container,
     * such that the container contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     */

    public int calSize(int x1, int y1, int x2, int y2) {
        int w = Math.abs(x1 - x2);
        int h = Math.min(y1, y2);
        return w * h;
    }

    public int maxArea(int[] height) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
