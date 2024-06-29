const TianGan = require('./tiangan');
const DiZhi = require('./dizhi');
const GanZhi = require('./ganzhi');
const ShiShen = require('./shishen');
const WuXing = require('./wuxing');
const LiuQin = require('./liuqin');

class BaZi {
    constructor(nianGan, nianZhi, yueGan, yueZhi, riGan, riZhi, shiGan, shiZhi, male, qiyun = 0, cal = 0) {
        this.nian = new GanZhi(nianGan, nianZhi);
        this.yue = new GanZhi(yueGan, yueZhi);
        this.ri = new GanZhi(riGan, riZhi);
        this.shi = new GanZhi(shiGan, shiZhi);
        this.wang = 0;
        this.qinYun = qiyun;
        this.year = cal;
        this.male = male;
        this.siZhu = [this.nian, this.yue, this.ri, this.shi];
        this.sshen = [[], []];

        for (const i of this.siZhu) {
            this.sshen[0].push(ShiShen.getShiShen(this.ri.mTg, i.mTg));
            this.sshen[1].push(ShiShen.getShiShen(this.ri.mTg, i.mDz.cangGan[0]));
        }
    }

    calcWang() {
        console.log("=================================================");
        for (const i of this.sshen) {
            for (const j of i) {
                process.stdout.write(j.toString());
            }
            console.log();
        }

        this.checkLingDiZhu();

        const nianGan = this.calcTianGan(this.nian.mTg, 1.0);
        const yueGan = this.calcTianGan(this.yue.mTg, 1.0);
        const riGan = this.calcTianGan(this.ri.mTg, 1.0);
        const shiGan = this.calcTianGan(this.shi.mTg, 1.0);

        const nianZhi = this.calcDiZhi(this.nian.mDz, 1.0);
        const yueZhi = this.calcDiZhi(this.yue.mDz, 1.5);
        const riZhi = this.calcDiZhi(this.ri.mDz, 1.0);
        const shiZhi = this.calcDiZhi(this.shi.mDz, 1.0);

        let result = this.addArray(nianGan, this.addArray(yueGan, this.addArray(riGan, shiGan)));
        result = this.addArray(result, this.addArray(nianZhi, this.addArray(yueZhi, this.addArray(riZhi, shiZhi))));
        console.log(`木: ${result[0]}, 火: ${result[1]}, 土: ${result[2]}, 金: ${result[3]}, 水: ${result[4]}`);

        console.log(this.ri.mTg.getName());
        const x = this.ri.mTg.xing.xing;

        this.wang = result[(x + 4) % 5] + result[x % 5];
        console.log(`旺: ${this.wang}`);

        console.log(result[0] + result[1] + result[2] + result[3] + result[4]);

        this.checkMuKu(); // 查日主墓库
        this.checkCaiKu(); // 查财库
        this.checkRoots(); // 检查是否有根
        this.checkHeChongXingHai(); // 检查合冲刑害
    }

    checkDaYun() {
        console.log("大运：");
        const yang = this.nian.mTg.isYang;
        let year = this.nian.add(this.qinYun);
        let sui = this.qinYun;
        if (yang === this.male) {
            let dy = this.yue.getNext();
            for (let i = 0; i <= 9; i++) {
                process.stdout.write(`${dy.getName()}`);
                const dyfen = this.calcDaYun(dy);
                console.log(dyfen);
                dy = dy.getNext();
                for (let j = 0; j <= 9; j++) {
                    process.stdout.write(`----${year.getName()}`);
                    if (this.year !== 0) {
                        process.stdout.write(` ${this.year + sui}年`);
                    }
                    process.stdout.write(` ${sui}岁 `);
                    process.stdout.write(`${(dyfen * 0.6 + this.calcDaYun(year) * 0.4).toFixed(0)} `);
                    console.log(this.checkTaoHua(year));
                    year = year.getNext();
                    sui++;
                }
            }
        } else {
            let dy = this.yue.getPrev();
            for (let i = 0; i <= 9; i++) {
                process.stdout.write(`${dy.getName()} `);
                const dyfen = this.calcDaYun(dy);
                console.log(dyfen);
                dy = dy.getPrev();
                for (let j = 0; j <= 9; j++) {
                    process.stdout.write(`----${year.getName()}`);
                    if (this.year !== 0) {
                        process.stdout.write(` ${this.year + sui}年`);
                    }
                    process.stdout.write(` ${sui}岁 `);
                    process.stdout.write(`${(dyfen * 0.6 + this.calcDaYun(year) * 0.4).toFixed(0)} `);
                    console.log(this.checkTaoHua(year));
                    year = year.getNext();
                    sui++;
                }
            }
        }
        console.log("-------------------------------");
    }

    calcDaYun(gz) {
        let value;
        const gan = gz.mTg;
        const zhi = gz.mDz;
        const ri = this.ri.mTg;

        if (gan.xing.xing === ri.xing.xing || gan.isSheng(ri)) {
            value = 40 * 0.8;
        } else {
            value = 40 * 0.3;
        }

        if (zhi.xing.xing === ri.xing.xing || zhi.xing.isSheng(ri.xing)) {
            value += 60 * 0.8;
        } else {
            value += 60 * 0.3;
        }
        return Math.round(value);
    }

