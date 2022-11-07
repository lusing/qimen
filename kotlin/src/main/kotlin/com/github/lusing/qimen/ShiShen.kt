package com.github.lusing.qimen

open class ShiShen() : LiuQin() {
    var shiShen = 0
        protected set get

    override fun toString(): String {
        val sb = StringBuilder()
        when (shiShen) {
            ShiShen.Companion.ZHENGYIN -> sb.append("正印（印绶）")
            ShiShen.Companion.PIANYIN -> sb.append("偏印（枭）")
            ShiShen.Companion.SHANGGUAN -> sb.append("伤官")
            ShiShen.Companion.SHISHEN -> sb.append("食神")
            ShiShen.Companion.ZHENGGUAN -> sb.append("正官")
            ShiShen.Companion.QISHA -> sb.append("七杀(偏官)")
            ShiShen.Companion.ZHENGCAI -> sb.append("正财")
            ShiShen.Companion.PIANCAI -> sb.append("偏财")
            ShiShen.Companion.BIJIAN -> sb.append("比肩")
            ShiShen.Companion.JIECAI -> sb.append("劫财")
            else -> {}
        }
        return sb.toString()
    }

    companion object {
        /**
         * 生我者为父母 / 印星 异性为正印 同性为偏印
         */
        const val YINXING = 0x1
        const val ZHENGYIN = 0x10
        const val PIANYIN = 0x11

        /**
         * 我生者为儿女 / 食伤 异性为伤官 同性为食神
         */
        const val SHISHANG = 0x2
        const val SHANGGUAN = 0x20
        const val SHISHEN = 0x21

        /**
         * 克我者为官杀 异性为正官 同性为七杀
         */
        const val ZHENGGUAN = 0x30
        const val QISHA = 0x31
        val PIANGUAN: Int = ShiShen.Companion.QISHA

        /**
         * 我克者为妻财 / 财星 异性为正财 同性为偏财
         */
        const val CAIXING = 0x4
        const val ZHENGCAI = 0x40
        const val PIANCAI = 0x41

        /**
         * 同我者为兄弟 / 比劫 异性为劫财 同性为比肩
         */
        const val BIJIE = 0x05
        const val JIECAI = 0x50
        const val BIJIAN = 0x51
        fun getShiShen(me: TianGan, other: TianGan): ShiShen {
            val ss1 = ShiShen()
            val sum = me.tianGan + other.tianGan
            val isSame = sum % 2 == 0
            if (other.isSheng(me)) {
                ss1.liuqin = FUMU
                if (isSame) {
                    ss1.shiShen = ShiShen.Companion.ZHENGYIN
                } else {
                    ss1.shiShen = ShiShen.Companion.PIANYIN
                }
            } else if (me.isSheng(other)) {
                ss1.liuqin = ERNV
                if (isSame) {
                    ss1.shiShen = ShiShen.Companion.SHISHEN
                } else {
                    ss1.shiShen = ShiShen.Companion.SHANGGUAN
                }
            } else if (other.isKe(me)) {
                ss1.liuqin = GUANSHA
                if (isSame) {
                    ss1.shiShen = ShiShen.Companion.QISHA
                } else {
                    ss1.shiShen = ShiShen.Companion.ZHENGGUAN
                }
            } else if (me.isKe(other)) {
                ss1.liuqin = QICAI
                if (isSame) {
                    ss1.shiShen = ShiShen.Companion.PIANCAI
                } else {
                    ss1.shiShen = ShiShen.Companion.ZHENGCAI
                }
            } else {
                ss1.liuqin = XIONGDI
                if (isSame) {
                    ss1.shiShen = ShiShen.Companion.BIJIAN
                } else {
                    ss1.shiShen = ShiShen.Companion.JIECAI
                }
            }
            return ss1
        }
    }
}
