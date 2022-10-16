package qimen

import (
	"qimen/src/qimen/dizhi"
	"qimen/src/qimen/tiangan"
)

// bool: true - 阳遁，false - 阴遁
// ju: 第几局

func GetJu(jq JieQi, rigan tiangan.TianGan, riZhi dizhi.DiZhi) (bool, uint8) {
	sanYuan := GetSanYuan(rigan, riZhi)
	isYang, jus := jq.GetJu()
	ju := jus[sanYuan]
	if isYang {
		print("阳遁", ju, "局")
	} else {
		print("阴遁", ju, "局")
	}
	return isYang, ju
}
