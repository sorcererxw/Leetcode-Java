package main

import (
	"math/rand"
)

type Skiplist struct {
	head         *Node
	maxLevel     int
	factor       float64
	currentLevel int
}

type Node struct {
	Value int
	Next  []*Node
}

func Constructor() Skiplist {
	return Skiplist{
		head: &Node{
			Next: make([]*Node, 32),
		},
		maxLevel:     32,
		factor:       0.25,
		currentLevel: 1,
	}
}

func (s *Skiplist) randomLevel() int {
	l := 1
	for rand.Float64() < s.factor && l < s.maxLevel {
		l++
	}
	return l
}

func (s *Skiplist) Search(target int) bool {
	for i := s.currentLevel - 1; i >= 0; i-- {
		n := s.findClosest(s.head, target, i)
		if n.Next[i] != nil && n.Next[i].Value == target {
			return true
		}
	}
	return false
}

func (s *Skiplist) findClosest(node *Node, level int, value int) *Node {
	for node.Next[level] != nil && value > node.Next[level].Value {
		node = node.Next[level]
	}
	return node
}

func (s *Skiplist) Add(num int) {
	level := s.randomLevel()
	newNode := &Node{
		Value: num,
		Next:  make([]*Node, level),
	}
	for i := s.currentLevel - 1; i >= 0; i-- {
		n := s.findClosest(s.head, num, i)
		if i < level {
			if n.Next[i] != nil {
				newNode.Next[i] = n.Next[i].Next[i]
			}
			n.Next[i] = newNode
		}
		newNode.Next[i] = n.Next[i]
		n.Next[i] = newNode
	}
	for level > s.currentLevel {
		s.head.Next[s.currentLevel] = newNode
		s.currentLevel++
	}
}

func (s *Skiplist) Erase(target int) bool {
	for i := s.currentLevel - 1; i >= 0; i-- {
		n := s.findClosest(s.head, target, i)
		if n.Next[i] != nil && n.Next[i].Value == target {
			n.Next[i] = n.Next[i].Next[i]
			return true
		}
	}
	return false
}
