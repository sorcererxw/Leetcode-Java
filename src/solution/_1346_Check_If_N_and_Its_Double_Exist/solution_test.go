package main

import "testing"

func Test_checkIfExist(t *testing.T) {
	tests := []struct {
		name string
		args []int
		want bool
	}{
		{
			args: []int{10, 2, 5, 3},
			want: true,
		},
		{
			args: []int{7, 1, 14, 11},
			want: true,
		},
		{
			args: []int{3, 1, 7, 11},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := checkIfExist(tt.args); got != tt.want {
				t.Errorf("checkIfExist() = %v, want %v", got, tt.want)
			}
		})
	}
}
