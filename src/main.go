package main

import (
	"qimen/src/qimen"
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

func main() {
	dz1 := dizhi.DiZhi{Id: dizhi.Zi}
	println(dz1.GetName())

	tg1 := tiangan.TianGan{
		Id: tiangan.Jia,
	}
	println(tg1.GetName())

	jieqi1 := qimen.JieQi{
		Id: qimen.BaiLu,
	}
	println(jieqi1.GetName())
}
