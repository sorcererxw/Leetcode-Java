package main

type node struct {
	st int
	ed int
	l  *node
	r  *node
}

type MyCalendar struct {
	root *node
}

func Constructor() MyCalendar {
	return MyCalendar{}
}

func (c *MyCalendar) Book(start int, end int) bool {
	if c.root == nil {
		c.root = &node{st: start, ed: end}
		return true
	}
	cur := c.root
	for {
		if cur.ed <= start {
			if cur.r == nil {
				cur.r = &node{st: start, ed: end}
				return true
			}
			cur = cur.r
		} else if cur.st >= end {
			if cur.l == nil {
				cur.l = &node{st: start, ed: end}
				return true
			}
			cur = cur.l
		} else {
			return false
		}
	}
}
