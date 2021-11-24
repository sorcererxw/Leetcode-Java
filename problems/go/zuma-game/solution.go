package main

func findMinStep(board string, hand string) int {
	return dfs(board, hand, map[int]struct{}{})
}

func dfs(board string, hand string, used map[int]struct{}) int {
	ans := -1
	for i := 0; i <= len(board); i++ {
		for j := 0; j < len(hand); j++ {
			if i > 0 && board[i-1] == hand[j] {
				continue
			}
			newBoard := board[:i] + string(hand[j])
			if i < len(board) {
				newBoard = newBoard + board[i:]
			}
		START:
			for k := 0; k < len(newBoard)-2; k++ {
				if newBoard[k] == newBoard[k+1] && newBoard[k] == newBoard[k+2] {
					l := k
					for ; l < len(newBoard) && newBoard[l] == newBoard[k]; l++ {
					}
					newBoard = newBoard[:k] + newBoard[l:]
					goto START
				}
			}
			used[j] = struct{}{}
			if v := dfs(newBoard, hand, used); v >= 0 {
				if ans == -1 || v < ans {
					ans = v
				}
			}
			delete(used, j)
		}
	}
	return ans
}
