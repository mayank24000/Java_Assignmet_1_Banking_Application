package main
import("fmt"; "main.go/String_manpltn"; "main.go/Int_manpltn")

func main(){
//---------Integer Manipulation --------------
	var a int
	fmt.Print("Enter a number to find its Factorial: ")
	fmt.Scan(&a)
	result := Int_manpltn.Factorial(a)
	fmt.Printf("The factorial of %d is %d\n", a, result)

	var b int
	fmt.Print("Enter a number to find its Power: ")
	fmt.Scan(&b)
	var c int
	fmt.Print("Enter the exponent: ")
	fmt.Scan(&c)
	powerResult := Int_manpltn.Power(b, c)
	fmt.Printf("%d raised to the power of %d is %d\n", b, c, powerResult)

//---------String Manipulation --------------

	var str string
	fmt.Print("Enter a string to count vowels: ")
	fmt.Scan(&str)
	vowelCount := String_manpltn.CountVowel(str)
	fmt.Printf("The number of vowels in the string \"%s\" is %d\n", str, vowelCount)

	var reverseStr string
	fmt.Print("Enter a string to reverse: ")
	fmt.Scan(&reverseStr)
	reversed := String_manpltn.Reverse(reverseStr)
	fmt.Print("The reversed string is " , reversed)
}