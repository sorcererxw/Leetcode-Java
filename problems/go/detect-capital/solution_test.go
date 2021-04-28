package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_detectCapitalUse(t *testing.T) {
	assert.Equal(t,true, detectCapitalUse("USA"))
	assert.Equal(t,true, detectCapitalUse("Leetcode"))
	assert.Equal(t,true, detectCapitalUse("leetcode"))
	assert.Equal(t,false, detectCapitalUse("leetCode"))
}
