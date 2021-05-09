package main

type FizzBuzz struct {
	n int
}

func fizzBuzzCreate(n int) *FizzBuzz {
	return &FizzBuzz{n}
}

// printFizz() outputs "fizz".
func (*FizzBuzz) fizz(printFizz func()) {
}

// printBuzz() outputs "buzz".
func (*FizzBuzz) buzz(printBuzz func()) {
}

// printFizzBuzz() outputs "fizzbuzz".
func (*FizzBuzz) fizzbuzz(printFizzBuzz func()) {
}

// You may call global function `void printNumber(int x)`
// to output "x", where x is an integer.
func (*FizzBuzz) number(printNumber func(int)) {
}
