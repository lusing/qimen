package qimen

import (
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

type Pan struct {
	gongs []Gong
	grid  [3][3]Cell
}

func (pan *Pan) GetZhiFuXing(xunshou tiangan.TianGan) (x int, y int) {
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			if pan.grid[i][j].SanQiLiuYi.Id == xunshou.Id {
				println("值符位置：", pan.grid[i][j].SanQiLiuYi.GetName(), "在", i, ",", j)
				println(pan.grid[i][j].DiPanJiuXing.GetName())
				return i, j
			}
		}
	}
	return 1, 1
}

// 根据三奇六仪名查找在九宫格中的位置

func (pan *Pan) GetPosByTianGan(shigan tiangan.TianGan) (x int, y int) {
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			if pan.grid[i][j].SanQiLiuYi.Id == shigan.Id {
				println("找到的天干：", pan.grid[i][j].SanQiLiuYi.GetName(), "在", i, ",", j)
				//println(pan.grid[i][j].DiPanJiuXing.GetName())
				return i, j
			}
		}
	}
	return 1, 1
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

	println("------------------------------------")
	for _, row := range pan.grid {
		for _, cell := range row {
			print(cell.Shen.GetName(), "|")
		}
		println()
		for _, cell := range row {
			print(cell.TianMen.GetName(), "|")
		}
		println()
		for _, cell := range row {
			print(cell.TianPanQiYi.GetName(), "|")
		}
		println()
		for _, cell := range row {
			print(cell.SanQiLiuYi.GetName(), "|")
			//print(cell.Gua.GetName())
		}
		println()
		//for _, cell := range row {
		//	print(cell.Gua.GetName(), "|")
		//}
		//println()
		//for _, cell := range row {
		//	print(cell.DiPanJiuXing.GetName(), "|")
		//}
		//println()
		for _, cell := range row {
			print(cell.TianPanJiuXing.GetName(), "|")
		}
		println()

		println("------------------------------------")
	}
}

