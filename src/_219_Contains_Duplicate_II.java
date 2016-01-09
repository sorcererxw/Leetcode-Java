import java.util.*;

/**
 * Created by Sorcerer on 2016/1/9 0009.
 * <p>
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class _219_Contains_Duplicate_II {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,1}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Node(nums[i], i));
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val == o2.val) {
                    return o1.index - o2.index;
                }
                return o1.val-o2.val;
            }
        });
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val == list.get(i - 1).val) {
                if (list.get(i).index - list.get(i - 1).index <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Node {
        int val;
        int index;

        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
