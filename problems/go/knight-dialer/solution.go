package main

func knightDialer(n int) int {
	const mod = 1000000000 + 7

	corner, edgey, edgex, center, zero := 1, 1, 1, 1, 1

	for i := 1; i < n; i++ {
		corner, edgey, edgex, center, zero = (edgey+edgex)%mod, (2*corner)%mod, (2*corner+zero)%mod, 0, (2*edgex)%mod
	}

	return (corner*4 + edgex*2 + edgey*2 + center + zero) % mod
}
