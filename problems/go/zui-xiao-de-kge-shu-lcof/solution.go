package main

import "container/heap"

type Heap []int

func (h *Heap) Len() int {
	return len(*h)
}

func (h *Heap) Swap(i, j int) {
	(*h)[i], (*h)[j] = (*h)[j], (*h)[i]
}

func (h *Heap) Less(i, j int) bool {
	return (*h)[i] > (*h)[j]
}

func (h *Heap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *Heap) Pop() (v interface{}) {
	v, *h = (*h)[h.Len()-1], (*h)[:h.Len()-1]
	return
}

func getLeastNumbers(arr []int, k int) []int {
	if k == 0 {
		return []int{}
	}
	h := Heap([]int{})
	for _, it := range arr {
		if h.Len() < k {
			heap.Push(&h, it)
		} else if h[0] > it {
			heap.Pop(&h)
			heap.Push(&h, it)
		}
	}
	res := make([]int, 0, k)
	for h.Len() > 0 {
		res = append(res, heap.Pop(&h).(int))
	}
	return res
}
