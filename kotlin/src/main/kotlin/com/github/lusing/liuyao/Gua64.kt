package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi
import com.github.lusing.qimen.LiuQin
import com.github.lusing.qimen.TianGan

/**
 * 六十四卦配六爻
 */
class Gua64 {
    val value: Int
    val riGan: TianGan
    var yaos: Array<Yao>
    lateinit var gong: Gua8

//    constructor(value: Int) {
//        this.value = value
//        var yao = Yao(8)
//        yaos = arrayOf(yao, yao, yao, yao, yao, yao)
//    }

//    constructor(lowNum: Int, highNum: Int) {
//        val lowGua = Gua8(lowNum)
//        val highGua = Gua8(highNum)
//        this.value = (highGua.value.shl(3)) + lowGua.value
//        var yao = Yao(8)
//        yaos = arrayOf(yao, yao, yao, yao, yao, yao)
//    }

    constructor(first: Int, second: Int, third: Int, fourth: Int, fifth: Int, sixth: Int, rg: Int) {
        var value = 0

        var yao = Yao(8)
        yaos = arrayOf(yao, yao, yao, yao, yao, yao)

        for (i in 0..5) {
            var yao = Yao(8)
            yaos[i] = yao
        }

        if (first % 2 == 1) {
            value = value.or(0b00000001)
            this.yaos[0].isYang = true
        } else {
            this.yaos[0].isYang = false
        }
        if (second % 2 == 1) {
            value = value.or(0b00000010)
            this.yaos[1].isYang = true
        } else {
            this.yaos[1].isYang = false
        }
        if (third % 2 == 1) {
            value = value.or(0b00000100)
            this.yaos[2].isYang = true
        } else {
            this.yaos[2].isYang = false
        }
        if (fourth % 2 == 1) {
            value = value.or(0b00001000)
            this.yaos[3].isYang = true
        } else {
            this.yaos[3].isYang = false
        }
        if (fifth % 2 == 1) {
            value = value.or(0b00010000)
            this.yaos[4].isYang = true
        } else {
            this.yaos[4].isYang = false
        }
        if (sixth % 2 == 1) {
            value = value.or(0b00100000)
            this.yaos[5].isYang = true
        } else {
            this.yaos[5].isYang = false
        }
        this.value = value
        this.riGan = TianGan(rg)
        this.paiPan()
    }

    constructor(values: Array<Int>, rg: Int) {
        var value = 0
        if (values[0] % 2 == 1) value = value.or(0b00000001)
        if (values[1] % 2 == 1) value = value.or(0b00000010)
        if (values[2] % 2 == 1) value = value.or(0b00000100)
        if (values[3] % 2 == 1) value = value.or(0b00001000)
        if (values[4] % 2 == 1) value = value.or(0b00010000)
        if (values[5] % 2 == 1) value = value.or(0b00100000)

        this.yaos = arrayOf(Yao(8), Yao(8), Yao(8), Yao(8), Yao(8), Yao(8))

        for (i in 0..5) {
            this.yaos[i] = Yao(values[i])
        }
        this.value = value
        this.riGan = TianGan(rg)
        this.paiPan()
    }

    constructor(yaos: Array<Yao>, rg: Int) {
        var value = 0
        if (yaos[0].isYang) value = value.or(0b00000001)
        if (yaos[1].isYang) value = value.or(0b00000010)
        if (yaos[2].isYang) value = value.or(0b00000100)
        if (yaos[3].isYang) value = value.or(0b00001000)
        if (yaos[4].isYang) value = value.or(0b00010000)
        if (yaos[5].isYang) value = value.or(0b00100000)
        this.value = value
        //this.yaos = yaos
        this.riGan = TianGan(rg)
        this.yaos = arrayOf(Yao(8), Yao(8), Yao(8), Yao(8), Yao(8), Yao(8))
        for (i in 0..5) {
            this.yaos[i].isYang = yaos[i].isYang
            //println("this.yaos[$i].isYang = ${this.yaos[i].isYang}")
            //println("this.yaos[$i].isShi = ${this.yaos[i].isShi}")
        }
        this.paiPan()
    }

