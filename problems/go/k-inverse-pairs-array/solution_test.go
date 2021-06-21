package main

import "testing"

func Test_kInversePairs(t *testing.T) {
	type args struct {
		n int
		k int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "",
			args: args{
				n: 3,
				k: 0,
			},
			want: 1,
		},
		{
			name: "",
			args: args{
				n: 3,
				k: 1,
			},
			want: 2,
		},
		{
			name: "",
			args: args{
				n: 1000,
				k: 1000,
			},
			want: 663677020,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := kInversePairs(tt.args.n, tt.args.k); got != tt.want {
				t.Errorf("kInversePairs() = %v, want %v", got, tt.want)
			}
		})
	}
}
