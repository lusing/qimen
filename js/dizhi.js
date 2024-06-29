const WuXing = require('./wuxing');
const TianGan = require('./tiangan');

class DiZhi {
    constructor(idz) {
        this.diZhi = (idz + 12) % 12;
    }

    getNext() {
        return new DiZhi((this.diZhi + 1) % 12);
    }

    getPrev() {
        return new DiZhi((this.diZhi + 11) % 12);
    }

    toString() {
        return DiZhi.sDiZhi[this.diZhi];
    }

    getName() {
        return this.toString();
    }

    get xing() {
        let xing = -1;
        switch (this.diZhi) {
            case DiZhi.YIN:
            case DiZhi.MAO:
                xing = WuXing.MU;
                break;
            case DiZhi.SI:
            case DiZhi.WU:
                xing = WuXing.HUO;
                break;
            case DiZhi.CHEN:
            case DiZhi.XU:
            case DiZhi.CHOU:
            case DiZhi.WEI:
                xing = WuXing.TU;
                break;
            case DiZhi.SHEN:
            case DiZhi.YOU:
                xing = WuXing.JIN;
                break;
            case DiZhi.HAI:
            case DiZhi.ZI:
                xing = WuXing.SHUI;
                break;
            default:
                xing = WuXing.MU;
        }
        return new WuXing(xing);
    }

    get cangGan() {
        let tgList = [];
        switch (this.diZhi) {
            case DiZhi.ZI:
                tgList.push(new TianGan(TianGan.GUI));
                break;
            case DiZhi.CHOU:
                tgList.push(new TianGan(TianGan.JI), new TianGan(TianGan.GUI), new TianGan(TianGan.XIN));
                break;
            case DiZhi.YIN:
                tgList.push(new TianGan(TianGan.JIA), new TianGan(TianGan.BING), new TianGan(TianGan.WU));
                break;
            case DiZhi.MAO:
                tgList.push(new TianGan(TianGan.YI));
                break;
            case DiZhi.CHEN:
                tgList.push(new TianGan(TianGan.WU), new TianGan(TianGan.JI), new TianGan(TianGan.GUI));
                break;
            case DiZhi.SI:
                tgList.push(new TianGan(TianGan.BING), new TianGan(TianGan.WU), new TianGan(TianGan.GENG));
                break;
            case DiZhi.WU:
                tgList.push(new TianGan(TianGan.DING), new TianGan(TianGan.JI));
                break;
            case DiZhi.WEI:
                tgList.push(new TianGan(TianGan.JI), new TianGan(TianGan.YI), new TianGan(TianGan.DING));
                break;
            case DiZhi.SHEN:
                tgList.push(new TianGan(TianGan.GENG), new TianGan(TianGan.REN), new TianGan(TianGan.WU));
                break;
            case DiZhi.YOU:
                tgList.push(new TianGan(TianGan.XIN));
                break;
            case DiZhi.XU:
                tgList.push(new TianGan(TianGan.WU), new TianGan(TianGan.XIN), new TianGan(TianGan.DING));
                break;
            case DiZhi.HAI:
                tgList.push(new TianGan(TianGan.REN), new TianGan(TianGan.JIA));
                break;
            default:
                break;
        }
        return tgList;
    }

    get benQin() {
        let tg = -1;
        switch (this.diZhi) {
            case DiZhi.ZI:
                tg = TianGan.GUI;
                break;
            case DiZhi.CHOU:
                tg = TianGan.JI;
                break;
            case DiZhi.YIN:
                tg = TianGan.JIA;
                break;
            case DiZhi.MAO:
                tg = TianGan.YI;
                break;
            case DiZhi.CHEN:
                tg = TianGan.WU;
                break;
            case DiZhi.SI:
                tg = TianGan.BING;
                break;
            case DiZhi.WU:
                tg = TianGan.DING;
                break;
            case DiZhi.WEI:
                tg = TianGan.JI;
                break;
            case DiZhi.SHEN:
                tg = TianGan.GENG;
                break;
            case DiZhi.YOU:
                tg = TianGan.XIN;
                break;
            case DiZhi.XU:
                tg = TianGan.WU;
                break;
            case DiZhi.HAI:
                tg = TianGan.REN;
                break;
            default:
                break;
        }
        return new TianGan(tg);
    }

