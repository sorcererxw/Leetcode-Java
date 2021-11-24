package reverse_linked_list

import (
	. "github.com/sorcererxw/leetcode/problems/go/_common/model"
)

func reverseList(head *ListNode) *ListNode {
	var pre *ListNode
	cur := head
	for cur != nil {
		t := cur.Next
		cur.Next = pre
		pre = cur
		cur = t
	}
	return pre
}
