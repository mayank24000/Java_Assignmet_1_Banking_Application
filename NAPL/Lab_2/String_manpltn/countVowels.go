package String_manpltn

func CountVowel(s string) int{
  count := 0

  for i := 0; i<len(s); i++{
	if s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u'{
		count ++
	}
}
return count
}