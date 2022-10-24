package main

import (
	"qimen/src/meihuayishu"
	"qimen/src/qimen"
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

func main() {

	//tg1 := tiangan.TianGan{
	//	Id: tiangan.Gui,
	//}
	//println(tg1.GetName())
	//
	//dz1 := dizhi.DiZhi{Id: dizhi.You}
	//println(dz1.GetName())
	//
	//jieqi1 := qimen.JieQi{
	//	Id: qimen.MangZhong,
	//}
	//println(jieqi1.GetName())
	//
	//num := qimen.GetSanYuan(tg1, dz1)
	//println(num)
	//
	//isYang, ju := qimen.GetJu(jieqi1, tg1, dz1)
	//println(isYang, ju)
	//
	//////============================
	//// 1996年2月1日 大寒 戊辰日，应为阳遁三局
	//_, _ = qimen.GetJu(qimen.JieQi{Id: qimen.DaHan}, tiangan.TianGan{Id: tiangan.Wu}, dizhi.DiZhi{Id: dizhi.Chen})
	//
	//// 1996年2月2日 大寒 己巳日，应为阳遁九局
	//_, _ = qimen.GetJu(qimen.JieQi{Id: qimen.DaHan}, tiangan.TianGan{Id: tiangan.Ji}, dizhi.DiZhi{Id: dizhi.Si})
	//
	//println("==========================================")

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
	//panSqzm1 := qimen.NewPan(qimen.JieQi{Id: qimen.MangZhong}, tiangan.TianGan{Id: tiangan.Gui}, dizhi.DiZhi{Id: dizhi.You}, dizhi.DiZhi{Id: dizhi.Si})
	//panSqzm1.Display()

	// 《神奇之门》106页，例2
	// 1995年8月13日下午8时，立秋
	// 丙子日 戌时 TODO:
	//panSqzm2 := qimen.NewPan(qimen.JieQi{Id: qimen.LiuQiu}, tiangan.TianGan{Id: tiangan.Bing}, dizhi.DiZhi{Id: dizhi.Zi}, dizhi.DiZhi{Id: dizhi.Xu})
	//panSqzm2.Display()

	// 《开悟之门》75页，例1
	// 2001年8月20日下午4点，立秋
	// 乙卯日 甲申时，阴遁 5 局
	panKwzm1 := qimen.NewPan(qimen.JieQi{Id: qimen.LiuQiu}, tiangan.TianGan{Id: tiangan.Yi}, dizhi.DiZhi{Id: dizhi.Mao}, dizhi.DiZhi{Id: dizhi.Shen})
	panKwzm1.Display()

	// 《开悟之门》80页，例2
	// 2001年8月20日下午9点，立秋
	// 乙卯日 丁亥时， 阴遁 5 局
	// TODO
	//panKwzm2 := qimen.NewPan(qimen.JieQi{Id: qimen.LiuQiu}, tiangan.TianGan{Id: tiangan.Yi}, dizhi.DiZhi{Id: dizhi.Mao}, dizhi.DiZhi{Id: dizhi.Hai})
	//panKwzm2.Display()

	// 《神奇之门》186页，例1
	// 1996年3月16日下午4时，惊蛰
	// 壬子日 申时
	// TODO:
	//panSqzm1_1 := qimen.NewPan(qimen.JieQi{Id: qimen.JingZhe}, tiangan.TianGan{Id: tiangan.Ren}, dizhi.DiZhi{Id: dizhi.Zi}, dizhi.DiZhi{Id: dizhi.Shen})
	//panSqzm1_1.Display()

	// 《神奇之门》188页，例2
	// 1996年7月27日下午4时，大暑
	// 乙丑日 申时 阴遁7局
	// TODO:
	//panSqzm1_2 := qimen.NewPan(qimen.JieQi{Id: qimen.DaShu}, tiangan.TianGan{Id: tiangan.Ren}, dizhi.DiZhi{Id: dizhi.Zi}, dizhi.DiZhi{Id: dizhi.Shen})
	//panSqzm1_2.Display()

	// 《神奇之门》190页，例3
	// 1996年5月9日下午4时20分，立夏
	// 丙午日 申时 阴遁7局
	// TODO:
	//panSqzm1_3 := qimen.NewPan(qimen.JieQi{Id: qimen.LiXia}, tiangan.TianGan{Id: tiangan.Bing}, dizhi.DiZhi{Id: dizhi.Wu}, dizhi.DiZhi{Id: dizhi.Shen})
	//panSqzm1_3.Display()

	// 《神奇之门》191页，例4
	// 1996年5月23日下午，小满
	// 庚申日 戌时
	// TODO: 八门不对
	//panSqzm1_4 := qimen.NewPan(qimen.JieQi{Id: qimen.XiaoMan}, tiangan.TianGan{Id: tiangan.Geng}, dizhi.DiZhi{Id: dizhi.Shen}, dizhi.DiZhi{Id: dizhi.Xu})
	//panSqzm1_4.Display()

	// 《神奇之门》193页，例5
	// 1996年11月2日下午4时，霜降
	// 癸卯日 申时
	// TODO:
	//panSqzm1_5 := qimen.NewPan(qimen.JieQi{Id: qimen.ShuangJiang}, tiangan.TianGan{Id: tiangan.Gui}, dizhi.DiZhi{Id: dizhi.Mao}, dizhi.DiZhi{Id: dizhi.Shen})
	//panSqzm1_5.Display()

	// 《奇门遁甲现代应用》76页，例1
	// 2007年5月6日辰时，立夏
	// 庚子日 辰时
	// TODO:
	panHd1 := qimen.NewPan(qimen.JieQi{Id: qimen.LiXia}, tiangan.TianGan{Id: tiangan.Geng}, dizhi.DiZhi{Id: dizhi.Zi}, dizhi.DiZhi{Id: dizhi.Chen})
	panHd1.Display()

	meihuayishu.Test()

}
