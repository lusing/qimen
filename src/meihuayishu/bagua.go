package meihuayishu

import (
	"qimen/src/qimen"
)

type FullGua struct {
	BenGua  Gua64
	HuGua   Gua64
	BianGua Gua64
	BianYao int
}

func (gua *FullGua) DuanGua() {
	lowIsTi := gua.BianYao > 3
	var tiGua, tiGua1, tiGua2 BaGua
	var yongGua, yongGua1, yongGua2 BaGua
	if lowIsTi {
		println("下卦为体")
		tiGua = gua.BenGua.GetLow()
		yongGua = gua.BenGua.GetHigh()
		tiGua1 = gua.HuGua.GetLow()
		yongGua1 = gua.HuGua.GetHigh()
		tiGua2 = gua.BianGua.GetLow()
		yongGua2 = gua.BianGua.GetHigh()
	} else {
		println("下卦为用")
		tiGua = gua.BenGua.GetHigh()
		yongGua = gua.BenGua.GetLow()
		tiGua1 = gua.HuGua.GetHigh()
		yongGua1 = gua.HuGua.GetLow()
		tiGua2 = gua.BianGua.GetHigh()
		yongGua2 = gua.BianGua.GetLow()
	}
	println("体卦：", tiGua.GetName())
	println("用卦：", yongGua.GetName())

	print("本卦：")
	JiXiong(yongGua, tiGua)

	print("互卦：")
	JiXiong(yongGua1, tiGua1)

	print("变卦：")
	JiXiong(yongGua2, tiGua2)
}

func JiXiong(yongGua BaGua, tiGua BaGua) {
	if yongGua.Sheng(&tiGua) {
		println("用卦生体卦，大吉")
	} else if tiGua.Sheng(&yongGua) {
		println("用卦生体卦，小凶")
	} else if tiGua.Ke(&yongGua) {
		println("用卦克体卦，大凶")
	} else if yongGua.Ke(&tiGua) {
		println("用卦克体卦，小吉")
	} else {
		println("用卦不生体卦，不克体卦，中平")
	}
}

type Gua64 struct {
	Value uint8
}

func (pbg *Gua64) GetLow() BaGua {
	value := pbg.Value & 0b000111
	//fmt.Printf("%b", value)
	return BaGua{Value: value}
}

func (pbg *Gua64) GetHigh() BaGua {
	value := pbg.Value & 0b111000
	value = value >> 3
	//fmt.Printf("%b", value)
	return BaGua{Value: value}
}

func (p64g *Gua64) GetHuGua() Gua64 {
	var value uint8 = p64g.Value

	var huGua uint8 = 0
	xiaGua := value & 0b001110
	xiaGua = xiaGua >> 1
	shangGua := value & 0b011100
	shangGua = shangGua << 1
	huGua = xiaGua | shangGua

	return Gua64{huGua}
}

func (p64g *Gua64) GetBianGua(bianYao int) Gua64 {
	var value uint8 = p64g.Value
	var value2 uint8 = 1

	if bianYao > 1 {
		value2 = value2 << (bianYao - 1)
	}

	var bianGua uint8 = value ^ value2

	return Gua64{bianGua}
}

func (p64g *Gua64) GetName() string {
	var value uint8 = p64g.Value

	switch value {
	case 0b000000:
		return "坤为地"
	case 0b000001:
		return "地雷复"
	case 0b000010:
		return "地水师"
	case 0b000011:
		return "地泽临"
	case 0b000100:
		return "地山谦"
	case 0b000101:
		return "地火明夷"
	case 0b000110:
		return "地风升"
	case 0b000111:
		return "地天泰"
	case 0b001000:
		return "雷地豫"
	case 0b001001:
		return "震为雷"
	case 0b001010:
		return "雷水解"
	case 0b001011:
		return "雷泽归妹"
	case 0b001100:
		return "雷山小过"
	case 0b001101:
		return "雷火丰"
	case 0b001110:
		return "雷风恒"
	case 0b001111:
		return "雷天大壮"
	case 0b010000:
		return "水地比"
	case 0b010001:
		return "水雷屯"
	case 0b010010:
		return "坎为水"
	case 0b010011:
		return "水泽节"
	case 0b010100:
		return "水山蹇"
	case 0b010101:
		return "水火既济"
	case 0b010110:
		return "水风井"
	case 0b010111:
		return "水天需"
	case 0b011000:
		return "泽地萃"
	case 0b011001:
		return "泽雷随"
	case 0b011010:
		return "泽水困"
	case 0b011011:
		return "兑为泽"
	case 0b011100:
		return "泽山咸"
	case 0b011101:
		return "泽火革"
	case 0b011110:
		return "泽风大过"
	case 0b011111:
		return "泽天夬"
	case 0b100000:
		return "山地剥"
	case 0b100001:
		return "山雷颐"
	case 0b100010:
		return "山水蒙"
	case 0b100011:
		return "山泽损"
	case 0b100100:
		return "艮为山"
	case 0b100101:
		return "山火贲"
	case 0b100110:
		return "山风蛊"
	case 0b100111:
		return "山天大畜"
	case 0b101000:
		return "火地晋"
	case 0b101001:
		return "火雷噬嗑"
	case 0b101010:
		return "火水未济"
	case 0b101011:
		return "火泽睽"
	case 0b101100:
		return "火山旅"
	case 0b101101:
		return "离为火"
	case 0b101110:
		return "火风鼎"
	case 0b101111:
		return "火天大有"
	case 0b110000:
		return "风地观"
	case 0b110001:
		return "风雷益"
	case 0b110010:
		return "风水涣"
	case 0b110011:
		return "风泽中孚"
	case 0b110100:
		return "风山渐"
	case 0b110101:
		return "风火家人"
	case 0b110110:
		return "巽为风"
	case 0b110111:
		return "风天小畜"
	case 0b111000:
		return "天地否"
	case 0b111001:
		return "天雷无妄"
	case 0b111010:
		return "天水讼"
	case 0b111011:
		return "天泽履"
	case 0b111100:
		return "天山遁"
	case 0b111101:
		return "天火同人"
	case 0b111110:
		return "天风姤"
	case 0b111111:
		return "乾为天"
	}

	return "混沌未开"
}

