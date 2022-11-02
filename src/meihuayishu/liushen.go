package meihuayishu

type LiuShen struct {
	Id int
}

const (
	QINGLONG = iota // 青龍
	ZHUQUE          // 朱雀
	GOUCHEN         // 勾陈
	TENGSHE         // 腾蛇
	BAIHU           // 白虎
	XUANWU          // 玄武
)

func (ls LiuShen) GetName() string {
	switch ls.Id % 6 {
	case QINGLONG:
		return "青龙"
	case ZHUQUE:
		return "朱雀"
	case GOUCHEN:
		return "勾陈"
	case TENGSHE:
		return "腾蛇"
	case BAIHU:
		return "白虎"
	case XUANWU:
		return "玄武"
	}
	return "神兽就是你"
}
