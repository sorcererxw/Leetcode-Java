import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Sorcerer
 * Date: 2018/4/18
 * Description:
 */
public class _1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        _1_Two_Sum solution = new _1_Two_Sum();
        System.out.println(
                Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9))
        );
    }
}
