package cmd

import (
	"strings"

	"github.com/spf13/cobra"

	"github.com/sorcererxw/leetcode/api"
)

func init() {
	RootCmd.AddCommand(ShowCmd)
	ShowCmd.Flags().StringP("slug", "s", "", "Problem Slug")
	ShowCmd.Flags().StringP("lang", "l", "", "Snippet language")
}

var ShowCmd = &cobra.Command{
	Use:   "show",
	Short: "Show problem",
	RunE: func(cmd *cobra.Command, args []string) error {
		debug, err := cmd.Flags().GetBool("debug")
		if err != nil {
			return err
		}
		slug, err := cmd.Flags().GetString("slug")
		if err != nil {
			return err
		}
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
		//content, err := html2text.FromString(q.Content)
		//if err != nil {
		//	return err
		//}
		if cn && q.TranslatedTitle != "" {
			cmd.Println(q.TranslatedTitle)
		} else {
			cmd.Println(q.Title)
		}
		cmd.Println()
		if cn && q.TranslatedContent != "" {
			cmd.Println(q.TranslatedContent)
		} else {
			cmd.Println(q.Content)
		}
		for _, snip := range q.CodeSnippets {
			if snip.LangSlug == lang || strings.ToLower(snip.Lang) == lang {
				cmd.Println()
				cmd.Printf("Snippet[%s]:\n", snip.Lang)
				cmd.Println()
				cmd.Println(snip.Code)
				break
			}
		}
		return nil
	},
}
