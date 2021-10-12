package decode_ways

import (
	"testing"
)

func Test_numDecodings(t *testing.T) {
	tests := []struct {
		name string
		args string
		want int
	}{
		// TODO: Add test cases.
		{args: "12", want: 2},
		{args: "226", want: 3},
		{args: "0", want: 0},
		{args: "06", want: 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numDecodings(tt.args); got != tt.want {
				t.Errorf("numDecodings() = %v, want %v", got, tt.want)
			}
		})
	}
}
