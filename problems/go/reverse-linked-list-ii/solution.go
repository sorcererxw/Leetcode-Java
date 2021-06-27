package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func (n *ListNode) flat() []int {
	ret := make([]int, 0)
	t := n
	for t != nil {
		ret = append(ret, t.Val)
		t = t.Next
	}
	return ret
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	dummy := &ListNode{
		Val:  -1,
		Next: head,
	}
	cur := head
	i := 1
	var last *ListNode
	for cur != nil {
		if i >= left && i < right {
			next := cur.Next
			if last != nil {
				last.Next = next
			}
			if next != nil {
				cur.Next = next.Next
				next.Next = cur
			}
			last = next
		} else {
			last = cur
			cur = cur.Next
		}
		i++
		fmt.Println(head.flat())
	}
	return dummy.Next
}
