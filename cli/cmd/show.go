package cmd

import (
	"fmt"
	"regexp"
	"strings"

	md "github.com/JohannesKaufmann/html-to-markdown"
	"github.com/charmbracelet/glamour"
	"github.com/spf13/cobra"

	"github.com/sorcererxw/leetcode/api"
)

func init() {
	RootCmd.AddCommand(showCmd)
	showCmd.Flags().StringP("slug", "s", "", "Problem Slug")
	showCmd.Flags().StringP("lang", "l", "", "Snippet language")
}

func extractSlug(s string) string {
	re := regexp.MustCompile("^https://leetcode(?:-cn)?\\.com/problems/([a-zA-Z0-9-]*)($|/)")
	if v := re.FindStringSubmatch(s); len(v) >= 2 {
		return v[1]
	}
	return s
}

var showCmd = &cobra.Command{
	Use:   "show",
	Short: "Show problem",
	RunE: func(cmd *cobra.Command, _ []string) error {
		debug, err := cmd.Flags().GetBool("debug")
		if err != nil {
			return err
		}
		slug, err := cmd.Flags().GetString("slug")
		if err != nil {
			return err
		}
		slug = extractSlug(slug)
		lang, err := cmd.Flags().GetString("lang")
		if err != nil {
			return err
		}
		cn, err := cmd.Flags().GetBool("cn")
		if err != nil {
			return err
		}
		leetcode, err := api.New(debug, cn)
		if err != nil {
			return err
		}
		q, err := leetcode.QuestionData(cmd.Context(), slug)
		if err != nil {
			return err
		}
		if q == nil {
			cmd.Println("Question not found")
			return nil
		}
		body := ""
		{
			title := q.Title
			if cn && q.TranslatedTitle != "" {
				title = q.TranslatedTitle
			}
			body += "# " + title + "\n"
		}
		{
			if q.Difficulty != "" {
				body += fmt.Sprintf("`%s`\n", q.Difficulty)
			}
		}
		{
			content := q.Content
			if cn && q.TranslatedContent != "" {
				content = q.TranslatedContent
			}
			if debug {
				fmt.Println(content)
			}
			content, err := md.NewConverter("", true, &md.Options{}).ConvertString(content)
			if err != nil {
				return err
			}
			body += "## Description\n" + content + "\n"
		}
		{
			for _, snip := range q.CodeSnippets {
				if snip.LangSlug == lang || strings.ToLower(snip.Lang) == lang {
					body += fmt.Sprintf("## Snippet:\n```%s\n%s\n```", snip.LangSlug, snip.Code)
					break
				}
			}
		}

		if debug {
			cmd.Println(body)
		}
		render, err := glamour.NewTermRenderer(glamour.WithAutoStyle(), glamour.WithWordWrap(100))
		if err != nil {
			return err
		}
		out, err := render.Render(body)
		if err != nil {
			return err
		}
		cmd.Println(out)
		return nil
	},
}
