package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverse(l *ListNode) *ListNode {
	var last *ListNode
	for l != nil {
		t := l
		l = l.Next
		t.Next = last
		last = t
	}
	return last
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	l := &ListNode{}
	head := l

	var addtion int
	for {
		if l1 == nil && l2 == nil && addtion == 0 {
			break
		}
		v := addtion
		if l1 != nil {
			v += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			v += l2.Val
			l2 = l2.Next
		}
		addtion = v / 10
		v = v % 10
		l.Next = &ListNode{Val: v}
		l = l.Next
	}
	return head.Next
}
