package _1389_Create_Target_Array_in_the_Given_Order

func createTargetArray(nums []int, index []int) []int {
	N := len(nums)
	dist := make([]int, N)
	for i := 0; i < N; i++ {
		idx := index[i]
		if idx >= i {
			dist[idx] = nums[i]
		} else {
			for j := i; j > idx; j-- {
				dist[j] = dist[j-1]
			}
			dist[idx] = nums[i]
		}
	}
	return dist
}
