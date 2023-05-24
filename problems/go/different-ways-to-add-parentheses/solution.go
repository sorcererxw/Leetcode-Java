package main

import (
	"fmt"
	"strconv"
)

func diffWaysToCompute(expression string) []int {
	nums, ops := parseExpression(expression)
	return dfs(nums, ops, make(map[string]struct{}))
}

func parseExpression(expression string) ([]int, []byte) {
	var nums []int
	var ops []byte
	currentNum := -1
	for i := 0; i < len(expression); i++ {
		switch c := expression[i]; c {
		case '+', '-', '*':
			ops = append(ops, c)
			if currentNum >= 0 {
				nums = append(nums, currentNum)
				currentNum = -1
			} else {
				panic("invalid expression")
			}
		case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
			if currentNum < 0 {
				currentNum = int(c - '0')
			} else {
				currentNum = currentNum*10 + int(c-'0')
			}
		default:
			panic("invalid expression")
		}
	}
	if currentNum >= 0 {
		nums = append(nums, currentNum)
	} else {
		panic("invalid expression")
	}
	return nums, ops
}

func dfs(nums []int, ops []byte, m map[string]struct{}) []int {
	var str string
	str += strconv.Itoa(nums[0])
	for i := 0; i < len(ops); i++ {
		str += fmt.Sprintf("%c%d", ops[i], nums[i+1])
	}
	if _, ok := m[str]; ok {
		return nil
	}
	m[str] = struct{}{}
	println(str)

	if len(nums) == 1 {
		return []int{nums[0]}
	}
	var result []int
	for i := 0; i < len(ops); i++ {
		v := cal(nums[i], nums[i+1], ops[i])
		newNums := clone(nums)
		newNums = omit(newNums, i)
		newNums[i] = v
		newOps := clone(ops)
		newOps = omit(newOps, i)
		result = append(result, dfs(newNums, newOps, m)...)
	}
	return result
}

func cal(a, b int, op byte) int {
	switch op {
	case '+':
		return a + b
	case '-':
		return a - b
	case '*':
		return a * b
	}
	panic("invalid op")
}

func clone[T int | byte](nums []T) []T {
	result := make([]T, len(nums))
	copy(result, nums)
	return result
}

func omit[T int | byte](nums []T, i int) []T {
	return append(nums[:i], nums[i+1:]...)
}
