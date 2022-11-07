package com.github.lusing.qimen


/**
 *
 * @author Louis
 */
class BaMen(men: Int) : WuXing(getWuXing(men % 8)) {
    val men: Int

    init {
        this.men = men % 8
    }

    override fun toString(): String {
        return sBaMen[men].toString()
    }

    companion object {
        /**
         * 休门 五行属水
         */
        const val XIU = 0
        const val SHENG = 1
        const val SHANG = 2
        const val DU = 3
        const val JING3 = 4
        const val SI = 5
        const val JING1 = 6
        const val KAI = 7
        const val sBaMen = "休生伤杜景死惊开"
        private fun getWuXing(men: Int): Int {
            var xing = 0
            when (men % 8) {
                XIU -> xing = SHUI
                SHENG, SI -> xing = TU
                SHANG, DU -> xing = MU
                JING3 -> xing = HUO
                JING1, KAI -> xing = JIN
            }
            return xing
        }
    }
}
