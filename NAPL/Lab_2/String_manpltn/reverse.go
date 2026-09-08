package String_manpltn

func Reverse(s string) string {
	var r string
	for i := len(s) - 1; i >= 0; i-- {
		r += string(s[i])
	}
	return r
}