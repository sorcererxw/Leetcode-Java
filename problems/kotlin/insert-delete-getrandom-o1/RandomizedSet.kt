package solution._380_Insert_Delete_GetRandom_O1

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: Sorcerer
 * @date: 2/22/2019
 * @description: https://leetcode.com/problems/insert-delete-getrandom-o1/
 * 使用map存储数据在数组当中的位置，使用数组存储数据
 * 插入时，如果不存在，就把数据放入数据，然后在map中插入其位置
 * 删除时，如果存在，就把列表最后方的数据填入删除值的位置，从map中删除，删去列表最后一项
 */
class RandomizedSet {

    /** Initialize your data structure here. */
    private val map: MutableMap<Int, Int> = HashMap()
    private val list: MutableList<Int> = ArrayList()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (map[`val`] != null) return false
        map[`val`] = list.size
        list.add(`val`)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        val location = map[`val`] ?: return false
        list[location] = list[list.size - 1]
        map[list[location]] = location
        map.remove(`val`)
        list.removeAt(list.size - 1)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val location = Random().nextInt(list.size)
        return list[location]
    }

}

fun main(args: Array<String>) {
    val set = RandomizedSet()
    set.insert(0)
    set.insert(1)
    set.remove(0)
    set.insert(2)
    set.remove(1)
    println(set.getRandom())
    set.remove(2)
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */