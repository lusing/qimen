package qimen

type JiuXing struct {
	Id uint8
}

const (
	TianPeng = iota
	TianRen
	TianChong
	TianFu
	TianYing
	TianRui
	TianZhu
	TianXin
	TianQin
)

func (pjx *JiuXing) GetName() string {
	names := []string{"天蓬", "天任", "天冲", "天辅", "天英", "天芮", "天柱", "天心", "天禽"}
	return names[pjx.Id%9]
}
