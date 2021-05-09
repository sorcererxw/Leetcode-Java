package main

import (
	"math/rand"
	"sync"
	"time"
)

type H2O struct {
	h1ch chan struct{}
	h2ch chan struct{}
	och  chan struct{}
}

func NewH2O() *H2O {
	h := &H2O{
		h1ch: make(chan struct{}, 1),
		h2ch: make(chan struct{}, 1),
		och:  make(chan struct{}, 1),
	}
	h.h1ch <- struct{}{}
	return h
}

func (h2o *H2O) Hydrogen(releaseHydrogen func()) {
	select {
	case <-h2o.h1ch:
		defer func() {
			h2o.h2ch <- struct{}{}
		}()
	case <-h2o.h2ch:
		defer func() {
			h2o.och <- struct{}{}
		}()
	}
	// releaseHydrogen.run() outputs "H". Do not change or remove this line.
	releaseHydrogen()
}

func (h2o *H2O) Oxygen(releaseOxygen func()) {
	<-h2o.och
	defer func() {
		h2o.h1ch <- struct{}{}
	}()
	// releaseOxygen.run() outputs "O". Do not change or remove this line.
	releaseOxygen()
}

func main() {
	rand.Seed(time.Now().Unix())
	h2o := NewH2O()
	cnt := 0
	var wg sync.WaitGroup
	for i := 0; cnt != 0 || i == 0; i++ {
		wg.Add(1)
		switch rand.Int() % 3 {
		case 0:
			cnt -= 2
			go func() {
				defer wg.Done()
				h2o.Oxygen(func() { print("O") })
			}()
		default:
			cnt += 1
			go func() {
				defer wg.Done()
				h2o.Hydrogen(func() { print("H") })
			}()
		}
	}
	wg.Wait()
}
