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
	switch riGan.Id {
	case tiangan.Jia, tiangan.Ji:
		return tiangan.TianGan{Id: tiangan.Jia}
	case tiangan.Yi, tiangan.Geng:
		return tiangan.TianGan{Id: tiangan.Bing}
	case tiangan.Bing, tiangan.Xin:
		return tiangan.TianGan{Id: tiangan.Wu}
	case tiangan.Ding, tiangan.Ren:
		return tiangan.TianGan{Id: tiangan.Geng}
	case tiangan.Wu, tiangan.Gui:
		return tiangan.TianGan{Id: tiangan.Ren}
	}
	return tiangan.TianGan{Id: 0}
}

func GetSanYuan(riGan tiangan.TianGan, riZhi dizhi.DiZhi) uint8 {
	var futou uint8
	var futou_gan uint8
	futou_zhi := riZhi.Id
	if riGan.Id < tiangan.Ji {
		futou_gan = tiangan.Jia
		futou = riGan.Id - tiangan.Jia
		futou_zhi = (futou_zhi + 12 - futou) % 12
		gz1 := GanZhi{TianGanId: futou_gan, DiZhiId: futou_zhi}
		println(gz1.GetName())
	} else {
		futou_gan = tiangan.Ji
		futou = riGan.Id - tiangan.Ji
		futou_zhi = (futou_zhi + 12 - futou) % 12
		gz1 := GanZhi{TianGanId: futou_gan, DiZhiId: futou_zhi}
		println(gz1.GetName())
	}
	switch futou_zhi {
	case dizhi.Zi, dizhi.Wu, dizhi.Mao, dizhi.You:
		return 0
	case dizhi.Yin, dizhi.Shen, dizhi.Si, dizhi.Hai:
		return 1
	default:
		return 2
	}
}
