package verify

import (
	"context"
	"encoding/json"
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
}

func (*leetcode) Submit(ctx context.Context, questionID string, langSlug string, code string) {

}

func (*leetcode) QuestionData(ctx context.Context, titleSlug string) (*question, error) {
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
	body, err := json.Marshal(arg)
	if err != nil {
		return nil, err
	}
}
