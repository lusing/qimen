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

    fun getConcept(): String {
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

    fun getRomance(): String {
        var str = ""
        when (this.id) {
            PENG -> str = "胆大妄为、聪明智慧、心狠手辣、敢于冒险、阴险奸诈。眼睛大或皮肤黑、头发蓬松、能干大事业、说话很直白"
            REN -> str = "老诚厚道、勤勤恳恳、任劳任怨、保守固执、怕老婆、慎重守信"
            CHONG -> str =
                "直爽果断、声音雄壮、自尊心强、心烦易怒、性急倔强、点火就着、耐性不足、说话冲、语言态度强烈、个子高大、身材挺直"

            FU -> str =
                "气度非凡、性情彬彬有礼、心慈而善、有教养、有文化、谦恭礼让、漂亮含蓄、谈吐不凡、稳重大方、气质高雅、做事勤恳认真、有奉献精神、有爱心、能包容别人"

            YING -> str = "性情急躁、沾火就着、虚荣浮夸、英俊潇洒、聪明好学、虚心处事、美好的憧憬"
            RUI -> str =
                "吝啬贪婪、节俭朴素、固执迟钝、温厚柔顺、恭敬谦让、肚大腰圆、面色萎黄、满脸雀斑、做事问题多。从事文化教育、医疗卫生等职业"

            ZHU -> str =
                "能说会道、声音清脆、语调响亮、活泼好动、身体灵巧、中流砥柱、业务骨干、顶梁柱。为破军星、做事不循规蹈矩，不按常规办事，具有破坏性"

            XIN -> str = "思维缜密、精于管理、办事周到、做事有心计、有能力、心眼多、有责任心、里外一把手、有所作为"
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
