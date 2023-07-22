package com.github.lusing.qimen

class BaShen(shen: Int) {
    private val mShen: Int

    init {
        mShen = shen % 8
    }

    override fun toString(): String {
        return (sBaShen[mShen].toString())
    }

    fun getConcept(): String {
        var str = ""
        when (this.mShen) {
            FU -> str =
                "直觉力、高贵的、高档的、稀有的、有组织能力的、名牌的、重点的、高尚的、有影响力的、服众的、威严的、德高望重的"

            SHE -> str =
                "缠绕、惊恐、虚惊、怪异、虚幻、梦境、变来变去、反反复复、虚诈、虚伪、华而不实、闪烁不定、光怪陆离、耀眼、娇艳、猜疑、狠毒、纠缠、变化、拐弯抹角"

            YIN -> str =
                "提升、护佑、隐避、藏匿、喜庆、贞祥、淫乱、阴私、隐私、密谋、缜密、诅咒、哭泣、忧疑、欺诈、口舌、私通、策划、遮盖、暗处、雕刻"

            LIU -> str =
                "欢乐、祥和、仁慈、包容、合作、联合、交易、谈判、结婚、众多、收拢、关闭、平和、共同、适合、合抱、重叠、相聚、聚集"

            BAI -> str = "凶猛、威严、阻隔、斗争、权力、刚毅、冷酷、严肃、艳丽、强硬、官司、伤灾、牢狱、疾病、死亡、技术过硬、道路"
            XUAN -> str = "深奥、玄虚、不可靠、不可捉摸、玄妙、神秘、幻想、领悟、理解、智慧、偷盗、偷情、谍言、阴谋、诡计"
            DI -> str = "矮小、稳定、厚重、柔顺、文静、恭敬、谦卑、吝啬、消极、哭泣、自私、模糊、旧物、博大、包容、关怀、缓慢、困惑"
            TIAN -> str = "高大、天空、虚无、高处、极端、重要、主宰、意志、灵魂、自然、高大、聪明、光明、恩赐、幸福、豪放、美丽"
        }
        return str
    }

    companion object {
        const val FU = 0
        const val SHE = 1
        const val YIN = 2
        const val LIU = 3
        const val BAI = 4
        const val XUAN = 5
        const val DI = 6
        const val TIAN = 7
        const val sBaShen = "符蛇阴六白玄地天"
    }

    private fun getWuXing(shen: Int): Int {
        var xing = 0
        when (shen % 8) {
            FU -> xing = WuXing.MU
            SHE -> xing = WuXing.HUO
            YIN -> xing = WuXing.JIN
            LIU -> xing = WuXing.MU
            BAI -> xing = WuXing.JIN
            XUAN -> xing = WuXing.SHUI
            DI -> xing = WuXing.TU
            TIAN -> xing = WuXing.JIN
        }
        return xing
    }
}