package main

import "testing"

func Test_numMatchingSubseq(t *testing.T) {
	type args struct {
		s     string
		words []string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "",
			args: args{
				s:     "abcde",
				words: []string{"a", "bb", "acd", "ace"},
			},
			want: 3,
		},
		{
			name: "",
			args: args{
				s:     "dsahjpjauf",
				words: []string{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"},
			},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numMatchingSubseq(tt.args.s, tt.args.words); got != tt.want {
				t.Errorf("numMatchingSubseq() = %v, want %v", got, tt.want)
			}
		})
	}
}
