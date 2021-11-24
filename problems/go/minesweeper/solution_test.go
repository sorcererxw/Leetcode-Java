package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_updateBoard(t *testing.T) {
	t.Run("", func(t *testing.T) {
		assert.Equal(t, [][]byte{
			{'B', '1', 'E', '1', 'B'},
			{'B', '1', 'M', '1', 'B'},
			{'B', '1', '1', '1', 'B'},
			{'B', 'B', 'B', 'B', 'B'},
		}, updateBoard([][]byte{
			{'E', 'E', 'E', 'E', 'E'},
			{'E', 'E', 'M', 'E', 'E'},
			{'E', 'E', 'E', 'E', 'E'},
			{'E', 'E', 'E', 'E', 'E'},
		}, []int{3, 0}))
	})
	t.Run("", func(t *testing.T) {
		assert.Equal(t, [][]byte{
			{'B', '1', 'E', '1', 'B'},
			{'B', '1', 'X', '1', 'B'},
			{'B', '1', '1', '1', 'B'},
			{'B', 'B', 'B', 'B', 'B'},
		}, updateBoard([][]byte{
			{'B', '1', 'E', '1', 'B'},
			{'B', '1', 'M', '1', 'B'},
			{'B', '1', '1', '1', 'B'},
			{'B', 'B', 'B', 'B', 'B'},
		}, []int{1, 2}))
	})
}
