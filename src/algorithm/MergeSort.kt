package algorithm

/**
 * @author: Sorcerer
 * @date: 2/27/2019
 * @description:
 */
class MergeSort<T : Comparable<T>> {
    fun sort(array: Array<T>): List<T> {
        val list = array.toMutableList()
        list.shuffle()
        sort(list, 0, list.size - 1)
        return list
    }

    private fun sort(list: MutableList<T>, low: Int, high: Int) {
        if (high <= low) return
        val mid = low + (high - low) / 2
        sort(list, low, mid)
        sort(list, mid + 1, high)
        merge(list, low, mid, high)
    }

    private fun merge(list: MutableList<T>, low: Int, mid: Int, high: Int) {
        // list[low..mid] and list[mid+1..high] is sorted

        val aux = list.toList()
        var i = low
        var j = mid + 1
        for (k in low..high) list[k] = when {
            i > mid -> aux[j++] // 第一段已经走完了，尽管填入第二段的内容就好了
            j > high -> aux[i++] // 第二段已经走完了，尽管填入第一段的内容就好了
            aux[j] < aux[i] -> aux[j++] // 填入小的那一项
            else -> aux[i++]
        }
    }
}