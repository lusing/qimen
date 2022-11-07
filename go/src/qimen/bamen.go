package qimen

type BaMen struct {
	Id uint8
}

const (
	XiuMen = iota
	ShengMen
	ShangMen
	DuMen
	Jing3Men
	SiMen
	Jing1Men
	KaMen
)

func (pbm *BaMen) GetName() string {
	names := []string{"休", "生", "伤", "杜", "景", "死", "惊", "开"}
	return names[pbm.Id%8]
}
