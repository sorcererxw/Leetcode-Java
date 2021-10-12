package sum_of_square_numbers

import (
	"testing"
)

func Test_judgeSquareSum(t *testing.T) {
	tests := []struct {
		name string
		args int
		want bool
	}{
		{args: 5, want: true},
		{args: 3, want: false},
		{args: 4, want: true},
		{args: 2, want: true},
		{args: 1, want: true},
		{args: 0, want: true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := judgeSquareSum(tt.args); got != tt.want {
				t.Errorf("judgeSquareSum() = %v, want %v", got, tt.want)
			}
		})
	}
}