    isKe(dz2) {
        return this.xing.isKe(dz2.xing);
    }

    isSheng(dz2) {
        return this.xing.isSheng(dz2.xing);
    }

    isChong(dz2) {
        return dz2.diZhi === (this.diZhi + 6) % 12;
    }

    isHai(dz2) {
        return ((this.diZhi + dz2.diZhi) % 12) === 7;
    }

    isXing2(dz2) {
        const d1 = this.diZhi;
        const d2 = dz2.diZhi;

        // 自刑
        if (d1 === DiZhi.CHEN && d2 === DiZhi.CHEN) {
            console.log(`${this.diZhi}自刑`);
            return true;
        }
        if (d1 === DiZhi.WU && d2 === DiZhi.WU) {
            console.log(`${this.diZhi}自刑`);
            return true;
        }
        if (d1 === DiZhi.YOU && d2 === DiZhi.YOU) {
            console.log(`${this.diZhi}自刑`);
            return true;
        }
        if (d1 === DiZhi.HAI && d2 === DiZhi.HAI) {
            console.log(`${this.diZhi}自刑`);
            return true;
        }

        // 无礼之刑
        const wu_li_xing = [DiZhi.ZI, DiZhi.MAO];
        if (wu_li_xing.includes(d1) && wu_li_xing.includes(d2)) {
            console.log("无礼之刑");
            return true;
        }

        // 无恩之刑
        const wu_en_xing = [DiZhi.YIN, DiZhi.SI, DiZhi.SHEN];
        if (wu_en_xing.includes(d1) && wu_en_xing.includes(d2)) {
            console.log("无恩之刑");
            return true;
        }

        // 恃势之刑
        const shi_shi_xing = [DiZhi.CHOU, DiZhi.XU, DiZhi.WEI];
        if (shi_shi_xing.includes(d1) && shi_shi_xing.includes(d2)) {
            console.log("恃势之刑");
            return true;
        }

        return false;
    }

    isHe(dz2) {
        return (dz2.diZhi + this.diZhi + 12) % 12 === 1;
    }

    getHe() {
        return new DiZhi(13 - this.diZhi);
    }

    getMuKu(x) {
        switch (x.xing) {
            case WuXing.SHUI:
                return new DiZhi(DiZhi.CHEN); // 水库辰
            case WuXing.MU:
                return new DiZhi(DiZhi.WEI); // 土库未
            case WuXing.JIN:
                return new DiZhi(DiZhi.CHOU); // 金库丑
            default:
                return new DiZhi(DiZhi.XU); // 火土为戌
        }
    }

    static isHe(dz1, dz2) {
        let xing = -1;
        if (dz1 === DiZhi.YIN && dz2 === DiZhi.HAI) {
            xing = WuXing.MU;
        } else if (dz1 === DiZhi.MAO && dz2 === DiZhi.XU) {
            xing = WuXing.HUO;
        }
        return new WuXing(xing);
    }

    static getMingGong(yueDZ, shiDZ) {
        const dzsum = yueDZ.diZhi - 1 + shiDZ.diZhi - 1;
        return new DiZhi((14 - dzsum + 1) % 12);
    }
}

DiZhi.ZI = 0;
DiZhi.CHOU = 1;
DiZhi.YIN = 2;
DiZhi.MAO = 3;
DiZhi.CHEN = 4;
DiZhi.SI = 5;
DiZhi.WU = 6;
DiZhi.WEI = 7;
DiZhi.SHEN = 8;
DiZhi.YOU = 9;
DiZhi.XU = 10;
DiZhi.HAI = 11;
DiZhi.sDiZhi = "子丑寅卯辰巳午未申酉戌亥";

module.exports = DiZhi;