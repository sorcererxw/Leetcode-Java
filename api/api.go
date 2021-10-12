package api

import (
	"bytes"
	"context"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
)

const endpoint = "https://leetcode.com"

type codeSnippet struct {
	Lang     string `json:"lang"`
	LangSlug string `json:"langSlug"`
	Code     string `json:"code"`
}

type question struct {
	Title              string        `json:"title"`
	TitleSlug          string        `json:"titleSlug"`
	Status             string        `json:"status"`
	QuestionID         string        `json:"questionId"`
	QuestionFrontendID string        `json:"questionFrontendId"`
	Metadata           string        `json:"metadata"`
	EnvInfo            string        `json:"envInfo"`
	ExampleTestcases   string        `json:"exampleTestcases"`
	Difficulty         string        `json:"difficulty"`
	Content            string        `json:"content"`
	CodeSnippets       []codeSnippet `json:"codeSnippets"`
}

type leetcode struct {
	client *http.Client
}

func (l *leetcode) request(ctx context.Context, method string, path string, body interface{}, dest interface{}) error {
	var reqBody io.Reader
	if body != nil {
		b, err := json.Marshal(reqBody)
		if err != nil {
			return err
		}
		reqBody = bytes.NewReader(b)
	}
	req, err := http.NewRequestWithContext(
		ctx, method, fmt.Sprintf(endpoint+path), reqBody,
	)
	if err != nil {
		return err
	}
	rsp, err := l.client.Do(req)
	if err != nil {
		return err
	}
	defer rsp.Body.Close()
	if dest != nil {
		if err := json.NewDecoder(rsp.Body).Decode(dest); err != nil {
			return err
		}
	}
	return nil
}

func (l *leetcode) Submit(ctx context.Context, questionID string, titleSlug string, langSlug string, code string) (string, error) {
	l.request(ctx, http.MethodPost, "/", map[string]string{
		"",
	}, nil)
}

type SubmitDetail struct {
}

func (*leetcode) Check(ctx context.Context, submitID string) error {

	http.NewRequest(
		http.MethodGet,
		fmt.Sprintf("%s/submissions/detail/%s/check/", endpoint, submitID),
		nil)
}

func (l *leetcode) QuestionData(ctx context.Context, titleSlug string) (*question, error) {
	var ret question
	arg := map[string]interface{}{
		"operationName": "questionData",
		"variables": map[string]string{
			"titleSlug": titleSlug,
		},
		"query": `
query questionData($titleSlug: String!) {
	question(titleSlug: $titleSlug) {
		questionId
		questionFrontendId
		boundTopicId
		title
		titleSlug
		content
		translatedTitle
		translatedContent
		isPaidOnly
		difficulty
		likes
		dislikes
		isLiked
		similarQuestions
		exampleTestcases
		contributors {
			username
			profileUrl
			avatarUrl
			__typename
		}
		topicTags {
			name
			slug
			translatedName
			__typename
		}
		companyTagStats
			codeSnippets {
			lang
			langSlug
			code
			__typename
		}
		stats
		hints
		solution {
			id
			canSeeDetail
			paidOnly
			hasVideoSolution
			paidOnlyVideo
			__typename
		}
		status
		sampleTestCase
		metaData
		judgerAvailable
		judgeType
		mysqlSchemas
		enableRunCode
		enableTestMode
		enableDebugger
		envInfo
		libraryUrl
		adminUrl
		__typename
	}
}`,
	}
	if err := l.request(ctx, http.MethodPost, "/graphql", arg, &ret); err != nil {
		return nil, err
	}
	return &ret, nil
}
