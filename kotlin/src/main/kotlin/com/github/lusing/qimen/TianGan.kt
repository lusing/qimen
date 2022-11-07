package com.github.lusing.qimen

class TianGan(tg: Int) {
    override fun toString(): String {
        return sTianGan[tianGan].toString()
    }

    val tianGan: Int

    init {
        tianGan = tg % 10
    }

    val xing: WuXing
        get() = WuXing(tianGan / 2)
    val isYang: Boolean
        get() = tianGan % 2 == 0

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