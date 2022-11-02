package meihuayishu

import (
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

func Test() {

	//ShiJianQiGua(2, 11, 24, dizhi.Shen+1)

	// 观梅占例
	ShiJianQiGua(dizhi.Chen+1, 12, 17, dizhi.Shen+1)

	// 牡丹占
	ShiJianQiGua(dizhi.Si+1, 3, 16, dizhi.Mao+1)

	gan1 := tiangan.TianGan{Id: tiangan.Ji}
	zhi1 := dizhi.DiZhi{Id: dizhi.Wei}
	LianZiQiGua(14, 12, 2, zhi1, gan1)

}
