package models

import (
	"reflect"
	"testing"
)

func TestTreeNode_PreOrderTraversal(t *testing.T) {
	tests := []struct {
		name   string
		fields *TreeNode
		want   []int
	}{
		{
			fields: &TreeNode{
				Val: 3,
				Left: &TreeNode{
					Val: 1,
					Right: &TreeNode{
						Val: 2,
					},
				},
			},
			want: []int{5, 4},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			c := &TreeNode{
				Val:   tt.fields.Val,
				Left:  tt.fields.Left,
				Right: tt.fields.Right,
			}
			if got := c.PreOrderTraversal(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("InOrderTraversal() = %v, want %v", got, tt.want)
			}
		})
	}
}
