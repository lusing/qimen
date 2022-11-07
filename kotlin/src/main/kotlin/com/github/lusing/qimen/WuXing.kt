package com.github.lusing.qimen

open class WuXing(xing: Int) {
    var xing: Int

    init {
        this.xing = (xing + 5) % 5
    }

    fun equals(other: WuXing): Boolean {
        return xing == other.xing
    }

    fun isSheng(xing2: WuXing): Boolean {
        return isSheng(xing, xing2.xing)
    }

    fun isKe(xing2: WuXing): Boolean {
        return isKe(xing, xing2.xing)
    }

    override fun toString(): String {
        return getWuXingName(xing)!!
    }

    fun toStringLong(): String {
        val sb = StringBuilder()
        when (xing % 5) {
            MU -> {
                sb.append("木\n")
                sb.append("主仁\n")
                sb.append("肝脏\n")
                sb.append("绿色\n")
            }
            HUO -> {
                sb.append("火\n")
                sb.append("主礼\n")
                sb.append("心脏\n")
                sb.append("红色\n")
            }
            TU -> {
                sb.append("土\n")
                sb.append("主信\n")
                sb.append("脾脏\n")
                sb.append("黄色\n")
            }
            JIN -> {
                sb.append("金\n")
                sb.append("主义\n")
                sb.append("肺脏\n")
                sb.append("白色\n")
            }
            SHUI -> {
                sb.append("水\n")
                sb.append("主智\n")
                sb.append("肾脏\n")
                sb.append("黑色\n")
            }
            else -> {}
        }
        return sb.toString()
    }

    companion object {
        /**
         * 木
         */
        const val MU = 0

        /**
         * 火
         */
        const val HUO = 1

        /**
         * 土
         */
        const val TU = 2

        /**
         * 金
         */
        const val JIN = 3

        /**
         * 水
         */
        const val SHUI = 4
        fun getWuXingName(xing: Int): String? {
            return when (xing % 5) {
                MU -> "木"
                HUO -> "火"
                TU -> "土"
                JIN -> "金"
                SHUI -> "水"
                else -> null
            }
        }

        //生, 顺位而生
        fun isSheng(xing1: Int, xing2: Int): Boolean {
            val x1 = (xing1 + 5) % 5
            val x2 = (xing2 + 5) % 5
            return (x2 - x1) % 5 == 1
        }

        //克,隔位相克
        fun isKe(xing1: Int, xing2: Int): Boolean {
            val x1 = (xing1 + 5) % 5
            val x2 = (xing2 + 5) % 5
            return (x2 - x1) % 5 == 2
        }
    }
}