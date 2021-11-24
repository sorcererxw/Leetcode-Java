package main

import (
	"fmt"
	"io"
	"os"

	"github.com/spf13/cobra"

	"github.com/sorcererxw/leetcode/cli/cmd"
)

func main() {
	if c, err := cmd.RootCmd.ExecuteC(); err != nil {
		printError(os.Stdout, err, c)
	}
}

func printError(out io.Writer, err error, cmd *cobra.Command) {
	fmt.Fprintln(out, err)
	fmt.Fprintln(out)
	fmt.Fprintln(out, cmd.UsageString())
}
