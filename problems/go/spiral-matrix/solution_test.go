package main

import (
	"reflect"
	"testing"
)

func Test_spiralOrder(t *testing.T) {
	tests := []struct {
		name string
		args [][]int
		want []int
	}{
		{
			args: [][]int{
				{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},
			},
			want: []int{1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := spiralOrder(tt.args); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("spiralOrder() = %v, want %v", got, tt.want)
			}
		})
	}
}
