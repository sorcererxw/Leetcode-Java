package main

import "fmt"

type Node struct {
	Val  int
	Next *Node
}

type MyLinkedList struct {
	Head *Node
}

/** Initialize your data structure here. */
func Constructor() MyLinkedList {
	return MyLinkedList{
		Head: &Node{},
	}
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
func (p *MyLinkedList) Get(index int) int {
	t := p.Head.Next
	for t != nil && index > 0 {
		t = t.Next
		index -= 1
	}
	if index > 0 || t == nil {
		return -1
	}
	return t.Val
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (p *MyLinkedList) AddAtHead(val int) {
	n := &Node{Val: val}
	n.Next = p.Head.Next
	p.Head.Next = n
}

/** Append a node of value val to the last element of the linked list. */
func (p *MyLinkedList) AddAtTail(val int) {
	t := p.Head
	for t.Next != nil {
		t = t.Next
	}
	t.Next = &Node{Val: val}
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (p *MyLinkedList) AddAtIndex(index int, val int) {
	t := p.Head
	for t != nil && index > 0 {
		t = t.Next
		index--
	}
	if index > 0 {
		return
	}
	if t != nil {
		n := &Node{Val: val}
		if t.Next != nil {
			n.Next = t.Next.Next
		}
		t.Next = n
	} else {
		p.AddAtTail(val)
	}
}

/** Delete the index-th node in the linked list, if the index is valid. */
func (p *MyLinkedList) DeleteAtIndex(index int) {
	var last *Node
	t := p.Head
	for t != nil && index > 0 {
		last = t
		t = t.Next
		index--
	}
	if index > 0 {
		return
	}
	if last != nil {
		if t == nil {
			last.Next = nil
		} else {
			last.Next = t.Next
		}
	}
}

func (p *MyLinkedList) all() (arr []int) {
	t := p.Head.Next
	for t != nil {
		arr = append(arr, t.Val)
		t = t.Next
	}
	return
}

func main() {
	l := Constructor()
	l.AddAtHead(1)
	l.AddAtTail(3)
	l.AddAtIndex(1, 2)
	fmt.Println(l.all())
	fmt.Println(l.Get(1))
	l.DeleteAtIndex(1)
	fmt.Println(l.all())
	fmt.Println(l.Get(1))
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
