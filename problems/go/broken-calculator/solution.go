package _991_Broken_Calculator

/**
乘除比加减可以更快地逼近结果
无法判断过早的减法对最后结果的影响
可以先快速使用除法逼近结果
 */
func brokenCalc(X int, Y int) int {
	k := 0
	for Y > X {
		if Y%2 == 1 {
			Y += 1
		} else {
			Y /= 2
		}
		k += 1
	}
	return X - Y + k
}
