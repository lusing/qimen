package meihuayishu

type Gua64 struct {
	Value uint8
}

type Gua8 struct {
	Value uint8
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
	QianGua = 1
	DuiGua  = 2
	LiGua   = 3
	ZhenGua = 4
	XunGua  = 5
	KanGua  = 6
	GenGua  = 7
	KunGua  = 8
)

func (pbg *BaGua) GetName() string {
	names := []string{"坤", "乾", "兑", "离", "震", "巽", "坎", "艮", "坤"}
	return names[pbg.Id%8]
}