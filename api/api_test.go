package api

import (
	"context"
	"fmt"
	"net/http"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestQuestionData(t *testing.T) {
	l := Leetcode{client: http.DefaultClient,debug: true}
	q, err := l.QuestionData(context.Background(), "candy")
	assert.NoError(t, err)
	fmt.Printf("%+v", q)
}
