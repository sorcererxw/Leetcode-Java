package api

import (
	"bytes"
	"context"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"net/http/httputil"
)

type codeSnippet struct {
	Lang     string `json:"lang"`
	LangSlug string `json:"langSlug"`
	Code     string `json:"code"`
}

type question struct {
	Title              string        `json:"title"`
	TitleSlug          string        `json:"titleSlug"`
	TranslatedTitle    string        `json:"translatedTitle"`
	TranslatedContent  string        `json:"translatedContent"`
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

type Leetcode struct {
	client *http.Client
	cn     bool
	debug  bool
}

func New(debug bool, cn bool) (*Leetcode, error) {
	return &Leetcode{
		client: &http.Client{},
		debug:  debug,
		cn:     cn,
	}, nil
}

func (l *Leetcode) endpoint() string {
	if l.cn {
		return "https://leetcode-cn.com"
	}
	return "https://leetcode.com"
}

func (l *Leetcode) request(ctx context.Context, method string, path string, body interface{}, dest interface{}) error {
	var reqBody io.Reader
	if body != nil {
		b, err := json.Marshal(body)
		if err != nil {
			return err
		}
		reqBody = bytes.NewReader(b)
	}
	req, err := http.NewRequestWithContext(
		ctx, method, fmt.Sprintf(l.endpoint()+path), reqBody,
	)
	if err != nil {
		return err
	}
	req.Header.Add("Content-Type", "application/json")
	if l.debug {
		dump, err := httputil.DumpRequestOut(req, true)
		if err != nil {
			return err
		}
		fmt.Println(string(dump))
	}
	rsp, err := l.client.Do(req)
	if err != nil {
		return err
	}
	defer rsp.Body.Close()
	if dest != nil {
		b, err := io.ReadAll(rsp.Body)
		if err != nil {
			return err
		}
		if l.debug {
			fmt.Println(string(b))
		}
		if err := json.Unmarshal(b, dest); err != nil {
			return err
		}
	}
	return nil
}

func (l *Leetcode) graphql(ctx context.Context, operationName string, variables map[string]interface{}, query string, dest interface{}) error {
	return l.request(ctx, http.MethodPost, "/graphql", map[string]interface{}{
		"operationName": operationName,
		"variables":     variables,
		"query":         query,
	}, dest)
}

func (l *Leetcode) QuestionData(ctx context.Context, titleSlug string) (*question, error) {
	var ret struct {
		Data struct {
			Question *question `json:"question"`
		} `json:"data"`
	}
	err := l.graphql(
		ctx,
		"questionData",
		map[string]interface{}{
			"titleSlug": titleSlug,
		},
		`
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
		difficulty
		likes
		dislikes
		isLiked
		similarQuestions
		exampleTestcases
		topicTags {
			name
			slug
			translatedName
		}
		companyTagStats
			codeSnippets {
			lang
			langSlug
			code
		}
		stats
		hints
		status
		sampleTestCase
		metaData
		judgerAvailable
		judgeType
		mysqlSchemas
		envInfo
		libraryUrl
	}
}`,
		&ret)
	if err != nil {
		return nil, err
	}
	return ret.Data.Question, nil
}

// func (l *Leetcode) Submit(ctx context.Context, questionID string, titleSlug string, langSlug string, code string) (string, error) {
// 	l.request(ctx, http.MethodPost, "/", map[string]string{
// 		"",
// 	}, nil)
// }

type SubmitDetail struct {
}

// func (*Leetcode) Check(ctx context.Context, submitID string) error {
// 	http.NewRequest(
// 		http.MethodGet,
// 		fmt.Sprintf("%s/submissions/detail/%s/check/", endpoint, submitID),
// 		nil)
// }
