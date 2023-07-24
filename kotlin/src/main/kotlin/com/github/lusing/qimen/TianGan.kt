package com.github.lusing.qimen

class TianGan(tg: Int) {
    override fun toString(): String {
        return sTianGan[tianGan].toString()
    }

    val tianGan: Int

    init {
        tianGan = tg % 10
    }

    fun getNext(): TianGan {
        return TianGan((tianGan + 1) % 10)
    }

    fun getPrev(): TianGan {
        return TianGan((tianGan + 9) % 10)
    }

    val xing: WuXing
        get() = WuXing(tianGan / 2)
    val isYang: Boolean
        get() = tianGan % 2 == 0

    fun getName(): String {
        return sTianGan[tianGan].toString()
    }

    /**
     * 生
     * @param tg2
     * @return
     */
    fun isSheng(tg2: TianGan): Boolean {
        return xing.isSheng(tg2.xing)
    }

    /**
     * 克
     * @param tg2
     * @return
     */
    fun isKe(tg2: TianGan): Boolean {
        return xing.isKe(tg2.xing)
    }

    /**
     * 冲
     * @param tg2
     * @return
     */
    fun isChong(tg2: TianGan): Boolean {
        var zR = false
        if (tianGan == JIA && tg2.tianGan == GENG || tianGan == YI && tg2.tianGan == XIN || tianGan == BING && tg2.tianGan == REN || tianGan == DING && tg2.tianGan == GUI) zR =
            true
        return zR
    }

    fun isHe(tg2: TianGan): WuXing? {
        return if (isHe(this, tg2) == null) {
            isHe(tg2, this)
        } else {
            isHe(this, tg2)
        }
    }

    fun getHe(): TianGan {
        var tg2 = TianGan(this.tianGan + 5)
        return tg2
    }

    fun getRomance(): String {
        when (this.tianGan) {
            JIA -> return ("庄重威仪、城府深、不怒而威、气质高雅、自负傲物、冷酷武断、孤独寂寞")
            YI -> return ("温柔贤惠、仁慈善良、柔情似水、娴于世故、优柔寡断")
            BING -> return ("英武雄猛、光明直爽、脾气急躁、热情好客")
            DING -> return ("精致细腻、洞察力强、锋芒毕露")
            WU -> return ("诚实守信、有条不紊、大智若愚、固执麻木、拙嘴笨舌")
            JI -> return ("温顺沉静、诡计多端、机智圆滑")
            GENG -> return ("大义凛然、刚键锐利、勇猛威严")
            XIN -> return ("思想叛逆、性格偏激、阴谋鬼计")
            REN -> return ("圆滑多变、聪明伶俐、目标迷茫、性情不定")
            GUI -> return ("多愁善感、多情多欲、犹豫不决、聪明")
            else -> return ("")
        }
    }

    companion object {
        const val JIA = 0
        const val YI = 1
        const val BING = 2
        const val DING = 3
        const val WU = 4
        const val JI = 5
        const val GENG = 6
        const val XIN = 7
        const val REN = 8
        const val GUI = 9
        const val sTianGan = "甲乙丙丁戊己庚辛壬癸"

        fun isHe(tg1: TianGan, tg2: TianGan): WuXing? {
            return if (tg1.tianGan == JIA && tg2.tianGan == JI) WuXing(
                WuXing.TU
            ) else if (tg1.tianGan == YI && tg2.tianGan == GENG) WuXing(
                WuXing.JIN
            ) else if (tg1.tianGan == BING && tg2.tianGan == XIN) WuXing(
                WuXing.SHUI
            ) else if (tg1.tianGan == DING && tg2.tianGan == REN) WuXing(
                WuXing.MU
            ) else if (tg1.tianGan == WU && tg2.tianGan == GUI) WuXing(
                WuXing.HUO
            ) else null
        }
    }
}