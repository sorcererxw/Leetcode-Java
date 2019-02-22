package solution._350_Intersection_of_Two_Arrays_II

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        val result: MutableList<Int> = ArrayList()

        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] == nums2[j] -> {
                    result.add(nums1[i])
                    i++
                    j++
                }
                nums1[i] < nums2[j] -> i++
                nums1[i] > nums2[j] -> j++
            }
        }
        return result.toIntArray()
    }
}
