package qimen

type BaGua struct {
	Id uint8
}

const (
	Kan = iota
	Kun
	Zhen
	Xun
	Zhong
	Qian
	Dui
	Gen
	Li
)

func (pbg *BaGua) GetName() string {
	names := []string{"坎", "坤", "震", "巽", "中", "乾", "兑", "艮", "离"}
	return names[pbg.Id%9]
}
