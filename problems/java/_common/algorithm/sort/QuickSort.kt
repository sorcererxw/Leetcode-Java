package algorithm.sort

/**
 * @author: Sorcerer
 * @date: 2/27/2019
 * @description:
 */
class QuickSort<T : Comparable<T>> {
    fun sort(array: Array<T>): List<T> {
        val list = array.toMutableList()
        list.shuffle()
        sort(list, 0, list.size - 1)
        return list
    }

    private fun sort(list: MutableList<T>, low: Int, high: Int) {
        if (low >= high) return
        val mid = partition(list, low, high)
        sort(list, low, mid - 1)
        sort(list, mid + 1, high)
    }

    private fun partition(list: MutableList<T>, low: Int, high: Int): Int {
        var i = low
        var j = high + 1
        val v = list[low]
        while (true) {
            while (list[++i] < v) // 从前到后寻找大于 v 的
                if (i == high) break // i==low 说明到底了，都小于v
            while (v < list[--j]) // 从后到前寻找小于 v 的
                if (j == low) break // j==low 说明到底了, 都大于v
            if (i >= j) break
            swap(list, i, j) // 交换，小的在前面，大的在后面
        }
        swap(list, low, j) // 放入最终位置
        return j // a[low..j-1]<=a[j]<=a[j+1..high]
    }

    private fun swap(list: MutableList<T>, i: Int, j: Int) {
        if (i < 0 || j < 0 || i >= list.size || j >= list.size) return
        val t = list[i]
        list[i] = list[j]
        list[j] = t
    }
}