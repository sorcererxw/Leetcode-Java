package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_addTwoNumbers(t *testing.T) {
	t.Run("", func(t *testing.T) {
		act := addTwoNumbers(
			&ListNode{Val: 7, Next: &ListNode{Val: 1, Next: &ListNode{Val: 6}}},
			&ListNode{Val: 5, Next: &ListNode{Val: 9, Next: &ListNode{Val: 2}}},
		)
		exp := &ListNode{Val: 2, Next: &ListNode{Val: 1, Next: &ListNode{Val: 9}}}

		for {
			if exp == nil {
				assert.Nil(t, act)
				break
			}
			assert.Equal(t, exp.Val, act.Val)
			exp = exp.Next
			act = act.Next
		}
	})
}

func Test_reverse(t *testing.T) {
	t.Run("", func(t *testing.T) {
		act := reverse(
			&ListNode{Val: 7, Next: &ListNode{Val: 1, Next: &ListNode{Val: 6}}},
		)
		exp := &ListNode{Val: 6, Next: &ListNode{Val: 1, Next: &ListNode{Val: 7}}}

		for {
			if exp == nil {
				assert.Nil(t, act)
				break
			}
			assert.Equal(t, exp.Val, act.Val)
			exp = exp.Next
			act = act.Next
		}
	})
}
