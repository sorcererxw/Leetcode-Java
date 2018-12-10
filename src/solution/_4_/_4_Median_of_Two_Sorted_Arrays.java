/**
 * Author: Sorcerer
 * Date: 2018/4/19
 * Description:
 */
public class _4_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int len = nums1.length + nums2.length;
        if (len == 0) {
            return 0;
        }
        int target = len / 2;
        int cur = 0;
        int history[] = new int[len];
        while (cur <= target) {
            if (i >= nums1.length && j >= nums2.length) {
                break;
            } else if (i >= nums1.length) {
                history[cur++] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                history[cur++] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                history[cur++] = nums1[i];
                i++;
            } else {
                history[cur++] = nums2[j];
                j++;
            }
        }
        if (len % 2 == 0) {
            return 1.0 * (history[len / 2] + history[len / 2 - 1]) / 2;
        } else {
            return history[len / 2];
        }
    }

    public static void main(String[] args) {
        _4_Median_of_Two_Sorted_Arrays solution = new _4_Median_of_Two_Sorted_Arrays();
        System.out.println(solution.findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2}
        ));
    }
}
