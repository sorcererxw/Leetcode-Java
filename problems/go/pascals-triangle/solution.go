package main

func generate(numRows int) [][]int {
	ret := make([][]int, numRows)
	for i := 0; i < numRows; i++ {
		ret[i] = make([]int, i+1)
		for j := 0; j < i+1; j++ {
			if j == 0 || j == i {
				ret[i][j] = 1
			} else {
				ret[i][j] = ret[i-1][j-1] + ret[i-1][j]
			}
		}
	}
	return ret
}

/*
f(i,j) = f(i-1,j-1)+f(i-1,j)
1
1 1
1 2 1
1 3 3  1
1 4 6  4  1
1 5 10 10 5  1
1 6 15 20 15 6 1
*/
