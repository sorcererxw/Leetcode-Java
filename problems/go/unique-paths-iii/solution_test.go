package main

import "testing"

func Test_uniquePathsIII(t *testing.T) {
	t.Run("", func(t *testing.T) {
		grid := [][]int{
			{1, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 2, -1},
		}
		got := uniquePathsIII(grid)
		want := 2
		if got != want {
			t.Errorf("got %d want %d", got, want)
		}
	})
	t.Run("", func(t *testing.T) {
		grid := [][]int{
			{1, 0, 0, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 2},
		}
		got := uniquePathsIII(grid)
		want := 4
		if got != want {
			t.Errorf("got %d want %d", got, want)
		}
	})
	t.Run("", func(t *testing.T) {
		grid := [][]int{
			{0, 1},
			{2, 0},
		}
		got := uniquePathsIII(grid)
		want := 0
		if got != want {
			t.Errorf("got %d want %d", got, want)
		}
	})
}
