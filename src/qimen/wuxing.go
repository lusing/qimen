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
