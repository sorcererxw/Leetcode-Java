package solution._721_

/**
 * @author: Sorcerer
 * @date: 12/4/2018
 * @description:
 */
class Solution {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val map: MutableMap<String, MutableSet<String>> = HashMap()

        accounts.forEach {

            val set = if (map.containsKey(it[0])) map[it[0]]!!
            else {
                val set = HashSet<String>()
                map[it[0]] = set
                set
            }
            for (i in 1 until it.size) set.add(it[i])
        }

        return map.map { listOf(it.key, *it.value.toTypedArray()) }
    }
}