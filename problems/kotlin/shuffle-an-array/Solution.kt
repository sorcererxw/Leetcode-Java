package solution._384_Shuffle_an_Array

import java.util.*

/**
 * @author: Sorcerer
 * @date: 2/26/2019
 * @description: https://leetcode.com/problems/shuffle-an-array/
 * 费雪耶茨洗牌算法
 */
class Solution(nums: IntArray) {
    private val originalNums = nums.copyOf()
    private var shuffleNums = originalNums.copyOf()
    private val random = Random()

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        shuffleNums = originalNums.copyOf()
        return shuffleNums
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        for (i in 0 until shuffleNums.size) {
            val idx = random.nextInt(i, shuffleNums.size)
            val t = shuffleNums[i]
            shuffleNums[i] = shuffleNums[idx]
            shuffleNums[idx] = t
        }
        return shuffleNums
    }

    /**
     * random int in [lowerBound, upperBound)
     */
    private fun Random.nextInt(lowerBound: Int, upperBound: Int): Int {
        return lowerBound + this.nextInt(upperBound - lowerBound)
    }
}