func NewPan(jq JieQi, riGan tiangan.TianGan, riZhi dizhi.DiZhi, shiZhi dizhi.DiZhi) Pan {
	pan := Pan{
		gongs: make([]Gong, 0, 9),
	}
	for i := 0; i < 9; i++ {
		pan.gongs = append(pan.gongs, Gong{Gua: BaGua{
			Id: uint8(i),
		}, SanQiLiuYi: tiangan.TianGan{Id: 0}})
	}
	isYang, ju := GetJu(jq, riGan, riZhi)
	// 阳遁顺布六仪，逆布三奇
	if isYang {
		pan.gongs[(ju+9-1)%9].SanQiLiuYi.Id = tiangan.Wu
		pan.gongs[(ju+9-1+1)%9].SanQiLiuYi.Id = tiangan.Ji
		pan.gongs[(ju+9-1+2)%9].SanQiLiuYi.Id = tiangan.Geng
		pan.gongs[(ju+9-1+3)%9].SanQiLiuYi.Id = tiangan.Xin
		pan.gongs[(ju+9-1+4)%9].SanQiLiuYi.Id = tiangan.Ren
		pan.gongs[(ju+9-1+5)%9].SanQiLiuYi.Id = tiangan.Gui
		pan.gongs[(ju+9-1+6)%9].SanQiLiuYi.Id = tiangan.Ding
		pan.gongs[(ju+9-1+7)%9].SanQiLiuYi.Id = tiangan.Bing
		pan.gongs[(ju+9-1+8)%9].SanQiLiuYi.Id = tiangan.Yi
	} else {
		//阴遁逆布六仪，顺布三奇
		pan.gongs[(ju+18-1)%9].SanQiLiuYi.Id = tiangan.Wu
		pan.gongs[(ju+18-1-1)%9].SanQiLiuYi.Id = tiangan.Ji
		pan.gongs[(ju+18-1-2)%9].SanQiLiuYi.Id = tiangan.Geng
		pan.gongs[(ju+18-1-3)%9].SanQiLiuYi.Id = tiangan.Xin
		pan.gongs[(ju+18-1-4)%9].SanQiLiuYi.Id = tiangan.Ren
		pan.gongs[(ju+18-1-5)%9].SanQiLiuYi.Id = tiangan.Gui
		pan.gongs[(ju+18-1-6)%9].SanQiLiuYi.Id = tiangan.Ding
		pan.gongs[(ju+18-1-7)%9].SanQiLiuYi.Id = tiangan.Bing
		pan.gongs[(ju+18-1-8)%9].SanQiLiuYi.Id = tiangan.Yi
	}

	// 洛书九宫映射
	pan.grid[2][1] = Cell{SanQiLiuYi: pan.gongs[0].SanQiLiuYi, Gua: pan.gongs[0].Gua}
	pan.grid[0][2] = Cell{SanQiLiuYi: pan.gongs[1].SanQiLiuYi, Gua: pan.gongs[1].Gua}
	pan.grid[1][0] = Cell{SanQiLiuYi: pan.gongs[2].SanQiLiuYi, Gua: pan.gongs[2].Gua}
	pan.grid[0][0] = Cell{SanQiLiuYi: pan.gongs[3].SanQiLiuYi, Gua: pan.gongs[3].Gua}
	pan.grid[1][1] = Cell{SanQiLiuYi: pan.gongs[4].SanQiLiuYi, Gua: pan.gongs[4].Gua} // 中宫
	pan.grid[2][2] = Cell{SanQiLiuYi: pan.gongs[5].SanQiLiuYi, Gua: pan.gongs[5].Gua}
	pan.grid[1][2] = Cell{SanQiLiuYi: pan.gongs[6].SanQiLiuYi, Gua: pan.gongs[6].Gua}
	pan.grid[2][0] = Cell{SanQiLiuYi: pan.gongs[7].SanQiLiuYi, Gua: pan.gongs[7].Gua}
	pan.grid[0][1] = Cell{SanQiLiuYi: pan.gongs[8].SanQiLiuYi, Gua: pan.gongs[8].Gua}

	pos1, pos2 := 2, 1

	// 地盘九星八门初始值

	for i := 0; i < 8; i++ {
		pan.grid[pos1][pos2].DiPanJiuXing = JiuXing{Id: uint8(i)}
		pan.grid[pos1][pos2].DiMen = BaMen{Id: uint8(i)}
		//if isYang {
		pos1, pos2 = GetNext(pos1, pos2)
		//} else {
		//	pos1, pos2 = GetPrev(pos1, pos2)
		//}
		//println(i)
	}
	pan.grid[1][1].DiPanJiuXing = JiuXing{Id: 8}

	shigan := WuZiYuanDun(riGan, shiZhi)
	xunshou, xunshouZhi := GetXunShou(shiZhi, riGan)
	println("旬首:", xunshou.GetName())
	pos1, pos2 = pan.GetZhiFuXing(xunshou)
	zhiFuXing := pan.grid[pos1][pos2].DiPanJiuXing
	println("值符星：", pan.grid[pos1][pos2].DiPanJiuXing.GetName())

	if pos1 == 1 && pos2 == 1 {
		println("值符星在中宫")
		// 中五宫寄在坤二宫
		pos1 = 0
		pos2 = 2
	}

	// 值符随时干

	// 时干在地盘几宫

	println("时干：", shigan.GetName())

	var posX, posY int

	// 如果时干是甲，按照遁甲的原则，查到时干支对应的天干，再查天干在地盘几宫
	if shigan.Id == tiangan.Jia {
		dungan := GetDunTianGan(shigan, shiZhi)
		println("遁甲：", dungan.GetName())
		posX, posY = pan.GetPosByTianGan(dungan)
	} else {
		posX, posY = pan.GetPosByTianGan(shigan)
	}

	// 值符原来在地盘几宫，已经在前面 GetZhiFuXing 计算了

	posX0, posY0 := pos1, pos2
	posX1, posY1 := posX, posY

	for i := 0; i < 8; i++ {
		pan.grid[posX][posY].TianPanJiuXing = JiuXing{Id: ((zhiFuXing.Id) + uint8(i)) % 8}
		pan.grid[posX][posY].TianPanQiYi = pan.grid[posX0][posY0].SanQiLiuYi

		posX, posY = GetNext(posX, posY)
		posX0, posY0 = GetNext(posX0, posY0)

		// 神盘分阴阳遁

		if isYang {
			pan.grid[posX][posY].Shen = BaShen{Id: uint8(i)}
		} else {
			pan.grid[posX1][posY1].Shen = BaShen{Id: uint8(i)}
			posX1, posY1 = GetPrev(posX1, posY1)
		}

	}
	pan.grid[1][1].TianPanJiuXing = JiuXing{Id: TianQin}
	pan.grid[1][1].TianPanQiYi = pan.grid[1][1].SanQiLiuYi

	// 值使随时宫
	println("值使：", pan.grid[pos1][pos2].DiMen.GetName())
	zhiShi := pan.grid[pos1][pos2].DiMen.Id
	println("值使支为：", xunshouZhi.GetName(), "而时支为：", shiZhi.GetName())
	stepMen := (int(shiZhi.Id) - int(xunshouZhi.Id) + 12) % 12
	println("需要走", stepMen, "步")

	// 查找旬首的位置，需要从旬首开始走stepMen步
	posM1, posM2 := pan.GetPosByTianGan(xunshou)
	if posM1 == 1 && posM2 == 1 {
		println("旬首在中宫")
		//posM1 = 0
		//posM2 = 2
	}
	for i := 1; i < stepMen; i++ {
		if isYang {
			posM1, posM2 = Fly(posM1, posM2)
		} else {
			posM1, posM2 = FlyBack(posM1, posM2)
		}

		println("Step：", i, ":", posM1, ",", posM2)
	}
	println("值使门起始位置在：", posM1, ",", posM2)

	for i := 0; i < 8; i++ {
		pan.grid[posM1][posM2].TianMen = BaMen{Id: uint8(zhiShi+uint8(i)) % 8}
		//if isYang {
		posM1, posM2 = GetNext(posM1, posM2)
		//} else {
		//	posM1, posM2 = GetPrev(posM1, posM2)
		//}
	}

	return pan
}

