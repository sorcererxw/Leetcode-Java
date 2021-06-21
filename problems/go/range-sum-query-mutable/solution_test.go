package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestNumArray(t *testing.T) {
	arr := Constructor([]int{1, 3, 5})
	assert.Equal(t, 9, arr.SumRange(0, 2))
	arr.Update(1, 2)
	assert.Equal(t, 8, arr.SumRange(0, 2))
}
