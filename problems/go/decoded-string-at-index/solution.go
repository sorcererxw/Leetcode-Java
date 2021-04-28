package _880_Decoded_String_at_Index

import "unicode"

func decodeAtIndex(S string, K int) string {
	size := 0
	for _, c := range S {
		if unicode.IsDigit(c) {
			size *= int(c - '0')
		} else {
			size += 1
		}
	}
	for i := len(S) - 1; i >= 0; i-- {
		K %= size // 取后半段 abcdabcdabcd, 比如这样重复了三遍, 取模之后取得是最后一段的剩余长度
		isDigit := unicode.IsDigit(rune(S[i]))
		if K == 0 && !isDigit {
			return string(S[i])
		}
		if isDigit {
			size = size / int(S[i]-'0')
		} else {
			size--
		}
	}
	return ""
}
