const TianGan = require('./tiangan');
const DiZhi = require('./dizhi');

class GanZhi {
    constructor(tg, dz) {
        if (typeof tg === 'number' && typeof dz === 'number') {
            this.mTg = new TianGan(tg);
            this.mDz = new DiZhi(dz);
        } else if (typeof tg === 'number' && dz === undefined) {
            const year = tg;
            const stemIndex = (year - 1984) % 10;
            const branchIndex = (year - 1984) % 12;

            this.mTg = new TianGan((stemIndex + 10) % 10);
            this.mDz = new DiZhi((branchIndex + 12) % 12);

            console.log(`${year}年为${this.getName()}年`);
        } else {
            this.mTg = tg;
            this.mDz = dz;
        }
    }

    temp(year) {
        // Function implementation if needed
    }

    getNext() {
        return new GanZhi(this.mTg.getNext(), this.mDz.getNext());
    }

    getPrev() {
        return new GanZhi(this.mTg.getPrev(), this.mDz.getPrev());
    }

    add(i) {
        let gz = this;
        for (let j = 1; j <= i; j++) {
            gz = gz.getNext();
        }
        return gz;
    }

    getXunKong() {
        const diff = (this.mDz.diZhi - this.mTg.tianGan + 12) % 12;
        let xunKong = new Set();
        const dz1 = new DiZhi((diff + 11) % 12).diZhi;
        const dz2 = new DiZhi((diff + 10) % 12).diZhi;
        xunKong.add(dz1);
        xunKong.add(dz2);
        return xunKong;
    }

    getXunKongNames() {
        const xk = this.getXunKong();
        let xkNames = "";
        for (const dz of xk) {
            xkNames += new DiZhi(dz).getName();
        }
        return xkNames;
    }

    isXunKong(dz) {
        const xk = this.getXunKong();
        return xk.has(dz.diZhi);
    }

    getName() {
        return this.mTg.getName() + this.mDz.getName();
    }
}

module.exports = GanZhi;