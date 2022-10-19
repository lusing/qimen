package qimen

import (
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

type GanZhi struct {
	TianGanId uint8
	DiZhiId   uint8
}

func (pgz *GanZhi) GetName() string {
	gan := tiangan.TianGan{Id: pgz.TianGanId}
	zhi := dizhi.DiZhi{Id: pgz.DiZhiId}
	return gan.GetName() + zhi.GetName()
}

func WuZiYuanDun(riGan tiangan.TianGan, shiZhi dizhi.DiZhi) tiangan.TianGan {
	diff := shiZhi.Id + 10
	switch riGan.Id {
	case tiangan.Jia, tiangan.Ji:
		return tiangan.TianGan{Id: (tiangan.Jia + diff) % 10}
	case tiangan.Yi, tiangan.Geng:
		return tiangan.TianGan{Id: (tiangan.Bing + diff) % 10}
	case tiangan.Bing, tiangan.Xin:
		return tiangan.TianGan{Id: (tiangan.Wu + diff) % 10}
	case tiangan.Ding, tiangan.Ren:
		return tiangan.TianGan{Id: (tiangan.Geng + diff) % 10}
	case tiangan.Wu, tiangan.Gui:
		return tiangan.TianGan{Id: (tiangan.Ren + diff) % 10}
	}
	return tiangan.TianGan{Id: 0}
}

func GetSanYuan(riGan tiangan.TianGan, riZhi dizhi.DiZhi) uint8 {
	var futou uint8
	var futouGan uint8
	futouZhi := riZhi.Id
	if riGan.Id < tiangan.Ji {
		futouGan = tiangan.Jia
		futou = riGan.Id - tiangan.Jia
		futouZhi = (futouZhi + 12 - futou) % 12
		gz1 := GanZhi{TianGanId: futouGan, DiZhiId: futouZhi}
		println(gz1.GetName())
	} else {
		futouGan = tiangan.Ji
		futou = riGan.Id - tiangan.Ji
		futouZhi = (futouZhi + 12 - futou) % 12
		gz1 := GanZhi{TianGanId: futouGan, DiZhiId: futouZhi}
		println(gz1.GetName())
	}
	switch futouZhi {
	case dizhi.Zi, dizhi.Wu, dizhi.Mao, dizhi.You:
		return 0
	case dizhi.Yin, dizhi.Shen, dizhi.Si, dizhi.Hai:
		return 1
	default:
		return 2
	}
}
