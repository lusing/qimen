package meihuayishu

import "qimen/src/qimen/dizhi"

type Yao struct {
	Value bool
	NaZhi dizhi.DiZhi
}

type GuaYao struct {
	Yaos [6]Yao
}

func (gua *FullGua) PaiPan() {
	guaValue := gua.BenGua.Value

	var yao6 GuaYao

	mask := uint8(1)
	for i := 0; i < 6; i++ {
		yao6.Yaos[i].Value = guaValue&mask != 0
		mask <<= 1
	}

	xiaGua := gua.BenGua.GetLow()
	shangGua := gua.BenGua.GetHigh()

	switch xiaGua.Value {
	case 0b000: // 坤 未巳卯
		yao6.Yaos[0].NaZhi.Id = dizhi.Wei
		yao6.Yaos[1].NaZhi.Id = dizhi.Si
		yao6.Yaos[2].NaZhi.Id = dizhi.Mao
	case 0b001, 0b111: // 震 子寅辰
		yao6.Yaos[0].NaZhi.Id = dizhi.Zi
		yao6.Yaos[1].NaZhi.Id = dizhi.Yin
		yao6.Yaos[2].NaZhi.Id = dizhi.Chen
	case 0b010: // 坎 寅辰午
		yao6.Yaos[0].NaZhi.Id = dizhi.Yin
		yao6.Yaos[1].NaZhi.Id = dizhi.Chen
		yao6.Yaos[2].NaZhi.Id = dizhi.Wu
	case 0b011: // 兑 巳卯丑
		yao6.Yaos[0].NaZhi.Id = dizhi.Si
		yao6.Yaos[1].NaZhi.Id = dizhi.Mao
		yao6.Yaos[2].NaZhi.Id = dizhi.Chou
	case 0b100: // 艮 辰午申
		yao6.Yaos[0].NaZhi.Id = dizhi.Chen
		yao6.Yaos[1].NaZhi.Id = dizhi.Wu
		yao6.Yaos[2].NaZhi.Id = dizhi.Shen
	case 0b101: // 离 卯丑亥
		yao6.Yaos[0].NaZhi.Id = dizhi.Mao
		yao6.Yaos[1].NaZhi.Id = dizhi.Chou
		yao6.Yaos[2].NaZhi.Id = dizhi.Hai
	case 0b110: // 巽 丑亥酉
		yao6.Yaos[0].NaZhi.Id = dizhi.Chou
		yao6.Yaos[1].NaZhi.Id = dizhi.Hai
		yao6.Yaos[2].NaZhi.Id = dizhi.You
	}

	switch shangGua.Value {
	case 0b000: // 坤 丑亥酉
		yao6.Yaos[3].NaZhi.Id = dizhi.Chou
		yao6.Yaos[4].NaZhi.Id = dizhi.Hai
		yao6.Yaos[5].NaZhi.Id = dizhi.You
	case 0b001, 0b111: // 震 午申戌
		yao6.Yaos[3].NaZhi.Id = dizhi.Wu
		yao6.Yaos[4].NaZhi.Id = dizhi.Shen
		yao6.Yaos[5].NaZhi.Id = dizhi.Xu
	case 0b010: // 坎 申戌子
		yao6.Yaos[3].NaZhi.Id = dizhi.Shen
		yao6.Yaos[4].NaZhi.Id = dizhi.Xu
		yao6.Yaos[5].NaZhi.Id = dizhi.Zi
	case 0b011: // 兑 亥酉未
		yao6.Yaos[3].NaZhi.Id = dizhi.Hai
		yao6.Yaos[4].NaZhi.Id = dizhi.You
		yao6.Yaos[5].NaZhi.Id = dizhi.Wei
	case 0b100: // 艮 戌子寅
		yao6.Yaos[3].NaZhi.Id = dizhi.Xu
		yao6.Yaos[4].NaZhi.Id = dizhi.Zi
		yao6.Yaos[5].NaZhi.Id = dizhi.Yin
	case 0b101: // 离 酉未巳
		yao6.Yaos[3].NaZhi.Id = dizhi.You
		yao6.Yaos[4].NaZhi.Id = dizhi.Wei
		yao6.Yaos[5].NaZhi.Id = dizhi.Si
	case 0b110: // 巽 未巳卯
		yao6.Yaos[3].NaZhi.Id = dizhi.Wei
		yao6.Yaos[4].NaZhi.Id = dizhi.Si
		yao6.Yaos[5].NaZhi.Id = dizhi.Mao
	}

	for i := 5; i >= 0; i-- {
		if yao6.Yaos[i].Value {
			print("-")
		} else {
			print("=")
		}
		print(yao6.Yaos[i].NaZhi.GetName())
		xing := yao6.Yaos[i].NaZhi.GetXing()
		print(xing.GetName())
		println()
	}
}
