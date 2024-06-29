const LiuQin = require('./liuqin.js');

class ShiShen extends LiuQin {
    constructor() {
        super(LiuQin.XIONGDI);
        this.shiShen = 0;
    }

    toLongString() {
        const sb = [];
        switch (this.shiShen) {
            case ShiShen.ZHENGYIN:
                sb.push("正印（印绶）");
                break;
            case ShiShen.PIANYIN:
                sb.push("偏印（枭）");
                break;
            case ShiShen.SHANGGUAN:
                sb.push("伤官");
                break;
            case ShiShen.SHISHEN:
                sb.push("食神");
                break;
            case ShiShen.ZHENGGUAN:
                sb.push("正官");
                break;
            case ShiShen.QISHA:
                sb.push("七杀(偏官)");
                break;
            case ShiShen.ZHENGCAI:
                sb.push("正财");
                break;
            case ShiShen.PIANCAI:
                sb.push("偏财");
                break;
            case ShiShen.BIJIAN:
                sb.push("比肩");
                break;
            case ShiShen.JIECAI:
                sb.push("劫财");
                break;
            default:
                break;
        }
        return sb.join('');
    }

    toString() {
        const sb = [];
        switch (this.shiShen) {
            case ShiShen.ZHENGYIN:
                sb.push("印");
                break;
            case ShiShen.PIANYIN:
                sb.push("枭");
                break;
            case ShiShen.SHANGGUAN:
                sb.push("伤");
                break;
            case ShiShen.SHISHEN:
                sb.push("食");
                break;
            case ShiShen.ZHENGGUAN:
                sb.push("官");
                break;
            case ShiShen.QISHA:
                sb.push("杀");
                break;
            case ShiShen.ZHENGCAI:
                sb.push("财");
                break;
            case ShiShen.PIANCAI:
                sb.push("才");
                break;
            case ShiShen.BIJIAN:
                sb.push("比");
                break;
            case ShiShen.JIECAI:
                sb.push("劫");
                break;
            default:
                break;
        }
        return sb.join('');
    }

    static get YINXING() {
        return 0x1;
    }

    static get ZHENGYIN() {
        return 0x10;
    }

    static get PIANYIN() {
        return 0x11;
    }

    static get SHISHANG() {
        return 0x2;
    }

    static get SHANGGUAN() {
        return 0x20;
    }

    static get SHISHEN() {
        return 0x21;
    }

    static get ZHENGGUAN() {
        return 0x30;
    }

    static get QISHA() {
        return 0x31;
    }

    static get PIANGUAN() {
        return ShiShen.QISHA;
    }

    static get CAIXING() {
        return 0x4;
    }

    static get ZHENGCAI() {
        return 0x40;
    }

    static get PIANCAI() {
        return 0x41;
    }

    static get BIJIE() {
        return 0x05;
    }

    static get JIECAI() {
        return 0x50;
    }

    static get BIJIAN() {
        return 0x51;
    }

    static getShiShen(me, other) {
        const ss1 = new ShiShen();
        const sum = me.tianGan + other.tianGan;
        const isSame = sum % 2 === 0;
        if (other.isSheng(me)) {
            ss1.liuqin = LiuQin.FUMU;
            ss1.shiShen = isSame ? ShiShen.PIANYIN : ShiShen.ZHENGYIN;
        } else if (me.isSheng(other)) {
            ss1.liuqin = LiuQin.ZISUN;
            ss1.shiShen = isSame ? ShiShen.SHISHEN : ShiShen.SHANGGUAN;
        } else if (other.isKe(me)) {
            ss1.liuqin = LiuQin.GUANGUI;
            ss1.shiShen = isSame ? ShiShen.QISHA : ShiShen.ZHENGGUAN;
        } else if (me.isKe(other)) {
            ss1.liuqin = LiuQin.QICAI;
            ss1.shiShen = isSame ? ShiShen.PIANCAI : ShiShen.ZHENGCAI;
        } else {
            ss1.liuqin = LiuQin.XIONGDI;
            ss1.shiShen = isSame ? ShiShen.BIJIAN : ShiShen.JIECAI;
        }
        return ss1;
    }
}

module.exports = ShiShen;
