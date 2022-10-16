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

	// ===============================

	pan := qimen.NewPan(qimen.JieQi{Id: qimen.DaHan}, tiangan.TianGan{Id: tiangan.Wu}, dizhi.DiZhi{Id: dizhi.Chen})
	pan.Display()
}
