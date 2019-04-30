package algorithm.sort

/**
 * @author: sorcererxw
 * @date: 2019/4/19
 * @description:
 */
import util.println
import java.util.*

class HeapSort(private val arr: IntArray) {

    /**
     * 堆排序的主要入口方法，共两步。
     */
    fun sort() {
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        val len = arr.size - 1
        val beginIndex = len - 1 shr 1 //最后一个非叶节点
        for (i in beginIndex downTo 0)
            maxHeapify(i, len)
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         *
         * 不断通过大顶堆找出最大的元素，放到尾部
         */
        arr.println()
        for (i in len downTo 1) {
            swap(0, i)
            maxHeapify(0, i - 1)
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 大顶堆
     * @param root 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private fun maxHeapify(root: Int, len: Int) {
        val lchild = (root shl 1) + 1 // 左子节点索引
        val rchild = lchild + 1           // 右子节点索引
        var maxChild = lchild             // 子节点值最大索引，默认左子节点。
        if (lchild > len) return       // 左子节点索引超出计算范围，直接返回。
        if (rchild <= len && arr[rchild] > arr[lchild])
        // 先判断左右子节点，哪个较大。
            maxChild = rchild
        if (arr[maxChild] > arr[root]) {
            swap(maxChild, root)      // 如果父节点被子节点调换，
            maxHeapify(maxChild, len)  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}

fun main() {
    val arr = intArrayOf(2, 4, 1, 3, 5)
//    val arr = intArrayOf(3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6)
    HeapSort(arr).sort()
    println(Arrays.toString(arr))
}