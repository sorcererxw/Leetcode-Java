package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMyHashMap(t *testing.T) {
	m := Constructor()
	m.Put(1, 1)
	m.Put(2, 2)
	m.print()
	assert.Equal(t, 1, m.Get(1))
	assert.Equal(t, -1, m.Get(3))
	m.Put(2, 1)
	assert.Equal(t, 1, m.Get(2))
	m.Remove(2)
	assert.Equal(t, -1, m.Get(2))
}