    /**
     * 根据上下卦来生成六爻
     */
    constructor(xiaGua: Gua8, shangGua: Gua8, rg: Int) {
        this.value = (shangGua.value.shl(3)) + xiaGua.value
        this.riGan = TianGan(rg)
        var yao = Yao(8)
        this.yaos = arrayOf(yao, yao, yao, yao, yao, yao)
        for (i in 0..2) {
            this.yaos[i] = Yao(8)
            this.yaos[i].isYang = xiaGua.value.and(0b00000001.shl(i)) != 0
        }
        for (i in 3..5) {
            this.yaos[i] = Yao(8)
            this.yaos[i].isYang = shangGua.value.and(0b00000001.shl(i - 3)) != 0
        }
        this.paiPan()
    }

    fun getBianGua(): Gua64 {

        var bianYao = arrayOf<Yao>(Yao(8), Yao(8), Yao(8), Yao(8), Yao(8), Yao(8))
        for (i in 0..5) {
            if (this.yaos[i].isChange) {
                bianYao[i].isYang = this.yaos[i].isYang.not()
            } else {
                bianYao[i].isYang = this.yaos[i].isYang
            }
            bianYao[i].isChange = false
        }
        var bg = Gua64(bianYao, this.riGan.tianGan)
        //println(this.gong.getName())
        bg.updateLiuQin(this.gong)
        //println("[debug]本卦为：${this.getName()}")
        //println("[debug]变卦为：${bg.getName()}")
        return bg
    }

    fun debug() {
        for (i in 0..5) {
            print("yao ${i + 1} is ${if (this.yaos[i].isYang) "阳" else "阴"}")
            print("yao ${i + 1} is ${if (this.yaos[i].isChange) "动" else "静"}")
            println("爻")
        }
    }

    fun getGuaArray(): Array<Boolean> {
        val result = arrayOf(false, false, false, false, false, false)
        if (value.and(0b00000001) == 0b00000001) result[0] = true
        if (value.and(0b00000010) == 0b00000010) result[1] = true
        if (value.and(0b00000100) == 0b00000100) result[2] = true
        if (value.and(0b00001000) == 0b00001000) result[3] = true
        if (value.and(0b00010000) == 0b00010000) result[4] = true
        if (value.and(0b00100000) == 0b00100000) result[5] = true
        return result
    }

    /*
     * 取下卦
     */
    fun getLow(): Gua8 {
        val value = this.value.and(0b000111)
        //fmt.Printf("%b", value)
        var gua = Gua8(value, false)
        return gua
    }

    fun getHigh(): Gua8 {
        var value = this.value.and(0b111000)
        value = value.ushr(3)
        var gua = Gua8(value, false)
        return gua
    }

