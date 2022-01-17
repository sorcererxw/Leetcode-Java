package main

import (
	"sort"
	"fmt"
)

func leastInterval(tasks []byte, n int) int {
	var taskCounts [30]struct {
		t byte
		c int
	}
	for _, t := range tasks {
		taskCounts[t-'A'] = struct {
			t byte
			c int
		}{
			t: t,
			c: taskCounts[t-'A'].c + 1,
		}
	}
	sort.Slice(taskCounts[:], func(i, j int) bool {
		return taskCounts[i].c > taskCounts[j].c
	})
	scheduler := make([]byte, (n+1)*len(tasks))
	var max int
	for _, v := range taskCounts {
		c := v.c
		var i int
		for c > 0 {
			if scheduler[i] == 0 {
				c--
				scheduler[i] = v.t
				if i >= max {
					max = i
				}
				i += n
			}
			i++
		}
	}
	fmt.Println(scheduler)
	return max + 1
}
