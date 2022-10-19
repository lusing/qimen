package qimen

type BaShen struct {
	Id uint8
}

const (
	ZhiFu = iota
	TengShe
	TaiYin
	LiuHe
	BaiHu
	XuanWu
	JiuDi
	JiuTian
)

func (pbs *BaShen) GetName() string {
	names := []string{"值符", "螣蛇", "太阴", "六合", "白虎", "青龙", "九地", "九天"}
	return names[pbs.Id%8]
}
