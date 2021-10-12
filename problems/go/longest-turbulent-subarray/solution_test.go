package main

import (
	"testing"
)

func Test_maxTurbulenceSize(t *testing.T) {
	tests := []struct {
		name string
		args []int
		want int
	}{
		{
			args: []int{9, 4, 2, 10, 7, 8, 8, 1, 9},
			want: 5,
		},
		{
			args: []int{4, 8, 12, 16},
			want: 2,
		},
		{
			args: []int{100},
			want: 1,
		},
		{
			args: []int{9, 9},
			want: 1,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxTurbulenceSize(tt.args); got != tt.want {
				t.Errorf("maxTurbulenceSize() = %v, want %v", got, tt.want)
			}
		})
	}
}
