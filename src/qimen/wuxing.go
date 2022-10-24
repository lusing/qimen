package qimen

type Xing struct {
	Id uint8
}

const (
	MU = iota
	HUO
	TU
	JIN
	SHUI
)

func (px *Xing) GetName() string {
	names := []string{"木", "火", "土", "金", "水"}
	return names[px.Id%5]
}

func (px *Xing) Ke(kee Xing) bool {
	return Ke(px.Id, kee.Id)
}

func (px *Xing) Sheng(sheng Xing) bool {
	return Sheng(px.Id, sheng.Id)
}

func Sheng(shenger uint8, shengee uint8) bool {
	return (shenger+1)%5 == shengee
}

func Ke(ker uint8, kee uint8) bool {
	return (ker+2)%5 == kee
}
