package meihuayishu

type LiuQin struct {
	Id int
}

const (
	FUMU    = iota // 父母
	ZISUN          // 子孫
	GUANGUI        // 官鬼
	QICAI          // 妻财
	XIONGDI        // 兄弟
)

func (lq LiuQin) GetName() string {
	switch lq.Id {
	case 0:
		return "父母"
	case 1:
		return "子孙"
	case 2:
		return "官鬼"
	case 3:
		return "妻财"
	case 4:
		return "兄弟"
	}
	return ""
}
