package util

import models.TreeNode
import java.util.*

/**
 * @author: SorcererXW
 * @date: 5/25/2018
 * @description:
 */
class TreePrinter {
    private class Connector(val length: Int) {
        fun space(): String {
            var res = ""
            for (i in 0 until this.length) res += " "
            return res
        }

        fun line(): String {
            var res = "|"
            for (i in 1 until this.length) res += " "
            return res
        }

        fun upLeft(): String {
            var res = ""
            for (i in 0 until this.length - 1) res += "─"
            return "$res┘"
        }

        fun downLeft(): String {
            var res = ""
            for (i in 0 until this.length - 1) res += "─"
            return "$res┐"
        }

        fun leftCross(): String {
            var res = ""
            for (i in 0 until this.length - 1) res += "─"
            return "$res┤"
        }
    }

    private companion object {
        private const val MIN_LENGTH = 2
    }

    private val stack: Stack<Int> = Stack()
    private lateinit var connector: Connector

    fun printTree(node: TreeNode?) {
        connector = Connector(calLength(node))
        printTree(node, 0)
    }

    private fun calLength(node: TreeNode?): Int {
        return if (node == null) MIN_LENGTH
        else Math.max("${node.`val`}".length,
                Math.max(calLength(node.left), calLength(node.right))
        )
    }

    private fun printTree(node: TreeNode?, deep: Int) {
        if (node == null) {
            return
        }
        stack.push(1)
        printTree(node.right, deep + 1)
        stack.pop()

        for (i in 0 until stack.size) {
            when {
                i == 0 -> print(connector.space())
                stack[i] == stack[i - 1] -> print(connector.space())
                else -> print(connector.line())
            }
        }

        print(node.`val`)
        if (node.left != null && node.right != null) {
            print(connector.leftCross())
        } else if (node.right != null) {
            print(connector.upLeft())
        } else if (node.left != null) {
            print(connector.downLeft())
        } else {

        }
        println()

        stack.push(0)
        printTree(node.left, deep + 1)
        stack.pop()
    }
}

