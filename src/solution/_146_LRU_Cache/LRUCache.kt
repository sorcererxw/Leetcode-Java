package solution._146_LRU_Cache

import util.println

/**
 * @author: Sorcerer
 * @date: 02/21/2019
 * @description: https://leetcode.com/problems/lru-cache/
 * 使用链表和哈希表连管理数据
 * 链表设有一个空的头指针和空的尾指针
 * 当插入的时候，如果容量足够，就存入哈希表中，并新建节点插在头指针的后面
 * 如果容量不够，就先删除尾指针前面那个节点，并从哈希表中删去那个值，然后同上操作
 *
 * 当取值的时候，先从哈希表中找到对应的节点，然后将其从链表中删除，然后重新插入到头指针的后方
 */
class LRUCache(capacity: Int) {

    companion object {
        private data class Node(
                var key: Int,
                var value: Int,
                var pre: Node? = null,
                var next: Node? = null
        )
    }

    private val capacity: Int = capacity
    private val map: MutableMap<Int, Node> = HashMap()
    private var head = Node(-1, -1)
    private var tail = Node(-1, -1)
    private var count = 0

    init {
        head.next = tail
    }

    private fun addNode(node: Node) {
        head.next!!.pre = node
        node.next = head.next
        head.next = node
        node.pre = head
    }

    private fun deleteNode(node: Node) {
        node.next!!.pre = node.pre
        node.pre!!.next = node.next
    }

    fun get(key: Int): Int {
        if (map.containsKey(key)) {
            val node = map[key]!!
            deleteNode(node)
            addNode(node)
            return node.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) return
        if (map.containsKey(key)) {
            val node = map[key]!!
            deleteNode(node)
            node.value = value
            addNode(node)
        } else {
            val node = Node(key = key, value = value)
            map[key] = node
            if (count < capacity) {
                count++
            } else {
                map.remove(tail.pre!!.key)
                deleteNode(tail.pre!!)
            }
            addNode(node)
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main(args: Array<String>) {
    val emptyCache = LRUCache(0)
    emptyCache.put(0, 1)
    emptyCache.put(1, 2)
    println(emptyCache.get(0))

    val cache = LRUCache(2)
    cache.put(0, 1)
    cache.put(1, 2)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.get(1).println()   // returns 1
    cache.put(3, 3)    // evicts key 2
    cache.get(2).println()        // returns -1 (not found)
    cache.put(4, 4)    // evicts key 1
    cache.get(1).println()        // returns -1 (not found)
    cache.get(3).println()      // returns 3
    cache.get(4).println()         // returns 4
}