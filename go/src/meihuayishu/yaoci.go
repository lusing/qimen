package meihuayishu

func (pgua *Gua64) GetYaoCi(yao int) {
	switch pgua.Value {
	case 0b000000: // 坤为地
		println("坤：元亨，利牝马之贞。君子有攸往，先迷，后得主，利。西南得朋，东北丧朋。安贞吉。")
		if yao == 1 {
			println("初六：履霜，坚冰至。")
		} else if yao == 2 {
			println("六二：直方大，不习无不利。")
		} else if yao == 3 {
			println("六三：含章可贞。或从王事，无成有终。")
		} else if yao == 4 {
			println("六四：括囊，无咎无誉。")
		} else if yao == 5 {
			println("九五：黄裳，元吉。")
		} else if yao == 6 {
			println("上六：龙战于野，其血玄黄。")
		}
	case 0b000001: // 地雷复
		println("复：亨。出入无疾，朋来无咎。反复其道，七日来复，利有攸往。")
	case 0b000010: // 地水师
		println("师：贞丈人吉，无咎。")
	case 0b000011: // 地泽临
		println("临：元亨，利贞。至于八月有凶。")
	case 0b000100: // 地山谦
		println("谦：亨，君子有终。")
	case 0b000101: // 地火明夷
		println("明夷：利艰贞。")
	case 0b000110: // 地风升
		println("升：元亨，用见大人，勿恤，南征吉。")
	case 0b000111: // 地天泰
		println("泰：小往大来，吉亨。")
	case 0b001000: // 雷地豫
		println("豫：利建侯行师。")
	case 0b001001: // 震为雷
		println("震：亨。震来虩虩，笑言哑哑，震惊百里，不丧匕鬯。")
	case 0b001010: // 雷水解
		println("解：利西南，无所往，其来复吉。有攸往，夙吉。")
	case 0b001011: // 雷泽归妹
		println("归妹：征凶，无攸利。")
	case 0b001100: // 雷山小过
		println("小过：亨。利贞，可小事，不可大事。飞鸟遗之音，不宜上，宜下，大吉。")
	case 0b001101: // 雷火丰
		println("丰：亨，王假有庙。利见大人，亨，利贞。用大牲吉，利有攸往。")
	case 0b001110: // 雷风恒
		println("恒：亨。无咎。利贞，利有攸往。")
	case 0b001111: // 雷天大壮
		println("大壮：利贞。")
	case 0b010000: // 水地比
		println("比：吉。原筮，元永贞，无咎。不宁方来，后夫凶。")
	case 0b010001: // 水雷屯
		println("屯，元亨，利贞；勿用有攸往，利建侯。")
		println("《彖》曰：屯，刚柔始交而难生，动乎险中，大亨贞。雷雨之动满盈，天造草昧，宜守建侯而不宁")
		println("《象》曰：云雷屯；君子以经纶。")
		if yao == 1 {
			println("初九：磐桓，利居贞，利建侯。")
		} else if yao == 2 {
			println("六二：屯如邅如，乘马班如。匪寇，婚媾，女子贞不字，十年乃字。")
		} else if yao == 3 {
			println("六三：即鹿无虞，惟入于林中，君子几不如舍，往吝。")
		} else if yao == 4 {
			println("六四：乘马班如，求婚媾，往吉，无不利。")
		} else if yao == 5 {
			println("九五：屯其膏，小贞吉，大贞凶。")
		} else if yao == 6 {
			println("上六：乘马班如，泣血涟如。")
		}
	case 0b010010: // 坎为水
		println("坎：元亨，利牝马之贞。君子有攸往，先迷，后得主，利。西南得朋，东北丧朋，安贞吉。")
	case 0b010011: // 水泽节
		println("节：亨，苦节不可贞。")
	case 0b010100: // 水山蹇
		println("蹇：利西南，不利东北；利见大人，贞吉。")
	case 0b010101: // 水火既济
		println("既济：亨小，利贞，初吉终乱。")
	case 0b010110: // 水风井
		println("井：改邑不改井，无丧无得，往来井井。汔至，亦未繘井，羸其瓶，凶。")
	case 0b010111: // 水天需
		println("需：有孚，光亨，贞吉，利涉大川。")
		if yao == 1 {
			println("初九：需于郊，利用恒，无咎。")
		} else if yao == 2 {
			println("九二：需于沙，小有言，终吉。")
		} else if yao == 3 {
			println("九三：需于泥，致寇至。")
		} else if yao == 4 {
			println("六四：需于血，出自穴。")
		} else if yao == 5 {
			println("九五：需于酒食，贞吉。")
		} else if yao == 6 {
			println("上六：入于穴，有不速之客三人来，敬之终吉。")
		}
	case 0b011000: // 泽地萃
		println("萃：亨。王假有庙，利见大人，亨，利贞。用大牲吉，利有攸往。")
	case 0b011001: // 泽雷随
		println("随：元亨，利贞，无咎。可贞，不可贞。无攸利，往来无咎。")
	case 0b011010: // 泽水困
		println("困：亨，贞，大人吉，无咎。有言不信。")
	case 0b011011: // 兑为泽
		println("兑：亨，利贞。")
	case 0b011100: // 泽山咸
		println("咸：亨，利贞，取女吉。")
	case 0b011101: // 泽火革
		println("革：巽在床下，用史巫纷若，吉无咎。")
	case 0b011110: // 泽风大过
		println("大过：栋桡，利有攸往，亨。")
	case 0b011111: // 泽天夬
		println("夬：利贞，不家食吉，利涉大川。")
	case 0b100000: // 山地剥
		println("剥：不利有攸往。")
	case 0b100001: // 山雷颐
		println("颐：贞吉。观颐，自求口实。")
	case 0b100010: // 山水蒙
		println("蒙：亨，匪我求童蒙，童蒙求我。初筮告，再三渎，渎则不告。利贞。")
		if yao == 1 {
			println("初六：发蒙，利用刑人，用说桎梏，以往吝。")
		} else if yao == 2 {
			println("九二：包蒙吉，纳妇吉，子克家。")
		} else if yao == 3 {
			println("六三：勿用取女，见金夫，不有躬，无攸利。")
		} else if yao == 4 {
			println("六四：困蒙，吝。")
		} else if yao == 5 {
			println("九五：童蒙，吉。")
		} else if yao == 6 {
			println("上六：击蒙，不利为寇，利御寇。")
		}
	case 0b100011: // 山泽损
		println("损：有孚，元吉，无咎，可贞。利有攸往，得臣无家。")
	case 0b100100: // 艮为山
		println("艮：艮其背，不获其身，行其庭，不见其人，无咎。")
	case 0b100101: // 山火贲
		println("贲：亨，小利有攸往。")
	case 0b100110: // 山风蛊
		println("蛊：元亨，利涉大川，利君子贞。")
	case 0b100111: // 山天大畜
		println("大畜：利贞，不家食吉，利涉大川。")
	case 0b101000: // 火地晋
		println("晋：康侯用锡马蕃庶，昼日三接。")
	case 0b101001: // 火雷噬嗑
		println("噬嗑：亨，利用狱。")
	case 0b101010: // 火水未济
		println("未济：亨，小狐汔济，濡其尾，无攸利。")
	case 0b101011: // 火泽睽
		println("睽：小事吉。")
	case 0b101100: // 火山旅
		println("旅：小亨，旅贞吉。")
	case 0b101101: // 离为火
		println("离：利贞，亨。畜牝牛，吉。")
	case 0b101110: // 火风鼎
		println("鼎：元吉，亨。")
	case 0b101111: // 火天大有
		println("大有：元亨，用见大人，勿恤，南征吉。")
	case 0b110000: // 风地观
		println("观：盥而不荐，有孚顒若。")
	case 0b110001: // 风雷益
		println("益：利有攸往，利涉大川。")
	case 0b110010: // 风水涣
		println("涣：亨，王假有庙，利涉大川，利贞。用大牲吉，利有攸往。")
	case 0b110011: // 风泽中孚
		println("中孚：豚鱼吉，利涉大川，利君子贞。")
	case 0b110100: // 风山渐
		println("渐：女归吉，利贞。")
	case 0b110101: // 风火家人
		println("家人：利女贞。")
	case 0b110110: // 巽为风
		println("巽：小亨，利有攸往，利见大人。")
	case 0b110111: // 风天小畜
		println("小畜：亨，密云不雨，自我西郊。")
	case 0b111000: // 天地否
		println("否：否之匪人，不利君子贞，大往小来。")
	case 0b111001: // 天雷无妄
		println("无妄：元亨，利贞，其匪正有眚，不利有攸往。")
	case 0b111010: // 天水讼
		println("讼：有孚，窒惕，中吉，终凶。利见大人，不利涉大川。")
		if yao == 1 {
			println("初六：不永所事，小有言，终吉。")
		} else if yao == 2 {
			println("九二：不克讼，归而逋其邑人，三百户，无眚。")
		} else if yao == 3 {
			println("九三：食旧德，贞厉，终吉。或从王事，无成有终。")
		} else if yao == 4 {
			println("九四：不克讼，复即命，渝，安贞吉。")
		} else if yao == 5 {
			println("九五：讼，元吉。")
		} else if yao == 6 {
			println("上九：或锡之鞶带，终朝三褫之。")
		}
	case 0b111011: // 天泽履
		println("履：履虎尾，不咥人，亨。")
	case 0b111100: // 天山遁
		println("遁：亨，小利贞。")
	case 0b111101: // 天火同人
		println("同人：同人于野，亨，利涉大川。")
	case 0b111110: // 天风姤
		println("姤：女壮，勿用取女。")
	case 0b111111: // 乾为天
		println("乾，元，亨，利，贞。其匪正有眚，不利有攸往。")
		if yao == 1 {
			println("初九：潜龙勿用。")
		} else if yao == 2 {
			println("九二：见龙在田，利见大人。")
		} else if yao == 3 {
			println("九三：君子终日乾乾，夕惕若厉，无咎。")
		} else if yao == 4 {
			println("九四：或跃在渊，无咎。")
		} else if yao == 5 {
			println("九五：飞龙在天，利见大人。")
		} else if yao == 6 {
			println("上九：亢龙有悔。")
		}
	}
}
