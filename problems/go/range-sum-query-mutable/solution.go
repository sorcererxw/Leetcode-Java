package main

type NumArray struct {
	n    int
	tree []int
}

func Constructor(nums []int) NumArray {
	n := len(nums)
	tree := make([]int, 2*n)
	for i := n; i < 2*n; i++ {
		tree[i] = nums[i-n]
	}
	for i := n - 1; i > 0; i-- {
		tree[i] = tree[i*2] + tree[i*2+1]
	}
	return NumArray{tree: tree, n: n}
}

func (arr *NumArray) Update(index int, val int) {
	index += arr.n
	sub := arr.tree[index] - val
	for index > 0 {
		arr.tree[index] -= sub
		index /= 2
	}
}

func (arr *NumArray) SumRange(left int, right int) int {
	l := left + arr.n
	r := right + arr.n
	var sum int
	for l <= r {
		if l%2 == 1 {
			sum += arr.tree[l]
			l++
		}
		if r%2 == 0 {
			sum += arr.tree[r]
			r--
		}
		l /= 2
		r /= 2
	}
	return sum
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * obj.Update(index,val);
 * param_2 := obj.SumRange(left,right);
 */
