package expression_add_operators

// Given a string num that contains only digits and an integer target,
// return all possibilities to add the binary operators '+', '-', or '*' between the digits of num
// so that the resultant expression evaluates to the target value.
func addOperators(num string, target int) []string {
	nums := make([]int, len(num))
	for i := range num {
		nums[i] = int(num[i] - '0')
	}

}

func dfs(nums []int, last string, pos int, target int) []string {
	if pos >= len(nums) {
		if target == 0 {
			return []string{last}
		}
		return nil
	}

}
