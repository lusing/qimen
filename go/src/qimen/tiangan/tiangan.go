package tiangan

const (
	Jia = iota
	Yi
	Bing
	Ding
	Wu
	Ji
	Geng
	Xin
	Ren
	Gui
)

type TianGan struct {
	Id uint8
}

func (ptg *TianGan) GetName() string {
	names := []string{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"}
	return names[ptg.Id%10]
}
