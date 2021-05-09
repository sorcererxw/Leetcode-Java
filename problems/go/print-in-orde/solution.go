package main

import (
	"math/rand"
	"sync"
)

type Foo struct {
	firstCh  chan struct{}
	secondCh chan struct{}
	thirdCh  chan struct{}
}

func NewFoo() *Foo {
	foo := &Foo{
		firstCh:  make(chan struct{}, 1),
		secondCh: make(chan struct{}, 1),
		thirdCh:  make(chan struct{}, 1),
	}
	foo.firstCh <- struct{}{}
	return foo
}

func (f *Foo) First(printFirst func()) {
	if _, ok := <-f.firstCh; !ok {
		return
	}
	defer func() {
		close(f.firstCh)
		f.secondCh <- struct{}{}
	}()
	printFirst()
}

func (f *Foo) Second(printSecond func()) {
	if _, ok := <-f.secondCh; !ok {
		return
	}
	defer func() {
		close(f.secondCh)
		f.thirdCh <- struct{}{}
	}()
	printSecond()
}

func (f *Foo) Third(printThird func()) {
	if _, ok := <-f.thirdCh; !ok {
		return
	}
	defer func() { close(f.thirdCh) }()
	printThird()
}

func main() {
	var wg sync.WaitGroup
	f := NewFoo()

	for i := 0; i < 1000; i++ {
		wg.Add(1)
		go func() {
			defer wg.Done()
			switch rand.Int() % 3 {
			case 0:
				f.First(func() { print("first") })
			case 1:
				f.Second(func() { print("second") })
			case 2:
				f.Third(func() { print("third") })
			}
		}()
	}
	wg.Wait()
}
