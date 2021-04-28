package _54_Spiral_Matrix

/**
 * @author: SorcererXW
 * @date: 2018/5/22
 * @description:
 */

class Solution {
    private lateinit var list: MutableList<Int>
    private var h: Int = 0
    private var w: Int = 0
    private var size: Int = 0
    private var direct: Int = 0
    private lateinit var vis: Array<BooleanArray>
    private lateinit var matrix: Array<IntArray>

    private fun check(x: Int, y: Int): Boolean {
        if (x >= h || x < 0 || y >= w || y < 0 || vis[x][y]) return false
        return true
    }

    private fun search(x: Int, y: Int) {
        if (list.size >= size) return
        if (!vis[x][y]) {
            list.add(matrix[x][y])
            vis[x][y] = true
        }
        if (direct % 4 == 0) {
            if (check(x, y + 1)) {
                search(x, y + 1)
            } else {
                direct++
                search(x, y)
            }
        } else if (direct % 4 == 1) {
            if (check(x + 1, y)) {
                search(x + 1, y)
            } else {
                direct++
                search(x, y)
            }
        } else if (direct % 4 == 2) {
            if (check(x, y - 1)) {
                search(x, y - 1)
            } else {
                direct++
                search(x, y)
            }
        } else {
            if (check(x - 1, y)) {
                search(x - 1, y)
            } else {
                direct++
                search(x, y)
            }
        }
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        this.matrix = matrix
        h = matrix.size
        if (h == 0) return ArrayList()
        w = matrix[0].size
        if (w == 0) return ArrayList()
        list = ArrayList()
        size = w * h
        direct = 0
        vis = Array(h, { BooleanArray(w, { false }) })
        search(0, 0)
        return list
    }
}

fun main(args: Array<String>) {
    println(
            Solution().spiralOrder(arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
            ))
    )
}
