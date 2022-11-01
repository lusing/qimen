package meihuayishu

import "qimen/src/qimen/dizhi"

func Test() {

	//ShiJianQiGua(2, 11, 24, dizhi.Shen+1)

	// 观梅占例
	ShiJianQiGua(dizhi.Chen+1, 12, 17, dizhi.Shen+1)

	// 牡丹占
	ShiJianQiGua(dizhi.Si+1, 3, 16, dizhi.Mao+1)

	LianZiQiGua(14, 12, 2)
}
