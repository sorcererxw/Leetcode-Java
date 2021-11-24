package main

import (
	"math/rand"
)

func sortArray(nums []int) []int {
	return heapSort(nums)
}

func heapSort(nums []int) []int {
	for i := len(nums) / 2; i >= 0; i-- {
		heapify(nums, i)
	}
	for i := len(nums) - 1; i >= 0; i-- {
		nums[0], nums[i] = nums[i], nums[0]
		heapify(nums[:i], 0)
	}
	return nums
}

func heapify(nums []int, i int) {
	l, r := 2*i+1, 2*i+2
	k := i
	if l < len(nums) && nums[l] > nums[k] {
		k = l
	}
	if r < len(nums) && nums[r] > nums[k] {
		k = r
	}
	if k != i {
		nums[k], nums[i] = nums[i], nums[k]
		heapify(nums, k)
	}
}

func mergeSort(nums []int) []int {
	if len(nums) <= 1 {
		return nums
	}
	return merge(
		mergeSort(nums[:len(nums)/2]),
		mergeSort(nums[len(nums)/2:]),
	)
}

func merge(l, r []int) []int {
	ret := make([]int, 0, len(l)+len(r))
	i, j := 0, 0
	for i < len(l) && j < len(r) {
		if l[i] < r[j] {
			ret = append(ret, l[i])
			i++
		} else {
			ret = append(ret, r[j])
			j++
		}
	}
	for i < len(l) {
		ret = append(ret, l[i])
		i++
	}
	for j < len(r) {
		ret = append(ret, r[j])
		j++
	}
	return ret
}

func quickSort(nums []int) []int {
	rand.Shuffle(len(nums), func(i, j int) {
		nums[i], nums[j] = nums[j], nums[i]
	})
	quickSort_(nums, 0, len(nums)-1)
	return nums
}

func quickSort_(nums []int, lo, hi int) {
	if lo > hi {
		return
	}
	p := partition(nums, lo, hi)
	quickSort_(nums, lo, p-1)
	quickSort_(nums, p+1, hi)
}

func partition(nums []int, lo, hi int) int {
	i, j := lo+1, hi
	p := nums[lo]
	for {
		if i < hi && nums[i] <= p {
			i++
		}
		for j > lo && nums[j] >= p {
			j--
		}
		if i >= j {
			break
		}
		nums[i], nums[j] = nums[j], nums[i]
	}
	nums[j], nums[lo] = nums[lo], nums[j]
	return j
}
