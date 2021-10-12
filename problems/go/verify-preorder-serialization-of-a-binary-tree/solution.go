package verify_preorder_serialization_of_a_binary_tree

func isValidSerialization(preorder string) bool {
	cnt := 1
	preorder += ","
	for i := range preorder {
		if preorder[i] != ',' {
			continue
		}
		cnt -= 1
		if cnt < 0 {
			break
		}
		// the previous item is not null
		if preorder[i-1] != '#' {
			cnt += 2
		}
	}
	return cnt == 0
}