type Cell struct {
	SanQiLiuYi     tiangan.TianGan
	TianPanQiYi    tiangan.TianGan
	DiPanJiuXing   JiuXing
	TianPanJiuXing JiuXing
	DiMen          BaMen
	TianMen        BaMen
	Shen           BaShen
	Gua            BaGua
}

func GetNext(row int, column int) (i int, j int) {
	if row == 0 && column == 0 {
		return 0, 1
	}
	if row == 0 && column == 1 {
		return 0, 2
	}
	if row == 0 && column == 2 {
		return 1, 2
	}
	if row == 1 && column == 2 {
		return 2, 2
	}
	if row == 2 && column == 2 {
		return 2, 1
	}
	if row == 2 && column == 1 {
		return 2, 0
	}
	if row == 2 && column == 0 {
		return 1, 0
	}
	if row == 1 && column == 0 {
		return 0, 0
	}
	if row == 1 && column == 1 {
		return 1, 1
	}
	return 1, 1
}

func GetPrev(row int, column int) (i int, j int) {
	if row == 0 && column == 0 {
		return 1, 0
	}
	if row == 1 && column == 0 {
		return 2, 0
	}
	if row == 2 && column == 0 {
		return 2, 1
	}
	if row == 2 && column == 1 {
		return 2, 2
	}
	if row == 2 && column == 2 {
		return 1, 2
	}
	if row == 1 && column == 2 {
		return 0, 2
	}
	if row == 0 && column == 2 {
		return 0, 1
	}
	if row == 0 && column == 1 {
		return 0, 0
	}
	if row == 1 && column == 1 {
		return 1, 1
	}
	return 1, 1
}

func Fly(row int, column int) (i int, j int) {
	if row == 2 && column == 1 {
		return 0, 2
	}
	if row == 0 && column == 2 {
		return 1, 0
	}
	if row == 1 && column == 0 {
		return 0, 0
	}
	if row == 0 && column == 0 {
		return 1, 1
	}
	if row == 1 && column == 1 {
		return 2, 2
	}
	if row == 2 && column == 2 {
		return 1, 2
	}
	if row == 1 && column == 2 {
		return 0, 1
	}
	if row == 0 && column == 1 {
		return 2, 1
	}
	return 2, 1
}

// 从离九宫跳回坎一宫

func FlyBack(row int, column int) (i int, j int) {
	if row == 0 && column == 1 {
		return 2, 0
	}
	if row == 2 && column == 0 {
		return 1, 2
	}
	if row == 1 && column == 2 {
		return 2, 2
	}
	if row == 2 && column == 2 {
		return 1, 1
	}
	if row == 1 && column == 1 {
		return 0, 0
	}
	if row == 0 && column == 0 {
		return 1, 0
	}
	if row == 1 && column == 0 {
		return 0, 2
	}
	if row == 0 && column == 2 {
		return 2, 1
	}
	if row == 2 && column == 1 {
		return 0, 1
	}

	return 0, 1
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

// 求旬首

func GetXunShou(shiZhi dizhi.DiZhi, riGan tiangan.TianGan) (tiangan.TianGan, dizhi.DiZhi) {
	shiGan := WuZiYuanDun(riGan, shiZhi)
	println("时干支:", shiGan.GetName(), shiZhi.GetName())
	diff := shiGan.Id - tiangan.Jia
	xunshouZhi := dizhi.DiZhi{Id: (shiZhi.Id - diff + 12) % 12}
	switch xunshouZhi.Id {
	case dizhi.Zi:
		return tiangan.TianGan{Id: tiangan.Wu}, xunshouZhi
	case dizhi.Xu:
		return tiangan.TianGan{Id: tiangan.Ji}, xunshouZhi
	case dizhi.Shen:
		return tiangan.TianGan{Id: tiangan.Geng}, xunshouZhi
	case dizhi.Wu:
		return tiangan.TianGan{Id: tiangan.Xin}, xunshouZhi
	case dizhi.Chen:
		return tiangan.TianGan{Id: tiangan.Ren}, xunshouZhi
	case dizhi.Yin:
		return tiangan.TianGan{Id: tiangan.Gui}, xunshouZhi
	}
	return tiangan.TianGan{Id: 0}, xunshouZhi
}

// 求六甲的遁干，如果不是六甲，返回原时干

func GetDunTianGan(shiGan tiangan.TianGan, riZhi dizhi.DiZhi) tiangan.TianGan {
	if shiGan.Id != tiangan.Jia {
		return shiGan
	} else {
		switch riZhi.Id {
		case dizhi.Zi:
			return tiangan.TianGan{Id: tiangan.Wu}
		case dizhi.Xu:
			return tiangan.TianGan{Id: tiangan.Ji}
		case dizhi.Shen:
			return tiangan.TianGan{Id: tiangan.Geng}
		case dizhi.Wu:
			return tiangan.TianGan{Id: tiangan.Xin}
		case dizhi.Chen:
			return tiangan.TianGan{Id: tiangan.Ren}
		case dizhi.Yin:
			return tiangan.TianGan{Id: tiangan.Gui}
		}
		return tiangan.TianGan{Id: tiangan.Jia}
	}
}
