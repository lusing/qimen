package meihuayishu

import (
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
	"qimen/src/qimen/wuxing"
)

type Yao struct {
	Value  bool        // true为阳，false为阴
	NaZhi  dizhi.DiZhi // 纳支
	WuXing wuxing.Xing
	LQ     LiuQin // 六亲
	IsShi  bool   // 世爻
	IsYing bool   // 应爻
	LS     LiuShen
}

type GuaYao struct {
	Yaos     [6]Yao
	GuanGong BaGua
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

	// 寻世问宫
	for i := 0; i < 6; i++ {
		yao6.Yaos[i].IsShi = false
		yao6.Yaos[i].IsYing = false
	}

	var gong BaGua

	if yao6.Yaos[2].Value == yao6.Yaos[5].Value &&
		yao6.Yaos[1].Value != yao6.Yaos[4].Value &&
		yao6.Yaos[0].Value != yao6.Yaos[3].Value {
		// 天同二世
		yao6.Yaos[1].IsShi = true
		yao6.Yaos[4].IsYing = true
		gong = shangGua
		//println("天同二世")
	} else if yao6.Yaos[2].Value != yao6.Yaos[5].Value &&
		yao6.Yaos[1].Value == yao6.Yaos[4].Value &&
		yao6.Yaos[0].Value == yao6.Yaos[3].Value {
		yao6.Yaos[4].IsShi = true
		yao6.Yaos[1].IsYing = true
		println("天变五")
	} else if yao6.Yaos[0].Value == yao6.Yaos[3].Value &&
		yao6.Yaos[1].Value != yao6.Yaos[4].Value &&
		yao6.Yaos[2].Value != yao6.Yaos[5].Value {
		yao6.Yaos[3].IsShi = true
		yao6.Yaos[0].IsYing = true
		gong = xiaGua.GetFan()
		println("地同四世")
	} else if yao6.Yaos[0].Value != yao6.Yaos[3].Value &&
		yao6.Yaos[1].Value == yao6.Yaos[4].Value &&
		yao6.Yaos[2].Value == yao6.Yaos[5].Value {
		yao6.Yaos[0].IsShi = true
		yao6.Yaos[3].IsYing = true
		gong = shangGua
		println("地变初，一世")
	} else if yao6.Yaos[1].Value == yao6.Yaos[4].Value &&
		yao6.Yaos[0].Value != yao6.Yaos[3].Value &&
		yao6.Yaos[2].Value != yao6.Yaos[5].Value {
		yao6.Yaos[3].IsShi = true
		yao6.Yaos[0].IsYing = true
		gong = xiaGua.GetFan()
		println("人同游魂")
	} else if yao6.Yaos[1].Value != yao6.Yaos[4].Value &&
		yao6.Yaos[0].Value == yao6.Yaos[3].Value &&
		yao6.Yaos[2].Value == yao6.Yaos[5].Value {
		yao6.Yaos[2].IsShi = true
		yao6.Yaos[5].IsYing = true
		gong = xiaGua
		println("人变归魂")
	}

	// 宫主
	if xiaGua.Value == shangGua.Value {
		yao6.Yaos[0].IsShi = true
		yao6.Yaos[3].IsYing = true
		gong = shangGua
	}

	for i := 0; i < 6; i++ {
		gongWuXing := gong.GetXing()
		zhiWuXing := yao6.Yaos[i].NaZhi.GetXing()
		if yao6.Yaos[i].NaZhi.GetXing().Id == gongWuXing.Id {
			yao6.Yaos[i].LQ.Id = XIONGDI
		} else if zhiWuXing.Sheng(gongWuXing) {
			yao6.Yaos[i].LQ.Id = FUMU
		} else if zhiWuXing.Ke(gongWuXing) {
			yao6.Yaos[i].LQ.Id = GUANGUI
		} else if gongWuXing.Sheng(zhiWuXing) {
			yao6.Yaos[i].LQ.Id = ZISUN
		} else if gongWuXing.Ke(zhiWuXing) {
			yao6.Yaos[i].LQ.Id = QICAI
		}
	}

	for i := 0; i < 6; i++ {
		switch gua.RiGan.Id {
		case tiangan.Jia, tiangan.Yi:
			yao6.Yaos[i].LS.Id = (QINGLONG + i) % 6
		case tiangan.Bing, tiangan.Ding:
			yao6.Yaos[i].LS.Id = (ZHUQUE + i) % 6
		case tiangan.Wu:
			yao6.Yaos[i].LS.Id = (GOUCHEN + i) % 6
		case tiangan.Ji:
			yao6.Yaos[i].LS.Id = (TENGSHE + i) % 6
		case tiangan.Geng, tiangan.Xin:
			yao6.Yaos[i].LS.Id = (BAIHU + i) % 6
		case tiangan.Ren, tiangan.Gui:
			yao6.Yaos[i].LS.Id = (XUANWU + i) % 6
		}
	}

	println("宫:", gong.GetName())

	for i := 5; i >= 0; i-- {
		print(yao6.Yaos[i].LS.GetName(), " ")
		if yao6.Yaos[i].Value {
			print("- ")
		} else {
			print("= ")
		}
		print(yao6.Yaos[i].LQ.GetName())
		print(yao6.Yaos[i].NaZhi.GetName())
		xing := yao6.Yaos[i].NaZhi.GetXing()
		print(xing.GetName())
		if yao6.Yaos[i].IsShi {
			print(" 世")
		} else if yao6.Yaos[i].IsYing {
			print(" 应")
		}
		println()
	}
}