    fun paiPan() {
        var xiaGua = this.getLow()
        var shangGua = this.getHigh()

        //println("[Debug]下卦：${xiaGua.getName()}, 上卦：${shangGua.getName()}")

        when (xiaGua.value % 8) {
            0b000 -> // 坤 未巳卯
            {
                this.yaos[0].naZhi = DiZhi(DiZhi.WEI)
                this.yaos[1].naZhi = DiZhi(DiZhi.SI)
                this.yaos[2].naZhi = DiZhi(DiZhi.MAO)
            }

            0b001, 0b111 -> // 震 子寅辰
            {
                //println("下卦：震，乾")
                this.yaos[0].naZhi = DiZhi(DiZhi.ZI)
                this.yaos[1].naZhi = DiZhi(DiZhi.YIN)
                this.yaos[2].naZhi = DiZhi(DiZhi.CHEN)
            }

            0b010 -> // 坎 寅辰午
            {
                this.yaos[0].naZhi = DiZhi(DiZhi.YIN)
                this.yaos[1].naZhi = DiZhi(DiZhi.CHEN)
                this.yaos[2].naZhi = DiZhi(DiZhi.WU)
            }

            0b011 -> // 兑 巳卯丑
            {
                this.yaos[0].naZhi = DiZhi(DiZhi.SI)
                this.yaos[1].naZhi = DiZhi(DiZhi.MAO)
                this.yaos[2].naZhi = DiZhi(DiZhi.CHOU)
            }

            0b100 -> // 艮 辰午申
            {
                this.yaos[0].naZhi = DiZhi(DiZhi.CHEN)
                this.yaos[1].naZhi = DiZhi(DiZhi.WU)
                this.yaos[2].naZhi = DiZhi(DiZhi.SHEN)
            }

            0b101 -> // 离 卯丑亥
            {
                this.yaos[0].naZhi = DiZhi(DiZhi.MAO)
                this.yaos[1].naZhi = DiZhi(DiZhi.CHOU)
                this.yaos[2].naZhi = DiZhi(DiZhi.HAI)
            }

            0b110 -> // 巽 丑亥酉
            {
                this.yaos[0].naZhi = DiZhi(DiZhi.CHOU)
                this.yaos[1].naZhi = DiZhi(DiZhi.HAI)
                this.yaos[2].naZhi = DiZhi(DiZhi.YOU)
            }
        }

        when (shangGua.value % 8) {
            0b000 -> // 坤 丑亥酉
            {
                this.yaos[3].naZhi = DiZhi(DiZhi.CHOU)
                this.yaos[4].naZhi = DiZhi(DiZhi.HAI)
                this.yaos[5].naZhi = DiZhi(DiZhi.YOU)
            }

            0b001, 0b111 -> // 震 午申戌
            {
                //println("上卦：震，乾")
                this.yaos[3].naZhi = DiZhi(DiZhi.WU)
                this.yaos[4].naZhi = DiZhi(DiZhi.SHEN)
                this.yaos[5].naZhi = DiZhi(DiZhi.XU)
            }

            0b010 -> // 坎 申戌子
            {
                this.yaos[3].naZhi = DiZhi(DiZhi.SHEN)
                this.yaos[4].naZhi = DiZhi(DiZhi.XU)
                this.yaos[5].naZhi = DiZhi(DiZhi.ZI)
            }

            0b011 -> // 兑 亥酉未
            {
                //println("兑")
                this.yaos[3].naZhi = DiZhi(DiZhi.HAI)
                this.yaos[4].naZhi = DiZhi(DiZhi.YOU)
                this.yaos[5].naZhi = DiZhi(DiZhi.WEI)
            }

            0b100 -> // 艮 戌子寅
            {
                this.yaos[3].naZhi = DiZhi(DiZhi.XU)
                this.yaos[4].naZhi = DiZhi(DiZhi.ZI)
                this.yaos[5].naZhi = DiZhi(DiZhi.YIN)
            }

            0b101 -> // 离 酉未巳
            {
                this.yaos[3].naZhi = DiZhi(DiZhi.YOU)
                this.yaos[4].naZhi = DiZhi(DiZhi.WEI)
                this.yaos[5].naZhi = DiZhi(DiZhi.SI)
            }

            0b110 -> // 巽 未巳卯
            {
                this.yaos[3].naZhi = DiZhi(DiZhi.WEI)
                this.yaos[4].naZhi = DiZhi(DiZhi.SI)
                this.yaos[5].naZhi = DiZhi(DiZhi.MAO)
            }
        }

        this.gong = shangGua

        if (this.yaos[2].isYang == this.yaos[5].isYang &&
            this.yaos[1].isYang != this.yaos[4].isYang &&
            this.yaos[0].isYang != this.yaos[3].isYang
        ) {
            // 天同二世
            this.yaos[1].isShi = true
            this.yaos[4].isYing = true
            this.gong = shangGua
            //println("[Debug]天同二世")
        } else if (this.yaos[2].isYang != this.yaos[5].isYang &&
            this.yaos[1].isYang == this.yaos[4].isYang &&
            this.yaos[0].isYang == this.yaos[3].isYang
        ) {
            this.yaos[4].isShi = true
            this.yaos[1].isYing = true
            gong = xiaGua.getFan()
            //println("[Debug]天变五")
        } else if ((this.yaos[0].isYang == this.yaos[3].isYang) &&
            (this.yaos[1].isYang != this.yaos[4].isYang) &&
            (this.yaos[2].isYang != this.yaos[5].isYang)
        ) {
            this.yaos[3].isShi = true
            this.yaos[0].isYing = true
            gong = xiaGua.getFan()
            //println("[Debug]地同四世")
        } else if (this.yaos[0].isYang != this.yaos[3].isYang &&
            this.yaos[1].isYang == this.yaos[4].isYang &&
            this.yaos[2].isYang == this.yaos[5].isYang
        ) {
            this.yaos[0].isShi = true
            this.yaos[3].isYing = true
            this.gong = shangGua
            //println("[Debug]地变初，一世")
        } else if (this.yaos[1].isYang == this.yaos[4].isYang &&
            this.yaos[0].isYang != this.yaos[3].isYang &&
            this.yaos[2].isYang != this.yaos[5].isYang
        ) {
            this.yaos[3].isShi = true
            this.yaos[0].isYing = true
            gong = xiaGua.getFan()
            //println(xiaGua.getName())
            //println(gong.getName())
            //println("[Debug]人同游魂")
        } else if (this.yaos[1].isYang != this.yaos[4].isYang &&
            this.yaos[0].isYang == this.yaos[3].isYang &&
            this.yaos[2].isYang == this.yaos[5].isYang
        ) {
            this.yaos[2].isShi = true
            this.yaos[5].isYing = true
            this.gong = xiaGua
            //println("[Debug]人变归魂")
        }

        // 宫主
        if (xiaGua.value == shangGua.value) {
            //println("[Debug]本卦六世")
            this.yaos[5].isShi = true
            this.yaos[2].isYing = true
            this.gong = xiaGua
        } else if (xiaGua.value == shangGua.getFan().value) {
            //println("[Debug]三世卦")
            this.yaos[2].isShi = true
            this.yaos[5].isYing = true
            this.gong = shangGua
        }

        //println("[Debug]宫主：${this.gong.getName()}")
//        for(i in 0..5){
//            println("[Debug]${this.yaos[i].naZhi.getName()} ${this.yaos[i].isShi} ${this.yaos[i].isYing}")
//        }

        //定六亲
        this.updateLiuQin(gong)

        for (i in 0..5) {
            when (this.riGan.tianGan) {
                TianGan.JIA, TianGan.YI -> this.yaos[i].liuShen = LiuShen((LiuShen.QINGLONG + i) % 6)
                TianGan.BING, TianGan.DING -> this.yaos[i].liuShen = LiuShen((LiuShen.ZHUQUE + i) % 6)
                TianGan.WU -> this.yaos[i].liuShen = LiuShen((LiuShen.GOUCHEN + i) % 6)
                TianGan.JI -> this.yaos[i].liuShen = LiuShen((LiuShen.TENGSHE + i) % 6)
                TianGan.GENG, TianGan.XIN -> this.yaos[i].liuShen = LiuShen((LiuShen.BAIHU + i) % 6)
                TianGan.REN, TianGan.GUI -> this.yaos[i].liuShen = LiuShen((LiuShen.XUANWU + i) % 6)
            }
        }
    }

