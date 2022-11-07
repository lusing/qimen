package qimen

const (
	DongZhi = iota
	XiaoHan
	DaHan
	LiChun
	YuShui
	JingZhe
	ChunFen
	QingMing
	GuYu
	LiXia
	XiaoMan
	MangZhong
	XiaZhi //从此开始为阳
	XiaoShu
	DaShu
	LiuQiu
	ChuShu
	BaiLu
	QiuFen
	HanLu
	ShuangJiang
	LiDong
	XiaoXue
	DaXue
)

type JieQi struct {
	Id uint8
}

func (jq *JieQi) GetName() string {
	names := []string{
		"冬至", "小寒", "大寒",
		"立春", "雨水", "惊蛰",
		"春分", "清明", "谷雨",
		"立夏", "小满", "芒种",
		"夏至", "小暑", "大暑",
		"立秋", "处暑", "白露",
		"秋分", "寒露", "霜降",
		"立冬", "小雪", "大雪"}
	return names[jq.Id%24]
}

func (jq *JieQi) GetJu() (yang bool, ju []uint8) {
	//从夏至开始阳遁
	yinyang := jq.Id < XiaZhi
	var ju_num []uint8
	switch jq.Id {
	case DongZhi, JingZhe:
		ju_num = []uint8{1, 7, 4}
	case XiaoHan:
		ju_num = []uint8{2, 5, 8}
	case DaHan, ChunFen:
		ju_num = []uint8{3, 9, 6}
	case MangZhong:
		ju_num = []uint8{6, 3, 9}
	case GuYu, XiaoMan:
		ju_num = []uint8{5, 2, 8}
	case LiChun:
		ju_num = []uint8{8, 5, 2}
	case LiXia, QingMing:
		ju_num = []uint8{4, 1, 7}
	case YuShui:
		ju_num = []uint8{9, 6, 3}
	case XiaZhi, BaiLu:
		ju_num = []uint8{9, 3, 6}
	case XiaoShu:
		ju_num = []uint8{8, 2, 5}
	case QiuFen, DaShu:
		ju_num = []uint8{7, 1, 4}
	case LiuQiu:
		ju_num = []uint8{2, 5, 8}
	case ShuangJiang, XiaoXue:
		ju_num = []uint8{5, 8, 2}
	case DaXue:
		ju_num = []uint8{4, 7, 1}
	case ChuShu:
		ju_num = []uint8{1, 4, 7}
	case LiDong, HanLu:
		ju_num = []uint8{6, 9, 3}
	}
	return yinyang, ju_num
}
