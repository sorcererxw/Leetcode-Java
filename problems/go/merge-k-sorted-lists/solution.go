package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}
	n := len(lists) - 1
	for n > 0 {
		for i := 0; i*2 < n; i++ {
			lists[i] = merge(lists[i], lists[n-i])
		}
		n = n / 2
	}
	return lists[0]
}

func merge(a *ListNode, b *ListNode) *ListNode {
	if a == nil {
		return b
	}
	if b == nil {
		return a
	}
	head := &ListNode{}
	t := head
	pa, pb := a, b
	for pa != nil && pb != nil {
		if pa.Val < pb.Val {
			t.Next = pa
			pa = pa.Next
		} else {
			t.Next = pb
			pb = pb.Next
		}
		t = t.Next
	}
	if pa != nil {
		t.Next = pa
	} else if pb != nil {
		t.Next = pb
	}
	return head.Next
}
