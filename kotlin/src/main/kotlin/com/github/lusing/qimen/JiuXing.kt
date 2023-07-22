package com.github.lusing.qimen


/**
 *
 * @author Louis
 */
class JiuXing(xing: Int) : WuXing(getWuXing(xing)) {
    val id: Int

    init {
        id = xing % 8
    }

    override fun toString(): String {
        return sJiuXing[id].toString()
    }

    fun toLongString(): String {
        return this.toString() + this.getConcept()
    }

    private fun getConcept(): String {
        var str = ""
        when (this.id) {
            PENG -> str = "思考力、膨胀鼓起、蓬松、四面透风的、松软的、汹涌澎湃、聪明智慧"
            REN -> str = "目标力、担当、承受、任劳任怨、任重道远"
            CHONG -> str = "行动力、执行力、冲动、直往前闯、冲击、猛烈、矛盾"
            FU -> str = "诚信力、帮助、奉献、辅佐、协助、指导、关爱、关怀、协调"
            YING -> str = "关系力、社交力、卓越、杰出、贤明、秀丽、智勇"
            RUI -> str = "保健力、问题、毛病、错误、联合、结交"
            ZHU -> str = "驾驭力、惊恐怪异、顶天立地、力挽狂澜、中流砥柱、能独当一面、破坏毁折"
            XIN -> str = "心态力、思想活动、想法、感情、中间、坚固、专制、压抑"
        }
        return str
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
        const val sJiuXing = "蓬任冲辅英芮柱心"
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
