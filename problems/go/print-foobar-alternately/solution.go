package main

import "sync"

/*
Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.



Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
*/

type FooBar struct {
	n     int
	fooCh chan struct{}
	barCh chan struct{}
}

func NewFooBar(n int) *FooBar {
	fooCh, barCh := make(chan struct{}, 1), make(chan struct{}, 1)
	fooCh <- struct{}{}
	return &FooBar{n: n, fooCh: fooCh, barCh: barCh}
}

func (f *FooBar) foo(printFoo func()) {
	for i := 0; i < f.n; i++ {
		<-f.fooCh
		// printFoo.run() outputs "foo". Do not change or remove this line.
		printFoo()
		f.barCh <- struct{}{}
	}
}

func (f *FooBar) bar(printBar func()) {
	for i := 0; i < f.n; i++ {
		<-f.barCh
		// printBar.run() outputs "bar". Do not change or remove this line.
		printBar()
		f.fooCh <- struct{}{}
	}
}

func main() {
	f := NewFooBar(10)
	var g sync.WaitGroup
	g.Add(1)
	go func() {
		defer g.Done()
		f.foo(func() { print("foo") })
	}()
	g.Add(1)
	go func() {
		defer g.Done()
		f.bar(func() { print("bar") })
	}()
	g.Wait()
}
