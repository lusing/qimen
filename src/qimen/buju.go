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
				println("找到的天干：", pan.grid[i][j].SanQiLiuYi.GetName(), "在", i, ",", j)
				println(pan.grid[i][j].DiPanJiuXing.GetName())
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
			print(cell.SanQiLiuYi.GetName(), "|")
			//print(cell.Gua.GetName())
		}
		println()
		for _, cell := range row {
			print(cell.Gua.GetName(), "|")
		}
		println()
		for _, cell := range row {
			print(cell.DiPanJiuXing.GetName(), "|")
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

	// 地盘九星初始值

	for i := 0; i < 8; i++ {
		pan.grid[pos1][pos2].DiPanJiuXing = JiuXing{Id: uint8(i)}
		pos1, pos2 = GetNext(pos1, pos2)
		//println(i)
	}
	pan.grid[1][1].DiPanJiuXing = JiuXing{Id: 8}

	xunshou := GetXunShou(shiZhi, riGan)
	println("旬首:", xunshou.GetName())
	pos1, pos2 = pan.GetZhiFuXing(xunshou)
	println("值符星位置：", pos1, ",", pos2)

	return pan
}

type Cell struct {
	SanQiLiuYi   tiangan.TianGan
	DiPanJiuXing JiuXing
	Gua          BaGua
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

func GetXunShou(shiZhi dizhi.DiZhi, riGan tiangan.TianGan) tiangan.TianGan {
	shiGan := WuZiYuanDun(riGan, shiZhi)
	println("时干支:", shiGan.GetName(), shiZhi.GetName())
	diff := shiGan.Id - tiangan.Jia
	xunshouZhi := dizhi.DiZhi{Id: (shiZhi.Id - diff + 12) % 12}
	switch xunshouZhi.Id {
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
	return tiangan.TianGan{Id: 0}
}
