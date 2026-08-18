package main
import "fmt"

func main(){
	fmt.Print("----Welcome to the Amazing Calculator ;)----\n")
    // JMD dd JMD dd JMD dd Bolo Jai Mata Di
	var optn int
	for{
		fmt.Println("Press 1 to perfrom inetger operations")
		fmt.Println("Press 2 to perfrom float operations")
		fmt.Println("Press 3 to EXIT")
		fmt.Print("Enter your input: ")
		fmt.Scan(&optn)

		if optn == 1{
			var num1 int
			var num2 int
			fmt.Print("Enter first number: ")
			fmt.Scan(&num1)
			fmt.Print("Enter second number: ")
			fmt.Scan(&num2)
			fmt.Printf("ADDITION: %d\n", num1+num2)
			fmt.Printf("SUBTRACTION: %d\n", num1-num2)
			fmt.Printf("MULTIPLICATION: %d\n", num1*num2)
		} else if optn == 2{
			var float1 float32
			var float2 float32
			fmt.Print("Enter first number: ")
			fmt.Scan(&float1)
			fmt.Print("Enter second number: ")
			fmt.Scan(&float2)
			fmt.Printf("ADDITION: %f\n", float1+float2)
			fmt.Printf("SUBTRACTION: %f\n", float1-float2)
			fmt.Printf("MULTIPLICATION: %f\n", float1*float2)
		}else if optn == 3{
			fmt.Println("Sayonara! Have an Amazing Day :D")
			break
		}else{
			fmt.Println("Invalid Input! Please try again :(")
		}
	}
}