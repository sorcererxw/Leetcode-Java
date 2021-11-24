package cmd

import (
	"github.com/spf13/cobra"
)

func init() {
	RootCmd.PersistentFlags().Bool("help", false, "Show Help")
	RootCmd.PersistentFlags().Bool("debug", false, "DEBUG")
	RootCmd.PersistentFlags().Bool("cn", false, "Use leetcode-cn.com")
}

var RootCmd = &cobra.Command{}
