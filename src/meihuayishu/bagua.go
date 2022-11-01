package meihuayishu

import "qimen/src/qimen"

type FullGua struct {
	BenGua  Gua64
	HuGua   Gua64
	BianGua Gua64
}

type Gua64 struct {
	Value uint8
}

func BuildGua(highGua Gua8, lowGua Gua8) *Gua64 {
	return &Gua64{Value: highGua.Value<<3 + lowGua.Value}
}

func getHighGua(gua Gua64) Gua8 {
	return Gua8{Value: gua.Value & 070}
}

func getLowGua(gua Gua64) Gua8 {
	return Gua8{Value: gua.Value & 007}
}

type Gua8 struct {
	Value uint8
}

func (pbg *Gua8) GetXing() qimen.Xing {
	switch pbg.Value % 8 {
	case 00: // 坤 土
		return qimen.Xing{Id: qimen.TU}
	case 01: // 震 木
		return qimen.Xing{Id: qimen.MU}
	case 02: // 坎 水
		return qimen.Xing{Id: qimen.SHUI}
	case 03: // 兑 金
		return qimen.Xing{Id: qimen.JIN}
	case 04: //	艮 土
		return qimen.Xing{Id: qimen.TU}
	case 05: // 离 火
		return qimen.Xing{Id: qimen.HUO}
	case 06: //	巽 木
		return qimen.Xing{Id: qimen.MU}
	case 07: // 乾 金
		return qimen.Xing{Id: qimen.JIN}
	}
	return qimen.Xing{Id: qimen.MU}
}

func (pbg *Gua8) sheng(shengee Gua8) bool {
	sheng1 := pbg.GetXing()
	sheng2 := shengee.GetXing()
	result := sheng1.Sheng(sheng2)
	if result {
		println(pbg.GetName(), "生", shengee.GetName())
	}
	return result
}

func (pbg *Gua8) ke(kee Gua8) bool {
	ke1 := pbg.GetXing()
	ke2 := kee.GetXing()
	result := ke1.Ke(ke2)
	if result {
		println(pbg.GetName(), "克", kee.GetName())
	}
	return result
}

func (pbg *Gua8) GetName() string {
	switch pbg.Value % 8 {
	case 00:
		return "坤"
	case 01:
		return "震"
	case 02:
		return "坎"
	case 03:
		return "兑"
	case 04:
		return "艮"
	case 05:
		return "离"
	case 06:
		return "巽"
	case 07:
		return "乾"
	}
	return "无极"
}

func NewGuaFromNumber(num int) *Gua8 {
	switch num % 8 {
	case KunGua % 8:
		return &Gua8{Value: 00}
	case QianGua:
		return &Gua8{Value: 07}
	case DuiGua:
		return &Gua8{Value: 03}
	case LiGua:
		return &Gua8{Value: 05}
	case ZhenGua:
		return &Gua8{Value: 01}
	case XunGua:
		return &Gua8{Value: 06}
	case KanGua:
		return &Gua8{Value: 02}
	case GenGua:
		return &Gua8{Value: 04}
	}
	return &Gua8{}
}

type BaGua struct {
	Id uint8
}

const (
	QianGua = 1 // 000 + 1
	DuiGua  = 2 // 001 + 1
	LiGua   = 3 // 010 + 1
	ZhenGua = 4 // 011 + 1
	XunGua  = 5 // 100 + 1
	KanGua  = 6 // 101 + 1
	GenGua  = 7 // 110 + 1
	KunGua  = 8 // 111 + 1
)

func (pbg *BaGua) GetName() string {
	names := []string{"坤", "乾", "兑", "离", "震", "巽", "坎", "艮", "坤"}
	return names[pbg.Id%8]
}
