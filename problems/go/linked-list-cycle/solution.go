package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasCycle(head *ListNode) bool {
	if head == nil {
		return false
	}
	l, r := head, head
	for l.Next != nil && r.Next != nil && r.Next.Next != nil {
		l = l.Next
		r = r.Next.Next
		if l == r {
			return true
		}
	}
	return false
}