func (pbg *BaGua) GetXing() qimen.Xing {
	switch pbg.Value {
	case 0b000: // 坤 土
		return qimen.Xing{Id: qimen.TU}
	case 0b001: // 震 木
		return qimen.Xing{Id: qimen.MU}
	case 0b010: // 坎 水
		return qimen.Xing{Id: qimen.SHUI}
	case 0b011: // 兑 金
		return qimen.Xing{Id: qimen.JIN}
	case 0b100: // 艮 土
		return qimen.Xing{Id: qimen.TU}
	case 0b101: // 离 火
		return qimen.Xing{Id: qimen.HUO}
	case 0b110: // 巽 木
		return qimen.Xing{Id: qimen.MU}
	case 0b111: // 乾 金
		return qimen.Xing{Id: qimen.JIN}
	}
	return qimen.Xing{Id: qimen.JIN}
}

func (pbg BaGua) Sheng(shengee *BaGua) bool {
	sheng1 := pbg.GetXing()
	sheng2 := shengee.GetXing()
	result := sheng1.Sheng(sheng2)
	if result {
		println(pbg.GetName(), "生", shengee.GetName())
	}
	return result
}

func (pbg *BaGua) Ke(kee *BaGua) bool {
	ke1 := pbg.GetXing()
	ke2 := kee.GetXing()
	result := ke1.Ke(ke2)
	if result {
		println(pbg.GetName(), "克", kee.GetName())
	}
	return result
}

func NewGua64FromNumbers(lowGuaNumber int, highGuaNumber int, bianYao int) *FullGua {
	lowGua := NewGuaFromNumber(lowGuaNumber)
	highGua := NewGuaFromNumber(highGuaNumber)
	result := highGua.Value<<3 + lowGua.Value
	//fmt.Printf("lowGua: %b, highGua: %b, result:%b", lowGua, highGua, result)
	benGua := Gua64{Value: result}
	huGua := benGua.GetHuGua()
	bianGua := benGua.GetBianGua(bianYao)
	return &FullGua{BenGua: benGua, HuGua: huGua, BianGua: bianGua, BianYao: bianYao}
}

func NewGuaFromNumber(num int) *BaGua {
	value := (num - 1) % 8
	var value8 uint8 = uint8(value) & 0b111
	//fmt.Printf("value8:%b\n", value8)
	value8 = (^value8) & 0b111
	//fmt.Printf("value8: %b\n", value8)
	value0 := value8 & 0b001
	value1 := (value8 & 0b010) >> 1
	value2 := (value8 & 0b100) >> 2
	//println(value0, value1, value2)
	result := (value0 << 2) + (value1 << 1) + value2
	//fmt.Printf("result: %b\n", result)
	return &BaGua{Value: result}
}

type BaGua struct {
	Value uint8
}

const (
	QianGua = 0b000
	DuiGua  = 0b001
	LiGua   = 0b010
	ZhenGua = 0b011
	XunGua  = 0b100
	KanGua  = 0b101
	GenGua  = 0b110
	KunGua  = 0b111
)

func (pbg *BaGua) GetName() string {
	//names := []string{"乾", "兑", "离", "震", "巽", "坎", "艮", "坤"}
	names := []string{"坤", "震", "坎", "兑", "艮", "离", "巽", "乾"}
	return names[pbg.Value%8]
}
