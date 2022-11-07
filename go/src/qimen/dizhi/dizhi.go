package dizhi

import (
	"qimen/src/qimen/wuxing"
)

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

func (pdz *DiZhi) GetXing() wuxing.Xing {
	switch pdz.Id {
	case Zi, Hai:
		return wuxing.Xing{Id: wuxing.SHUI}
	case Yin, Mao:
		return wuxing.Xing{Id: wuxing.MU}
	case Chen, Xu, Chou, Wei:
		return wuxing.Xing{Id: wuxing.TU}
	case Si, Wu:
		return wuxing.Xing{Id: wuxing.HUO}
	case Shen, You:
		return wuxing.Xing{Id: wuxing.JIN}
	}
	return wuxing.Xing{Id: wuxing.MU}
}
