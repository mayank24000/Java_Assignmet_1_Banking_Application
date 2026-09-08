package main
import "fmt"
// import "slices"

/* func main(){
// 1 SLICES
	 students := []string{}

    for i := 0; i < 4; i++ {
        var name string
        fmt.Printf("Enter student %d name: ", i+1)
        fmt.Scan(&name)
        students = append(students, name)
    }

    fmt.Println("Students:", students)

	//Add

	students = append(students, "Rakesh")
	fmt.Println("Student Names After adding Rakesh: ", students)
	
	//Update
	
	students[3] = "Vishesh"
	fmt.Println("After Update Vishesh: ", students)	

	// Delete
	students = slices.Delete(students, 2, 3)
	fmt.Println("After Delete: ", students)
	} */

	func main(){
// 2 MAPS
	marks := map[string]int{}
	marks["Maths"] = 73
	marks["Science"] = 68
	marks["English"] = 88
	marks["Hindi"] = 95
	marks["Sanskrit"] = 52
	fmt.Println("Marks of subject: ", marks)

	// Insert
	var k string
	var v int
	fmt.Print("Enter a Subject to add: ")
	fmt.Scan(&k)
	fmt.Print("Enter the Marks for it: ")
	fmt.Scan(&v)
		marks[k] = v
		fmt.Println("After Insert: ", marks)

	//Delete
		(delete(marks, "Maths"))
		fmt.Println("After Deleting Maths: ", marks)

	//Lookup
	var a string
	fmt.Print("Enter the key to lookup: ")
	fmt.Scan(&a)
	v, status := marks[a]
	fmt.Print(v, status)

		// for k, v := range marks{
		// 	fmt.Println(k, v)
			
		// }
}