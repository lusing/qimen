class WuXing {
    constructor(xing) {
        this.xing = (xing + 5) % 5;
    }

    equals(other) {
        return this.xing === other.xing;
    }

    isSheng(xing2) {
        return WuXing.isSheng(this.xing, xing2.xing);
    }

    isKe(xing2) {
        return WuXing.isKe(this.xing, xing2.xing);
    }

    // isRuMu(dz) {
    //     switch (this.xing) {
    //         case WuXing.MU:
    //             return dz.diZhi === DiZhi.WEI;
    //         case WuXing.TU:
    //             return dz.diZhi === DiZhi.CHEN;
    //         case WuXing.JIN:
    //             return dz.diZhi === DiZhi.CHOU;
    //         case WuXing.SHUI:
    //             return dz.diZhi === DiZhi.CHEN;
    //         case WuXing.HUO:
    //             return dz.diZhi === DiZhi.XU;
    //         default:
    //             return false;
    //     }
    // }

    toString() {
        return WuXing.getWuXingName(this.xing);
    }

    toStringLong() {
        let sb = [];
        switch (this.xing % 5) {
            case WuXing.MU:
                sb.push("木\n主仁\n肝脏\n绿色\n");
                break;
            case WuXing.HUO:
                sb.push("火\n主礼\n心脏\n红色\n");
                break;
            case WuXing.TU:
                sb.push("土\n主信\n脾脏\n黄色\n");
                break;
            case WuXing.JIN:
                sb.push("金\n主义\n肺脏\n白色\n");
                break;
            case WuXing.SHUI:
                sb.push("水\n主智\n肾脏\n黑色\n");
                break;
            default:
                break;
        }
        return sb.join('');
    }

    static getWuXingName(xing) {
        switch (xing % 5) {
            case WuXing.MU:
                return "木";
            case WuXing.HUO:
                return "火";
            case WuXing.TU:
                return "土";
            case WuXing.JIN:
                return "金";
            case WuXing.SHUI:
                return "水";
            default:
                return null;
        }
    }

    // 生, 顺位而生
    static isSheng(xing1, xing2) {
        const x1 = (xing1 + 5) % 5;
        const x2 = (xing2 + 5) % 5;
        return ((x2 - x1) + 5) % 5 === 1;
    }

    // 克, 隔位相克
    static isKe(xing1, xing2) {
        const x1 = (xing1 + 5) % 5;
        const x2 = (xing2 + 5) % 5;
        return ((x2 - x1) + 5) % 5 === 2;
    }
}

WuXing.MU = 0;
WuXing.HUO = 1;
WuXing.TU = 2;
WuXing.JIN = 3;
WuXing.SHUI = 4;

module.exports = WuXing;