    fun updateLiuQin(gong: Gua8) {
        val fullLq = setOf(LiuQin.QICAI, LiuQin.FUMU, (LiuQin.ZISUN), (LiuQin.GUANGUI), (LiuQin.XIONGDI))
        var lqSet = setOf<Int>()
        for (i in 0..5) {
            if (this.yaos[i].naZhi.xing.xing == gong.xing) {
                //println("兄弟")
                this.yaos[i].lq = LiuQin(LiuQin.XIONGDI)
                lqSet = lqSet.plusElement((LiuQin.XIONGDI))
            } else if (this.yaos[i].naZhi.xing.isSheng(gong.getWuXing())) {
                this.yaos[i].lq = LiuQin(LiuQin.FUMU)
                //println("父母")
                lqSet = lqSet.plusElement((LiuQin.FUMU))
            } else if (this.yaos[i].naZhi.xing.isKe(gong.getWuXing())) {
                this.yaos[i].lq = LiuQin(LiuQin.GUANGUI)
                //println("官鬼")
                lqSet = lqSet.plusElement((LiuQin.GUANGUI))
            } else if (gong.getWuXing().isSheng(this.yaos[i].naZhi.xing)) {
                this.yaos[i].lq = LiuQin(LiuQin.ZISUN)
                //println("子孙")
                lqSet = lqSet.plusElement((LiuQin.ZISUN))
            } else if (gong.getWuXing().isKe(this.yaos[i].naZhi.xing)) {
                this.yaos[i].lq = LiuQin(LiuQin.QICAI)
                //println("妻财")
                lqSet = lqSet.plusElement((LiuQin.QICAI))
            }
        }
        val missedLq = fullLq.minus(lqSet)
        //println(missedLq.size)
        for (i in missedLq) {
            //println("[Debug]缺少六亲：${LiuQin(i).getName()}")
            findFuYao(liuQin = LiuQin(i))
        }
    }

