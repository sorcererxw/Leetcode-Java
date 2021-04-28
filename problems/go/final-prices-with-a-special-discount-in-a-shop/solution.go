package _1475

/*
遍历列表，如果当前值小于等于栈内值，就将其位相应值减小，并将当前值的位置放入栈内
 */

func finalPrices(prices []int) []int {
	stack := make([]int, 0, len(prices))

	for i := 0; i < len(prices); i++ {
		for len(stack) > 0 {
			top := stack[len(stack)-1]
			if prices[top] < prices[i] {
				break
			}
			prices[top] = prices[top] - prices[i]
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}
	return prices
}
