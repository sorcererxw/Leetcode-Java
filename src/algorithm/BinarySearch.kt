package algorithm

/**
 * @author: Sorcerer
 * @date: 2/11/2019
 * @description:
 */

fun <T> binarySearch(
        list: Array<T>,
        target: T,
        comparator: Comparator<T>
): Int {
    // low 和 high 是 **两头闭区间** 的上下限
    var low = 0
    var high = list.size - 1
    while (low <= high) {
        // 如果使用 (low+high)/2 可能因为 low+high 超出 int 范围而溢出
        val mid = low + (high - low) / 2
        val cmp = comparator.compare(target, list[mid])
        when {
            cmp < 0 -> high = mid - 1
            cmp > 0 -> low = mid + 1
            else -> return mid
        }
    }
    return -1
}

