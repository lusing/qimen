package meihuayishu

import "qimen/src/qimen/dizhi"

func Test() {

	for i := 1; i <= 8; i++ {
		bagua := NewGuaFromNumber(i)
		println(bagua.GetName())
	}

	ShiJianQiGua(2, 11, 24, dizhi.Shen+1)

	var gua1 = Gua64{Value: 0}
	var huGua1 = gua1.GetHuGua()
	println(gua1.GetName())
	name1 := huGua1.GetName()
	println(name1)

}
