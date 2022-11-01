package meihuayishu

func ShiJianQiGua(year int, month int, day int, hour int) {
	var shangGua uint8 = uint8((year + month + day) % 8)
	//println("上卦：", shangGua)
	//sg := NewGuaFromNumber(int(shangGua))
	//println("上卦：", sg.GetName())
	var xiaGua uint8 = uint8((year + month + day + hour) % 8)
	//println("下卦：", xiaGua)
	//xg := NewGuaFromNumber(int(xiaGua))
	//println("下卦：", xg.GetName())
	bianYao := (year + month + day + hour) % 6
	println("变爻：", bianYao)
	println(hour)
	println(year+month+day, year+month+day+hour)

	fullGua := NewGua64FromNumbers(int(xiaGua), int(shangGua), bianYao)
	println("卦名：", fullGua.BenGua.GetName())
	//fmt.Printf("%b\n", fullGua.Value)

	println("互卦：", fullGua.HuGua.GetName())

	println("变卦：", fullGua.BianGua.GetName())

	fullGua.DuanGua()
}
