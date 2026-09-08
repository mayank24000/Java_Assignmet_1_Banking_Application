package Int_manpltn

func Power(bs, exp int) int {
	if exp == 0{
		return 1
	}
	return bs * Power(bs, exp-1)
}