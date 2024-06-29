const WuXing = require("./wuxing");

class TianGan {
    constructor(tg) {
        this.tianGan = tg % 10;
    }

    toString() {
        return TianGan.sTianGan.charAt(this.tianGan);
    }

    getNext() {
        return new TianGan((this.tianGan + 1) % 10);
    }

    getPrev() {
        return new TianGan((this.tianGan + 9) % 10);
    }

    get xing() {
        return new WuXing(Math.floor(this.tianGan / 2));
    }

    get isYang() {
        return this.tianGan % 2 === 0;
    }

    getName() {
        return TianGan.sTianGan.charAt(this.tianGan);
    }

    isSheng(tg2) {
        return this.xing.isSheng(tg2.xing);
    }

    isKe(tg2) {
        return this.xing.isKe(tg2.xing);
    }

    isChong(tg2) {
        const { JIA, YI, BING, DING, GENG, XIN, REN, GUI } = TianGan;
        return (
            (this.tianGan === JIA && tg2.tianGan === GENG) ||
            (this.tianGan === YI && tg2.tianGan === XIN) ||
            (this.tianGan === BING && tg2.tianGan === REN) ||
            (this.tianGan === DING && tg2.tianGan === GUI)
        );
    }

    isHe(tg2) {
        const he = TianGan.isHe(this, tg2);
        return he ? he : TianGan.isHe(tg2, this);
    }

    getHe() {
        return new TianGan(this.tianGan + 5);
    }

    getRomance() {
        switch (this.tianGan) {
            case TianGan.JIA:
                return "庄重威仪、城府深、不怒而威、气质高雅、自负傲物、冷酷武断、孤独寂寞";
            case TianGan.YI:
                return "温柔贤惠、仁慈善良、柔情似水、娴于世故、优柔寡断";
            case TianGan.BING:
                return "英武雄猛、光明直爽、脾气急躁、热情好客";
            case TianGan.DING:
                return "精致细腻、洞察力强、锋芒毕露";
            case TianGan.WU:
                return "诚实守信、有条不紊、大智若愚、固执麻木、拙嘴笨舌";
            case TianGan.JI:
                return "温顺沉静、诡计多端、机智圆滑";
            case TianGan.GENG:
                return "大义凛然、刚键锐利、勇猛威严";
            case TianGan.XIN:
                return "思想叛逆、性格偏激、阴谋鬼计";
            case TianGan.REN:
                return "圆滑多变、聪明伶俐、目标迷茫、性情不定";
            case TianGan.GUI:
                return "多愁善感、多情多欲、犹豫不决、聪明";
            default:
                return "";
        }
    }

    static isHe(tg1, tg2) {
        const { JIA, YI, BING, DING, WU, JI, GENG, XIN, REN, GUI } = TianGan;
        const { TU, JIN, SHUI, MU, HUO } = WuXing;
        if (tg1.tianGan === JIA && tg2.tianGan === JI) return new WuXing(TU);
        if (tg1.tianGan === YI && tg2.tianGan === GENG) return new WuXing(JIN);
        if (tg1.tianGan === BING && tg2.tianGan === XIN) return new WuXing(SHUI);
        if (tg1.tianGan === DING && tg2.tianGan === REN) return new WuXing(MU);
        if (tg1.tianGan === WU && tg2.tianGan === GUI) return new WuXing(HUO);
        return null;
    }
}

TianGan.JIA = 0;
TianGan.YI = 1;
TianGan.BING = 2;
TianGan.DING = 3;
TianGan.WU = 4;
TianGan.JI = 5;
TianGan.GENG = 6;
TianGan.XIN = 7;
TianGan.REN = 8;
TianGan.GUI = 9;
TianGan.sTianGan = "甲乙丙丁戊己庚辛壬癸";

module.exports = TianGan;