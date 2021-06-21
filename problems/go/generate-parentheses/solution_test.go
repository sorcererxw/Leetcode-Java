package main

import (
	"reflect"
	"sort"
	"testing"
)

func Test_generateParenthesis(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		{
			name: "",
			args: args{n: 3},
			want: []string{"((()))", "(()())", "(())()", "()(())", "()()()"},
		},
		{
			name: "",
			args: args{n: 1},
			want: []string{"()"},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := generateParenthesis(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				sort.Slice(got, func(i, j int) bool { return got[i] < got[j] })
				sort.Slice(tt.want, func(i, j int) bool { return tt.want[i] < tt.want[j] })

				t.Errorf("generateParenthesis() = %v, want %v", got, tt.want)
			}
		})
	}
}
