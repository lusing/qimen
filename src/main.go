package main

import (
	"qimen/src/qimen"
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

func main() {

	tg1 := tiangan.TianGan{
		Id: tiangan.Gui,
	}
	println(tg1.GetName())

	dz1 := dizhi.DiZhi{Id: dizhi.You}
	println(dz1.GetName())

	jieqi1 := qimen.JieQi{
		Id: qimen.MangZhong,
	}
	println(jieqi1.GetName())

	num := qimen.GetSanYuan(tg1, dz1)
	println(num)

	isYang, ju := qimen.GetJu(jieqi1, tg1, dz1)
	println(isYang, ju)

	////============================
	// 1996年2月1日 大寒 戊辰日，应为阳遁三局
	_, _ = qimen.GetJu(qimen.JieQi{Id: qimen.DaHan}, tiangan.TianGan{Id: tiangan.Wu}, dizhi.DiZhi{Id: dizhi.Chen})

	// 1996年2月2日 大寒 己巳日，应为阳遁九局
	_, _ = qimen.GetJu(qimen.JieQi{Id: qimen.DaHan}, tiangan.TianGan{Id: tiangan.Ji}, dizhi.DiZhi{Id: dizhi.Si})

	println("==========================================")

	// ===============================

	//pan := qimen.NewPan(qimen.JieQi{Id: qimen.DaHan}, tiangan.TianGan{Id: tiangan.Wu}, dizhi.DiZhi{Id: dizhi.Chen}, dizhi.DiZhi{Id: dizhi.Chen})
	//pan.Display()

	// 《奇门遁甲铁口断》25页，例1
	// 2001年3月23日10点，春分
	// 辛巳年辛卯月乙酉日庚戌时
	//pan1 := qimen.NewPan(qimen.JieQi{Id: qimen.ChunFen}, tiangan.TianGan{Id: tiangan.Yi}, dizhi.DiZhi{Id: dizhi.You}, dizhi.DiZhi{Id: dizhi.Si})
	//pan1.Display()

	// 《奇门真传》31页，例1
	// 2017年3月23日3点27分，春分
	// 丁酉年癸卯月 己酉 日丙寅时
	//panZhenChuan1 := qimen.NewPan(qimen.JieQi{Id: qimen.ChunFen}, tiangan.TianGan{Id: tiangan.Ji}, dizhi.DiZhi{Id: dizhi.You}, dizhi.DiZhi{Id: dizhi.Yin})
	//panZhenChuan1.Display()

	// 《神奇之门》103页，例1
	// 1995年6月11日上午9时30分，芒种
	// 乙亥年 壬午月 癸酉 日 丁巳时
	panSqzm1 := qimen.NewPan(qimen.JieQi{Id: qimen.MangZhong}, tiangan.TianGan{Id: tiangan.Gui}, dizhi.DiZhi{Id: dizhi.You}, dizhi.DiZhi{Id: dizhi.Si})
	panSqzm1.Display()

}
