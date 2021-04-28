package add_strings

import "fmt"

func reverse(s string) string {
	b := make([]byte, len(s))
	var j = len(s) - 1
	for i := 0; i <= j; i++ {
		b[j-i] = s[i]
	}
	return string(b)
}

func addStrings(num1 string, num2 string) string {
	num1 = reverse(num1)
	num2 = reverse(num2)
	var append int = 0
	var result = ""
	var index = 0
	for true {
		if append == 0 && len(num1) <= index && len(num2) <= index {
			break
		}
		var n1 int
		if len(num1) <= index {
			n1 = 0
		} else {
			n1 = int(num1[index]) - '0'
		}
		var n2 int
		if len(num2) <= index {
			n2 = 0
		} else {
			n2 = int(num2[index]) - '0'
		}
		var v = n1 + n2 + append
		//fmt.Printf("n1: %d n2: %d append: %d", n1, n2, append)
		append = int(v / 10)
		v = v % 10
		result += string('0' + v)
		index++
	}
	return reverse(result)
}

func main() {
	fmt.Println(addStrings("3", "69"))
}
