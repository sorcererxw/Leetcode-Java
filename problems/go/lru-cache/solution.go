package main

type LRUCache struct {
	m    map[int]*Node
	head *Node
	tail *Node
	cap  int
}

type Node struct {
	next  *Node
	prev  *Node
	key   int
	value int
}

func Constructor(capacity int) LRUCache {
	h := &Node{}
	t := &Node{}
	h.next = t
	t.prev = h
	return LRUCache{
		m:    make(map[int]*Node, capacity),
		head: h,
		tail: t,
		cap:  capacity,
	}
}

func (l *LRUCache) up(node *Node) {
	newLeft := l.head
	newRight := l.head.next
	oldLeft := node.prev
	oldRight := node.next

	l.link(newLeft, node)
	l.link(node, newRight)
	l.link(oldLeft, oldRight)
}

func (l *LRUCache) link(left, right *Node) {
	if left != nil {
		left.next = right
	}
	if right != nil {
		right.prev = left
	}
}

func (l *LRUCache) Get(key int) int {
	v := l.m[key]
	if v != nil {
		l.up(v)
		return v.value
	}
	return -1
}

func (l *LRUCache) Put(key int, value int) {
	v := l.m[key]
	if v != nil {
		v.value = value
		l.up(v)
		return
	}
	for len(l.m) >= l.cap && l.tail.prev != l.head {
		t := l.tail.prev
		t.prev.next = t.next
		t.next.prev = t.prev
		delete(l.m, t.key)
	}
	cur := &Node{
		key:   key,
		value: value,
	}
	left := l.head
	right := l.head.next
	l.link(left, cur)
	l.link(cur, right)
	l.m[key] = cur
}
