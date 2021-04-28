package solution._134_Gas_Station

/**
 * @author: Sorcerer
 * @date: 2/25/2019
 * @description: https://leetcode.com/problems/gas-station/
 * 解题思路类似于 最大子序列和
 */

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var n = gas.size
        var start = 0
        var total = 0
        var tank = 0
        for (i in 0 until n) {

            val now = gas[i] - cost[i]
            total += now
            tank += now
            if (tank < 0) {
                // 说明从上一个 start 值到无法这个位置，那么上一个 start 是无效的
                // 不过这里你可能会问，那么怎么证明 start+1也是无效的
                // 因为 start 刚开始的时候 tank=0
                // 那么 start 位置必然使 tank 增加
                // 既然 start+1 时，已经 tank>0，start+1依旧无法成功越过 now 点
                // 那么 start+1 点也是无效的
                // 同理，可以证明 start~now 点都是无效的
                // 当然，now 点必然是让 tank 减小的
                start = i + 1
                tank = 0
            }
        }
        // 只要总量大于消耗，那么必然存在一点可以
        return if (total < 0) -1 else start
    }
}
