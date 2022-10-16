package qimen

import (
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

type Pan struct {
	gongs []Gong
}

func (pan *Pan) Display() {
	i := 1
	for _, gong := range pan.gongs {
		println(gong.Gua.GetName(), i, "宫：", gong.SanQiLiuYi.GetName())
		i = (i + 1) % 9
		if i == 0 {
			i = 9
		}
	}
}

func NewPan(jq JieQi, riGan tiangan.TianGan, riZhi dizhi.DiZhi) Pan {
	pan := Pan{
		gongs: make([]Gong, 0, 9),
	}
	isYang, ju := GetJu(jq, riGan, riZhi)
	if isYang {
		for i := 0; i < 9; i++ {
			pan.gongs = append(pan.gongs, Gong{Gua: BaGua{
				Id: uint8(i),
			}, SanQiLiuYi: tiangan.TianGan{Id: 0}})
		}
		pan.gongs[(ju+9-1)%9].SanQiLiuYi.Id = tiangan.Wu
		pan.gongs[(ju+9-1+1)%9].SanQiLiuYi.Id = tiangan.Ji
		pan.gongs[(ju+9-1+2)%9].SanQiLiuYi.Id = tiangan.Geng
		pan.gongs[(ju+9-1+3)%9].SanQiLiuYi.Id = tiangan.Xin
		pan.gongs[(ju+9-1+4)%9].SanQiLiuYi.Id = tiangan.Ren
		pan.gongs[(ju+9-1+5)%9].SanQiLiuYi.Id = tiangan.Gui
		pan.gongs[(ju+9-1+6)%9].SanQiLiuYi.Id = tiangan.Ding
		pan.gongs[(ju+9-1+7)%9].SanQiLiuYi.Id = tiangan.Bing
		pan.gongs[(ju+9-1+8)%9].SanQiLiuYi.Id = tiangan.Yi
	}
	return pan
}

type Gong struct {
	Gua        BaGua
	SanQiLiuYi tiangan.TianGan
}

// bool: true - 阳遁，false - 阴遁
// ju: 第几局

func GetJu(jq JieQi, rigan tiangan.TianGan, riZhi dizhi.DiZhi) (bool, uint8) {
	sanYuan := GetSanYuan(rigan, riZhi)
	isYang, jus := jq.GetJu()
	ju := jus[sanYuan]
	if isYang {
		println("阳遁", ju, "局")
	} else {
		println("阴遁", ju, "局")
	}
	return isYang, ju
}
