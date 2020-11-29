package main

func checkIfExist(arr []int) bool {
	set := make(map[int]struct{}, len(arr))
	for _, it := range arr {
		if it%2 == 0 {
			if _, ok := set[it/2]; ok {
				return true
			}
		}
		if _, ok := set[it*2]; ok {
			return true
		}
		set[it] = struct{}{}
	}
	return false
}
