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
}
