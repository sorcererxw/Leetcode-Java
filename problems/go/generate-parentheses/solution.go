package main

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

Constraints:

1 <= n <= 8
*/

func generateParenthesis(n int) []string {
	return recursive("", 0, 0, n)
}

func recursive(s string, cl, cr, n int) []string {
	if cl == cr && cl == n {
		return []string{s}
	}
	var ret []string
	if cl < n {
		ret = append(ret, recursive(s+"(", cl+1, cr, n)...)
	}
	if cl > cr {
		ret = append(ret, recursive(s+")", cl, cr+1, n)...)
	}
	return ret
}
