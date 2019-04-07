package solution._735_Asteroid_Collision

import util.println
import java.util.*

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (asteroid in asteroids) {
            if (asteroid == 0) continue
            if (stack.empty()) {
                stack.push(asteroid)
                continue
            }
            while (!stack.empty()) {
                if (stack.peek() > 0 && asteroid < 0) {
                    if (stack.peek() > -asteroid) {
                        break
                    } else if (stack.peek() < -asteroid) {
                        stack.pop()
                        if (stack.isEmpty()) {
                            stack.push(asteroid)
                            break
                        }
                    } else {
                        stack.pop()
                        break
                    }
                } else {
                    stack.push(asteroid)
                    break
                }
            }
        }
        return stack.toIntArray()
    }
}

fun main() {
    Solution().asteroidCollision(intArrayOf(5, 10, -5)).println()
    Solution().asteroidCollision(intArrayOf(8, -8)).println()
    Solution().asteroidCollision(intArrayOf(10, 2, -5)).println()
    Solution().asteroidCollision(intArrayOf(-2, -1, 1, 2)).println()
}