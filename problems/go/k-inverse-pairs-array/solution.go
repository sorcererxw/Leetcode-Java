package main

/*
在 [0..i-1] 中加入 i, 因为 i 最大，插在中部必然会制造逆序对
f(i,j)
= 放在最右侧 + 放在倒数第二位置 + 放在倒数第三位置 + ... + 最多只能引入 i-1 个，所以极限位置是 j-(i-1)
= f(i-1，j) + f(i-1,j-1) + f(i-1,j-2) + ... + f(i-1,j-i+1)

f(i,j-1)
= f(i-1，j-1) + f(i-1,j-2) + f(i-1,j-3) + ... + f(i-1,j-i+1) + f(i-1,j-i)

f(i,j)-f(i,j-1)
= f(i-1,j) - f(i-1,j-i)

f(i,j) = f(i-1,j) - f(i-1,j-i) + f(i,j-1)

当 i==0, f = 0
当 j==0, f = 1

*/

func kInversePairs(n int, k int) int {
	const mod = 1000000007
	dp := make([][]int, n+1)
	for i := 1; i <= n; i++ {
		if dp[i] == nil {
			dp[i] = make([]int, k+1)
		}
		for j := 0; j <= k && j <= i*(i-1)/2; j++ {
			if i == 1 && j == 0 {
				dp[i][j] = 1
				break
			} else if j == 0 {
				dp[i][j] = 1
			} else {
				var sub int
				if j >= i {
					sub = dp[i-1][j-i]
				}
				dp[i][j] = ((dp[i-1][j]+mod-sub)%mod + dp[i][j-1]) % mod
			}
		}
	}
	return dp[n][k]
}
