package com.github.lusing.qimen


/**
 *
 * @author Louis
 */
class JiuXing(xing: Int) : WuXing(getWuXing(xing)) {
    private val mXing: Int

    init {
        mXing = xing % 8
    }

    override fun toString(): String {
        return sBaMen[mXing].toString()
    }

    companion object {
        const val PENG = 0
        const val REN = 1
        const val CHONG = 2
        const val FU = 3
        const val YING = 4
        const val RUI = 5
        const val ZHU = 6
        const val XIN = 7
        const val sBaMen = "蓬任冲辅英芮柱心"
        private fun getWuXing(star: Int): Int {
            var xing = 0
            when (star) {
                PENG -> xing = SHUI
                REN, RUI -> xing = TU
                CHONG, FU -> xing = MU
                YING -> xing = HUO
                ZHU, XIN -> xing = JIN
            }
            return xing
        }
    }
}
