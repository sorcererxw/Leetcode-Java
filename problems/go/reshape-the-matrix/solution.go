package main

func matrixReshape(mat [][]int, r int, c int) [][]int {
	h := len(mat)
	if h == 0 {
		return mat
	}
	w := len(mat[0])
	if w == 0 {
		return mat
	}
	if h*w != r*c {
		return mat
	}
	mat_ := make([][]int, r)
	for i := 0; i < r; i++ {
		mat_[i] = make([]int, c)
		for j := 0; j < c; j++ {
			idx := i*c + j
			mat_[i][j] = mat[idx/w][idx%w]
		}
	}
	return mat_
}
