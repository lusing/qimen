package com.github.lusing.qimen


/**
 *
 * @author Louis
 */
class BaziResult(var status: Int, var method: String) {
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("日主旺衰情况为：")
        when (status) {
            BaziResult.Companion.WANG -> sb.append("旺\n")
            BaziResult.Companion.RUO -> sb.append("弱\n")
            BaziResult.Companion.CONG_QIANG -> sb.append("从强\n")
            BaziResult.Companion.CONG_RUO -> sb.append("从弱\n")
            BaziResult.Companion.JIA_CONG -> {
                sb.append("假从\n")
                sb.append("未知\n")
            }

            else -> sb.append("未知\n")
        }
        sb.append("使用的方法是$method")
        return sb.toString()
    }

    companion object {
        /**
         * 旺
         */
        const val WANG = 0

        /**
         * 弱
         */
        const val RUO = 1

        /**
         * 从强格
         */
        const val CONG_QIANG = 0x10

        /**
         * 从弱格
         */
        const val CONG_RUO = 0x11

        /**
         * 假从格
         */
        const val JIA_CONG = 0x12
        const val UNKNOWN = -1
    }
}