    calcTianGan(tg, factor) {
        const result = [0, 0, 0, 0, 0];
        if (tg.xing.xing === WuXing.MU) {
            result[0] = Math.round(40.0 * factor);
        } else if (tg.xing.xing === WuXing.HUO) {
            result[1] = Math.round(40.0 * factor);
        } else if (tg.xing.xing === WuXing.TU) {
            result[2] = Math.round(40.0 * factor);
        } else if (tg.xing.xing === WuXing.JIN) {
            result[3] = Math.round(40.0 * factor);
        } else if (tg.xing.xing === WuXing.SHUI) {
            result[4] = Math.round(40.0 * factor);
        }
        return result;
    }

    calcDiZhi(dz, factor2) {
        let result = [0, 0, 0, 0, 0];
        const factor = 2.5 * factor2;
        switch (dz.diZhi) {
            case DiZhi.ZI:
                result = this.calcTianGan(new TianGan(TianGan.GUI), factor);
                break;
            case DiZhi.CHOU:
                result = this.calcTianGan(new TianGan(TianGan.JI), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.GUI), factor * 0.2));
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.XIN), factor * 0.1));
                break;
            case DiZhi.YIN:
                result = this.calcTianGan(new TianGan(TianGan.JIA), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.BING), factor * 0.2));
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.WU), factor * 0.1));
                break;
            case DiZhi.MAO:
                result = this.calcTianGan(new TianGan(TianGan.YI), factor * 1.0);
                break;
            case DiZhi.CHEN:
                result = this.calcTianGan(new TianGan(TianGan.WU), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.YI), factor * 0.2));
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.GUI), factor * 0.1));
                break;
            case DiZhi.SI:
                result = this.calcTianGan(new TianGan(TianGan.BING), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.WU), factor * 0.2));
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.GENG), factor * 0.1));
                break;
            case DiZhi.WU:
                result = this.calcTianGan(new TianGan(TianGan.DING), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.JI), factor * 0.3));
                break;
            case DiZhi.WEI:
                result = this.calcTianGan(new TianGan(TianGan.JI), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.DING), factor * 0.2));
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.YI), factor * 0.1));
                break;
            case DiZhi.SHEN:
                result = this.calcTianGan(new TianGan(TianGan.GENG), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.REN), factor * 0.2));
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.WU), factor * 0.1));
                break;
            case DiZhi.YOU:
                result = this.calcTianGan(new TianGan(TianGan.XIN), factor * 1.0);
                break;
            case DiZhi.XU:
                result = this.calcTianGan(new TianGan(TianGan.WU), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.XIN), factor * 0.2));
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.DING), factor * 0.1));
                break;
            case DiZhi.HAI:
                result = this.calcTianGan(new TianGan(TianGan.REN), factor * 0.7);
                result = this.addArray(result, this.calcTianGan(new TianGan(TianGan.JIA), factor * 0.3));
                break;
        }
        return result;
    }

    addArray(a, b) {
        const result = [0, 0, 0, 0, 0];
        for (let i = 0; i <= 4; i++) {
            result[i] = a[i] + b[i];
        }
        return result;
    }

    checkTaoHua(gz) {
        const riGan = this.ri.mTg;
        const riZhi = this.ri.mDz;
        const ngan = gz.mTg;
        const nzhi = gz.mDz;
        let result = "";

        if (riGan.isKe(ngan)) {
            result += " 桃花年";
        }

        if (riZhi.isChong(nzhi)) {
            result += " 烂桃花";
        }

        if (riZhi.isHe(nzhi)) {
            result += " 好桃花";
        }

        if (riZhi.diZhi === nzhi.diZhi) {
            result += " 婚恋年";
        }

        return result;
    }

    checkLingDiZhu() {
        const ling = this.yue.mDz;
        const riZhu = this.ri.mTg;

        let des = 0;

        if (this.isShengFu(ling.xing, riZhu.xing)) {
            console.log("得令");
            des++;
        } else {
            console.log("不得令");
        }

        let count = 0;
        const nZhi = this.nian.mDz;
        const rZhi = this.ri.mDz;
        const sZhi = this.shi.mDz;

        if (this.isShengFu(nZhi.xing, riZhu.xing)) {
            count++;
        }
        if (this.isShengFu(rZhi.xing, riZhu.xing)) {
            count++;
        }
        if (this.isShengFu(sZhi.xing, riZhu.xing)) {
            count++;
        }
        if (count >= 2) {
            console.log("得地");
            des++;
        } else {
            console.log("不得地");
        }

        const nGan = this.nian.mTg;
        const yGan = this.yue.mTg;
        const sGan = this.shi.mTg;

        let count2 = 0;
        if (this.isShengFu(nGan.xing, riZhu.xing)) {
            count2++;
        }
        if (this.isShengFu(yGan.xing, riZhu.xing)) {
            count2++;
        }
        if (this.isShengFu(sGan.xing, riZhu.xing)) {
            count2++;
        }

        if (count2 >= 2) {
            console.log("得助");
            des++;
        } else {
            console.log("不得助");
        }

        if (des >= 2) {
            console.log("日主旺");
        } else {
            console.log("日主弱");
        }

        if (des === 0) {
            console.log("从弱");
        } else if (des === 1) {
            console.log("身弱");
        } else if (des === 2) {
            console.log("身强");
        } else {
            console.log("从强");
        }
        this.checkYongShen(des);
    }

    checkYongShen(state) {
        let yins = 0;
        let bijies = 0;
        let guans = 0;
        let cais = 0;
        let shishang = 0;

        for (const i of this.sshen) {
            for (const j of i) {
                switch (j.shiShen) {
                    case ShiShen.ZHENGYIN:
                    case ShiShen.PIANYIN:
                        yins++;
                        break;
                    case ShiShen.ZHENGGUAN:
                    case ShiShen.QISHA:
                        guans++;
                        break;
                    case ShiShen.ZHENGCAI:
                    case ShiShen.PIANCAI:
                        cais++;
                        break;
                    case ShiShen.SHISHEN:
                    case ShiShen.SHANGGUAN:
                        shishang++;
                        break;
                    case ShiShen.BIJIAN:
                    case ShiShen.JIECAI:
                        bijies++;
                        break;
                }
            }
        }
        bijies--;

        switch (state) {
            case 1:
                if (yins > 0) {
                    console.log("用神为印");
                    console.log("命中有印，忌神为财");
                }
                if (bijies > 0) {
                    console.log("用神为比劫");
                    console.log("命中有比劫，忌神为官杀");
                }
                break;
            case 2:
                if (guans > 0) {
                    console.log("命中有官杀，用神为官杀");
                    console.log("命中有官杀，忌神为食伤");
                } else {
                    if (shishang > 0) {
                        console.log("命中无官杀，用神为食伤");
                        console.log("忌神为印");
                    }
                }
                if (cais > 0) {
                    console.log("命中有财，用神为财");
                    console.log("忌神为比劫");
                }
                break;
        }
    }

    isShengFu(x1, x2) {
        return x1.xing === x2.xing || x1.isSheng(x2);
    }

    checkMuKu() {
        for (const gz of this.siZhu) {
            if (gz.mDz.getMuKu(this.ri.mTg.xing).diZhi === gz.mDz.diZhi) {
                switch (gz.mDz.diZhi) {
                    case DiZhi.CHEN:
                        console.log("命中出生的时候旁边有河流、湖泊、水库等");
                        break;
                    case DiZhi.XU:
                        console.log("命中出生的时候旁边有学校、电影院、文化局等");
                        break;
                    case DiZhi.CHOU:
                        console.log("命中出生的时候旁边有银行");
                        break;
                    case DiZhi.WEI:
                        console.log("命中出生的时候旁边有公园");
                        break;
                }
            }
        }
    }

    checkCaiKu() {
        const cai = new WuXing(this.ri.mTg.xing.xing + 2);
        for (const gz of this.siZhu) {
            if (gz.mDz.getMuKu(cai).diZhi === gz.mDz.diZhi) {
                console.log("有财库,消费更保守,理财观念好");
            }
        }
    }

    checkRoots() {
        for (const gz of this.siZhu) {
            const xingList = gz.mDz.cangGan.map(tg => tg.xing.xing);
            if (this.ri.mTg.xing.xing in xingList) {
                console.log(`天干${this.ri.mTg.toString()}在地支${gz.mDz.toString()}中有根`);
            }
        }
    }

    checkHeChongXingHai() {
        for (let i = 0; i < this.siZhu.length; i++) {
            for (let j = 0; j < i; j++) {
                if (i === j) continue;
                const gz1 = this.siZhu[i];
                const gz2 = this.siZhu[j];
                const tg1 = gz1.mTg;
                const tg2 = gz2.mTg;
                const dz1 = gz1.mDz;
                const dz2 = gz2.mDz;

                if (tg1.isHe(tg2)) {
                    console.log(`${tg1.toString()}与${tg2.toString()}合`);
                }
                if (tg1.isChong(tg2)) {
                    console.log(`${tg1.toString()}与${tg2.toString()}冲`);
                }
                if (dz1.isHe(dz2)) {
                    console.log(`${dz1.toString()}与${dz2.toString()}合`);
                }
                if (dz1.isChong(dz2)) {
                    console.log(`${dz1.toString()}与${dz2.toString()}冲`);
                }
                if (dz1.isHai(dz2)) {
                    console.log(`${dz1.toString()}与${dz2.toString()}害`);
                }
                if (dz1.isXing2(dz2)) {
                    console.log(`${dz1.toString()}与${dz2.toString()}刑`);
                }
            }
        }
    }
}

module.exports = BaZi;