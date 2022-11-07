package com.github.lusing.qimen

/**
 *
 * @author Louis
 */
class BaGua(gua: Int) : WuXing(getWuXing(gua % 8)) {
    /**
     * @return the mGua
     */
    val gua: Int

    init {
        this.gua = gua % 8
    }

    override fun toString(): String {
        return sBaGua[gua].toString()
    }

    companion object {
        const val QIAN = 0
        const val KAN = 1
        const val GEN = 2
        const val ZHEN = 3
        const val XUN = 4
        const val LI = 5
        const val KUN = 6
        const val DUI = 7
        const val sBaGua = "乾坎艮震巽离坤兑"
        private fun getWuXing(gua: Int): Int {
            var xing = 0
            when (gua % 8) {
                KAN -> xing = SHUI
                KUN, GEN -> xing = TU
                XUN, ZHEN -> xing = MU
                LI -> xing = HUO
                QIAN, DUI -> xing = JIN
            }
            return xing
        }
    }
}