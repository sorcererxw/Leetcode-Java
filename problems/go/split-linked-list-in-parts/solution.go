package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func splitListToParts(head *ListNode, k int) []*ListNode {
	var n int
	{
		t := head
		for t != nil {
			n++
			t = t.Next
		}
	}
	avg := n / k
	mod := n % k
	lists := make([]*ListNode, k)
	{
		for i := 0; i < k; i++ {
			size := avg
			if i < mod {
				size += 1
			}
			if size == 0 {
				lists[i] = nil
				continue
			}
			t := head
			for j := 0; j < size-1; j++ {
				t = t.Next
			}
			lists[i] = head
			head = t.Next
			t.Next = nil
		}
	}
	return lists
}
