package solution._349_Intersection_of_Two_Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: sorcererxw
 * @date: 2019/4/18
 * @description:
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}