package com.github.lusing.liuyao

import com.github.lusing.qimen.DiZhi

class LiuYao constructor(gua: Gua64) {
    var benGua = gua
    lateinit var bianGua: Gua64
    fun paiPan() {
        this.bianGua = benGua.getBianGua()
        println(this.bianGua.getName())

        var xiaGua = benGua.getLow()
        var shangGua = benGua.getHigh()

        when (xiaGua.value) {
            0b000 -> // 坤 未巳卯
            {
                benGua.yaos[0].naZhi = DiZhi(DiZhi.WEI)
                benGua.yaos[1].naZhi = DiZhi(DiZhi.SI)
                benGua.yaos[2].naZhi = DiZhi(DiZhi.MAO)
            }

            0b001, 0b111 -> // 震 子寅辰
            {
                benGua.yaos[0].naZhi = DiZhi(DiZhi.ZI)
                benGua.yaos[1].naZhi = DiZhi(DiZhi.YIN)
                benGua.yaos[2].naZhi = DiZhi(DiZhi.CHEN)
            }

            0b010 -> // 坎 寅辰午
            {
                benGua.yaos[0].naZhi = DiZhi(DiZhi.YIN)
                benGua.yaos[1].naZhi = DiZhi(DiZhi.CHEN)
                benGua.yaos[2].naZhi = DiZhi(DiZhi.WU)
            }

            0b011 -> // 兑 巳卯丑
            {
                benGua.yaos[0].naZhi = DiZhi(DiZhi.SI)
                benGua.yaos[1].naZhi = DiZhi(DiZhi.MAO)
                benGua.yaos[2].naZhi = DiZhi(DiZhi.CHOU)
            }

            0b100 -> // 艮 辰午申
            {
                benGua.yaos[0].naZhi = DiZhi(DiZhi.CHEN)
                benGua.yaos[1].naZhi = DiZhi(DiZhi.WU)
                benGua.yaos[2].naZhi = DiZhi(DiZhi.SHEN)
            }

            0b101 -> // 离 卯丑亥
            {
                benGua.yaos[0].naZhi = DiZhi(DiZhi.MAO)
                benGua.yaos[1].naZhi = DiZhi(DiZhi.CHOU)
                benGua.yaos[2].naZhi = DiZhi(DiZhi.HAI)
            }

            0b110 -> // 巽 丑亥酉
            {
                benGua.yaos[0].naZhi = DiZhi(DiZhi.CHOU)
                benGua.yaos[1].naZhi = DiZhi(DiZhi.HAI)
                benGua.yaos[2].naZhi = DiZhi(DiZhi.YOU)
            }
        }

        when (shangGua.value) {
            0b000 -> // 坤 丑亥酉
            {
                benGua.yaos[3].naZhi = DiZhi(DiZhi.CHOU)
                benGua.yaos[4].naZhi = DiZhi(DiZhi.HAI)
                benGua.yaos[5].naZhi = DiZhi(DiZhi.YOU)
            }

            0b001, 0b111 -> // 震 午申戌
            {
                benGua.yaos[3].naZhi = DiZhi(DiZhi.WU)
                benGua.yaos[4].naZhi = DiZhi(DiZhi.SHEN)
                benGua.yaos[5].naZhi = DiZhi(DiZhi.XU)
            }

            0b010 -> // 坎 申戌子
            {
                benGua.yaos[3].naZhi = DiZhi(DiZhi.SHEN)
                benGua.yaos[4].naZhi = DiZhi(DiZhi.XU)
                benGua.yaos[5].naZhi = DiZhi(DiZhi.ZI)
            }

            0b011 -> // 兑 亥酉未
            {
                benGua.yaos[3].naZhi = DiZhi(DiZhi.HAI)
                benGua.yaos[4].naZhi = DiZhi(DiZhi.YOU)
                benGua.yaos[5].naZhi = DiZhi(DiZhi.WEI)
            }

            0b100 -> // 艮 戌子寅
            {
                benGua.yaos[3].naZhi = DiZhi(DiZhi.XU)
                benGua.yaos[4].naZhi = DiZhi(DiZhi.ZI)
                benGua.yaos[5].naZhi = DiZhi(DiZhi.YIN)
            }

            0b101 -> // 离 酉未巳
            {
                benGua.yaos[3].naZhi = DiZhi(DiZhi.YOU)
                benGua.yaos[4].naZhi = DiZhi(DiZhi.WEI)
                benGua.yaos[5].naZhi = DiZhi(DiZhi.SI)
            }

            0b110 -> // 巽 未巳卯
            {
                benGua.yaos[3].naZhi = DiZhi(DiZhi.WEI)
                benGua.yaos[4].naZhi = DiZhi(DiZhi.SI)
                benGua.yaos[5].naZhi = DiZhi(DiZhi.MAO)
            }
        }

        var gong : Gua8

        if (benGua.yaos[2].isYang == benGua.yaos[5].isYang &&
                benGua.yaos[2].isYang == benGua.yaos[5].isYang &&
                benGua.yaos[2].isYang == benGua.yaos[5].isYang){
            // 天同二世
            benGua.yaos[1].isShi = true
            benGua.yaos[4].isYing = true
            benGua.gong = shangGua
            //println("天同二世")
        } else if (benGua.yaos[2].isYang != benGua.yaos[5].isYang &&
                benGua.yaos[1].isYang == benGua.yaos[4].isYang &&
                benGua.yaos[0].isYang == benGua.yaos[3].isYang) {
            benGua.yaos[4].isShi = true
            benGua.yaos[1].isYing = true
            println("天变五")
        } else if (benGua.yaos[0].isYang == benGua.yaos[3].isYang &&
                benGua.yaos[1].isYang != benGua.yaos[4].isYang &&
                benGua.yaos[2].isYang != benGua.yaos[5].isYang) {
            benGua.yaos[3].isShi = true
            benGua.yaos[0].isYing = true
            //gong = xiaGua.GetFan()
            println("地同四世")
        } else if (benGua.yaos[0].isYang != benGua.yaos[3].isYang &&
                benGua.yaos[1].isYang == benGua.yaos[4].isYang &&
                benGua.yaos[2].isYang == benGua.yaos[5].isYang) {
            benGua.yaos[0].isShi = true
            benGua.yaos[3].isYing = true
            gong = shangGua
            println("地变初，一世")
        } else if (benGua.yaos[1].isYang == benGua.yaos[4].isYang &&
                benGua.yaos[0].isYang != benGua.yaos[3].isYang &&
                benGua.yaos[2].isYang != benGua.yaos[5].isYang) {
            benGua.yaos[3].isShi = true
            benGua.yaos[0].isYing = true
            //gong = xiaGua.GetFan()
            println("人同游魂")
        } else if (benGua.yaos[1].isYang != benGua.yaos[4].isYang &&
                benGua.yaos[0].isYang == benGua.yaos[3].isYang &&
                benGua.yaos[2].isYang == benGua.yaos[5].isYang) {
            benGua.yaos[2].isShi = true
            benGua.yaos[5].isYing = true
            gong = xiaGua
            println("人变归魂")
        }

        // 宫主
        if (xiaGua.value == shangGua.value) {
            benGua.yaos[0].isShi = true
            benGua.yaos[3].isYing = true
            gong = shangGua
        }
    }
}
