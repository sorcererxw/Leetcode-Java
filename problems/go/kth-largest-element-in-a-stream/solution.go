package kth_largest_element_in_a_stream

import (
	"sort"
)

type KthLargest struct {
	arr []int
}

func Constructor(k int, nums []int) KthLargest {
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] > nums[j]
	})

	arr := make([]int, 0, k)
	if len(nums) > k {
		arr = append(arr, nums[:k]...)
	} else {
		arr = append(arr, nums...)
	}

	return KthLargest{
		arr: arr,
	}
}

func (this *KthLargest) Add(val int) int {
	k := cap(this.arr)
	l := len(this.arr)
	for i := l; i >= 0; i-- {
		if i == 0 {
			if l == 0 {
				this.arr = append(this.arr, val)
			} else {
				this.arr[0] = val
			}
			break
		}
		if this.arr[i-1] < val {
			if i < l {
				this.arr[i] = this.arr[i-1]
			} else if l < k {
				this.arr = append(this.arr, this.arr[i-1])
			}
		} else {
			if i < l {
				this.arr[i] = val
			} else if l < k {
				this.arr = append(this.arr, val)
			}
			break
		}
	}
	return this.arr[len(this.arr)-1]
}
