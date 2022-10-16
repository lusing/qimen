package dizhi

const (
	Zi = iota
	Chou
	Yin
	Mao
	Chen
	Si
	Wu
	Wei
	Shen
	You
	Xu
	Hai
)

type DiZhi struct {
	Id uint8
}

func (pdz *DiZhi) GetName() string {
	names := []string{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"}
	return names[pdz.Id%12]
}