    fun findFuYao(liuQin: LiuQin) {
        val gong2 = this.gong
        val gua2 = Gua64(gong2, gong2, this.riGan.tianGan)
        //println("[伏神]首卦为：${gua2.getName()}")
        //println("[伏神]首卦的六亲")
        for (i in 5 downTo 0) {
            if (liuQin == gua2.yaos[i].lq) {
                this.yaos[i].fuShen = gua2.yaos[i]
            }
        }
    }

    override fun toString(): String {
        return this.getName()
    }

    fun getName(): String {
        when (this.value) {
            0b000000 -> return "坤为地"
            0b000001 -> return "地雷复"
            0b000010 -> return "地水师"
            0b000011 -> return "地泽临"
            0b000100 -> return "地山谦"
            0b000101 -> return "地火明夷"
            0b000110 -> return "地风升"
            0b000111 -> return "地天泰"
            0b001000 -> return "雷地豫"
            0b001001 -> return "震为雷"
            0b001010 -> return "雷水解"
            0b001011 -> return "雷泽归妹"
            0b001100 -> return "雷山小过"
            0b001101 -> return "雷火丰"
            0b001110 -> return "雷风恒"
            0b001111 -> return "雷天大壮"
            0b010000 -> return "水地比"
            0b010001 -> return "水雷屯"
            0b010010 -> return "坎为水"
            0b010011 -> return "水泽节"
            0b010100 -> return "水山蹇"
            0b010101 -> return "水火既济"
            0b010110 -> return "水风井"
            0b010111 -> return "水天需"
            0b011000 -> return "泽地萃"
            0b011001 -> return "泽雷随"
            0b011010 -> return "泽水困"
            0b011011 -> return "兑为泽"
            0b011100 -> return "泽山咸"
            0b011101 -> return "泽火革"
            0b011110 -> return "泽风大过"
            0b011111 -> return "泽天夬"
            0b100000 -> return "山地剥"
            0b100001 -> return "山雷颐"
            0b100010 -> return "山水蒙"
            0b100011 -> return "山泽损"
            0b100100 -> return "艮为山"
            0b100101 -> return "山火贲"
            0b100110 -> return "山风蛊"
            0b100111 -> return "山天大畜"
            0b101000 -> return "火地晋"
            0b101001 -> return "火雷噬嗑"
            0b101010 -> return "火水未济"
            0b101011 -> return "火泽睽"
            0b101100 -> return "火山旅"
            0b101101 -> return "离为火"
            0b101110 -> return "火风鼎"
            0b101111 -> return "火天大有"
            0b110000 -> return "风地观"
            0b110001 -> return "风雷益"
            0b110010 -> return "风水涣"
            0b110011 -> return "风泽中孚"
            0b110100 -> return "风山渐"
            0b110101 -> return "风火家人"
            0b110110 -> return "巽为风"
            0b110111 -> return "风天小畜"
            0b111000 -> return "天地否"
            0b111001 -> return "天雷无妄"
            0b111010 -> return "天水讼"
            0b111011 -> return "天泽履"
            0b111100 -> return "天山遁"
            0b111101 -> return "天火同人"
            0b111110 -> return "天风姤"
            0b111111 -> return "乾为天"
            else -> return "周文王也不知道"
        }
    }
}