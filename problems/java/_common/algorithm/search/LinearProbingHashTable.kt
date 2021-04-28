package algorithm.search

/**
 * @author: sorcererxw
 * @date: 2019/3/31
 * @description:
 */
class LinearProbingHashTable<K, V> {
    private var N = 0
    private var M = 16
    private var keys: Array<K?>
    private var vals: Array<V?>

    constructor(cap: Int) {
        M = cap
        keys = Array<Any?>(M) { null } as Array<K?>
        vals = Array<Any?>(M) { null } as Array<V?>
    }

    private fun hash(key: K): Int {
        return (key.hashCode() and 0x7fffffff) % M
    }

    private fun resize(size: Int) {
        val t = LinearProbingHashTable<K, V>(size)
        for (i in 0 until M) {
            if (keys[i] != null) {
                t.put(keys[i]!!, vals[i]!!)
            }
        }
        keys = t.keys
        vals = t.vals
        M = t.M
    }

    fun put(key: K, value: V) {
        if (N >= M / 2) resize(M * 2)
        var i = hash(key)
        while (keys[i] != null) {
            if (keys[i]!! == key) {
                vals[i] = value
                return
            }
            i = (i + 1) % M
        }
        keys[i] = key
        vals[i] = value
        N++
    }

    fun get(key: K): V? {
        var i = hash(key)
        while (keys[i] != null) {
            if (keys[i]!! == key) return vals[i]
            i = (i + 1) % M
        }
        return null
    }

    fun contain(key: K): Boolean {
        return get(key) != null
    }

    fun delete(key: K) {
        if (!contain(key)) return
        var i = hash(key)
        while (key != keys[i]) i = (i + 1) % M
        keys[i] = null
        vals[i] = null
        i = (i + 1) % M
        while (keys[i] != null) {
            val keyToRehash = keys[i]!!
            val valueToRehash = vals[i]!!
            keys[i] = null
            vals[i] = null
            N--
            put(keyToRehash, valueToRehash)
            i = (i + 1) % M
        }
        N--
        if (N > 0 && N <= M / 8) resize(M / 2)
    }
}