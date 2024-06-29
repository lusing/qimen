class LiuQin {
    constructor(lq) {
        this.liuqin = LiuQin.XIONGDI;
        this.liuqin = lq;
    }

    getName() {
        switch (this.liuqin) {
            case LiuQin.FUMU:
                return "父母";
            case LiuQin.ZISUN:
                return "子孙";
            case LiuQin.GUANGUI:
                return "官鬼";
            case LiuQin.QICAI:
                return "妻财";
            case LiuQin.XIONGDI:
                return "兄弟";
            default:
                return "";
        }
    }

    equals(other) {
        if (other instanceof LiuQin) {
            return this.liuqin === other.liuqin;
        } else {
            return false;
        }
    }

    static get XIONGDI() {
        return 0;
    }

    static get FUMU() {
        return 1;
    }

    static get ZISUN() {
        return 2;
    }

    static get GUANGUI() {
        return 3;
    }

    static get QICAI() {
        return 4;
    }
}

module.exports = LiuQin;