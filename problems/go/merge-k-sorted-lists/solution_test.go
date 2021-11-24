package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func array(node *ListNode) []int {
	ans := make([]int, 0)
	for node != nil {
		ans = append(ans, node.Val)
		node = node.Next
	}
	return ans
}

func Test_merge(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.EqualValues(
			t,
			array(&ListNode{
				Val: 1,
				Next: &ListNode{
					Val:  2,
					Next: nil,
				},
			}),
			array(merge(
				&ListNode{
					Val:  1,
					Next: nil,
				},
				&ListNode{
					Val:  2,
					Next: nil,
				},
			)),
		)
	})
}

func Test_mergeKLists(t *testing.T) {
	t.Run("", func(t *testing.T) {
		expect := &ListNode{
			Val: 1, Next: &ListNode{
				Val: 1,
				Next: &ListNode{
					Val: 2,
					Next: &ListNode{
						Val: 3,
						Next: &ListNode{
							Val: 4,
							Next: &ListNode{
								Val: 4,
								Next: &ListNode{
									Val: 5,
									Next: &ListNode{
										Val: 6,
									},
								},
							},
						},
					},
				},
			},
		}
		actual := mergeKLists([]*ListNode{
			{
				Val: 1, Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val: 5,
					},
				},
			},
			{
				Val: 1, Next: &ListNode{
					Val: 3,
					Next: &ListNode{
						Val: 4,
					},
				},
			},
			{
				Val: 2, Next: &ListNode{
					Val: 6,
				},
			},
		})
		assert.Equal(t, array(expect), array(actual))
	})
	t.Run("", func(t *testing.T) {
		expect := (*ListNode)(nil)
		actual := mergeKLists([]*ListNode{})
		assert.Equal(t, array(expect), array(actual))
	})
}
